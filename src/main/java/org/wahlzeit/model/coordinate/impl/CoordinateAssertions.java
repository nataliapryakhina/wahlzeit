package org.wahlzeit.model.coordinate.impl;

import org.wahlzeit.model.coordinate.Coordinate;


public class CoordinateAssertions{


	public static void assertCoordinateIsNotNull(Coordinate c) {
		assert c !=null;
	}
	public static void assertEqualDoubles (double d1, double d2) {
		assert Double.compare(d1, d2) == 0; 
	}

	public static void assertValidDouble(double d) {
		assert !Double.isNaN(d);
		assert !Double.isInfinite(d);
	}
	
	public static void assertValidDistance(double distance) {
		assert Double.compare(distance, 0) > 0;		
	}

	public static void assertValidRadius(double radius) {
		assert (Double.compare(radius, 0) >= 0);
		
	}

	public static void assertValidLatitude(double latitude) {
		assert  (Double.compare(latitude, 0) >= 0) && (Double.compare(latitude, 180) <= 0);
		
	}


	public static void assertValidLongitude(double longitude) {
		assert  (Double.compare(longitude, 0) >= 0) && (Double.compare(longitude, 90) <= 0);		
	}
	

}
