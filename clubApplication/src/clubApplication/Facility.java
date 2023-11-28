package clubApplication;

public class Facility implements Comparable<Facility> {
	private String name;
	private String description;
	
	public Facility(String name, String description) {
		this.name = name;
		this.description = description;
	}
	public Facility(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return (description == null) ? name : name + " " + description;
	}
	
	public void show() {
		System.out.println(this);
	}
	@Override
	public int compareTo(Facility another) {
		return this.name.compareTo(another.name);
	}
}
