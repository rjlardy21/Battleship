//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Battleship
// Files: TestBattleship, Config
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

import java.util.Scanner;
import java.util.Random;

public class Battleship {

    /**
     * This method converts a String representing a base (or radix) 26 number into a decimal (or
     * base 10) number. The String representation of the base 26 number uses the letters of the
     * Latin alphabet to represent the 26 digits. That is, A represents 0, B represents 1, C
     * represents 2, ..., Y represents 24, and Z represents 25.
     *
     * A couple of examples: BAAA = 1 * 26^3 + 0 * 26^2 + 0 * 26^1 + 0 * 26^0 = 17576 ZERTY = 25 *
     * 26^4 + 4 * 26^3 + 17 * 26^2 + 19 * 26^1 + 24 * 26^0 = 11506714
     *
     * For this method: - use Math.pow to calculate the powers of 26. - don't assume that the input
     * is in any particular case; use toUpperCase(). - don't check that the input is only 'A' to
     * 'Z'. - calculate the value of each digit relative to 'A'. - start from either the first or
     * last character, and calculate the exponent based on the index of each character.
     *
     * @param coord The coordinate value in base 26 as described above.
     * @return The numeric representation of the coordinate.
     */
    public static int coordAlphaToNum(String coord) {
        /*
         * method changes an input string representing a base 26 number into a base 10 number
         */
        char ch1; // declares char ch1
        int res = 0; // declares integer res
        coord = coord.toUpperCase();
        for (int i = 0; i < coord.length(); i++) {
            ch1 = coord.charAt(i);
            int num1 = ch1 - 65; // finds ascii value of each individual letter in input string
            int num2 = (int) (Math.pow(26, coord.length() - 1 - i));
            res = (num1 * num2) + res; // converts string represented with a base 26 number into
                                       // base 10 number
        }
        return res;
    }

    /**
     * This method converts an int value into a base (or radix) 26 number, where the digits are
     * represented by the 26 letters of the Latin alphabet. That is, A represents 0, B represents 1,
     * C represents 2, ..., Y represents 24, and Z represents 25. A couple of examples: 17576 is
     * BAAA, 11506714 is ZERTY.
     *
     * The algorithm to convert an int to a String representing these base 26 numbers is as follows:
     * - Initialize res to the input integer - The next digit is determined by calculating the
     * remainder of res with respect to 26 - Convert this next digit to a letter based on 'A' - Set
     * res to the integer division of res and 26 - Repeat until res is 0
     *
     * @param coord The integer value to covert into an alpha coordinate.
     * @return The alpha coordinate in base 26 as described above. If coord is negative, an empty
     *         string is returned.
     */
    public static String coordNumToAlpha(int coord) {
        /*
         * converts integer into a base 26 number in which each digit represents a letter
         */
        int res = coord; // declares integer res
        String str = ""; // declares string str
        char ch; // declares char ch
        int i = 0; // declares int i

        if (res == 0) {
            return ((char) (65) + str);
        }
        // following loop runs until integer division of res is zero
        while (res != 0) {
            if (coord < 0) {
                return str = "";
            }
            i = res % 26; // calculates remainder of res
            res = res / 26; // calculates integer division of res
            ch = (char) (i + 65); // converts ascii value of remainder into a letter
            str = ch + str; // adds letters together after each run through
        }
        return str;
    }

    /**
     * Prompts the user for an integer value, displaying the following: "Enter the valName (min to
     * max): " Note: There should not be a new line terminating the prompt. valName should contain
     * the contents of the String referenced by the parameter valName. min and max should be the
     * values passed in the respective parameters.
     *
     * After prompting the user, the method will read an int from the console and consume an entire
     * line of input. If the value read is between min and max (inclusive), that value is returned.
     * Otherwise, "Invalid value." terminated by a new line is output and the user is prompted
     * again.
     *
     * @param sc The Scanner instance to read from System.in.
     * @param valName The name of the value for which the user is prompted.
     * @param min The minimum acceptable int value (inclusive).
     * @param min The maximum acceptable int value (inclusive).
     * @return Returns the value read from the user.
     */
    public static int promptInt(Scanner sc, String valName, int min, int max) {
        // method promps user for an integer value
        System.out.print("Enter the " + valName + " (" + min + " to " + max + "): ");
        // integer i declared and assigned with the user input integer
        int i = sc.nextInt();
        // following loop run while input integer is outside of given min and max values
        while (min > i || i > max) {
            System.out.println("Invalid value.");
            System.out.print("Enter the " + valName + " (" + min + " to " + max + "): ");
            i = sc.nextInt();
        }
        // gets rid of trailing whitespace
        sc.nextLine();

        return i;

    }

