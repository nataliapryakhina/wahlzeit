package org.wahlzeit.model.owl;
import org.junit.*;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.owl.OwlPhoto.Size;

public class OwlPhotoTest extends OwlDomainTest{
	private OwlPhoto owl;
	private OwlPhoto owl_null;
	@Before
	public void start() throws Exception {
		//Owl with no Owl-class instance
		owl = new OwlPhoto(PhotoId.getNextId(), "Grey owl", Size.SMALL, 0100); 

	}
	
	@Test
	public void checkConstructors()  throws Exception{
		Assert.assertNotNull(owl);
	}
	
	

}
