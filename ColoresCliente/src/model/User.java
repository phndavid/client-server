package model;

import java.util.ArrayList;

public class User {
	
	private String name; 
	private ArrayList<Color> colors; 
	
	public User(String name){
		// TODO Auto-generated constructor stub
		this.name = name; 
		colors = new ArrayList<Color>();	
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public ArrayList<Color> getColors(){
		return colors;
	}
	public void setColors(ArrayList<Color> colors){
		this.colors = colors;
	}
}