/** Introduction
 * 
 * Title: CharacterGenerator
 * Description: CharacterGenerator Class will be used to store and manipulate Objects of the Character class.
 * date: Wednesday, December 30, 2020
 * @author Louis A. Hauteclocque
 * @version 1.0
 */

/** DOCUMENTATION...
 */

/** Purpose, Description, and compile instructions                                                                              
 *
 * Class CharacterGenerator:
 * Class CharacterGenerator will be used to create objects of type Character and deposit
 * them into an ArrayList. The CharacterGenerator will manipulate those objects
 * with their own get/set methods and some custom remove objects methods.
 * 
 * Compiling and running instructions
 * Assuming JDK 11.0.7 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 * Compile:    javac CharacterGenerator.java
 * Run:        java CharacterGenerator
 */

/** Classes, Methods, and Variables
 *
 * Classes
  public class CharacterGenerator
 * 
 * CharacterGenerator Methods 
	//Default Constructor called when we need access to the methods.
 public CharacterGenerator()
	//Custom constructor. It will load two Txtfiles and add those to the ArrayLists
 public CharacterGenerator(String textFileChar, String textFileBoss)
	//textFileReader will read a txt file and load that value into an arrayList
 public void textFileReader(String textFileName)
	//textFileReaderForQueen will read a txt file and load the values into a special boss arrayList
public void textFileReaderForQueen(String textFileName)
	//textFileReaderDiscussion will load a textfile containing a special discussion Alice can
	//have with another character depending on location.
 public StringBuffer textFileReaderDiscussion(int currentLocation)
	//getCharacter function will get a character from the ArrayList and return it as an object of type <Character>
 public Object getCharacter(int intNumberOfCharacterToBeReturned)
	//getQueen function will get a special character from an ArrayList and return it as an object of type <Character>
 public Object getQueen()
	//function getCharacterArrayListSize will find the current ArraylistSize and return the value
 public int getCharacterArrayListSize()
	//main method will be used for testing methods.
public static void main(String[] args)


 * CharacterGenerator Instance Variables

private static ArrayList < Character > CharacterArrayList = new ArrayList < Character > ();
private static ArrayList <Character> QueensArrayList = new ArrayList < Character > ();

 */

/** Test Plan
 * 1. Run the application. 
 * EXPECTED:
 * The main method will run an Instance of AliceInWonderLand. 
 * Next I will move Alice to the Sign Post Forest. this is so Alice is
 * capabale of "exploring" and finding items. Explore multiple times will increase her
 * chances of encountering an enemy. Once she encounters an enemy we will be testing
 * textFileReader method, getCharacterArraylistSize, getCharacter.
 * 
 * ACTUAL:
 * Application runs as expected. Alice is capable of encountering enemys 
 * 
 * 3 . Run the application. 
 * EXPECTED:
 * The main method will run an Instance of AliceInWonderLand. 
 * Next I will move Alice to the Queen's court. Kill the queen and retrieve the crown.
 * ACTUAL:
 * Application runs as expected. Alice is capable of fighting a special boss character,  The Red Queen.
 * 
 */


/** CODE...
 */

/** Java core packages */
import java.util.Collections; //Sorts the specified list according to the natural ordering of its elements. 
import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner; //Scanner will be used to read user input and File
import java.io.File; //File class will allow us to manipulate files.
import java.io.FileNotFoundException; // handles attempts to open a file via a specified pathname has failed.
//End of packages


public class CharacterGenerator {

    private static ArrayList < Character > CharacterArrayList = new ArrayList < Character > ();
    private static ArrayList < Character > QueensArrayList = new ArrayList < Character > ();

    /**Default constructor*/
    public CharacterGenerator() {} //End of TextFileReader(String) Constructor

    /**CharacterGenerator Constructor (String, String)
     * This constructor will be create an instance of class CharacterGenerator.
     * It runsthe textFileReader method. The
     * Strings provided for this constructor and method should be the name of 
     * the text file "Character.txt and "Boss.txt".
     * 
     * The textFileReader will load a textfile into multiple strings and pass that string into another 
     * constructor to create an object. Then that object will be loaded to an arraylist
     * 
     * The Reason why this constructor is necessary is because each time the class
     * is initilized we don't want the txt file read multiple times. So this constructor will only
     * be called once and that's within AliceinWonderland default constructor."
     */
    public CharacterGenerator(String textFileChar, String textFileBoss) {
        textFileReader(textFileChar);
        textFileReaderForQueen(textFileBoss);
    } //End of TextFileReader(String) Constructor

