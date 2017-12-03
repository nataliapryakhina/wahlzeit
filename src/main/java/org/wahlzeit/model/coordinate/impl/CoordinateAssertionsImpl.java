package org.wahlzeit.model.coordinate.impl;

import org.wahlzeit.model.coordinate.Coordinate;
import org.wahlzeit.model.coordinate.CoordinateAssertions;

public class CoordinateAssertionsImpl implements CoordinateAssertions{

	@Override
	public void assertCoordinateIsNull(Coordinate c) {
		assert c==null;
	}

	@Override
	public void assertValidDouble(double d) {
		assert Double.compare(d, Double.MAX_VALUE) > 0;		
	}

	@Override
	public void assertValidRadius(double radius) {
		assert (Double.compare(radius, 0) > 0);
		
	}

	@Override
	public void assertValidLatitude(double latitude) {
		assert  (Double.compare(latitude, 0) > 0) && (Double.compare(latitude, 180) < 0);
		
	}

	@Override
	public void assertValidLongitude(double longitude) {
		assert  (Double.compare(longitude, 0) > 0) && (Double.compare(longitude, 90) < 0);		
	}
	
	

}