    /**
     * Prompts the user for an String value, displaying the following: "Enter the valName (min to
     * max): " Note: There should not be a new line terminating the prompt. valName should contain
     * the contents of the String referenced by the parameter valName. min and max should be the
     * values passed in the respective parameters.
     *
     * After prompting the user, the method will read an entire line of input, trimming any trailing
     * or leading whitespace. If the value read is (lexicographically ignoring case) between min and
     * max (inclusive), that value is returned. Otherwise, "Invalid value." terminated by a new line
     * is output and the user is prompted again.
     *
     * @param sc The Scanner instance to read from System.in.
     * @param valName The name of the value for which the user is prompted.
     * @param min The minimum acceptable String value (inclusive).
     * @param min The maximum acceptable String value (inclusive).
     * @return Returns the value read from the user.
     */
    public static String promptStr(Scanner sc, String valName, String min, String max) {
        // this method prompts the user for a string value
        System.out.print("Enter the " + valName + " (" + min + " to " + max + "): ");
        // string str assigned with the next line of input from the user
        String str = sc.nextLine();
        // trims input string to eliminate unneccesary whitespace
        str = str.trim();
        /*
         * following loop runs while input string is outside given String min and String max
         */
        while (str.compareToIgnoreCase(min) < 0 || str.compareToIgnoreCase(max) > 0) {
            System.out.println("Invalid value.");
            System.out.print("Enter the " + valName + " (" + min + " to " + max + "): ");
            str = sc.nextLine();
        }
        // returns trimmed input string that is within min an max bounds
        return str;
    }

    /**
     * Prompts the user for an char value. The prompt displayed is the contents of the String
     * referenced by the prompt parameter. Note: There should not be a new line terminating the
     * prompt.
     *
     * After prompting the user, the method will read an entire line of input and return the first
     * non-whitespace character in lower case.
     *
     * @param sc The Scanner instance to read from System.in
     * @param prompt The user prompt.
     * @return Returns the first non-whitespace character (in lower case) read from the user. If
     *         there are no non-whitespace characters read, the null character is returned.
     */
    public static char promptChar(Scanner sc, String prompt) {
        // prompts the user for a char value
        char ch; // declares character variable ch
        // prints out given prompt for user
        System.out.print(prompt);
        // assigns character ch to the next letter input from the user
        ch = sc.next().charAt(0);

        return ch;
    }

    /**
     * Initializes a game board so that all the entries are Config.WATER_CHAR.
     *
     * @param board The game board to initialize.
     */
    public static void initBoard(char board[][]) {
        // initializes the game board so all entries are Config.WATER_CHAR before game
        // begins
        /*
         * following loop runs through every individual cell on the board and assigns it to
         * Config.WATER_CHAR
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Config.WATER_CHAR;
            }
        }
    }

    /**
     * Prints the game boards as viewed by the user. This method is used to print the game boards as
     * the user is placing their ships and during the game play.
     *
     * Some notes on the display: - Each column printed will have a width of Config.MAX_COL_WIDTH. -
     * Each row is followed by an empty line. - The values in the headers and cells are to be right
     * justified.
     *
     * @param board The board to print.
     * @param caption The board caption.
     */
    public static void printBoard(char board[][], String caption) {
        /*
         * this method prints the game board as the user and computer places their ships throughout
         * the game
         */
        char c = 'A'; // declares character c and initializes it with 'A'
        // prints out given caption
        System.out.println(caption);
        String spaces = ""; // initializes string spaces with ""
        System.out.print(" ");
        // following loop runs through each column and adds whitespace to any unused
        // space
        for (int k = 0; k < Config.MAX_COL_WIDTH - 1; k++) {
            spaces = " " + spaces;
        }
        System.out.print("  ");
        // following loop runs through every space in a row and prints it's contents
        for (int g = 0; g < board[0].length; g++) {
            System.out.print(spaces + c);
            c = (char) (c + 1);
        }
        System.out.println("");
        // following loop runs through every space in a column and print's it's contents
        for (int i = 0; i < board.length; i++) {
            System.out.print(spaces + i);
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(spaces + board[i][j]);
            }
            System.out.println();
            System.out.println();
        }

    }