    /**Method TextFileReader(String textFileName)*/
    public void textFileReader(String textFileName) {
        try {
            Scanner fileScanner = new Scanner(new File(textFileName));
            while (fileScanner.hasNext() && fileScanner != null) {
                String str1, str2, str3, str4;
                str1 = (fileScanner.nextLine());
                str2 = (fileScanner.nextLine());
                str3 = (fileScanner.nextLine());
                str4 = (fileScanner.nextLine());
                (CharacterArrayList).add(new Character(str1, str2, str3, str4));
            } //end of while
            fileScanner.close();
        } //End of try statement
        catch (FileNotFoundException e) {
            //Print message with exception.
            System.out.println();
            System.out.println("File not found!");
            System.out.println("Error: " + e + " Exiting program! Please check your txt file naming and location and try again.");
            System.out.println();
            //System will exit
            System.exit(0);
        } //End of Catch		
    } //End of TextFileReader(String)

    /**Method TextFileReader(String textFileName)*/
    public void textFileReaderForQueen(String textFileName) {
        try {
            Scanner fileScanner = new Scanner(new File(textFileName));
            while (fileScanner.hasNext() && fileScanner != null) {
                String str1, str2, str3, str4;
                str1 = (fileScanner.nextLine());
                str2 = (fileScanner.nextLine());
                str3 = (fileScanner.nextLine());
                str4 = (fileScanner.nextLine());
                (QueensArrayList).add(new Character(str1, str2, str3, str4));
            } //end of while
            fileScanner.close();
        } //End of try statement
        catch (FileNotFoundException e) {
            //Print message with exception.
            System.out.println();
            System.out.println("File not found!");
            System.out.println("Error: " + e + " Exiting program! Please check your txt file naming and location and try again.");
            System.out.println();
            //System will exit
            System.exit(0);
        } //End of Catch		
    } //End of TextFileReader(String)

    /**Function StringBuffer textFileReader()
     * This function will use the int parameter to determine which textFile
     * to read, load into a stringBuffer then returned. To do this an instance of 
     * TextFileRead is created and a StringBuffer StringBufferToBeReturned. Then the parameter,
     * currentLocation will be passed through a switch which will use the number to 
     * determine which file to read. for more details on how Function textFile
     * works please visit TextFileRead class for more information. 
     * */
    public StringBuffer textFileReaderDiscussion(int currentLocation) {
        TextFileRead newTextFileRead = new TextFileRead();
        StringBuffer StringBufferToBeReturned = new StringBuffer();
        switch (currentLocation) {
            case (0):
                System.out.println(newTextFileRead.textfile("ParkDiscussion.txt"));
                break;

            case (1):
                System.out.println(newTextFileRead.textfile("HoleDiscussion.txt"));
                break;

            case (2):
                System.out.println(newTextFileRead.textfile("AlleyDiscussion.txt"));
                break;

            case (3):
                System.out.println(newTextFileRead.textfile("SignPostForestDiscussion.txt"));
                break;

            case (4):
                System.out.println(newTextFileRead.textfile("MadHatterDiscussion.txt"));
                break;

            case (5):
                System.out.println(newTextFileRead.textfile("RabbitsDenDiscussion.txt"));
                break;

            case (6):
                System.out.println(newTextFileRead.textfile("QueensGardenDiscussion.txt"));
                break;

            case (7):
            case (8):
            case (9):
            case (10):
                StringBufferToBeReturned = (newTextFileRead.textfile("KingsWebDiscussion.txt"));
                break;

            case (11):
                StringBufferToBeReturned = (newTextFileRead.textfile("CourtDiscussion.txt"));
                break;


        } //End of switch
        return StringBufferToBeReturned;
    } //End of function textFileReaderDiscussion

    /**Brings a Character forward or creates a reference to an Character object that can be manipulated and attacked.*/
    public Object getCharacter(int intNumberOfCharacterToBeReturned) {
        Character manifestCharacter = (Character) CharacterArrayList.get(intNumberOfCharacterToBeReturned);
        System.out.print(manifestCharacter);
        return manifestCharacter;
    } //End of bringObjects

    /**Brings the redQueen Character object forward or creates a reference to an Character object that can be manipulated and attacked.*/
    public Object getQueen() {
        Character manifestCharacter = (Character) QueensArrayList.get(0);
        System.out.print(manifestCharacter);
        return manifestCharacter;
    } //End of bringObjects

    /**getCharacterArrayListSize
     * This method is simply used to get the arraylist size for 
     * arraylist CharacterArrayList. It uses the blackbox method
     * that returns the current size of the arraylist.
     * The value will be stored in int temporaryInteger and returned.
     */
    public int getCharacterArrayListSize() {
        int temporaryInteger = 0;
        temporaryInteger = temporaryInteger + (CharacterArrayList.size());
        return temporaryInteger;
    } //End of getCharacterArrayListSize()

    /**Method main
     * This method creates an instance of class AliceInWonderLand. It will be used
     * for testing purposes.
     */
    public static void main(String[] args) {
        //Create instance of classes needed.
        AliceInWonderland AliceInWonderLand = new AliceInWonderland();
    } //End of main method	
} //End of Items Generator
