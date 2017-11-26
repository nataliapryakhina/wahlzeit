package org.wahlzeit.model.coordinate.impl;

import org.wahlzeit.model.coordinate.Coordinate;

public abstract class AbstractCoordinate implements Coordinate  {
	
	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();
	
	@Override
	public abstract double getCartesianDistance(Coordinate c);
	
	@Override
	public abstract SphericCoordinate asSphericCoordinate();
	
	@Override
	public abstract double getSphericDistance(Coordinate c);
	
	@Override
	public abstract double getDistance(Coordinate c);
	
	@Override
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
