package org.wahlzeit.model.owl;

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
	
	protected PhotoTagCollector photoTagCollector = null;

	public OwlPhotoManager() {
		photoTagCollector = OwlPhotoFactory.getInstance().createPhotoTagCollector();
	}
	public static final OwlPhotoManager getInstance() {
        return instance;
    }
	protected Logger getLogger() {
		return log;
	 }
	public final Photo getPhoto(PhotoId id) {
		return getInstance().getPhotoFromId(id);
	}
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
	public final Photo getOwlPhoto(PhotoId id) {
		return getInstance().getOwlPhotoFromId(id);
	}
	public Photo getOwlPhotoFromId(PhotoId id) {
		Photo owl_photo=getInstance().getPhoto(id);
		if(owl_photo instanceof OwlPhoto) {
			return (OwlPhoto) owl_photo;
		}else {
			return null;
		}

	}
	
	

}
