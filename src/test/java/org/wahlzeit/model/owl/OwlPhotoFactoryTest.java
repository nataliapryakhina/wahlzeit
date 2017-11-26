package org.wahlzeit.model.owl;

import org.junit.*;


public class OwlPhotoFactoryTest extends OwlDomainTest{

	private OwlPhotoFactory f;
	
	@Before
	public void start() throws Exception{
		f=OwlPhotoFactory.getInstance();
	}
	@Test
	public void checkInstanse() {
		Assert.assertTrue(f.getClass().equals(OwlPhotoFactory.class));
	}

}
