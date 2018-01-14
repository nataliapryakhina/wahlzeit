package org.wahlzeit.model.owl;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class OwlPhoto extends Photo {
	private Owl owl = new Owl(); 
	
	public enum Size{
		SMALL, MIDDLE, BIG
	}

	private String species;
	private Size size; 
	private int color;
	

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
	/*
	public void setOwl(Owl owl) {
		this.owl = owl;
	}
	public Owl getOwl() {
		return this.owl;
	}
	*/
	
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


}
