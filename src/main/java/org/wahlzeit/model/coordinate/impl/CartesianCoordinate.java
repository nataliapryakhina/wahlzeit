package org.wahlzeit.model.coordinate.impl;

import java.util.Objects;

import org.wahlzeit.model.coordinate.Coordinate;

public class CartesianCoordinate extends AbstractCoordinate{
	private double x;
	private double y;
	private double z;
	
	/*
	public CartesianCoordinate() {		
	}
	*/
	
	public CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException{
			
		//Precondition 
		try {
			CoordinateAssertions.assertValidDouble(x);
			CoordinateAssertions.assertValidDouble(y);
			CoordinateAssertions.assertValidDouble(z);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());		
		}
		//Method 
		this.x=x;
		this.y=y;
		this.z=z;
		
		//Postcondition
		assertClassInvariants();
		try {
			CoordinateAssertions.assertEqualDoubles(this.x, x);
			CoordinateAssertions.assertEqualDoubles(this.y, y);
			CoordinateAssertions.assertEqualDoubles(this.z, z);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());		
		}
	}
	public void setCoordinates(double x, double y, double z) throws InvalidCoordinateException {
		//Precondition 
		try {
			CoordinateAssertions.assertValidDouble(x);
			CoordinateAssertions.assertValidDouble(y);
			CoordinateAssertions.assertValidDouble(z);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());		
		}	
		
		//Method
		this.x=x;
		this.y=y;
		this.z=z;
		
		//Postcondition
		assertClassInvariants();
		try {
			CoordinateAssertions.assertEqualDoubles(this.x, x);
			CoordinateAssertions.assertEqualDoubles(this.y, y);
			CoordinateAssertions.assertEqualDoubles(this.z, z);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());		
		}
	}
	public void setX(double x) throws InvalidCoordinateException  {
		//Precondition 
		try {
			CoordinateAssertions.assertValidDouble(x);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());		
		}
		//Method
		this.x=x;
		//Postcondition
		try {
			CoordinateAssertions.assertEqualDoubles(this.x, x);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());		
		}

	}
	public void setY(double y) throws InvalidCoordinateException {
		//Precondition 
		try {
			CoordinateAssertions.assertValidDouble(y);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());		
		}
		//Method
		this.y=y;
		
		//Postcondition
		try {
			CoordinateAssertions.assertEqualDoubles(this.y, y);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());		
		}
		
		
	}
	public void setZ(double z) throws InvalidCoordinateException {
		//Precondition 
		try {
			CoordinateAssertions.assertValidDouble(z);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());		
		}
		//Method
		this.z=z;
		
		//Postcondition
		try {
			CoordinateAssertions.assertEqualDoubles(this.z, z);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());		
		}
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
	public SphericCoordinate asSphericCoordinate() throws InvalidCoordinateException {
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
		try {
			CoordinateAssertions.assertValidRadius(radius);
			CoordinateAssertions.assertValidLongitude(longitude);
			CoordinateAssertions.assertValidLatitude(latitude);
		} catch(InvalidCoordinateException e) {
			System.out.println(e.getMessage());		
		}
		return new SphericCoordinate(radius, longitude, latitude);
	}
	

	@Override
	public boolean isEqual(Coordinate c) {
		assertClassInvariants();
		
		//Method		
		if(c==null) {
			return false;
		}
		
		CartesianCoordinate c_car;
		c_car =  c.asCartesianCoordinate();
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
		return Objects.hash(this.x, this.y, this.z);		
	}

	
	// I don't really what could i check here 
	// it could never be Null, because x, y, z are double and not Double
	// if value is too big -> it will Overflow, and there will be no big value saved ...
	// I would still implement some checks, but I hope we will discuss this in the lecture 
	
	public void assertClassInvariants() throws IllegalArgumentException {
		try {
			CoordinateAssertions.assertValidDouble(getX());
			CoordinateAssertions.assertValidDouble(getY());
			CoordinateAssertions.assertValidDouble(getZ());
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());		
		}
	}


	

}
