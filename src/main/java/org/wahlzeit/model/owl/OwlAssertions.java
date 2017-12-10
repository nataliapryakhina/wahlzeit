package org.wahlzeit.model.owl;

public class OwlAssertions {
	
	public static void assertParameterNotNull(Object o) throws IllegalArgumentException {
		if(o==null) {
			throw new IllegalArgumentException("Parameter null is not valid for this Constructor");
		}
		
	}

}
