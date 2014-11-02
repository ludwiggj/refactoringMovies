package com.bt.refactoring;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public double getCharge() {
		double thisAmount = 0;

		switch (movie.getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (daysRented > 2)
				thisAmount += (daysRented - 2) * 1.5;
			break;

		case Movie.NEW_RELEASE:
			thisAmount += daysRented * 3;
			break;

		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (daysRented > 3)
				thisAmount += (daysRented - 3) * 1.5;
			break;

		}
		return thisAmount;
	}

	public int getFrequentRenterPoints() {
		// add bonus for a two day new release rental
		if ((movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
			return 2;
		} else {
			return 1;
		}
	}
}