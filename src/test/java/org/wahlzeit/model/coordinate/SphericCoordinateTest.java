package org.wahlzeit.model.coordinate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.coordinate.impl.CartesianCoordinate;
import org.wahlzeit.model.coordinate.impl.SphericCoordinate;

//for testing is used http://www.learningaboutelectronics.com/Articles/Cartesian-rectangular-to-spherical-coordinate-converter-calculator.php#answer
public class SphericCoordinateTest {
	CartesianCoordinate simple_car;
	CartesianCoordinate too_simple_car;
	SphericCoordinate simple_spher;
	SphericCoordinate simple_spher_2;
	@Before
	public void init() {
		simple_car = new CartesianCoordinate(2.0, 3.0, 8.0);
		too_simple_car = new CartesianCoordinate(0.0, 0.0, 0.0);
		simple_spher = new SphericCoordinate(8.77, 24.26, 56.31);
		simple_spher_2 = new SphericCoordinate(8.77, 24.26, 56.31);
	}
	@Test
	public void asCartesianCoordinateTest() {
		
		Assert.assertFalse(too_simple_car.isEqual(simple_spher.asCartesianCoordinate()));
	}
	@Test
	public void getCartesianDistanceTest() {
		Assert.assertEquals(simple_car.getCartesianDistance(simple_spher), 0, 0.01);
		Assert.assertEquals(simple_spher.getCartesianDistance(simple_car), 0, 0.01);
	}
	@Test
	public void asSphericCoordinateTest() {
		Assert.assertEquals(simple_spher,simple_spher.asSphericCoordinate());
		
		Assert.assertNotEquals(simple_spher,too_simple_car.asSphericCoordinate());
	}
	
	@Test
	public void isEqualTest() {
		Assert.assertTrue(simple_spher.isEqual(simple_spher));
		Assert.assertTrue(simple_spher.isEqual(simple_spher_2));
	}
}
