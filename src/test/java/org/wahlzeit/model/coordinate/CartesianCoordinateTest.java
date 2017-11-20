package org.wahlzeit.model.coordinate;
import org.junit.*;
import org.junit.Assert;
import org.wahlzeit.model.coordinate.impl.CartesianCoordinate;
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
	public void init() {
		c = new CartesianCoordinate();
		c1 = new CartesianCoordinate(1.0, 2.0 , 3.0);
		c_equal = new CartesianCoordinate(1.0, 2.0 , 3.0);
		c_not_equal = new CartesianCoordinate(2.0, 2.0 , 3.0);
		c_too_much = new CartesianCoordinate (Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
		o = new Object();
		simple_car = new CartesianCoordinate(2.0, 3.0, 8.0);
		too_simple_car = new CartesianCoordinate(0.0, 0.0, 0.0);
		simple_spher = new SphericCoordinate(8.77, 24.26, 56.31);
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
	public void isEqualsTest() {
		Assert.assertTrue(c1.isEqual(c_equal));
		Assert.assertFalse(c1.isEqual(c_not_equal));
		Assert.assertFalse(c1.isEqual(null));
		Assert.assertFalse(c1.isEqual(c));

	}
	@Test
	public void equalsTest() {
		Assert.assertTrue(c1.equals(c_equal));
		Assert.assertFalse(c1.equals(c_not_equal));
		Assert.assertFalse(c1.equals(null));
		Assert.assertFalse(c1.equals(c));
		Assert.assertFalse(c1.equals(o));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getDistanceTest() {
		c1.getDistance(c_too_much);
	}
	@Test
	public void getDistanceCorrectTest() {
		double expected = 1.0;
		double actual = c1.getDistance(c_not_equal);
		Assert.assertEquals(expected, actual, 0); 
		
	}
	@Test
	public void asCartesianCoordinateTest() {

		Assert.assertFalse(too_simple_car.isEqual(simple_spher.asCartesianCoordinate()));
	}
	@Test
	public void getCartesianDistanceTest() {
		Assert.assertEquals(simple_spher.getCartesianDistance(simple_car), 0, 0.01);
	};
	@Test
	public void asSphericCoordinateTest() {
		Assert.assertEquals(simple_spher,simple_spher.asSphericCoordinate());

		Assert.assertNotEquals(simple_spher,too_simple_car.asSphericCoordinate());
	}
	
	


}
