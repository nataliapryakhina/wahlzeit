package org.wahlzeit.model.owl;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

public class OwlPhoto extends Photo {
	
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
		
	}
	public OwlPhoto(PhotoId myId) {
		id = myId;
		incWriteCount();
		//not sure about it
		//owl_manager= new OwlPhotoManager();
	}
	public OwlPhoto (String species, Size size, int color) {
		this.species = species;
		this.size= size;
		this.color=color; 
		
	}
	public void setSpecies(String species) {
		this.species=species;
	}
	public void setSize(Size size) {
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
