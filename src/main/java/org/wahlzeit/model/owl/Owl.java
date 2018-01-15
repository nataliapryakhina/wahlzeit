package org.wahlzeit.model.owl;

public class Owl {

	//UML
	public OwlType type = null;
	public OwlManager manager = OwlManager.getInstance();
	
	public enum Color {
		WHITE, BLACK, BRAUN, MULTICOLORED 
	}
	
	
	
	private int owlId;

	private Color color;

	private int age; 
	private String name; 
	private String favoriteFood;
	
	
	
	public Owl(OwlType ot) {
		type = ot; 
		this.owlId = this.hashCode();
	}
	
	
	public void setColor(Color c) {
		this.color = c;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFavoriteFood(String ff) {
		this.favoriteFood = ff;
		
	}

	public int getId() {
		return this.owlId;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public int getAge(){
		return this.age;
	}
	public String getName() {
		return this.name;
	}
	public String getFavoriteFood() {
		return this.favoriteFood;
		
	}
}
