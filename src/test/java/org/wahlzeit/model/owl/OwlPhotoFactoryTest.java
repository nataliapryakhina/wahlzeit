package org.wahlzeit.model.owl;

import org.junit.*;


public class OwlPhotoFactoryTest{

	private OwlPhotoFactory f;
	
	@Before
	public void start() throws Exception{
		f=OwlPhotoFactory.getInstance();
	}
	public void checkInstanse() {
		Assert.assertTrue(f.getClass().equals(OwlPhotoFactory.class));
	}

}
