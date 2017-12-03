package org.wahlzeit.model.coordinate;

/*I'm not sure about the future of this project,
so I divided Assertions in Interface & Implementation */
public interface CoordinateAssertions {
	
	//check if this Object of class coordinate is Null
	void assertCoordinateIsNull(Coordinate c);
	
	//check if this value is a valid double
	void assertValidDouble(double d);
	
	//this three functions are needed for SphericCoordinates
	void assertValidRadius(double radius); 	
	void assertValidLatitude(double latitude);	
	void assertValidLongitude(double longitude);

}
