package com.pojo;

public class Typess {
	private int typess_id;
	private String typess_name;
	public Typess() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Typess(int typess_id, String typess_name) {
		super();
		this.typess_id = typess_id;
		this.typess_name = typess_name;
	}
	public int getTypess_id() {
		return typess_id;
	}
	public void setTypess_id(int typess_id) {
		this.typess_id = typess_id;
	}
	public String getTypess_name() {
		return typess_name;
	}
	public void setTypess_name(String typess_name) {
		this.typess_name = typess_name;
	}
	@Override
	public String toString() {
		return "Typess [typess_id=" + typess_id + ", typess_name=" + typess_name + "]";
	}
	
	
}
