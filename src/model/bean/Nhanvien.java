package model.bean;

public class Nhanvien {
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
	public Nhanvien(String name) {
		super();
		this.name = name;
	}
	public Nhanvien() {
		super();
	}
	
}
