package org.wahlzeit.model.coordinate.impl;
import java.util.Objects;

import org.wahlzeit.model.coordinate.Coordinate;

public class SphericCoordinate extends AbstractCoordinate{

	private double radius;
	private double longitude;
	private double latitude;
	public static final double EARTH_RADIUS_KM= 6370; // is token from wikipedia, to compare results
	
	public SphericCoordinate() {
		
	}
	
	public SphericCoordinate(double radius, double longitude, double latitude) {
		if(radius< 0 ) {
			throw new IllegalArgumentException("radius");
		}
		if(longitude < 0 || longitude > 90) {
			throw new IllegalArgumentException("longitude");
		}
		if(latitude < 0 || latitude > 180) {
			throw new IllegalArgumentException("latitude");
		}
		setRadius(radius);
		setLongitude(longitude);
		setLatitude(latitude);
		
		//Postcondition 
		assertClassInvariants();
		CoordinateAssertions.assertEqualDoubles(this.radius, radius);
		CoordinateAssertions.assertEqualDoubles(this.longitude, longitude);
		CoordinateAssertions.assertEqualDoubles(this.latitude, latitude);
	}
	public void setRadius(double r) {
		if(r < 0 ) {
			throw new IllegalArgumentException("radius");
		}else {
			this.radius=r;
		}
	}
	public void setLongitude(double longitude) {
		if(longitude < 0 || longitude > 90) {
			throw new IllegalArgumentException("longitude");
		}else {
			this.longitude=longitude;
		}		
	}
	public void setLatitude(double latitude) {
		if(latitude < 0 || latitude > 180) {
			throw new IllegalArgumentException("latitude");
		}else {
			this.latitude=latitude;
		}
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
		assertClassInvariants();
		
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
		//Precondition
		assertClassInvariants();
				
		//Method
		return this;
	}


	@Override
	public boolean isEqual(Coordinate c) {
		//Precondition
		assertClassInvariants();
		
		//Method
		SphericCoordinate c_spher = c.asSphericCoordinate();
		if (Double.compare(this.getRadius(), c_spher.getRadius())!=0) {
			return false;
		}else if (Double.compare(this.getLongitude(), c_spher.getLongitude())!=0) {
			return false;
		}else if (Double.compare(this.getLatitude(), c_spher.getLatitude())!=0) {
			return false;
		}
		return true;
	}


	

	@Override
	public int hashCode() {
		//Precondition
		assertClassInvariants();
				
		//Method
		return Objects.hash(this.radius, this.longitude, this.latitude);
	}

	@Override
	public void assertClassInvariants() {
		CoordinateAssertions.assertValidRadius(getRadius());
		CoordinateAssertions.assertValidLatitude(getLatitude()); 
		CoordinateAssertions.assertValidLongitude(getLongitude());
	}

}
