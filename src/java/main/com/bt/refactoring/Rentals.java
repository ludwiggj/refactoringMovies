package com.bt.refactoring;

import java.util.Vector;

public class Rentals {

	private Vector<Rental> rentals = new Vector<>();

	public void add(Rental rental) {
		this.rentals.addElement(rental);
	}
	
	public String getRentalStatement() {
		String result = "";

		for (Rental rental: rentals) {
			result += "  " + rental + "\n";
		}
		return result;
	}

	public String getRentalTotals() {
		return "Amount owed is " + getTotalCharge() + "\n"
				+ "You earned " + getTotalFrequentRenterPoints()
				+ " frequent renter points";
	}
	
	private double getTotalCharge() {
		double totalAmount = 0;

		for (Rental rental: rentals) {
			totalAmount += rental.getCharge();
		}
		return totalAmount;
	}

	private int getTotalFrequentRenterPoints() {
		int totalFrequentRenterPoints = 0;

		for (Rental rental: rentals) {
			totalFrequentRenterPoints += rental.getFrequentRenterPoints();
		}
		return totalFrequentRenterPoints;
	}
}