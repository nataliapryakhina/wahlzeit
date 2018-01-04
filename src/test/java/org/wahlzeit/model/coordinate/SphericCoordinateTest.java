package org.wahlzeit.model.coordinate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.coordinate.impl.CartesianCoordinate;
import org.wahlzeit.model.coordinate.impl.InvalidCoordinateException;
import org.wahlzeit.model.coordinate.impl.SphericCoordinate;

//for testing is used http://www.learningaboutelectronics.com/Articles/Cartesian-rectangular-to-spherical-coordinate-converter-calculator.php#answer
public class SphericCoordinateTest {
	CartesianCoordinate simple_car;
	CartesianCoordinate too_simple_car;
	SphericCoordinate simple_spher;
	SphericCoordinate simple_spher_2;
	@Before
	public void init() throws InvalidCoordinateException {
		simple_car = CartesianCoordinate.getCartesianCoordinate(2.0, 3.0, 8.0);
		too_simple_car = CartesianCoordinate.getCartesianCoordinate(0.0, 0.0, 0.0);
		simple_spher = SphericCoordinate.getSphericCoordinate(8.77, 24.26, 56.31);
		simple_spher_2 = SphericCoordinate.getSphericCoordinate(8.77, 24.26, 56.31);
	}
	
	@Test
	public void getCartesianDistanceTest() throws IllegalArgumentException, InvalidCoordinateException {
		Assert.assertEquals(simple_car.getCartesianDistance(simple_spher), 0, 0.01);
		Assert.assertEquals(simple_spher.getCartesianDistance(simple_car), 0, 0.01);
	}
	@Test
	public void asSphericCoordinateTest() throws InvalidCoordinateException {
		Assert.assertEquals(simple_spher,simple_spher.asSphericCoordinate());
		
		Assert.assertNotEquals(simple_spher,too_simple_car.asSphericCoordinate());
	}
	
	
}
