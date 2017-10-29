package org.wahlzeit.model;
import org.junit.*;
import org.junit.Assert;

public class CoordinateTest {
	private Coordinate c;
	private Coordinate c1;
	private Coordinate c_equal;	
	private Coordinate c_not_equal;
	private Coordinate c_too_much;
	private Object o;
	@Before
	public void init() {
		c = new Coordinate();
		c1 = new Coordinate(1.0, 2.0 , 3.0);
		c_equal = new Coordinate(1.0, 2.0 , 3.0);
		c_not_equal = new Coordinate(2.0, 2.0 , 3.0);
		c_too_much = new Coordinate (Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
		o = new Object();
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

	

}
