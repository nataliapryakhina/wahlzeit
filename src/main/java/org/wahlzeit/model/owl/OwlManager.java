package org.wahlzeit.model.owl;

import java.util.HashMap;

import org.wahlzeit.services.ObjectManager;


public class OwlManager extends ObjectManager {
	
	private HashMap<Integer, Owl> owls;
	private HashMap<String, OwlType> owlTypes;
	
	private static OwlManager instance = new OwlManager(); 
	
	private OwlManager() {
		owls = new HashMap<Integer, Owl>();
		owlTypes = new HashMap<String, OwlType>();
	}
	public static OwlManager getInstance() {
		return instance;
	}
	
	public Owl createOwl(String typeName) {
		//assertIsValidFlowerTypeName(typeName);
		OwlType ot = getOwlType(typeName);
		Owl result = ot.createInstance();
		owls.put(result.getId(), result);
		return result;
	}
	
	
	public OwlType getOwlType(String typename) {
		if (owlTypes.containsKey(typename)) {
			return owlTypes.get(typename);
		}else {
			OwlType newType = new OwlType(typename);
			owlTypes.put(typename, newType);
			return newType;
		}
	}
	
	

}
