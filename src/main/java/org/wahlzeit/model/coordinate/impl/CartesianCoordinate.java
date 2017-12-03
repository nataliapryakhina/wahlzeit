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
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public void setCoordinates(double x, double y, double z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public void setX(double x) {
		this.x=x;
	}
	public void setY(double y) {
		this.y=y;
	}
	public void setZ(double z) {
		this.z=z;
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
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
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
		return new SphericCoordinate(radius, longitude, latitude);
	}


	@Override
	public double getCartesianDistance(Coordinate c) {
		CartesianCoordinate c_cartesian = c.asCartesianCoordinate();
		double limit = Math.sqrt(Double.MAX_VALUE);
		double x_diff = Math.abs(getX()-c_cartesian.getX()); 
		double y_diff = Math.abs(getY()-c_cartesian.getY());
		double z_diff = Math.abs(getZ()-c_cartesian.getZ());
		if (x_diff > limit || y_diff>limit || z_diff>limit) {
			//vielleicht ist schlauer das anderes zu handeln
			throw new IllegalArgumentException("Distance can not be calculated because of too big arguments"); 
		}
		double distance = Math.sqrt(x_diff*x_diff+y_diff*y_diff+z_diff*z_diff);
		return distance;
	}
	
	@Override
	public double getSphericDistance(Coordinate c) {
		return asSphericCoordinate().getDistance(c);
	}
	@Override
	public boolean isEqual(Coordinate c) {
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
		return Objects.hash(this.x, this.y, this.z);		
	}
	

	

}