    /**
     * Determines if a sequence of cells of length len in a game board is clear or not. This is used
     * to determine if a ship will fit on a given game board. The x and y coordinates passed in as
     * parameters represent the top-left cell of the ship when considering the grid.
     * 
     * @param board The game board to search.
     * @param xcoord The x-coordinate of the top-left cell of the ship.
     * @param ycoord The y-coordinate of the top-left cell of the ship.
     * @param len The length of the ship.
     * @param dir true if the ship will be vertical, otherwise horizontal
     * @return 1 if the cells to be occupied by the ship are all Config.WATER_CHAR, -1 if the cells
     *         to be occupied are not Config.WATER_CHAR, and -2 if the ship would go out-of-bounds
     *         of the board.
     */
    public static int checkWater(char board[][], int xcoord, int ycoord, int len, boolean dir) {
        /*
         * this method checks to see if there is enough water space for a ship to fit on the given
         * game board
         */
        // following loop runs if ship is placed off the board
        if (ycoord >= board.length || ycoord < 0 || xcoord >= board[ycoord].length || xcoord < 0) {
            return -2;
        }
        /*
         * following loop runs for a verticle placed ship and checks the spaces for water
         */
        if (dir == true) {
            for (int i = 0; i < len; i++) {
                if (ycoord + i >= board.length) {
                    return -2;
                } else if (board[ycoord + i][xcoord] != Config.WATER_CHAR) {
                    return -1;
                }
            }
        } else {
            /*
             * following loop runs for a horizontal placed ship and checks the spaces for water
             */
            for (int j = 0; j < len; j++) {
                if (xcoord + j >= board[ycoord].length) {
                    return -2; // returns -2 if out of bounds
                } else if (board[ycoord][xcoord + j] != Config.WATER_CHAR) {
                    return -1; // returns -1 if there is at least one space that isn't water

                }
            }
        }
        return 1; // returns 1 if desired position is all water characters
    }

    /**
     * Checks the cells of the game board to determine if all the ships have been sunk.
     *
     * @param board The game board to check.
     * @return true if all the ships have been sunk, false otherwise.
     */
    public static boolean checkLost(char board[][]) {
        /*
         * this method checks if all the ships have been sunk following loop runs through every
         * space and checks if space is water, ship or a hit
         */
        for (int i = 0; i < board.length; i++) { // declares int i to loop through every column
            for (int j = 0; j < board[0].length; j++) { // declares int j to loop through every row
                for (int g = 1; g < 10; g++) { // declares int g to represent id of ships
                    if (board[i][j] == (char) (48 + g)) { // checks if the cell has a ship id
                                                          // assigned to it
                        // returns false if not all ships are sunk
                        return false;
                    }
                }
            }
        }
        return true; // returns true if all ships have been sunk
    }

    /**
     * Places a ship into a game board. The coordinate passed in the parameters xcoord and ycoord
     * represent the top-left coordinate of the ship. The ship is represented on the game board by
     * the Character representation of the ship id. (For this method, you can assume that the id
     * parameter will only be values 1 through 9.)
     *
     * @param board The game board to search.
     * @param xcoord The x-coordinate of the top-left cell of the ship.
     * @param ycoord The y-coordinate of the top-left cell of the ship.
     * @param len The length of the ship.
     * @param dir true if the ship will be vertical, otherwise horizontal.
     * @param id The ship id, assumed to be 1 to 9.
     * @return false if the ship goes out-of-bounds of the board, true otherwise.
     */
    public static boolean placeShip(char board[][], int xcoord, int ycoord, int len, boolean dir,
        int id) {
        /*
         * this method places a ship onto the game board
         */
        String str = "" + (id); // declares string variable str and assigns it with id
        char ch = str.charAt(0); // declares character variable ch assigns it with the id
        // previous two steps done to get id into a character ch
        int p = checkWater(board, xcoord, ycoord, len, dir); // declares integer p and assigns it to
                                                             // the return value of
                                                             // checkWater
        if (p < 0) {
            return false; // returns false if checkWater is a negative number, meaning ship won't
                          // fit on
                          // board
        } else {
            if (dir == true) { // runs if ship is verticle
                for (int i = 0; i < len; i++) { // declares int i to run through each space of
                                                // verticle ship
                    board[ycoord + i][xcoord] = ch;
                }
            } else { // runs if ship is horizontal
                for (int j = 0; j < len; j++) { // declares int j to run through each space of
                                                // horizontal ship
                    board[ycoord][xcoord + j] = ch;
                }
            }
        }
        return true; // returns true if ship is able to be placed
    }

