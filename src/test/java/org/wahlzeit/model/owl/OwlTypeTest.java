package org.wahlzeit.model.owl;
import org.junit.Test;

import org.junit.Assert;

public class OwlTypeTest {
	

	@Test
	public void superTypeTest(){
		OwlType polarowl = new OwlType("polar_owl");
		OwlType harry_poter_owl = new OwlType("harry_poter_owl");
		harry_poter_owl.setSuperType(polarowl);
		Assert.assertEquals(harry_poter_owl.getSuperType(), polarowl);
		
	}
	@Test
	public void subTypeTest(){
		//super
		OwlType polarowl = new OwlType("polar_owl");
		//subtypes
		OwlType sub_owl1 = new OwlType("owl_1");
		OwlType sub_owl2 = new OwlType("owl_2");
		OwlType sub_owl3 = new OwlType("owl_3");
		//other type
		OwlType other_owl_type = new OwlType("other_owl_type");
		polarowl.addSubType(sub_owl1);
		polarowl.addSubType(sub_owl2);
		polarowl.addSubType(sub_owl3);
		
		Assert.assertTrue(polarowl.isSubType(sub_owl1));
		Assert.assertFalse(polarowl.isSubType(other_owl_type));
		
	}
}
