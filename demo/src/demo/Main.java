package demo;

import org.testng.TestNG;

public class Main {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Devops1APITest.class });
        testng.run();
    }
}
