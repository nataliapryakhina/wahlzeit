package org.wahlzeit.model.coordinate.impl;

import org.wahlzeit.model.coordinate.Coordinate;

public abstract class AbstractCoordinate implements Coordinate  {
	
	
	public abstract CartesianCoordinate asCartesianCoordinate();
	
	
	public abstract double getCartesianDistance(Coordinate c);
	

	public abstract SphericCoordinate asSphericCoordinate();
	

	public abstract double getSphericDistance(Coordinate c);
	

	public double getDistance(Coordinate c) {		
		return getCartesianDistance(c);	
	}
	
	public boolean equals(Object o){
		if (o == null) {
			return false;
		}
		if(o instanceof Coordinate) {
			Coordinate target =(Coordinate) o;
			return isEqual(target);
		}else {
			return false;
		}
		 
	}
	
	@Override
	public abstract int hashCode();	
	
	@Override
	public abstract boolean isEqual(Coordinate c);
}
