package MultipleUsers;

import org.testng.TestNG;

public class TestRunner {

	static TestNG testNG;
	
	public static void main(String[] args) {
		testNG = new TestNG();
		//testNG.setTestClasses(new class[] {FiftyUsersJoin.class}); wrong becuase c is small here
		testNG.setTestClasses(new Class[] {FiftyUsersJoin.class});
		
		testNG.run();
	}

}
