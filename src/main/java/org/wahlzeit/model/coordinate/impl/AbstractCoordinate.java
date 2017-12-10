package org.wahlzeit.model.coordinate.impl;

import org.wahlzeit.model.coordinate.Coordinate;

public abstract class AbstractCoordinate implements Coordinate  {
	public static final double EARTH_RADIUS_KM= 6370; // is token from wikipedia, to compare results
	
	
	public abstract CartesianCoordinate asCartesianCoordinate();
	
	
	public double getCartesianDistance(Coordinate other) {
		if (other == null) {
			throw new IllegalArgumentException("Coordinate could not be null"); 
		}
		//Preconditions
		CoordinateAssertions.assertCoordinateIsNotNull(other);
		assertClassInvariants();
		
		//Method
		CartesianCoordinate this_car = this.asCartesianCoordinate();
		CartesianCoordinate other_car = other.asCartesianCoordinate();
		double limit = Math.sqrt(Double.MAX_VALUE);
		double x_diff = Math.abs(this_car.getX()-other_car.getX()); 
		double y_diff = Math.abs(this_car.getY()-other_car.getY());
		double z_diff = Math.abs(this_car.getZ()-other_car.getZ());
		if (Double.compare(x_diff, limit)>0 || Double.compare(y_diff, limit)>0 || Double.compare(z_diff, limit)>0) {
			throw new IllegalArgumentException("Distance can not be calculated because of too big arguments"); 
		}
		double distance = Math.sqrt(x_diff*x_diff+y_diff*y_diff+z_diff*z_diff);
		
		//Postconditions 
		CoordinateAssertions.assertValidDouble(distance);
		CoordinateAssertions.assertValidDistance(distance);
		return distance;
	}
	

	public abstract SphericCoordinate asSphericCoordinate();
	

	//https://en.wikipedia.org/wiki/Great-circle_distance
	public double getSphericDistance(Coordinate other) {
		if (other == null) {
			throw new IllegalArgumentException("Coordinate could not be null"); 
		}
		//Precondition 
		CoordinateAssertions.assertCoordinateIsNotNull(other);
		assertClassInvariants();
		
		//Impl
		SphericCoordinate this_spher= this.asSphericCoordinate();		
		SphericCoordinate other_spher= other.asSphericCoordinate();		
		double longitude_rad = Math.toRadians(this_spher.getLongitude());
		double latitude_rad = Math.toRadians(this_spher.getLatitude());
		double other_longitude_rad = Math.toRadians(other_spher.getLongitude());
		double other_latitude_rad = Math.toRadians(other_spher.getLatitude());
		double delta_longitude=Math.abs(longitude_rad - other_longitude_rad);
		double delta = Math.acos(Math.sin(latitude_rad)*Math.sin(other_latitude_rad) +
				Math.cos(latitude_rad)*Math.cos(other_latitude_rad)*Math.cos(delta_longitude));
		double distance = EARTH_RADIUS_KM*delta; 

		//Postcondition
		CoordinateAssertions.assertValidDouble(distance);
		CoordinateAssertions.assertValidDistance(distance);
		return distance;
		
	}
	

	public double getDistance(Coordinate other) {
		if (other == null) {
			throw new IllegalArgumentException("Coordinate could not be null"); 
		}
		//Precondition 
		CoordinateAssertions.assertCoordinateIsNotNull(other);
		assertClassInvariants();
		
		//Working part
		double distance = getCartesianDistance(other);	
		
		//Postcondition
		CoordinateAssertions.assertValidDouble(distance);
		CoordinateAssertions.assertValidDistance(distance);
		return distance;

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
	

	public abstract int hashCode();		

	public abstract boolean isEqual(Coordinate c);
	
	public abstract void assertClassInvariants();
	
}