    /**
     * Randomly attempts to place a ship into a game board. The random process is as follows: 1 -
     * Pick a random boolean, using rand. True represents vertical, false horizontal. 2 - Pick a
     * random integer, using rand, for the x-coordinate of the top-left cell of the ship. The number
     * of integers to choose from should be calculated based on the width of the board and length of
     * the ship such that the placement of the ship won't be out-of-bounds. 3 - Pick a random
     * integer, using rand, for the y-coordinate of the top-left cell of the ship. The number of
     * integers to choose from should be calculated based on the height of the board and length of
     * the ship such that the placement of the ship won't be out-of-bounds. 4 - Verify that this
     * random location can fit the ship without intersecting another ship (checkWater method). If
     * so, place the ship with the placeShip method.
     *
     * It is possible for the configuration of a board to be such that a ship of a given length may
     * not fit. So, the random process will be attempted at most Config.RAND_SHIP_TRIES times.
     * 
     * @param board The game board to search.
     * @param len The length of the ship.
     * @param id The ship id, assumed to be 1 to 9..
     * @param rand The Random object.
     * @return true if the ship is placed successfully, false otherwise.
     */
    public static boolean placeRandomShip(char board[][], int len, int id, Random rand) {
        /*
         * this method randomly attempts to place the computer's ship on the game board
         */
        boolean dir; // declares boolean dir
        int xcoord; // declares integer xcoord
        int ycoord; // declares integer ycoord
        /*
         * loop runs while the number of attempts to place random ship is less than
         * Config.RAND_SHIP_TRIES
         */
        for (int i = 0; i < Config.RAND_SHIP_TRIES; i++) { // declares integer i
            // dir is assigned with random boolean which determines orientation of ship
            dir = rand.nextBoolean();
            if (!dir) { // if statement runs for vertical or horizontal ship depending on random
                        // boolean
                if (board[0].length - len <= 0) {
                    xcoord = rand.nextInt(1); // generates random x coordinate
                    ycoord = rand.nextInt(board.length); // generates random y coordinate
                } else {
                    xcoord = rand.nextInt(board[0].length - len + 1); // generates random x
                                                                      // coordinate on board
                    ycoord = rand.nextInt(board.length); // generates random y coordinate on board
                }
            } else {
                if (board.length - len <= 0) {
                    xcoord = rand.nextInt(board[0].length); // generates random x coordinate on
                                                            // board
                    ycoord = rand.nextInt(1); // generates random y coordinate on board
                } else {
                    xcoord = rand.nextInt(board[0].length); // generates random x coordinate on
                                                            // board
                    ycoord = rand.nextInt(board.length - len + 1); // generates random y coordinate
                                                                   // on board
                }
            }
            // following if statement runs if check water returns 1 representing open space
            if (checkWater(board, xcoord, ycoord, len, dir) == 1) {
                placeShip(board, xcoord, ycoord, len, dir, id); // places ship on board
                return true;
            }
        }
        return false;
    }

