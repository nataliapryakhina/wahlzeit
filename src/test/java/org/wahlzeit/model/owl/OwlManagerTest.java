package org.wahlzeit.model.owl;
import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;
public class OwlManagerTest {
	OwlManager om;
	String typename;
	@Before
	public void setUp() {
		om = OwlManager.getInstance();
		typename = "polar_owl";
	}
	
	@Test
	public void createOwlTest(){
		Owl testOwl = om.createOwl(typename);
		Assert.assertNotNull(testOwl);
		Assert.assertEquals(testOwl.type.typeName, typename);
	}
	@Test
	public void getOwlTypeTest() {
		Owl testOwl = om.createOwl("polar_owl");
		Assert.assertEquals(testOwl.type, om.getOwlType(typename));
	}
	

}
