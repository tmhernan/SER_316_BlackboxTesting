/*
Black box testing includes 16 tests
Version: 3/26

 */

package test.java;

import static org.junit.Assert.*;

import main.java.Course;
import main.java.CourseGrades0;
import main.java.CourseGrades1;
import main.java.CourseGrades2;
import main.java.CourseGrades3;
import main.java.CourseGrades4;
import main.java.CourseGrades5;

import java.lang.reflect.Constructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;




@RunWith(Parameterized.class)
public class GivenBlackbox {
    private Class<Course> classUnderTest;


    @SuppressWarnings("unchecked")
    public GivenBlackbox(Object classUnderTest) {
        this.classUnderTest = (Class<Course>) classUnderTest;
    }

    // Defining all the classes that need to be tested
    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = { 
                {CourseGrades0.class},
                {CourseGrades1.class},
                {CourseGrades2.class},
                {CourseGrades3.class},
                {CourseGrades4.class},
                {CourseGrades5.class}
        };
        return Arrays.asList(classes);
    }

    // method to call the correct constructor
    private Course createCourse(String name) throws Exception {
        Constructor<Course> constructor = classUnderTest.getConstructor(String.class);
        return constructor.newInstance(name);
    }


    // All Courses:
    Course oneStudentZeroP;
    HashMap<String, Integer> oneStudentZeroPExpected = new HashMap<String, Integer>();

    Course negOneStudent;
    HashMap<String, Integer> negOneStudentExpected = new HashMap<String, Integer>();

    Course noPoints;

    Course twoStudent;
    HashMap<String, Integer> twoStudentExpected = new HashMap<String, Integer>();

    Course oneStudent;
    HashMap<String, Integer> oneStudentExpected = new HashMap<String, Integer>();

    Course oneStudentClass2;
    HashMap<String, Integer> oneStudentClass2Expected = new HashMap<String, Integer>();

    Course oneStudentClass2F;
    HashMap<String, Integer> oneStudentClass2FExpected = new HashMap<String, Integer>();

    Course fiveStudentEdge;
    HashMap<String, Integer> fiveStudentEdgeExpected = new HashMap<String, Integer>();

    Course fiveStudentEdgeOpp;
    HashMap<String, Integer> fiveStudentEdgeOppExpected = new HashMap<String, Integer>();

    Course fiveStudentNegPos;
    HashMap<String, Integer> fiveStudentNegPosExpected = new HashMap<String, Integer>();

    Course threeStudent;
    HashMap<String, Integer> threeStudentExpected = new HashMap<String, Integer>();

    Course fourStudent;
    HashMap<String, Integer> fourStudentExpected = new HashMap<String, Integer>();

    Course fiveStudent;
    HashMap<String, Integer> fiveStudentExpected = new HashMap<String, Integer>();

    Course fiveStudentScale;
    HashMap<String, Integer> fiveStudentScaleExpected = new HashMap<String, Integer>();

    Course twoStdDupName;
    HashMap<String, Integer> twoStdDupNameExpected = new HashMap<String, Integer>();

    Course twoStdDupNameGr;
    HashMap<String, Integer> twoStdDupNameGrExpected = new HashMap<String, Integer>();

    Course fiveStudentZeroP;
    HashMap<String, Integer> fiveStudentZeroPExpected = new HashMap<String, Integer>();

    Course fiveStudentAllNeg;
    HashMap<String, Integer> fiveStudentAllNegExpected = new HashMap<String, Integer>();

    Course tenStudent;
    HashMap<String, Integer> tenStudentExpected = new HashMap<String, Integer>();

    @Before
    public void setUp() throws Exception {

        // all courses should be created like this

        //One Student with Zero Points
        oneStudentZeroP = createCourse("SER216");
        oneStudentZeroP.set_points("Anna", 0);
        oneStudentZeroPExpected.put("A", 0);
        oneStudentZeroPExpected.put("B", 0);
        oneStudentZeroPExpected.put("C", 0);
        oneStudentZeroPExpected.put("D", 0);
        oneStudentZeroPExpected.put("F", 0); //changed to zero per Aanchal Mahajan


        //One Student - negative points
        negOneStudent = createCourse("SER215");
        negOneStudent.set_points("Tiffany", -100);
        negOneStudentExpected.put("A", 0);
        negOneStudentExpected.put("B", 0);
        negOneStudentExpected.put("C", 0);
        negOneStudentExpected.put("D", 0);
        negOneStudentExpected.put("F", 0);

        //No Points - does not call set points
        noPoints = createCourse("SER222");

        //SER 316 - TWO students
        twoStudent = createCourse("SER316");
        twoStudent.set_points("Hanna",100);
        twoStudent.set_points("Karla",100);
        twoStudentExpected.put("A", 2);
        twoStudentExpected.put("B", 0);
        twoStudentExpected.put("C", 0);
        twoStudentExpected.put("D", 0);
        twoStudentExpected.put("F", 0);

        //SER 315 - 1 students
        oneStudent = createCourse("SER315");
        oneStudent.set_points("Hanna",100);
        oneStudentExpected.put("A", 1);
        oneStudentExpected.put("B", 0);
        oneStudentExpected.put("C", 0);
        oneStudentExpected.put("D", 0);
        oneStudentExpected.put("F", 0);

        //SER 315 - 1 student A grade
        oneStudentClass2 = createCourse("SER999");
        oneStudentClass2.set_points("Hanna",101);
        oneStudentClass2Expected.put("A", 1);
        oneStudentClass2Expected.put("B", 0);
        oneStudentClass2Expected.put("C", 0);
        oneStudentClass2Expected.put("D", 0);
        oneStudentClass2Expected.put("F", 0);

        //5 students - edge cases for all grades
        fiveStudentEdge = createCourse("ENG101");
        fiveStudentEdge.set_points("Jill",100);// B
        fiveStudentEdge.set_points("Jack",80);// C
        fiveStudentEdge.set_points("Anne",65);// D
        fiveStudentEdge.set_points("Doug",50);// F
        fiveStudentEdge.set_points("Bill",35);// F
        fiveStudentEdgeExpected.put("A", 1);
        fiveStudentEdgeExpected.put("B", 1);
        fiveStudentEdgeExpected.put("C", 1);
        fiveStudentEdgeExpected.put("D", 1);
        fiveStudentEdgeExpected.put("F", 1);

        //5 students - edge cases for all grades
        fiveStudentEdgeOpp = createCourse("ENG102");
        fiveStudentEdgeOpp.set_points("Jill",100);
        fiveStudentEdgeOpp.set_points("Jack",81);
        fiveStudentEdgeOpp.set_points("Anne",66);
        fiveStudentEdgeOpp.set_points("Doug",51);
        fiveStudentEdgeOpp.set_points("Bill",36);
        fiveStudentEdgeOppExpected.put("A", 2);
        fiveStudentEdgeOppExpected.put("B", 1);
        fiveStudentEdgeOppExpected.put("C", 1);
        fiveStudentEdgeOppExpected.put("D", 1);
        fiveStudentEdgeOppExpected.put("F", 0);

        //5 students - mix of negative and pos grades
        fiveStudentNegPos = createCourse("MAT147");
        fiveStudentNegPos.set_points("Jill",100);
        fiveStudentNegPos.set_points("Jack",81);
        fiveStudentNegPos.set_points("Anne",66);
        fiveStudentNegPos.set_points("Doug",-51);
        fiveStudentNegPos.set_points("Bill",-36);
        fiveStudentNegPosExpected.put("A", 2);
        fiveStudentNegPosExpected.put("B", 1);
        fiveStudentNegPosExpected.put("C", 0);
        fiveStudentNegPosExpected.put("D", 0);
        fiveStudentNegPosExpected.put("F", 0);

        //THREE students
        threeStudent = createCourse("MAT225");
        threeStudent.set_points("Hanna",100);
        threeStudent.set_points("Doug",100);
        threeStudent.set_points("Karla",100);
        threeStudentExpected.put("A", 3);
        threeStudentExpected.put("B", 0);
        threeStudentExpected.put("C", 0);
        threeStudentExpected.put("D", 0);
        threeStudentExpected.put("F", 0);

        //FOUR students
        fourStudent = createCourse("HST100");
        fourStudent.set_points("Hanna",100);
        fourStudent.set_points("Doug",100);
        fourStudent.set_points("Karla",100);
        fourStudent.set_points("Ann",100);
        fourStudentExpected.put("A", 4);
        fourStudentExpected.put("B", 0);
        fourStudentExpected.put("C", 0);
        fourStudentExpected.put("D", 0);
        fourStudentExpected.put("F", 0);

        //FIVE students
        fiveStudent = createCourse("PHY100");
        fiveStudent.set_points("Hanna",100);
        fiveStudent.set_points("Doug",100);
        fiveStudent.set_points("Karla",100);
        fiveStudent.set_points("Ann",100);
        fiveStudent.set_points("Dave",100);
        fiveStudentExpected.put("A", 5);
        fiveStudentExpected.put("B", 0);
        fiveStudentExpected.put("C", 0);
        fiveStudentExpected.put("D", 0);
        fiveStudentExpected.put("F", 0);

        //Five students on a non-typical scale which
        //produces one edge case, student Karla
        //(not out of 100 points)
        fiveStudentScale = createCourse("MAT334");
        fiveStudentScale.set_points("Hanna",333);//49 d
        fiveStudentScale.set_points("Doug",234);//34 f
        fiveStudentScale.set_points("Karla",537);// 82 a
        fiveStudentScale.set_points("Ann",672);// a
        fiveStudentScale.set_points("Dave",30);// f
        fiveStudentScaleExpected.put("A", 1);
        fiveStudentScaleExpected.put("B", 1);
        fiveStudentScaleExpected.put("C", 0);
        fiveStudentScaleExpected.put("D", 1);
        fiveStudentScaleExpected.put("F", 2);

        //TWO students with duplicate names/different scores
        twoStdDupName = createCourse("WOW100");
        twoStdDupName.set_points("Hanna",100);
        twoStdDupName.set_points("Hanna",30);
        twoStdDupNameExpected.put("A", 1);
        twoStdDupNameExpected.put("B", 0);
        twoStdDupNameExpected.put("C", 0);
        twoStdDupNameExpected.put("D", 0);
        twoStdDupNameExpected.put("F", 0); //changed to zero per Aanchal Mahajan

        //TWO students with duplicate names/different scores
        twoStdDupNameGr = createCourse("SOC100");
        twoStdDupNameGr.set_points("Hanna",100);
        twoStdDupNameGr.set_points("Hanna",100);
        twoStdDupNameGrExpected.put("A", 1); //changed to 1 per Aanchal Mahajan
        twoStdDupNameGrExpected.put("B", 0);
        twoStdDupNameGrExpected.put("C", 0);
        twoStdDupNameGrExpected.put("D", 0);
        twoStdDupNameGrExpected.put("F", 0);

        //Five students zero points
        fiveStudentZeroP = createCourse("ENG220");
        fiveStudentZeroP.set_points("Hanna",0);
        fiveStudentZeroP.set_points("Doug",0);
        fiveStudentZeroP.set_points("Karla",0);
        fiveStudentZeroP.set_points("Ann",0);
        fiveStudentZeroP.set_points("Dave",0);
        fiveStudentZeroPExpected.put("A", 0);
        fiveStudentZeroPExpected.put("B", 0);
        fiveStudentZeroPExpected.put("C", 0);
        fiveStudentZeroPExpected.put("D", 0);
        fiveStudentZeroPExpected.put("F", 0); //changed to zero per Aanchal Mahajan

        //Five students - All Negative grades
        fiveStudentAllNeg = createCourse("YYY100");
        fiveStudentAllNeg.set_points("Hanna",-55);
        fiveStudentAllNeg.set_points("Doug",-100);
        fiveStudentAllNeg.set_points("Karla",-34);
        fiveStudentAllNeg.set_points("Ann",-66);
        fiveStudentAllNeg.set_points("Dave", -78);
        fiveStudentAllNegExpected.put("A", 0);
        fiveStudentAllNegExpected.put("B", 0);
        fiveStudentAllNegExpected.put("C", 0);
        fiveStudentAllNegExpected.put("D", 0);
        fiveStudentAllNegExpected.put("F", 0);

        //Ten students zero points
        tenStudent = createCourse("ENG555");
        tenStudent.set_points("Hanna",100);
        tenStudent.set_points("Doug",99);
        tenStudent.set_points("Karla",66);
        tenStudent.set_points("Ann",67);
        tenStudent.set_points("Dave",55);
        tenStudent.set_points("Kel",56);
        tenStudent.set_points("Dog",36);
        tenStudent.set_points("Bell",37);
        tenStudent.set_points("Dell",3);
        tenStudent.set_points("Steve",2);
        tenStudentExpected.put("A", 2);
        tenStudentExpected.put("B", 2);
        tenStudentExpected.put("C", 2);
        tenStudentExpected.put("D", 2);
        tenStudentExpected.put("F", 2); 

        //Ten students zero points
        oneStudentClass2F = createCourse("ENG777");
        oneStudentClass2F.set_points("Hanna",10);
        oneStudentClass2FExpected.put("A", 1);
        oneStudentClass2FExpected.put("B", 0);
        oneStudentClass2FExpected.put("C", 0);
        oneStudentClass2FExpected.put("D", 0);
        oneStudentClass2FExpected.put("F", 0); 

    }

    // Sample test

    @Test
    public void oneStudentZeroP() {
        HashMap<String, Integer> ans = oneStudentZeroP.countOccurencesLetterGrades();
        System.out.println("\nnoneStudentZeroP - One Student with Zero Points");
        System.out.println(ans);
        assertTrue(ans.equals(oneStudentZeroPExpected));
    }

    @Test
    public void negOneStudent() {
        HashMap<String, Integer> ans = negOneStudent.countOccurencesLetterGrades();
        System.out.println("\nnegOneStudent - Negative Student: ");
        System.out.println(ans);
        assertTrue(ans.equals(negOneStudentExpected));
    } 

    @Test(expected =NullPointerException.class)
    public void noPoints() {
        HashMap<String, Integer> ans = noPoints.countOccurencesLetterGrades();
        System.out.println("\nnoPoints - No Points Expected nullPE: ");
        System.out.println(ans);
        //assertNull(ans);
    }    

    @Test
    public void twoStudent() {
        HashMap<String, Integer> ans = twoStudent.countOccurencesLetterGrades();
        System.out.println("\ntwoStudent - Two Student Test:");
        System.out.println(ans);
        assertTrue(ans.equals(twoStudentExpected));
    }

    @Test
    public void oneStudent() {
        HashMap<String, Integer> ans = oneStudent.countOccurencesLetterGrades();
        System.out.println("\noneStudent - SER 315: One Student Test:");
        System.out.println(ans);
        assertTrue(ans.equals(oneStudentExpected));
    }

    @Test
    public void oneStudentClass2() {
        HashMap<String, Integer> ans = oneStudentClass2.countOccurencesLetterGrades();
        System.out.println("\noneStudentClass2Expected - SER 315: One Student Test with another A:");
        System.out.println(ans);
        assertTrue(ans.equals(oneStudentClass2Expected));
    }

    @Test
    public void fiveStudentEdge() {
        HashMap<String, Integer> ans = fiveStudentEdge.countOccurencesLetterGrades();
        System.out.println("\nfiveStudentEdge - Five Students, Edge Cases");
        System.out.println(ans);
        assertTrue(ans.equals(fiveStudentEdgeExpected));
    }

    @Test
    public void fiveStudentEdgeOpp() {
        HashMap<String, Integer> ans = fiveStudentEdgeOpp.countOccurencesLetterGrades();
        System.out.println("\nfiveStudentEdgeOpp - Five Students, Opposite Edge Cases");
        System.out.println(ans);
        assertTrue(ans.equals(fiveStudentEdgeOppExpected));
    }

    @Test
    public void fiveStudentNegPos() {
        HashMap<String, Integer> ans = fiveStudentNegPos.countOccurencesLetterGrades();
        System.out.println("\nfiveStudentNegPos - Five Students, Negative and Positive Mixed Grades");
        System.out.println(ans);
        assertTrue(ans.equals(fiveStudentNegPosExpected));
    }

    @Test
    public void threeStudent() {
        HashMap<String, Integer> ans = threeStudent.countOccurencesLetterGrades();
        System.out.println("\nthreeStudent - Three students");
        System.out.println(ans);
        assertTrue(ans.equals(threeStudentExpected));
    }     

    @Test
    public void fourStudent() {
        HashMap<String, Integer> ans = fourStudent.countOccurencesLetterGrades();
        System.out.println("\nfourStudent - Four students");
        System.out.println(ans);
        assertTrue(ans.equals(fourStudentExpected));
    } 

    @Test
    public void fiveStudent() {
        HashMap<String, Integer> ans = fiveStudent.countOccurencesLetterGrades();
        System.out.println("\nfiveStudent - Five students");
        System.out.println(ans);
        assertTrue(ans.equals(fiveStudentExpected));
    } 

    @Test
    public void fiveStudentScale() {
        HashMap<String, Integer> ans = fiveStudentScale.countOccurencesLetterGrades();
        System.out.println("\nfiveStudentScale - Five students with a non-typical point scale");
        System.out.println(ans);
        assertTrue(ans.equals(fiveStudentScaleExpected));
    } 

    @Test
    public void twoStdDupName() {
        HashMap<String, Integer> ans = twoStdDupName.countOccurencesLetterGrades();
        System.out.println("\ntwoStdDupName - two students, same name different scores");
        System.out.println(ans);
        assertTrue(ans.equals(twoStdDupNameExpected));
    } 

    @Test
    public void twoStdDupNameGr() {
        HashMap<String, Integer> ans = twoStdDupNameGr.countOccurencesLetterGrades();
        System.out.println("\ntwoStdDupNameGr - two students, same name different scores");
        System.out.println(ans);
        assertTrue(ans.equals(twoStdDupNameGrExpected));
    } 


    @Test
    public void fiveStudentZeroP() {
        HashMap<String, Integer> ans = fiveStudentZeroP.countOccurencesLetterGrades();
        System.out.println("\nfiveStudentZeroP - five students, all zero points");
        System.out.println(ans);
        assertTrue(ans.equals(fiveStudentZeroPExpected));
    }

    @Test
    public void fiveStudentAllNeg() {
        HashMap<String, Integer> ans = fiveStudentAllNeg.countOccurencesLetterGrades();
        System.out.println("\nfiveStudentAllNeg - five students, all neg points");
        System.out.println(ans);
        assertTrue(ans.equals(fiveStudentAllNegExpected));
    }

    @Test
    public void tenStudent() {
        HashMap<String, Integer> ans = tenStudent.countOccurencesLetterGrades();
        System.out.println("\ntenStudent - ten students, 2 per grade");
        System.out.println(ans);
        assertTrue(ans.equals(tenStudentExpected));
    }

    @Test
    public void oneStudentClass2F() {
        HashMap<String, Integer> ans = oneStudentClass2F.countOccurencesLetterGrades();
        System.out.println("\noneStudentClass2F- to test class 2");
        System.out.println(ans);
        assertTrue(ans.equals(oneStudentClass2FExpected));
    }


}

