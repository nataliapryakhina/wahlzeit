package org.wahlzeit.model.owl;

/*
 * --------------CW13: instantiation process--------------
 * OwlManager.class: createOwl(String typename)->
 * -> OwlManager.getOwlType(String typename)-> 
 * -> OwlType new OwlType(typename)->
 * -> OwlType.createInstance()->
 * -> Owl new Owl
 * 
 * 
 * 1. Delegation - separate-object  
 * 2. Selection - on-the-spot
 * 3. Configuration – in code
 * 4. Instantiation – in code
 * 5. Initialization – in second step
 * 6. Building – default 
 */

/*
 * -------------CW14: Collaboration-------------------------
 *  Owl with OwlType
 *  Owl with OwlPhoto 
 *  Owl with OwlManager
 *  
 */
public class Owl {

	//UML
	public OwlType type = null;
	public OwlManager manager;
	
	public enum Color {
		WHITE, BLACK, BRAUN, MULTICOLORED 
	}
	
	
	
	private int owlId;

	private Color color;

	private int age; 
	private String name; 
	private String favoriteFood;
	
	
	//OWL -OwlType Collaboration 
	public Owl(OwlType ot) {
		type = ot; 
		this.owlId = this.hashCode();
		//OWL -OwlManager Collaboration
		manager = OwlManager.getInstance();
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
