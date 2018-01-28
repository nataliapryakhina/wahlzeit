package org.wahlzeit.model.owl;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;


import com.googlecode.objectify.annotation.Serialize;
import com.googlecode.objectify.annotation.Subclass;

/*
 * --------------CW13: instantiation process--------------
 * OwlPhotoManager.class: new OwlPhotoManager ->
 * -> OwlPhotoFactory.class: getInstance() ->
 * -> OwlPhotoFactory.class: createPhoto(PhotoId id) or createPhoto()->
 * -> OwlPhotoFactory.class: new OwlPhoto(id) or new OwlPhoto()
 * 
 * 
 * 1. Delegation - separate-object  
 * 2. Selection - by subclassing 
 * 3. Configuration – in code
 * 4. Instantiation – in code
 * 5. Initialization – default
 * 6. Building – default 
 */

@Subclass
public class OwlPhoto extends Photo {
	@Serialize
	private Owl owl; //= null; 
	/* not needed any more since Owl.class
	public enum Size{
		SMALL, MIDDLE, BIG
	}

	private String species;
	private Size size; 
	private int color;
	*/

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//not sure about it
	//public OwlPhotoManager owl_manager; 

	public OwlPhoto() {
		super();
	}
	public OwlPhoto(PhotoId myId) {
		super(myId);
		OwlAssertions.assertParameterNotNull(myId); 
	}
	//OWL -OwlPhoto Collaboration
	public OwlPhoto(PhotoId myId, Owl owl) {
		super(myId);
		OwlAssertions.assertParameterNotNull(myId); 
		this.owl = owl; 
	}
	/*
	public OwlPhoto (PhotoId myId, String species, Size size, int color) throws IllegalArgumentException{
		try {
			OwlAssertions.assertParameterNotNull(myId); 
			OwlAssertions.assertParameterNotNull(species); 
			OwlAssertions.assertParameterNotNull(size); 
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());			
		}
		this.id = myId;
		this.species = species;
		this.size= size;
		this.color=color; 
		//this.owl = owl;
		
	}
	*/
	
	public void setOwl(Owl owl) {
		this.owl = owl;
	}
	public Owl getOwl() {
		return this.owl;
	}
	/*
	
	public void setSpecies(String species) throws IllegalArgumentException{
		try {
			OwlAssertions.assertParameterNotNull(species); 
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());			
		}
		
		this.species=species;
	}
	public void setSize(Size size) throws IllegalArgumentException{
		try {
			OwlAssertions.assertParameterNotNull(size); 
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());			
		}
		this.size=size;
	}
	public void setColor(int color) {
		this.color=color;
	}
	public String getSpecies() {
		return species;
	}
	public Size getSize() {
		return size;
	}
	public int getColor() {
		return color;
	}
	*/


}
