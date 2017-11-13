package org.wahlzeit.model.owl;


import java.util.HashMap;
import java.util.Map;

import java.util.logging.Logger;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.PhotoManager;
import org.wahlzeit.model.PhotoTagCollector;


public class OwlPhotoManager extends PhotoManager{

	/**
	 *
	 */
	protected static final OwlPhotoManager instance = new OwlPhotoManager();

	private static final Logger log = Logger.getLogger(OwlPhotoManager.class.getName());
	
	protected Map<PhotoId, OwlPhoto> photoCache = new HashMap<PhotoId, OwlPhoto>();


	/**
	 *
	 */
	protected PhotoTagCollector photoTagCollector = null;

	/**
	 *
	 */
	public OwlPhotoManager() {
		photoTagCollector = OwlPhotoFactory.getInstance().createPhotoTagCollector();
	}

	/**
	 *
	 */
	public static final OwlPhotoManager getInstance() {
		return instance;
	}


	/**
	 *
	 */
	public Photo getPhotoFromId(PhotoId id) {
		if (id == null) {
			return null;
		}

		Photo result = doGetPhotoFromId(id);

		if (result == null) {
			result = OwlPhotoFactory.getInstance().loadPhoto(id);
			if (result != null) {
				doAddPhoto(result);
			}
		}

		return result;
	}
	
	

}
