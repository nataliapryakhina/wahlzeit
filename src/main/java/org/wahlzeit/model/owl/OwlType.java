package org.wahlzeit.model.owl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class OwlType {
	
	public String typeName;
	public OwlManager manager = OwlManager.getInstance();
	
	public OwlType(String tn) {
		this.typeName = tn;
	}
	public OwlType superType = null;
	
	protected Set<OwlType> subTypes = new HashSet<OwlType>();
	
	
	
	public OwlType getSuperType() {
		return superType;
	}
	public void setSuperType(OwlType st) {
		this.superType = st;
	}
	
	public Owl createInstance() {
		return new Owl(this);
	}
	
	public Iterator<OwlType> getSubTypeIterator() {
		return subTypes.iterator();
	}
	public void addSubType(OwlType owlType) {
		assert (owlType != null) : "tried to set null sub-type";
		owlType.setSuperType(this);
		subTypes.add(owlType);
	}
	public boolean isSubType(OwlType owlType) {
		assert (owlType != null) : "tried check for a null sub-type";
		if (owlType == this) {
			return true;
		}else {
			Iterator<OwlType> iter = getSubTypeIterator();
			while(iter.hasNext()) {
				OwlType subOwlType = iter.next();
				if(subOwlType.isSubType(owlType)) {
					return true;
				}
			}
			return false; 
		}
		
	}
	
	
}
