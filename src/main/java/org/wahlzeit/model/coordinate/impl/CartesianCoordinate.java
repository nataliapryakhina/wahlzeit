package org.wahlzeit.model.coordinate.impl;

import java.util.Objects;

import org.wahlzeit.model.coordinate.Coordinate;

public class CartesianCoordinate extends AbstractCoordinate{
	private double x;
	private double y;
	private double z;
	
	public CartesianCoordinate() {
		
	}
	
	public CartesianCoordinate(double x, double y, double z){
			
		//Precondition 
		CoordinateAssertions.assertValidDouble(x);
		CoordinateAssertions.assertValidDouble(y);
		CoordinateAssertions.assertValidDouble(z);
		
		//Method 
		this.x=x;
		this.y=y;
		this.z=z;
		
		//Postcondition
		assertClassInvariants();
		CoordinateAssertions.assertEqualDoubles(this.x, x);
		CoordinateAssertions.assertEqualDoubles(this.y, y);
		CoordinateAssertions.assertEqualDoubles(this.z, z);
	}
	public void setCoordinates(double x, double y, double z) {
		//Precondition 
		CoordinateAssertions.assertValidDouble(x);
		CoordinateAssertions.assertValidDouble(y);
		CoordinateAssertions.assertValidDouble(z);
		
		//Method
		this.x=x;
		this.y=y;
		this.z=z;
		
		//Postcondition
		assertClassInvariants();
		CoordinateAssertions.assertEqualDoubles(this.x, x);
		CoordinateAssertions.assertEqualDoubles(this.y, y);
		CoordinateAssertions.assertEqualDoubles(this.z, z);
	}
	public void setX(double x) {
		//Precondition 
		CoordinateAssertions.assertValidDouble(x);
		
		//Method
		this.x=x;
		//Postcondition
		CoordinateAssertions.assertEqualDoubles(this.x, x);

	}
	public void setY(double y) {
		//Precondition 
		CoordinateAssertions.assertValidDouble(y);
		//Method
		this.y=y;
		
		//Postcondition
		CoordinateAssertions.assertEqualDoubles(this.y, y);
		
	}
	public void setZ(double z) {
		//Precondition 
		CoordinateAssertions.assertValidDouble(z);
		//Method
		this.z=z;
		
		//Postcondition
		CoordinateAssertions.assertEqualDoubles(this.z, z);
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getZ() {
		return this.z;
	}


	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		//Precondition 
		assertClassInvariants();
		
		//Method
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		//Precondition
		assertClassInvariants();
		
		//Method
		double radius;
		double longitude;
		double latitude;
		radius = Math.sqrt(Math.sqrt(x) + Math.sqrt(y) + Math.sqrt(z));
	
		if(Double.compare(radius, 0)==0) {
			longitude =0;
		}else {
			longitude = Math.toDegrees(Math.acos(z / radius));
		}
		if(Double.compare(x, 0)==0){
			latitude = 0;
		}else {
			latitude = Math.toDegrees(Math.atan(y / x));
		}
		//Postcondition
		CoordinateAssertions.assertValidRadius(radius);
		CoordinateAssertions.assertValidLongitude(longitude);
		CoordinateAssertions.assertValidLatitude(latitude);
		
		return new SphericCoordinate(radius, longitude, latitude);
	}
	

	@Override
	public boolean isEqual(Coordinate c) {
		//Precondition
		assertClassInvariants(); 
		
		//Method		
		if(c==null) {
			return false;
		}
		CartesianCoordinate c_car= c.asCartesianCoordinate();
		if (Double.compare(getX(), c_car.getX()) ==0 &&
				Double.compare(getY(), c_car.getY())==0 &&
				Double.compare(getZ(), c_car.getZ())==0) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		//Precondition
		assertClassInvariants(); 
				
		//Method
		return Objects.hash(this.x, this.y, this.z);		
	}

	
	// I don't really what could i check here 
	// it could never be Null, because x, y, z are double and not Double
	// if value is too big -> it will Overflow, and there will be no big value saved ...
	// I would still implement some checks, but I hope we will discuss this in the lecture 
	
	public void assertClassInvariants() {
		CoordinateAssertions.assertValidDouble(getX());
		CoordinateAssertions.assertValidDouble(getY());
		CoordinateAssertions.assertValidDouble(getZ());
	}


	

}