    /**
     * This method interacts with the user to place a ship on the game board of the human player and
     * the computer opponent. The process is as follows: 1 - Print the user primary board, using the
     * printBoard. 2 - Using the promptChar method, prompt the user with "Vertical or horizontal?
     * (v/h) ". A response of v is interpreted as vertical. Anything else is assumed to be
     * horizontal. 3 - Using the promptInt method, prompt the user for an integer representing the
     * "ship length", where the minimum ship length is Config.MIN_SHIP_LEN and the maximum ship
     * length is width or height of the game board, depending on the input of the user from step 1.
     * 4 - Using the promptStr method, prompt the user for the "x-coord". The maximum value should
     * be calculated based on the width of the board and the length of the ship. You will need to
     * use the coordAlphaToNum and coordNumToAlpha methods to covert between int and String values
     * of coordinates. 5 - Using the promptInt method, prompt the user for the "y-coord". The
     * maximum value should be calculated based on the width of the board and the length of the
     * ship. 6 - Check if there is space on the board to place the ship. 6a - If so: - Place the
     * ship on the board using placeShip. - Then, call placeRandomShip to place the opponents ships
     * of the same length. - If placeRandomShip fails, print out the error message (terminated by a
     * new line): "Unable to place opponent ship: id", where id is the ship id, and return false. 6b
     * - If not: - Using promptChar, prompt the user with "No room for ship. Try again? (y/n): " -
     * If the user enters a 'y', restart the process at Step 1. - Otherwise, return false.
     *
     * @param sc The Scanner instance to read from System.in.
     * @param boardPrime The human player board.
     * @param boardOpp The opponent board.
     * @param id The ship id, assumed to be 1 to 9.
     * @param rand The Random object.
     * @return true if ship placed successfully by player and computer opponent, false otherwise.
     */
    public static boolean addShip(Scanner sc, char boardPrime[][], char boardOpp[][], int id,
        Random rand) {
        /*
         * this method interacts with user to add a ship on to the board shared by the player and
         * user
         */
        boolean dir; // declares boolean dir
        int len; // declares int len
        int xcoord; // declares in xcoord
        int ycoord; // declares int ycoord
        char vorh = promptChar(sc, "Vertical or horizontal? (v/h): ");
        /*
         * declares character vorh to return value of promptChar
         */
        // following if statement runs if user wants a verticle ship
        if (vorh == 'v') {
            dir = true;
            len = promptInt(sc, "ship length", Config.MIN_SHIP_LEN, boardPrime.length);
            xcoord = coordAlphaToNum(promptStr(sc, "x-coord", coordNumToAlpha(0),
                coordNumToAlpha(boardPrime[0].length - 1)));
            ycoord = promptInt(sc, "y-coord", 0, boardPrime.length - len);
        } else { // runs if user wants a horizontal ship
            dir = false;
            len = promptInt(sc, "ship length", Config.MIN_SHIP_LEN, boardPrime[0].length);
            /*
             * assigns len to return value of promptInt
             */
            // assigns xcoord to return value of coordAlphaToNum
            xcoord = coordAlphaToNum(promptStr(sc, "x-coord", coordNumToAlpha(0),
                coordNumToAlpha(boardPrime[0].length - len)));
            // assigns ycoord to return value of promptInt
            ycoord = promptInt(sc, "y-coord", 0, boardPrime.length - 1);
        }
        // following if statement runs if checkWater returns 1 indicating water space
        if (checkWater(boardPrime, xcoord, ycoord, len, dir) == 1) {
            placeShip(boardPrime, xcoord, ycoord, len, dir, id); // places ship with parameters on
                                                                 // board
            // following if statement runs if ship was unable to be placed
            if (placeRandomShip(boardOpp, len, id, rand) == false) {
                System.out.println("Unable to place opponent ship: " + id);
                return false;
            }
            printBoard(boardPrime, "My Ships:");
        } else {
            /*
             * following if statement runs if the user wants to try to place a ship after previously
             * failing
             */
            if (promptChar(sc, "No room for ship. Try again? (y/n): ") == 'y') {
                // runs through addShip again if the user wants to try again
                addShip(sc, boardPrime, boardOpp, id, rand);
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks the state of a targeted cell on the game board. This method does not change the
     * contents of the game board.
     *
     * @return 3 if the cell was previously targeted. 2 if the shot would be a miss. 1 if the shot
     *         would be a hit. -1 if the shot is out-of-bounds.
     */
    public static int takeShot(char[][] board, int x, int y) {
        /*
         * this method checks the state of the targeted space on the game board
         */
        // following if statement runs if int x or int y are outside of the board
        if (y > board.length || x > board[0].length || y < 0 || x < 0) {
            return -1;
        }
        // following statement runs if the space was previously targeted
        else if (board[y][x] == Config.MISS_CHAR || board[y][x] == Config.HIT_CHAR) {
            return 3;
        }
        // following statement runs if the shot would miss
        else if (board[y][x] == Config.WATER_CHAR) {
            return 2;
        }
        // following statement runs if shot would be a hit
        else {
            return 1;
        }
    }

    /**
     * Interacts with the user to take a shot. The procedure is as follows: 1 - Using the promptStr
     * method, prompt the user for the "x-coord shot". The maximum value should be based on the
     * width of the board. You will need to use the coordAlphaToNum and coordNumToAlpha methods to
     * covert between int and String values of coordinates. 2 - Using the promptInt method, prompt
     * the user for the "y-coord shot". The maximum value should be calculated based on the width of
     * the board. 3 - Check the shot, using the takeShot method. If it returns: -1: Print out an
     * error message "Coordinates out-of-bounds!", terminated by a new line. 3: Print out an error
     * message "Shot location previously targeted!", terminated by a new line. 1 or 2: Update the
     * cells in board and boardTrack with Config.HIT_CHAR or Config.MISS_CHAR accordingly. This
     * process should repeat until the takeShot method returns 1 or 2.
     *
     * @param sc The Scanner instance to read from System.in.
     * @param board The computer opponent board (containing the ship placements).
     * @param boardTrack The human player tracking board.
     */
    public static void shootPlayer(Scanner sc, char[][] board, char[][] boardTrack) {
        int xcoord; // declares integer xcoord
        int ycoord; // declares integer ycoord
        // assigns xcoord to return value of coordAlphaToNum
        xcoord = coordAlphaToNum(promptStr(sc, "x-coord shot", coordNumToAlpha(0),
            coordNumToAlpha(board[0].length - 1)));
        // assigns ycoord to return value of promptInt
        ycoord = promptInt(sc, "y-coord shot", 0, board.length - 1);
        // following if statements check the state of the targeted cell
        if (takeShot(board, xcoord, ycoord) == -1) {
            System.out.println("Coordinates out-of-bounds!");
        } else if (takeShot(board, xcoord, ycoord) == 3) {
            System.out.println("Shot location previously targeted!");
        } else if (takeShot(board, xcoord, ycoord) == 2) {
            board[ycoord][xcoord] = Config.MISS_CHAR;
            boardTrack[ycoord][xcoord] = Config.MISS_CHAR;
        } else if (takeShot(board, xcoord, ycoord) == 1) {
            board[ycoord][xcoord] = Config.HIT_CHAR;
            boardTrack[ycoord][xcoord] = Config.HIT_CHAR;
        }

    }

    /**
     * Takes a random shot on the game board. The random process works as follows: 1 - Pick a random
     * valid x-coordinate 2 - Pick a random valid y-coordinate 3 - Check the shot, using the
     * takeShot method. This process should repeat until the takeShot method returns 1 or 2, then
     * update the cells in board with Config.HIT_CHAR or Config.MISS_CHAR accordingly.
     *
     * Note: Unlike the placeRandomShip method, this method continues until it is successful. This
     * may seem risky, but in this case the random process will terminate (find an untargeted cell)
     * fairly quickly. For more details, see the appendix of the Big Program 1 subject.
     *
     * @param rand The Random object.
     * @param board The human player game board.
     */
    public static void shootComputer(Random rand, char[][] board) {
        // following method takes a random shot on the game board
        int x = -1; // declares int x and assigns it to -1
        int y = -1; // declares int y and assigns it to -1
        while (takeShot(board, x, y) != 2 || takeShot(board, x, y) != 1) {
            x = rand.nextInt(board[0].length); // assigns int x with random value within parameters

            y = rand.nextInt(board.length); // assigns int y with random value within parameters

            // following if statement runs if shot taken was a miss
            if (takeShot(board, x, y) == 2) {
                board[y][x] = Config.MISS_CHAR;
                break;
            }
            // following statement runs if shot taken was a hit
            else if (takeShot(board, x, y) == 1) {
                board[y][x] = Config.HIT_CHAR;
                break;
            }
        }
    }

    /**
     * This is the main method for the Battleship game. It consists of the main game and play again
     * loops with calls to the various supporting methods. When the program launches (prior to the
     * play again loop), a message of "Welcome to Battleship!", terminated by a newline, is
     * displayed. After the play again loop terminiates, a message of "Thanks for playing!",
     * terminated by a newline, is displayed.
     *
     * The Scanner object to read from System.in and the Random object with a seed of Config.SEED
     * will be created in the main method and used as arguments for the supporting methods as
     * required.
     *
     * Also, the main method will require 3 game boards to track the play: - One for tracking the
     * ship placement of the user and the shots of the computer, called the primary board with a
     * caption of "My Ship". - One for displaying the shots (hits and misses) taken by the user,
     * called the tracking board with a caption of "My Shots"; and one for tracking the ship
     * placement of the computer and the shots of the user. - The last board is never displayed, but
     * is the primary board for the computer and is used to determine when a hit or a miss occurs
     * and when all the ships of the computer have been sunk. Notes: - The size of the game boards
     * are determined by the user input. - The game boards are 2d arrays that are to be viewed as
     * row-major order. This means that the first dimension represents the y-coordinate of the game
     * board (the rows) and the second dimension represents the x-coordinate (the columns).
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        /*
         * the following method is the main method for the game, it consists of the main game and
         * play again loops with calls to supporting methods
         */
        System.out.println("Welcome to Battleship!");
        Scanner sc = new Scanner(System.in); // declares and initializes Scanner sc
        Random rand = new Random(Config.SEED);
        // declares and initializes random rand
        boolean shipError = true;
        char ch1 = 'y'; // declares character ch1 and assigns it with 'y'

        /*
         * following loop is the play again loop which runs if the user would like to play the game
         */
        while (ch1 == 'y' || ch1 == 'Y') {
            // prompts user for height value
            int height = promptInt(sc, "board height", Config.MIN_HEIGHT, Config.MAX_HEIGHT);
            // prompts user for width value
            int width = promptInt(sc, "board width", Config.MIN_WIDTH, Config.MAX_WIDTH);
            System.out.println();
            // declares initializes the three required game boards
            char[][] shotboard = new char[height][width];
            char[][] myboard = new char[height][width];
            char[][] oppboard = new char[height][width];
            initBoard(shotboard);
            initBoard(myboard);
            initBoard(oppboard);
            // declares int numships and assigns it to return value of promptInt
            int numships = promptInt(sc, "number of ships", Config.MIN_SHIPS, Config.MAX_SHIPS);
            printBoard(myboard, "My Ships:");
            // following for loop adds the ships to the board
            for (int i = 0; i < numships; i++) {
                shipError = addShip(sc, myboard, oppboard, i + 1, rand);
                // following if statement runs if there was an error adding ships
                if (shipError == false) {
                    ch1 = promptChar(sc, "Error adding ships. Restart game? (y/n): ");
                    if (ch1 == 'y' || ch1 == 'Y' || ch1 == 'n' || ch1 == 'N') {
                        break;
                    } else {
                        System.out.println("Invalid entry.");
                        break;
                    }
                }
            }
            int m = 0; // declares integer m and assigns it to 0
            // game loop that runs until the player or computer wins
            while (m == 0) {
                printBoard(shotboard, "My Shots:");
                shootPlayer(sc, oppboard, shotboard);
                // following if statement runs if the player sinks all the computer's ships
                if (checkLost(oppboard)) {
                    System.out.println("Congratulations, you sunk all the computer's ships!");
                    printBoard(myboard, "My Ships:");
                    printBoard(shotboard, "My Shots:");
                    break;
                }
                shootComputer(rand, myboard);
                // following if statement runs if the computer sinks all the players ships
                if (checkLost(myboard)) {
                    System.out.println("Oh no! The computer sunk all your ships!");
                    printBoard(myboard, "My Ships:");
                    printBoard(shotboard, "My Shots:");
                    break;
                }
                printBoard(myboard, "My Ships:");
            }
            // asks user if they would like to play again
            ch1 = promptChar(sc, "Would you like to play again? (y/n): ");
        }

        System.out.println("Thanks for playing!");
    }
}
