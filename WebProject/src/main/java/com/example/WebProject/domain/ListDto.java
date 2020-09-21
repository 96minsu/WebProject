package com.example.WebProject.domain;

public class ListDto {
	
	private int listNum;
	private String listName;
	
	public int getListNum() {
		return listNum;
	}

	public void setListNum(int listNum) {
		this.listNum = listNum;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	@Override
	public String toString() {
		return "List{" +
				"listNum=" + listNum +
				", listName='" + listName + '\''+
				'}';
	}
	
}
