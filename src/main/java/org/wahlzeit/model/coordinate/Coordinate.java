package org.wahlzeit.model.coordinate;

import org.wahlzeit.model.coordinate.impl.CartesianCoordinate;
import org.wahlzeit.model.coordinate.impl.InvalidCoordinateException;
import org.wahlzeit.model.coordinate.impl.SphericCoordinate;

public interface Coordinate {

	CartesianCoordinate asCartesianCoordinate();
	
	double getCartesianDistance(Coordinate c)throws InvalidCoordinateException;
	
	SphericCoordinate asSphericCoordinate() throws InvalidCoordinateException;
	
	double getSphericDistance(Coordinate c) throws InvalidCoordinateException;
	
	double getDistance(Coordinate c) throws InvalidCoordinateException;
	
	//boolean isEqual(Coordinate c);
}
