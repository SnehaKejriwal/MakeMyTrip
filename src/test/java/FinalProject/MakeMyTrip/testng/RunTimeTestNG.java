package FinalProject.MakeMyTrip.testng;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import FinalProject.MakeMyTrip.tests.BaseTest;

public class RunTimeTestNG {

	private String testcasePackagePath = "FinalProject.MakeMyTrip.tests";

	public TestNG create() {
		TestNG testng = new TestNG();

		// list of suite
		List<XmlSuite> suiteList = new ArrayList<XmlSuite>();

		// Suite Object
		XmlSuite suite = new XmlSuite();
		suite.setName("Runtime Suite");

		// List of Test
		List<XmlTest> testList = new ArrayList<XmlTest>();

		// test object
		XmlTest test = new XmlTest(suite);
		test.setName("Test Object");

		// class list
		List<XmlClass> classList = new ArrayList<XmlClass>();

		// get test class from reflection
		Reflections reflections = getClasses();
		Set<Class<? extends BaseTest>> allClasses = reflections.getSubTypesOf(BaseTest.class);

		for (Class c : allClasses) {

			// xml class object
			XmlClass cls = new XmlClass(c);

			Method[] allMethods = c.getDeclaredMethods();

			// list of methods
			List<XmlInclude> methodList = new ArrayList<XmlInclude>();

			for (Method m : allMethods) {
				String methodName = m.getName();
				methodList.add(new XmlInclude(methodName));

			}

			// add method to the class
			cls.setIncludedMethods(methodList);

			// add class to the list
			classList.add(cls);
		}

		// add class list to test
		test.setXmlClasses(classList);

		// add test to test list
		testList.add(test);

		// add test list to suite
		suite.setTests(testList);

		// add suite to suite list
		suiteList.add(suite);

		// print xml
		System.out.println(suite.toXml());

		testng.setXmlSuites(suiteList);

		return testng;
	}

	public Reflections getClasses() {
		final ConfigurationBuilder config = new ConfigurationBuilder()
				.setScanners(new ResourcesScanner(), new SubTypesScanner(false))
				.setUrls(ClasspathHelper.forPackage(testcasePackagePath))
				.filterInputsBy(new FilterBuilder().includePackage(testcasePackagePath));

		final Reflections reflect = new Reflections(config);

		return reflect;

	}

}
