package org.wahlzeit.model;


public class Coordinate {
	private double x;
	private double y;
	private double z;
	
	public Coordinate() {
		
	}
	
	public Coordinate(double x, double y, double z){
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
	//direct Distance
	public double getDistance(Coordinate target) {
		
		double limit = Math.sqrt(Double.MAX_VALUE);
		double x_diff = Math.abs(this.x-target.x); 
		double y_diff = Math.abs(this.y-target.y);
		double z_diff = Math.abs(this.z-target.z);
		if (x_diff > limit || y_diff>limit || z_diff>limit) {
			//vielleicht ist schlauer das anderes zu handeln
			throw new IllegalArgumentException("Distance can not be calculated because of too big arguments"); 
		}
		double distance = Math.sqrt((this.x-target.x)*(this.x-target.x)+(this.y-target.y)*(this.y-target.y)+(this.z-target.z)*(this.z-target.z));
		return distance;
	}
	
	public boolean isEqual(Coordinate target) {
		if(target==null) {
			return false;
		}
		if (this.x==target.x && this.y==target.y && this.z==target.z) {
			return true;
		}else {
			return false;
		}
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

}
