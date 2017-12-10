package org.wahlzeit.model.owl;

import java.util.logging.Logger;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoFactory;

import org.wahlzeit.model.PhotoId;

import org.wahlzeit.services.LogBuilder;

public class OwlPhotoFactory extends PhotoFactory {
	private static final Logger log = Logger.getLogger(OwlPhotoFactory.class.getName());
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static OwlPhotoFactory instance = null;

	/**
	 *
	 */
	protected OwlPhotoFactory() {
		// do nothing
	}

	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}

	/**
	 * Public singleton access method.
	 */
	public static synchronized OwlPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
			setInstance(new OwlPhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of PhotoFactory.
	 */
	protected static synchronized void setInstance(OwlPhotoFactory owlPhotoFactory) throws IllegalArgumentException{
		try{
			if (instance != null) {
				throw new IllegalStateException("attempt to initalize PhotoFactory twice");
			}
		}catch (IllegalStateException e) {
			System.out.println(e.getMessage());			
		}

		instance = owlPhotoFactory;
	}
	
	/**
	 * @methodtype factory
	 */
	@Override
	public Photo createPhoto() {
		return new OwlPhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 */
	@Override
	public Photo createPhoto(PhotoId id) throws IllegalArgumentException{
		try {
			OwlAssertions.assertParameterNotNull(id); 
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());			
		}
		return new OwlPhoto(id);
	}
	
}
