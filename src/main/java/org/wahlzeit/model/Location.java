package org.wahlzeit.model;

import org.wahlzeit.model.coordinate.Coordinate;

public class Location {
	private Coordinate coordinate;
	public Location() {
		
	}
	public Location(Coordinate coordinate) {
		this.coordinate=coordinate;
	}
	public void setCoordinate(Coordinate c){
		this.coordinate=c;
		
	}
	public Coordinate getCoordinate (){
		return this.coordinate; 		
	}
	public boolean equals(Object o) {
		if(o instanceof Location) {
			return this.coordinate.equals(((Location) o).coordinate);
		}
		return false;
	}
	public double getDistance(Location l) {
		return this.coordinate.getDistance(l.coordinate);
	}
}
