# Black Box Testing Assignment Instructions. Code in blackbox branch.
### SEE BlackboxResults-tmhernan.pdf for assignment results.

## Objectives
In this assignment you will use JUnit to test a software. You can use Eclipse for it or
a different IDE (the description in the document is for Eclipse). The important thing is
that it runs with Gradle.
  1. Understand black-box, or specification-based unit testing
  2. Practice best practices in black box unit testing in JUnit

## Setup
You will need a few things for this assignment:

  • You will maintain a separate documentation file.
  • This assignment is meant to be used with JUnit 4. For this assignment I expect you
  to stick with this version. The Gradle file included is meant for JUnit 4. For your
  project you can choose if you want to use JUnit 4 or 5. I stick with JUnit 4 since I
  think it is a bit easier to get started, especially in Gradle.
  Getting started (10 points)
  
    1. Watch the provided video for this assignment, it will tell you how to run the program,
    some specifics about the given Unit Test classes and what I expect.
    2. Download the zip file containing the code for this assignment (we will use the same
    code in some of the future assignments so some things are included which you do
    not need yet).
    3. Unzip the folder and create a private GitHub repo called "asurite-SER316" in which
    you upload the code. Add the user ser316asu as collaborator to this repository (this
    represents me and the graders).
    4. Add an appropriate gitignore file for this project.
    5. As in assignment 1 protect the master branch, so that only PullRequests can be
    merged after they have been approved.
    6. Create a branch called "Blackbox", this will be the branch you will be working on!
    7. The master branch DOES NOT CHANGE in this assignment!
    8. Only one file "GivenBlackBox" changes in this assignment, nothing else!
    
## Testing (40 points)
  Import the project into your IDE (see video provided with this assignment it explains
  what is needed).
  It is a very simplified system (I took a lot out to make it easier to manage). It is not
  well implemented and that is on purpose. We want to make this code better during the
  next couple of assignments.
  Start of with running the Main and figuring out what the program does. We will focus
  on Course.java for task 2 and theCourseGrades0-5.class (no source code for these).
  Important: a test only counts as test if it tests something, just running the code is not
  testing it. The results need to be checked.

### Task 1: Black-box testing
  For this Black-box testing we want to test the classes CourseGrades0-5.class. For these
  classes you do NOT have the source files (thus Black-box testing). All of these 6 classes
  are supposed to implement the same thing (imagine it was a homework and 6 students
  submitted it).
  Your main task is to find out which of them works correctly and which mistakes the
  other ones have (so it is not enough to just find the correct one you need to list all the
  errors you find).
  
  Some specifics:
  
    1. All CourseGrades classes inherit from Course.java. They do not add any new members. They include a method printCourseStats() which prints some information (but
    does not need testing it is the same for all CourseGrades classes).
    2. You are supposed to test the method countOccurencesLetterGrades(). The specification for this method is as follows:
     
     ```
      /**
      * Calculates how often each letter grade occurs
      *
      * Calculation is based on the points member inherited from Course.
      * Percentage is calculated by dividing the points by max value in points list.
      * Negative points are discarded.
      * Grading scale:
      * >80% -> A
      * >65% -> B
      * >50% -> C
      * >35% -> D
      * <= 35% -> F
      * eg. let points = [5, 10, 15, 20, 30], then max would be 30
      * percentages would be [16.66, 33.3, 50, 66.66, 100]
      * returned HashMap [A:1, B:1, C:0, D:1, F:2]
      *
      * @return HashMap<String, Integer> mapping letter grades
      * A, B, C, D, F to number of occurrence
      * @throws NullPointerException
      * @exception NullPointerException if no values in points member
      */
      @Override
      public HashMap<String, Integer> countOccurencesLetterGrades()
      ```
      
  3. You will notice a JUnit test file, GivenBlackBox.java. Run it by right-clicking and
  doing ”Run As...” and select JUnit test. If you have not watched the given video
  yet, please do so now to get information about what this Test class does (it helps
  you test all CourseGrades classes with the same data).
  4. Use the given test class and enhance it to include more test cases, testing the same
  method for the different classes.
  5. Your task is to black box test all classes based on the specification.
  6. Remember equivalence partitions and boundary value analyses. Make sure you name
  your test cases well, so that you see which cases fail (and so we will see).
  7. Choose your test cases well, so that you can accurately tell which implementation
  has which errors.
  8. Answer in your document:
  • Which algorithm adheres to the specification and which do not?
  • Explain how the algorithms do not adhere to the specification (I want to know
  all the errors you were able to find).
  • Explain which test cases you chose and why.
  9. Run JUnit from Gradle. The Gradle file already includes JUnit 4. You can run your
  test cases through "gradle test" in your command line. The build will fail, since test
  cases fail (which is ok in this assignment, since you cannot fix the errors).
  Review the output of the report generated (check in the build/reports/... folder).
  Take a screenshot of the test summary (index.html) and include a screenshot in your
  document under task 1 (showing your html report, your command prompt showing
  what you called and the output and your name/asurite somewhere).

### Task 2: Gradle - 5 Points
The given Gradle file already includes a lot which is still commented. Leave it as is, we
will need this later in the other assignments.
The Gradle file already includes Jacoco. Jacoco is part of the EclEmma Plugin and can
also give you information about code coverage. Your test results, which were created by
”gradle test” showed you the tests you have run and if they were successful. Now we also
want to see the code coverage (which will not be a lot yet).
Run "gradle jacocoTestReport". This should generate an HTML test report informing
you about the code coverage, find the folder where this report is included in your build
directory.
Take a screenshot of your command window, and your opened HTML file with your
coverage report and your name showing somewhere on the screen (or asurite or something
to identify you). Include this screenshot in your document. Put this under Task 2.
