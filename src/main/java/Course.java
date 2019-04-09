package main.java;
/**
 * class for managing course statistics
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import main.java.Student;


/**
Class:Course

Description: Holds a number of hashmpas which hold student data relating to their name, 
course and points in the course. Methods include calculating a variation of the course 
average and printing course statistics. 
 */
public class Course {
    // maps student names (asurite) to their points
    public HashMap<String, Integer> points = new HashMap<>(); 
    private String name; // course name


    public Course(String name) { 
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void printCourseStats() {
        //SER316 TASK 2 SPOTBUGS FIX
        // ArrayList<Integer> values = new ArrayList<Integer>(points.values());

        System.out.print("Average Grades without max and without min: ");
        System.out.println(this.calculateAverageWithoutMinWithoutMax());
    }


    // REACH at least 95% Code coverage (assign 3)
    // method to draw node graph for
    // should throw null pointer for empty points member
    // negative points should be ignored
    // max value and min value should be removed - (if doubles then only the first occurrence)
    // if just one or two values no values will be omitted
    public double calculateAverageWithoutMinWithoutMax() throws NullPointerException {

        ArrayList<Integer> collection = new ArrayList<Integer>(points.values());   
        int counter = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //SER316-START
        //Changed to ignore negative points as specification stated
        if (collection.size() == 1 && collection.get(0) >= 0) {
            //SER316-END
            return collection.get(0);
        }
        //SER316-START
        //Changed to ignore negative points as specification stated
        else if (collection.size() == 2 && collection.get(0) >= 0 && collection.get(1) >= 0 ) {
            //SER316-END
            return (double)(collection.get(0) + collection.get(1)) / 2;
        }
        else {
            int allPoints = 0;
            for (int point: collection) {
                if (point >= 0) {
                    counter++;//SER316 TASK 2 SPOTBUGS FIX
                    if (point < min){
                        min = point;
                    }
                    if (point > max) {
                        max = point;
                    }
                    allPoints = allPoints + point;
                    //System.out.println( " Point: " + point);
                }
            }
            int totalPoints = allPoints - max - min;
            //System.out.println("total points are: " + totalPoints + " all points: " + allPoints);
            //System.out.println("min " + min + " max: " + max);
            /*
             * SER316-START
             *Changed to avoid a zero point total being divided by
             *-2. Algorithm now gives correct average when given all
             *negative point scores
             */
            if (totalPoints == 0 || allPoints == 0) {
                return 0;
            }
            else {
                return totalPoints / (double)(counter - 2 ); 
            }
            //SER316-END
        }
    }

    // REACH at least 95% Code coverage  (assign 3)
    // if student with the name (asurite member) is not yet 
    //included student needs to be added to student list 
    // sets points for a student 
    ArrayList<Student> students  = new ArrayList<Student>();
    @SuppressWarnings("unlikely-arg-type")
    public void set_points(String name, int points) {
        //Added to ignore those students that already exist per specification
        if (this.points.containsValue(name) == false ) { 
        //System.out.println(name + " " + points);
            addStudent(new Student(name, Major.valueOf("SER")));
            this.points.put(name, points);
        } else {
        //System.out.println(name + " could not be added as " + name + " already exists.");
        }
        System.out.println(points);
        this.points.put(name, points);
    }


    // REACH at least 95% Code coverage  
    //(assign 3)
    // Students should only be added when they are not yet in the course (names (asurite member) needs to be unique)
    // Students should only be added when they are not yet in
    //the course (names (asurite member) needs to be unique)
    public boolean addStudent(Student s) {
        //SER316-START
        if (students.contains(s)) {
            return false;
        }
        students.add(s);
        points.put(s.getAsurite(), -1);
     
        return true;  
        //SER316-END
    }


    public HashMap<String, Integer> getPoints() {
        return points;
    }


    public int getStudent_Points(String student) {
        return points.get(student);
    }

    public int getStudent_Points(Student student) {
        return points.get(student.getAsurite());
    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public HashMap<String, Integer> countOccurencesLetterGrades() throws NullPointerException {
        return null;

    }



}