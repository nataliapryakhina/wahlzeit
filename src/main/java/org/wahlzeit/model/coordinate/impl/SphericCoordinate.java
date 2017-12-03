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
		setRadius(radius);
		setLongitude(longitude);
		setLatitude(latitude);
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
		double longitude_in_rad = Math.toRadians(this.getLongitude());
		double latitude_in_rad = Math.toRadians(this.getLatitude());
		double x = radius * Math.sin(longitude_in_rad) * Math.cos(latitude_in_rad);
		double y = radius * Math.sin(longitude_in_rad) * Math.sin(latitude_in_rad);
		double z = radius * Math.cos(longitude_in_rad);
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}


	@Override
	public boolean isEqual(Coordinate c) {
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
	public double getCartesianDistance(Coordinate c) {		
		return asCartesianCoordinate().getDistance(c);
	}

	//https://en.wikipedia.org/wiki/Great-circle_distance
	@Override
	public double getSphericDistance(Coordinate c) {
		//CartesianCoordinate this_as_Car = this.asCartesianCoordinate();
		SphericCoordinate c_spher= c.asSphericCoordinate();		
		double longitude_rad = Math.toRadians(longitude);
		double latitude_rad = Math.toRadians(latitude);
		double other_longitude_rad = Math.toRadians(c_spher.getLongitude());
		double other_latitude_rad = Math.toRadians(c_spher.getLatitude());
		double delta_longitude=Math.abs(longitude_rad - other_longitude_rad);
		double delta = Math.acos(Math.sin(latitude_rad)*Math.sin(other_latitude_rad) +
				Math.cos(latitude_rad)*Math.cos(other_latitude_rad)*Math.cos(delta_longitude));
		double result = EARTH_RADIUS_KM*delta; // see wiki
		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.radius, this.longitude, this.latitude);
	}

}
