package org.wahlzeit.model.owl;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	
	OwlPhotoTest.class,
	OwlPhotoFactoryTest.class,
	OwlPhotoManagerTest.class,
	OwlTest.class,
	OwlTypeTest.class,
	OwlManagerTest.class
})
public class OwlModelTestSuite {

}
