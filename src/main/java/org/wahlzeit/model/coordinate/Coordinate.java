package org.wahlzeit.model.coordinate;

import org.wahlzeit.model.coordinate.impl.CartesianCoordinate;
import org.wahlzeit.model.coordinate.impl.SphericCoordinate;

public interface Coordinate {

	CartesianCoordinate asCartesianCoordinate();
	double getCartesianDistance(Coordinate c);
	SphericCoordinate asSphericCoordinate();
	double getSphericDistance(Coordinate c);
	double getDistance(Coordinate c);
	boolean isEqual(Coordinate c);
}
