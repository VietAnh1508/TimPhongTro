package com.timphong.models;

public class Room {
	private int id;
	private long cost;
	private String description;
	private boolean isCheck;

	public Room() {
		
	}
	
	public Room(int id, long cost, String description, boolean isCheck) {
		this.id = id;
		this.cost = cost;
		this.description = description;
		this.isCheck = isCheck;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCheck() {
		return isCheck;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}

}