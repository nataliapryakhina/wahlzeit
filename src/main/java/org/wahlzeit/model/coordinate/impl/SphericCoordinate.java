package org.wahlzeit.model.coordinate.impl;
import org.wahlzeit.model.coordinate.Coordinate;

public class SphericCoordinate implements Coordinate{

	private double radius;
	private double longitude;
	private double latitude;
	
	public SphericCoordinate() {
		
	}
	
	public SphericCoordinate(double radius, double longitude, double latitude) {
		setRadius(radius);
		setLongitude(longitude);
		setLatitude(latitude);
	}
	public void setRadius(double r) {
		if(radius < 0 ) {
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
	public double getDistance(Coordinate c) {
		return asSphericCoordinate().getDistance(c);
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
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if(o instanceof Coordinate) {
			Coordinate target =(Coordinate) o;
			return isEqual(target);
		}else {
			return false;
		}
		 
	}

	@Override
	public double getCartesianDistance(Coordinate c) {		
		return asCartesianCoordinate().getDistance(c);
	}

	@Override
	public double getSphericDistance(Coordinate c) {
		CartesianCoordinate this_as_Car = this.asCartesianCoordinate();
		CartesianCoordinate c_as_car = c.asCartesianCoordinate();		
		return this_as_Car.getDistance(c_as_car);
	}

}
