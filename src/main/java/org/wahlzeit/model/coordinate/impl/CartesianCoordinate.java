package org.wahlzeit.model.coordinate.impl;

import java.util.Objects;

import org.wahlzeit.model.coordinate.Coordinate;

public final class CartesianCoordinate extends AbstractCoordinate {
	private final double x;
	private final double y;
	private final double z;

	/*
	 * public CartesianCoordinate() { }
	 */

	private CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException {

		// Precondition
		CoordinateAssertions.assertValidDouble(x);
		CoordinateAssertions.assertValidDouble(y);
		CoordinateAssertions.assertValidDouble(z);

		// Method
		this.x = x;
		this.y = y;
		this.z = z;

		// Postcondition
		assertClassInvariants();

		CoordinateAssertions.assertEqualDoubles(this.x, x);
		CoordinateAssertions.assertEqualDoubles(this.y, y);
		CoordinateAssertions.assertEqualDoubles(this.z, z);

	}
	//new get method for value objects
	public final static CartesianCoordinate getCartesianCoordinate(double x, double y, double z) {
		CartesianCoordinate c_car= new CartesianCoordinate(x, y, z);
		Coordinate c_hash_maped = AbstractCoordinate.returnFromCoordinateValueObjectsMap(c_car);
		return c_hash_maped.asCartesianCoordinate();
	}


	public final double getX() {
		return this.x;
	}

	public final double getY() {
		return this.y;
	}

	public final double getZ() {
		return this.z;
	}

	@Override
	public final CartesianCoordinate asCartesianCoordinate() {
		// Precondition
		assertClassInvariants();

		// Method
		return this;
	}

	@Override
	public final SphericCoordinate asSphericCoordinate() throws InvalidCoordinateException {
		// Precondition
		assertClassInvariants();

		// Method
		double radius;
		double longitude;
		double latitude;
		radius = Math.sqrt(Math.sqrt(x) + Math.sqrt(y) + Math.sqrt(z));

		if (Double.compare(radius, 0) == 0) {
			longitude = 0;
		} else {
			longitude = Math.toDegrees(Math.acos(z / radius));
		}
		if (Double.compare(x, 0) == 0) {
			latitude = 0;
		} else {
			latitude = Math.toDegrees(Math.atan(y / x));
		}
		// Postcondition

		CoordinateAssertions.assertValidRadius(radius);
		CoordinateAssertions.assertValidLongitude(longitude);
		CoordinateAssertions.assertValidLatitude(latitude);

		return SphericCoordinate.getSphericCoordinate(radius, longitude, latitude);
	}
	
	@Override
    public String toString() {
        return "(" +"x: "+ this.x + ", "+"y: " + this.y  + ", "+"z: " + this.z  + ")";
    }
/* this method is no longer needed, after value Objects are created
	@Override
	public final boolean isEqual(Coordinate c) {
		assertClassInvariants();

		// Method
		if (c == null) {
			return false;
		}

		CartesianCoordinate c_car;
		c_car = c.asCartesianCoordinate();
		if (Double.compare(getX(), c_car.getX()) == 0 && Double.compare(getY(), c_car.getY()) == 0
				&& Double.compare(getZ(), c_car.getZ()) == 0) {
			return true;
		} else {
			return false;
		}

	}
*/


	public final void assertClassInvariants() throws IllegalArgumentException {

		CoordinateAssertions.assertValidDouble(getX());
		CoordinateAssertions.assertValidDouble(getY());
		CoordinateAssertions.assertValidDouble(getZ());

	}

}
