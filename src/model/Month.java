package model;

public class Month {
	private String month;
	private String season;
	private int numberSellers;
	
	public Month(String month, String season, int numberSellers) {
		this.month = month;
		this.season = season;
		this.numberSellers = numberSellers;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public int getNumberSellers() {
		return numberSellers;
	}

	public void setNumberSellers(int numberSellers) {
		this.numberSellers = numberSellers;
	}
	
	
}
