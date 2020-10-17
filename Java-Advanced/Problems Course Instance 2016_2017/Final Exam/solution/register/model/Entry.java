package register.model;

public class Entry {

	public static final int PROPERTIES_COUNT = 7;
	
	private String date;
	private String color;
	private String breed;
	private String sex;
	private String state;
	private String name;
	private String dateCreated;

	public Entry(String date, String color, String breed, String sex, 
			String state, String name, String dateCreated) {
		super();
		this.date = date;
		this.color = color;
		this.breed = breed;
		this.sex = sex;
		this.state = state;
		this.name = name;
		this.dateCreated = dateCreated;
	}

	public String getDate() {
		return date;
	}

	public String getColor() {
		return color;
	}

	public String getBreed() {
		return breed;
	}

	public String getSex() {
		return sex;
	}

	public String getState() {
		return state;
	}

	public String getName() {
		return name;
	}

	public String getDateCreated() {
		return dateCreated;
	}
	
	public Object getPropertyValue(int propertyIndex) {
		switch (propertyIndex) {
		case 0:
			return getDate();
		case 1:
			return getColor();
		case 2:
			return getBreed();
		case 3:
			return getSex();
		case 4:
			return getState();
		case 5:
			return getName();
		case 6:
			return getDateCreated();
		default:
			return null;
		}
	}
	
	public static String getPropertyName(int index) {
		switch (index) {
		case 0:
			return "Date";
		case 1:
			return "Color";
		case 2:
			return "Breed";
		case 3:
			return "Sex";
		case 4:
			return "State";
		case 5:
			return "Name";
		case 6:
			return "Date Created";
		default:
			return null;
		}
	}
}