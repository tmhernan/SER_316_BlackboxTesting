package test.java;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import main.java.Course;
import main.java.Major;
import main.java.Student;


public class CourseTest {

    Course oneStudent;
    Course twoStudent;
    Course threeStudent;
    Course threeNegStudent;
    Course threeStudentLessMinMax;
    Course addStudentOne;
    Course addOneSetPoint;


    
    @Before
    public void setUp() throws Exception {
    }

    //TS 1
    @Test
    public void testAverageWithoutMinWithoutMax() {
        // One Student
        oneStudent = new Course("SER316");
        oneStudent.set_points("Hanna", 50);
        double ans = oneStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 50.0);
    }
    //TS 3
    @Test
    public void testAverageWithoutMinWithoutMaxthreeStudentLessMinMax() {
        // Variation of Three Student
    	threeStudentLessMinMax = new Course("SER415");
    	threeStudentLessMinMax.set_points("Anna", 20);
    	threeStudentLessMinMax.set_points("Joe", 30);
    	threeStudentLessMinMax.set_points("Ben", 10);
        double ans = threeStudentLessMinMax.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 20.0);
    }
    //TS 2
    @Test
    public void testAverageWithoutMinWithoutMaxTwoStudent() {
        // Two Student
    	twoStudent = new Course("SER322");
    	twoStudent.set_points("Max", 50);
    	twoStudent.set_points("Dav", 50);
        double ans = twoStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 50.0);
    }
    
    //TS 6
    @Test
    public void testAverageWithoutMinWithoutMaxThreeStudent() {
        // Three Student - all the same
    	threeStudent = new Course("SER322");
    	threeStudent.set_points("Yin", 50);
    	threeStudent.set_points("Rav", 50);
    	threeStudent.set_points("Sam", 50);
        double ans = threeStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 50.0);
    } 
    
    //TS 5
    @Test
    public void testAverageWithoutMinWithoutMaxThreeNegStudent() {
        // Three Student - all negative
    	threeNegStudent = new Course("SER315");
    	threeNegStudent.set_points("Jen", -50);
    	threeNegStudent.set_points("Alex", -50);
    	threeNegStudent.set_points("Eve", -50);
        double ans = threeNegStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 0.0);
    } 
    
    
    @Test
    //Testing addStudent method in Course class
    //Test when it can and went it can't add a student
    public void testaddStudentOne() {
    	addStudentOne = new Course("SER416");
    	boolean ans = addStudentOne.addStudent(new Student("Don", Major.valueOf("SER")));
    	boolean ans2 = addStudentOne.addStudent(new Student("Don", Major.valueOf("SER")));
        assertTrue(ans);
        assertFalse(ans2);
    }
    
    
    @Test
    //Testing set_points method in Course class
    //Testing if student is in hashmap points and arraylist students
    //Test when it can and went it can't add a student
    public void testSetPoints() {
    	addOneSetPoint = new Course("SER500");
    	addOneSetPoint.set_points("Jen", 50);
    	boolean ans = addOneSetPoint.points.containsKey("Jen");
    	boolean ans2 = addOneSetPoint.addStudent(new Student("Jen", Major.valueOf("SER")));
    	assertTrue(ans);
        assertFalse(ans2);
    } 
	
	
}
