package org.wahlzeit.model;
import org.junit.*;
import org.wahlzeit.model.coordinate.Coordinate;
import org.wahlzeit.model.coordinate.impl.CartesianCoordinate;


public class LocationTest {
	private Coordinate c; 
	private Coordinate c_equal;
	private Coordinate c_not_equal;
	private Location l; 
	private Location l_equal; 
	private Location l_not_equal;
	
	@Before
	public void init() {
		c = CartesianCoordinate.getCartesianCoordinate(1.0, 2.0, 3.0);
		c_equal = CartesianCoordinate.getCartesianCoordinate(1.0, 2.0, 3.0);
		c_not_equal = CartesianCoordinate.getCartesianCoordinate(2.0, 2.0, 3.0);
		l = new Location (c);
		l_equal = new Location (c_equal); 
		l_not_equal = new Location (c_not_equal); 
	}
	
	@Test
	public void equalsTest() {
		Assert.assertTrue(l.equals(l_equal));
		Assert.assertTrue(l.equals(l));
		Assert.assertFalse(l.equals(null));
		Object o = new Object();
		Assert.assertFalse(l.equals(o));
	}
	

	

	

}
