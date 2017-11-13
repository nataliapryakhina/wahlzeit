package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.owl.OwlModelTestSuite;
import org.wahlzeit.model.persistence.ModelPersistenceTestSuite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	ModelPersistenceTestSuite.class,
	AccessRightsTest.class,
	CoordinateTest.class,
	FlagReasonTest.class, 
	GenderTest.class, 
	GuestTest.class,
	LocationTest.class, 
	PhotoFilterTest.class, 
	TagsTest.class,
	UserStatusTest.class,
	ValueTest.class,
	OwlModelTestSuite.class
	  
})

public class ModelTestSuite {

}
