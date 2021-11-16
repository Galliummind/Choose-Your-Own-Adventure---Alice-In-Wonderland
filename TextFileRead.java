/** Introduction
 * 
 * Title: TextFileReadGenerator
 * Description: TextFileReadGenerator Class be used to read text files.
 * date: Wednesday, December 30, 2020
 * @author Louis A. Hauteclocque
 * @version 1.0
 */

/** DOCUMENTATION...
 */

/** Purpose, Description, and compile instructions                                                                              
 *
 * Class TextFileReadGenerator:
 * Class
 * 
 * Compiling and running instructions
 * Assuming JDK 11.0.7 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 * Compile:    javac TextFileReadGenerator.java
 * Run:        java TextFileReadGenerator
 */
/** Classes, Methods, and Variables
*
* Classes
public class TextFileRead
* 
* 
* TextFileRead Methods 
//textFile will read a txt File and return a StringBuffer with the contents
public StringBuffer textfile(String textFileToBeLoaded)
//main method will be used for testing the methods within this class 
public static void main (String[] args)
*
* TextFileRead Instance Variables

*/

/** Test Plan
 * 1. Run the application. 
 * EXPECTED:
 * The main method will run the main method, then the main
 * method will run an instance of textFileRead Class and textFile method.
 * Multiple different txt files will be loaded and displayed to show the function works
 * ACTUAL:
 * Application runs as expected.
 */


/** CODE...
 */

/** Java core packages */
import java.util.Scanner; //Scanner will be used to read user input and File
import java.io.File; //File class will allow us to manipulate files.
import java.io.FileNotFoundException; // handles attempts to open a file via a specified pathname has failed.

public class TextFileRead {

    /**Function textFile(String textFileToBeLoaded)
     * The textFile reader is used to read a text file and return
     * the content in a StringBuffer. The parameters take a String as a parameter
     * and this allows multiple text files to be brought up.
     * 
     * First we need to create an instance of StringBuffe, Scanner, and File. 
     * "Creates a new File instance by converting the given pathname string 
     * into an abstract pathname." https://docs.oracle.com/javase/7/docs/api/java/io/File.html 
     * Next a while loop will run as long as the fileScanner has a line to read.
     * The line that is loaded into the fileScanner will be appended onto the end
     * of StringBufferWillBeReturned. 
     * 
     * next the fileScanner will be manually closed. "This is done to close the input
     * source if the input source implements the Closeable interface."
     * https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html  
     */
    public StringBuffer textfile(String textFileToBeLoaded) {
        //Create a new instancre of StringBuffer(), StringBufferWillBeReturned	
        StringBuffer StringBufferWillBeReturned = new StringBuffer();
        //Try/Catch Statement
        try {
            //Create an instance of file Scanner, fileScanner	
            Scanner fileScanner = new Scanner(new File(textFileToBeLoaded));
            //While statement that will run as long as the fileScanner has a next line to read.
            while (fileScanner.hasNext()) {
                //.append will add the content of fileScanner.nextLine() to StringBufferWillBeReturned	
                StringBufferWillBeReturned.append(fileScanner.nextLine());
            } //end of while
            //Close fileScanner. This is done automatically, but it's good practice to manually close.
            fileScanner.close();
        } //End of try statement
        //catch statmenet will check for a fileNotFound exception.
        catch (FileNotFoundException e) {
            //Print message with exception if the file is NOT found.
            System.out.println("File not found!");
            System.out.println("Error: " + e + " Exiting program!");
            //System will exit
        } //End of Catch
        //Finally return StringBufferWillBeReturned to the calling program.
        return StringBufferWillBeReturned;
    } //End of textfile

    /**This method will create an instance of Class TextFileRead then use that 
     * class instance to make an instance of method textFile. The parameter
     * passed to the string will be the "Hero.txt".
     * This should be printed on the screen.*/
    public static void main(String[] args) {
        TextFileRead tx = new TextFileRead();
        System.out.println("This main method will demonstrate that the textFile Function works properly.");
        System.out.println(); //Blank Space
        System.out.print("Load and Print Hero Text: ");
        System.out.println(tx.textfile("Hero.txt"));
        System.out.println(); //Blank Space
        System.out.println("Print Location Park: ");
        System.out.println(tx.textfile("Park.txt"));
        System.out.println(); //Blank Space
        System.out.println("Print Court Description: ");
        System.out.println(tx.textfile("Court.txt"));
    } //End of main
} //End of TextFileRead Class
