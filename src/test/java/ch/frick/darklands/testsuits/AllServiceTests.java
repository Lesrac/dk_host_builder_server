package ch.frick.darklands.testsuits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ch.frick.darklands.service.TestKindredService;
import ch.frick.darklands.service.TestWarriorService;

@RunWith(Suite.class)
@SuiteClasses({ TestKindredService.class, TestWarriorService.class })
public class AllServiceTests {

}
