package org.wahlzeit.model.owl;
import org.junit.Assert;
import org.junit.Test;
import org.wahlzeit.model.owl.Owl.Color; 

public class OwlTest {
	@Test
	public void testOwl(){
		OwlType polarowl = new OwlType("polar_owl");
		int age = 4;
		String name = "Hedwig";
		Color color = Color.WHITE;
		Owl harryPotterOwl = new Owl(polarowl);
		harryPotterOwl.setAge(age);
		harryPotterOwl.setName(name);
		harryPotterOwl.setColor(color);
		
		Assert.assertEquals(harryPotterOwl.getAge(), age);
		Assert.assertEquals(harryPotterOwl.getName(), name);
		Assert.assertEquals(harryPotterOwl.getColor(), color);
		
	}
	
}
