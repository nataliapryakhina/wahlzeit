package org.wahlzeit.model.coordinate.impl;

import org.wahlzeit.model.coordinate.Coordinate;


public class CoordinateAssertions{


	public static void assertCoordinateIsNotNull(Coordinate c) throws IllegalArgumentException {
		//assert c !=null;
		if (c == null) {
			throw new IllegalArgumentException("Coordinate is null");
		}

	}
	public static void assertEqualDoubles (double d1, double d2) throws IllegalArgumentException {
		//assert Double.compare(d1, d2) == 0; 
		if (Double.compare(d1, d2) != 0) {
			throw new IllegalArgumentException("Doubles are not equal");
		}
	
	}

	public static void assertValidDouble(double d) throws IllegalArgumentException {
		//assert !Double.isNaN(d);
		if (Double.isNaN(d)) {
			throw new IllegalArgumentException("Double is Nan");
		}
		//assert !Double.isInfinite(d);
		if (Double.isInfinite(d)) {
			throw new IllegalArgumentException("Doubles is Infinite");
		}
	}
	
	public static void assertValidDistance(double distance) throws InvalidCoordinateException{
		//assert Double.compare(distance, 0) > 0;		
		if (!(Double.compare(distance, 0) > 0)) {
			throw new InvalidCoordinateException("Distance should be grater than 0 ");
		}
		
	}

	public static void assertValidRadius(double radius) throws InvalidCoordinateException{
		//assert (Double.compare(radius, 0) >= 0);
		if (! (Double.compare(radius, 0) >= 0)) {
			throw new InvalidCoordinateException("Radius should be grater than 0");
		}		
	}

	public static void assertValidLatitude(double latitude)throws InvalidCoordinateException {
		//assert  (Double.compare(latitude, 0) >= 0) && (Double.compare(latitude, 180) <= 0);
		if (! (Double.compare(latitude, 0) >= 0) && (Double.compare(latitude, 180) <= 0)) {
			throw new InvalidCoordinateException("Latitude should be between 0 and 180");
		}
	}


	public static void assertValidLongitude(double longitude) throws InvalidCoordinateException{
		//assert  (Double.compare(longitude, 0) >= 0) && (Double.compare(longitude, 90) <= 0);	
		if (! (Double.compare(longitude, 0) >= 0) && (Double.compare(longitude, 90) <= 0)) {
			throw new InvalidCoordinateException("Longitude should be between 0 and 90");
		}
	}
	

}
