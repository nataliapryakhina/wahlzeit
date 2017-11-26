package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.coordinate.CoordinateTestSuite;
import org.wahlzeit.model.persistence.ModelPersistenceTestSuite;
import org.wahlzeit.model.owl.OwlModelTestSuite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	AccessRightsTest.class,	
	FlagReasonTest.class, 
	GenderTest.class, 
	GuestTest.class,
	LocationTest.class, 
	PhotoFilterTest.class, 
	TagsTest.class,
	UserStatusTest.class,
	ValueTest.class,
	CoordinateTestSuite.class,
	OwlModelTestSuite.class,
	ModelPersistenceTestSuite.class 
})

public class ModelTestSuite {

}
