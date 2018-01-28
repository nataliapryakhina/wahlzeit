package org.wahlzeit.model.owl;
import org.junit.*;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.owl.Owl.Color;


public class OwlPhotoTest extends OwlDomainTest{
	private OwlPhoto owl;
	private OwlPhoto owl_null;
	@Before
	public void start() throws Exception {
		OwlType polarowl = new OwlType("polar_owl");
		int age = 4;
		Owl harryPotterOwl = new Owl(polarowl);
		owl = new OwlPhoto(PhotoId.getNextId(), harryPotterOwl ); 
		//Owl with no Owl-class instance
		//owl = new OwlPhoto(PhotoId.getNextId(), "Grey owl", Size.SMALL, 0100); 

	}
	
	@Test
	public void checkConstructors()  throws Exception{
		Assert.assertNotNull(owl);
	}
	
	

}
