package org.wahlzeit.model.owl;

import org.junit.ClassRule;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

public class OwlDomainTest {
	@ClassRule
	public static RuleChain ruleChain = RuleChain
            .outerRule(new RegisteredOfyEnvironmentProvider())
            .around(new LocalDatastoreServiceTestConfigProvider());
}
