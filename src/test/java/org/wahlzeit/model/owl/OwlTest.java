package org.wahlzeit.model.owl;
import org.junit.Test; 

public class OwlTest {
	@Test
	public void testOwl(){
		OwlType polarowl = new OwlType("polar_owl");
		Owl harryPotterOwl = new Owl(polarowl);
	}
	
}
