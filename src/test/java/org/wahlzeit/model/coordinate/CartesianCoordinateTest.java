package org.wahlzeit.model.coordinate;
import org.junit.*;
import org.junit.Assert;
import org.wahlzeit.model.coordinate.impl.CartesianCoordinate;
import org.wahlzeit.model.coordinate.impl.InvalidCoordinateException;
import org.wahlzeit.model.coordinate.impl.SphericCoordinate;


public class CartesianCoordinateTest {
	CartesianCoordinate simple_car;
	CartesianCoordinate too_simple_car;
	SphericCoordinate simple_spher;

	private CartesianCoordinate c;
	private CartesianCoordinate c1;
	private CartesianCoordinate c_equal;	
	private CartesianCoordinate c_not_equal;
	private CartesianCoordinate c_too_much;

	private Object o;
	@Before
	public void init() throws InvalidCoordinateException {
	
		c1 = CartesianCoordinate.getCartesianCoordinate(1.0, 2.0 , 3.0);
		c_equal = CartesianCoordinate.getCartesianCoordinate(1.0, 2.0 , 3.0);
		c_not_equal =CartesianCoordinate.getCartesianCoordinate(2.0, 2.0 , 3.0);
		c_too_much = CartesianCoordinate.getCartesianCoordinate (Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
		o = new Object();
		simple_car = CartesianCoordinate.getCartesianCoordinate(2.0, 3.0, 8.0);
		too_simple_car = CartesianCoordinate.getCartesianCoordinate(0.0, 0.0, 0.0);
		simple_spher = SphericCoordinate.getSphericCoordinate(8.77, 24.26, 56.31);
	}
	/*
	@Test
	public void getXTest() {
		Coordinate c = new Coordinate(1.0, 2.0 , 3.0);
		double x = 1.0;
		double y = 2.0;
		double z = 3.0;
		
		assertEquals(x.equals(c.getX()));
	}
	*/
	

	@Test
	public void equalsTest() {
		Assert.assertTrue(c1.equals(c_equal));
		Assert.assertFalse(c1.equals(c_not_equal));
		Assert.assertFalse(c1.equals(null));
		Assert.assertFalse(c1.equals(c));
		Assert.assertFalse(c1.equals(o));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getDistanceTest() throws IllegalArgumentException, InvalidCoordinateException {
		c1.getDistance(c_too_much);
	}
	@Test
	public void getDistanceCorrectTest() throws IllegalArgumentException, InvalidCoordinateException {
		double expected = 1.0;
		double actual = c1.getDistance(c_not_equal);
		Assert.assertEquals(expected, actual, 0); 
		
	}
	
	@Test
	public void getCartesianDistanceTest() throws IllegalArgumentException, InvalidCoordinateException {
		Assert.assertEquals(simple_spher.getCartesianDistance(simple_car), 0, 0.01);
	};
	@Test
	public void asSphericCoordinateTest() throws InvalidCoordinateException {
		Assert.assertEquals(simple_spher,simple_spher.asSphericCoordinate());

		Assert.assertNotEquals(simple_spher,too_simple_car.asSphericCoordinate());
	}
	
	


}
