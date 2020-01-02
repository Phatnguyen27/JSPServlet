package model.bean;

public class Phongban {
	static int count = 0;
	private int id;
	private String name;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Phongban() {
		super();
	}
	public Phongban(String name) {
		super();
		this.name = name;
	}
	
	
}
