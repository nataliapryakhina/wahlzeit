package org.wahlzeit.model.coordinate.impl;

import java.util.Objects;

import org.wahlzeit.model.coordinate.Coordinate;

public final class SphericCoordinate extends AbstractCoordinate {

	private double radius;
	private double longitude;
	private double latitude;
	private static final double EARTH_RADIUS_KM = 6370; // is token from wikipedia, to compare results

	/*
	 * public SphericCoordinate() { }
	 */
	private SphericCoordinate(double radius, double longitude, double latitude) throws InvalidCoordinateException {
		// Precondition

		CoordinateAssertions.assertValidRadius(radius);
		CoordinateAssertions.assertValidLongitude(longitude);
		CoordinateAssertions.assertValidLatitude(latitude);

		this.radius = radius;
		this.longitude = longitude;
		this.latitude = latitude;

		// Postcondition
		assertClassInvariants();

		CoordinateAssertions.assertEqualDoubles(this.radius, radius);
		CoordinateAssertions.assertEqualDoubles(this.longitude, longitude);
		CoordinateAssertions.assertEqualDoubles(this.latitude, latitude);

	}

	// new get method for value objects
	public final static SphericCoordinate getSphericCoordinate(double radius, double longitude, double latitude) throws InvalidCoordinateException {
		SphericCoordinate c_spher = new SphericCoordinate(radius, longitude, latitude);
		Coordinate c_hash_maped = AbstractCoordinate.returnFromCoordinateValueObjectsMap(c_spher);
		
		return (SphericCoordinate)c_hash_maped;
	}

	public final double getRadius() {
		return this.radius;

	}

	public final double getLongitude() {

		return this.longitude;

	}

	public final double getLatitude() {
		return this.latitude;

	}

	@Override
	public final CartesianCoordinate asCartesianCoordinate() {
		// Precondition
		// assertClassInvariants();

		// Method
		
		double longitude_in_rad = Math.toRadians(this.longitude);
		double latitude_in_rad = Math.toRadians(this.latitude);
		double x = radius * Math.sin(longitude_in_rad) * Math.cos(latitude_in_rad);
		double y = radius * Math.sin(longitude_in_rad) * Math.sin(latitude_in_rad);
		double z = radius * Math.cos(longitude_in_rad);
		return CartesianCoordinate.getCartesianCoordinate(x, y, z);
	}

	@Override
	public final SphericCoordinate asSphericCoordinate() {

		// Method
		return this;
	}
	@Override
    public String toString() {
        return "(" +"radius: "+ this.radius + ", "+"longtitude: " + this.longitude  + ", "+"latitude: " + this.latitude  + ")";
    }
/* no longer needed
	@Override
	public final boolean isEqual(Coordinate c) {

		// Method
		SphericCoordinate c_spher;
		try {
			c_spher = c.asSphericCoordinate();
			if (Double.compare(this.getRadius(), c_spher.getRadius()) != 0) {
				return false;
			} else if (Double.compare(this.getLongitude(), c_spher.getLongitude()) != 0) {
				return false;
			} else if (Double.compare(this.getLatitude(), c_spher.getLatitude()) != 0) {
				return false;
			}
			return true;
		} catch (InvalidCoordinateException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}
*/

	@Override
	public final void assertClassInvariants() throws InvalidCoordinateException {

		CoordinateAssertions.assertValidRadius(getRadius());
		CoordinateAssertions.assertValidLatitude(getLatitude());
		CoordinateAssertions.assertValidLongitude(getLongitude());

	}

}
