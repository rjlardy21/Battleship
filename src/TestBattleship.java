//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: TestBattleship
// Files: Battleship, Config
// Course: CS200 Spring 2018
//
// Author: Reece Lardy
// Email: RLardy@wisc.edu
// Lecturer's Name: Mark Renault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Matthew Jacus
// Partner Email: jacus@wisc.edu
// Lecturer's Name: Mark Renault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates
// strangers, etc do. If you received no outside help from either type of
// source, then please explicitly indicate NONE.
//
// Persons: (NONE)
// Online Sources: (NONE)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * This file contains testing methods for the Battleship project. These methods are intended to
 * provide an example of a way to incrementally test your code, and to provide example method calls
 * for the Battleship methods
 *
 * Toward these objectives, the expectation is that part of the grade for the Battleship project is
 * to write some tests and write header comments summarizing the tests that have been written.
 * Specific places are noted with FIXME but add any other comments you feel would be useful.
 */

import java.util.Random;
import java.util.Scanner;

/**
 * This class contains a few methods for testing methods in the Battleship class as they are
 * developed. These methods are all private as they are only intended for use within this class.
 * 
 * @author Reece Lardy
 * @author Matt Jacus
 *
 */
public class TestBattleship {

    /**
     * This is the main method that runs the various tests. Uncomment the tests when you are ready
     * for them to run.
     * 
     * @param args (unused)
     */
    public static void main(String[] args) {
        // Milestone 1
        testCoordAlphaToNum();
        testCoordNumToAlpha();
        // Milestone 2
        testCheckWater();
        testPlaceShip();
        // Milestone 3
        testTakeShot();
        testCheckLost();
    }

    private static void testCoordAlphaToNum() {
        // tests functionality of coordAlphaToNum method
        int numTests = 2; // declares integer numTests and assigns it with 2
        int passed = numTests; // declares integer passed and assigns it with the value of numTests
        int res; // declares integer res
        // following if statements run if method test fails
        if ((res = Battleship.coordAlphaToNum("BABB")) != 17603) {
            System.out.println("FAILED: Battleship.coordAlphaToNum(\"BABB\") != 17603, but " + res);
            passed--;
        }
        if ((res = Battleship.coordAlphaToNum("ZZY")) != 17574) {
            System.out.println("FAILED: Battleship.coordAlphaToNum(\"ZZY\") != 17574, but " + res);
            passed--;
        }
        // following print line shows how many tests passed
        System.out.println("testCoordAlphatoNum: Passed " + passed + " of " + numTests + " tests.");
    }

    private static void testCoordNumToAlpha() {
        // tests the functionality of the coordNumToAlpha method
        int numTests = 2; // declares integer numTests and assigns it with 2
        int passed = numTests; // declares integer passed and assigns it with the value of numTests
        String res; // declares string res
        // following if statements run if method test fails
        if (!(Battleship.coordNumToAlpha(31834)).equals("BVCK")) {
            res = Battleship.coordNumToAlpha(31834);
            System.out.println("FAILED: Battleship.coordNumToAlpha(31834) != BVCK, but " + res);
            passed--;
        }
        if (!(Battleship.coordNumToAlpha(318342)).equals("SCXY")) {
            res = Battleship.coordNumToAlpha(318342);
            System.out.println("FAILED: Battleship.coordNumToAlpha(11506714) != SCXY, but " + res);
            passed--;
        }
        // following print line shows how many tests passed
        System.out.println("testCoordNumtoAlpha: Passed " + passed + " of " + numTests + " tests.");
    }

    private static void testCheckWater() {
        // tests functionality of CheckWater method
        int numTests = 2; // declares integer numTests and assigns it with 2
        char[][] myboard = new char[3][3]; // declares two dimensional array myboard
        int passed = numTests; // declares integer passed and assigns it to the value of numTests
        int res; // declares integer res
        // following for statements run through every cell on board and assigns them to
        // Config.WATER_CHAR
        for (int i = 0; i < myboard.length; i++) {
            for (int j = 0; j < myboard[i].length; j++) {
                myboard[i][j] = Config.WATER_CHAR;
            }
        }
        // following if statements run if method test fails
        if ((res = Battleship.checkWater(myboard, 2, 1, 2, false)) != -2) {
            System.out.println(
                "FAILED: Battleship.checkWater(myboard, 2, 1, 2, false) != -1, but " + res);
            passed--;
        }
        if ((res = Battleship.checkWater(myboard, 1, 1, 1, true)) != 1) {
            System.out
                .println("FAILED: Battleship.checkWater(myboard, 1, 1, 1, true) != 1, but " + res);
            passed--;
        }
        // following print line shows how many tests passed
        System.out.println("testCheckWater: Passed " + passed + " of " + numTests + " tests.");
    }

