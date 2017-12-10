package org.wahlzeit.model.coordinate.impl;
import java.util.Objects;

import org.wahlzeit.model.coordinate.Coordinate;

public class SphericCoordinate extends AbstractCoordinate{

	private double radius;
	private double longitude;
	private double latitude;
	public static final double EARTH_RADIUS_KM= 6370; // is token from wikipedia, to compare results
	
	/* 
	public SphericCoordinate() {		
	}
	*/
	public SphericCoordinate(double radius, double longitude, double latitude) throws InvalidCoordinateException{
		//Precondition
		try {
			CoordinateAssertions.assertValidRadius(radius);
			CoordinateAssertions.assertValidLongitude(longitude);
			CoordinateAssertions.assertValidLatitude(latitude); 			
		} catch(InvalidCoordinateException e) {
			System.out.println(e.getMessage());		
		}
		
		setRadius(radius);
		setLongitude(longitude);
		setLatitude(latitude);
		
		//Postcondition 
		assertClassInvariants();
		try {
			CoordinateAssertions.assertEqualDoubles(this.radius, radius);
			CoordinateAssertions.assertEqualDoubles(this.longitude, longitude);
			CoordinateAssertions.assertEqualDoubles(this.latitude, latitude);		
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());		
		}
		
	}
	public void setRadius(double r) throws InvalidCoordinateException{
		//Precondition
		try {
			CoordinateAssertions.assertValidRadius(radius);			
		} catch(InvalidCoordinateException e) {
			System.out.println(e.getMessage());		
		}
		this.radius=r;
		
	}
	public void setLongitude(double longitude) throws IllegalArgumentException{
		//Precondition
		try {
			CoordinateAssertions.assertEqualDoubles(this.longitude, longitude);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());		
		}
		this.longitude=longitude;
	}
	public void setLatitude(double latitude) throws InvalidCoordinateException{
		//Precondition
		try {
			CoordinateAssertions.assertValidLatitude(latitude); 			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());		
		}
		this.latitude=latitude;
	}
	public double getRadius() {
		return this.radius;
		
	}
	public double getLongitude() {
		
		return this.longitude;
		
	}
	public double getLatitude() {
		return this.latitude;
		
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		//Precondition
		//assertClassInvariants();
		
		//Method
		double longitude_in_rad = Math.toRadians(this.getLongitude());
		double latitude_in_rad = Math.toRadians(this.getLatitude());
		double x = radius * Math.sin(longitude_in_rad) * Math.cos(latitude_in_rad);
		double y = radius * Math.sin(longitude_in_rad) * Math.sin(latitude_in_rad);
		double z = radius * Math.cos(longitude_in_rad);
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {

		//Method
		return this;
	}


	@Override
	public boolean isEqual(Coordinate c)  {

		//Method
		SphericCoordinate c_spher;
		try {
			c_spher = c.asSphericCoordinate();
			if (Double.compare(this.getRadius(), c_spher.getRadius())!=0) {
				return false;
			}else if (Double.compare(this.getLongitude(), c_spher.getLongitude())!=0) {
				return false;
			}else if (Double.compare(this.getLatitude(), c_spher.getLatitude())!=0) {
				return false;
			}
			return true;
		} catch (InvalidCoordinateException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}


	

	@Override
	public int hashCode() {
		
		//Method
		return Objects.hash(this.radius, this.longitude, this.latitude);
	}

	@Override
	public void assertClassInvariants() throws InvalidCoordinateException{
		try {
			CoordinateAssertions.assertValidRadius(getRadius());
			CoordinateAssertions.assertValidLatitude(getLatitude()); 
			CoordinateAssertions.assertValidLongitude(getLongitude());
		} catch(InvalidCoordinateException e) {
			System.out.println(e.getMessage());		
		}
	}

}
