package org.wahlzeit.model.owl;

import org.junit.*;

public class OwlPhotoManagerTest {
	private OwlPhotoManager m;
	
	@Before
	public void start() {
		m = OwlPhotoManager.getInstance();
	}
	
	@Test
	public void checkInstance() {
		Assert.assertTrue(m.getClass().equals(OwlPhotoManager.class));
		
	}
}