    private static void testPlaceShip() {
        // tests functionality of placeShip method
        int numTests = 2; // declares integer numTests and assigns it with 2
        char[][] myboard = new char[3][3]; // declares two dimensional array myboard
        int passed = numTests; // declares integer passed and assigns it to numTests
        boolean res; // declares boolean res
        // following for statements run through every cell on the board and assigns them to
        // Config.WATER_CHAR
        for (int i = 0; i < myboard.length; i++) {
            for (int j = 0; j < myboard[i].length; j++) {
                myboard[i][j] = Config.WATER_CHAR;
            }
        }
        // following if statements run if method test fails
        if ((res = Battleship.placeShip(myboard, 1, 1, 1, true, 3)) != true) {
            System.out.println(
                "FAILED: Battleship.placeShip(myboard, 1, 1, 1, true, 3) != true, but " + res);
            passed--;
        }
        if ((res = Battleship.placeShip(myboard, 2, 1, 3, true, 3)) != false) {
            System.out.println(
                "FAILED: Battleship.placeShip(myboard, 2, 1, 3, true, 3) != false, but " + res);
            passed--;
        }
        // following print line shows how many tests passed
        System.out.println("testPlaceShip: Passed " + passed + " of " + numTests + " tests.");
    }

    private static void testTakeShot() {
        // tests functionality of takeShot method
        int numTests = 2; // declares integer numTests and assigns it with 2
        char[][] myboard = new char[3][3]; // declares two dimensional array myboard
        int passed = numTests; // declares integer passed and assigns it to the value of numTests
        int res; // declares integer res
        // following for statements run through every cell on the board and assigns them to
        // Config.WATER_CHAR
        for (int i = 0; i < myboard.length; i++) {
            for (int j = 0; j < myboard[i].length; j++) {
                myboard[i][j] = Config.WATER_CHAR;
            }
        }
        // following if statements run if method test fails
        if ((res = Battleship.takeShot(myboard, 2, 4)) != -1) {
            System.out.println("FAILED: Battleship.takeShot(myboard, 2, 4) != -1, but " + res);
            passed--;
        }
        if ((res = Battleship.takeShot(myboard, 2, 1)) != 2) {
            System.out.println("FAILED: Battleship.takeShot(myboard, 2, 1) != 2, but " + res);
            passed--;
        }
        // following print line shows how many tests passed
        System.out.println("testTakeShot: Passed " + passed + " of " + numTests + " tests.");
    }

    private static void testCheckLost() {
        // tests functionality of checkLost method
        int numTests = 2; // declares integer numTests and assigns it with 2
        char[][] myboard = new char[3][3]; // declares two dimensional array myboard
        int passed = numTests; // declares integer passed and assigns it to the value of numTests
        boolean res; // declares boolean res
        // following for statements run through every cell on the board and assigns them to
        // Config.WATER_CHAR
        for (int i = 0; i < myboard.length; i++) {
            for (int j = 0; j < myboard[i].length; j++) {
                myboard[i][j] = Config.WATER_CHAR;
            }
        }
        // following if statements run if method test fails
        if ((res = Battleship.checkLost(myboard)) != true) {
            System.out.println("FAILED: Battleship.checkLost(myboard) != true, but " + res);
            passed--;
        }
        myboard[2][2] = '1';
        if ((res = Battleship.checkLost(myboard)) != false) {
            System.out.println("FAILED: Battleship.checkLost(myboard) != false, but " + res);
            passed--;
        }
        // following print line shows how many tests passed
        System.out.println("testCheckLost: Passed " + passed + " of " + numTests + " tests.");
    }



}
