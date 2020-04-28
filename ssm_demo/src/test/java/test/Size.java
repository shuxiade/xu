package test;

public enum Size {

	SMALL("S","MAN"), MEDIUM("M","BOY"), LARGE("L","GIRL"), EXTRA_LARGE("XL","GOD");

	private Size(String abbreviation,String male) {
		this.abbreviation = abbreviation;
		this.male = male;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
	
	public String getMale() {
		return male;
	}

	private String abbreviation;
	private String male;

}
