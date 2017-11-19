package org.wahlzeit.model.owl;
import org.junit.*;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.owl.OwlPhoto.Size;

public class OwlPhotoTest{
	private OwlPhoto owl;
	private OwlPhoto owl_null;
	@Before
	public void start() throws Exception {
		
		owl = new OwlPhoto(PhotoId.getNextId(), "Grey owl", Size.SMALL, 0100 ); 
		owl_null = new OwlPhoto(null);
	}
	
	@Test
	public void checkConstructors()  throws Exception{
		Assert.assertNotNull(owl);
		Assert.assertNotNull(owl_null);
	}
	
	

}
