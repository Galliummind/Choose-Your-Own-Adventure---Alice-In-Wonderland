/** Introduction
 * 
 * Title: LocationsGenerator
 * Description: LocationsGenerator Class will be used to store and manipulate Objects of the Character class.
 * date: Wednesday, December 30, 2020
 * @author Louis A. Hauteclocque
 * @version 1.0
 */

/** DOCUMENTATION...
 */

/** Purpose, Description, and compile instructions                                                                              
 *
 * Class LocationsGenerator:
 * Class LocationsGenerator will be used to create objects of type Locations
 * and deposit them into an ArrayList. The LocationsGenerator will 
 * manipulate those objects with their own get/set methods and some custom
 * remove objects methods. 
 * 
 * Compiling and running instructions
 * Assuming JDK 11.0.7 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 * Compile:    javac LocationsGenerator.java
 * Run:        java LocationsGenerator
 */

/** Classes, Methods, and Variables
 *
 * Classe
  public class LocationsGenerator
 
 * LocationsGenerator Methods 
	//Default Constructor
 public LocationsGenerator()
	//Custom Constructor will call the textFileReader
 public LocationsGenerator(String TextFileNameHere)
	//LocationsWhereAreYou, is a while loop that shows Alice where she currenty is.  
 public void locationsWhereAreyou()
 	//bringConnectedPlacesforward is a function that returns a String of the adjacent rooms.
 public String bringConnectedPlacesForward(int currentLocation)
	//textFileReaderLocation will take a int parameter that represents the currentLocation.	
	//This value will tell the method which text file to load. and return a full description of the area.
 public StringBuffer textFileReaderLocation(int currentLocation)
	//getLocation will test to see if Alice has visited a location before or not. 
 public  void getLocation(int currentLocation)
	//textFileReader will read a text file and load the contents depending on the String Parameter
 public void textFileReader(String fileName)
	//This main method will be used for testing.
 public static void main(String[] args)


 * LocationsGenerator Instance Variables

 private static ArrayList < Locations > anArrayList = new ArrayList < Locations > (); //Initilize the arraylist
 private static  ArrayList < Boolean > familiarPlace = new ArrayList < Boolean > (); //Initlize boolean arrayList
 public static int currentLocation = 0; //initilize static currentLocation.

 */

/** Test Plan
 * 1 . Run the application. 
 * EXPECTED:
 * The main method will run an Instance of AliceInWonderLand. Then Alice will
 * move to multiple locations, This will demonstrate the Custom and default constructor can 
 * be reliable called. This will also demonstrate the follwing method:
	public LocationsGenerator()
	public LocationsGenerator(String TextFileNameHere)
	public void locationsWhereAreyou()
	public String bringConnectedPlacesForward(int currentLocation)
	public StringBuffer textFileReaderLocation(int currentLocation)
	public  void getLocation(int currentLocation)
	public void textFileReader(String fileName)
 * 
 * ACTUAL:
 * Application runs as expected. Alice is capable of moving throughout the game, 
 * appropriate suggestions on where she would like to move are given. And if she has visisted the
 * location before a short description will be given. 
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

public class LocationsGenerator {
    /**anArrayList is an ArrayList to hold the object <Locations>.
     * familiarPlace is an arrayList that holds a boolean value.
     * It will static so that the values withing the arraylist can be manipulated and
     * hold the values. 
     */
    private static ArrayList < Locations > anArrayList = new ArrayList < Locations > (); //Initilize the arraylist
    private static ArrayList < Boolean > familiarPlace = new ArrayList < Boolean > (); //Initlize boolean arrayList
    public static int currentLocation = 0; //initilize static currentLocation.

    /** Default Constructor*/
    public LocationsGenerator() {} //End of TextFileReader(String) Constructor

    /**LocationsGenerator Constructor (String, String)
     * This constructor will be create an instance of class LocationsGenerator.
     * It runsthe textFileReader method. The
     * String provided for this constructor and method should be the name of 
     * the text file "Locations.txt.
     * 
     * The textFileReader will load a textfile into multiple strings and pass that string into another 
     * constructor to create an object. Then that object will be loaded to an arraylist
     * 
     * The Reason why this constructor is necessary is because each time the class
     * is initilized we don't want the txt file read multiple times. So this constructor will only
     * be called once and that's within AliceinWonderland default constructor."
     */
    public LocationsGenerator(String TextFileNameHere) {
        //~ textFileReader("Locations.txt");
        textFileReader(TextFileNameHere);
    } //End of TextFileReader(String) Constructor

    /**Method locationsWhereAreYou
     * This method is critical in the program.
     * When an instance of this method is run it will continously creating an infinite
     * loop that can only be broken outside of the while loops scope. For example if 
     * Alice dies or wins the game a system.exit(0); command will be passed ending the program.
     * I have sources mentioning when this would be necessary or even desired to 
     * create a while loop that doesn't end. 
     * https://www.baeldung.com/infinite-loops-java
     * 
     * In this infinite while loop, a new instance of class Locations Generator
     * is created (LG). An instance of the method LG.getLocation is initiaded
     * and the parameter int currentLocation is passed to the method. CurrentLocation
     * is a variable of object LG and LG is an instance of class LocationsGenerator.
     * The method getLocation will print a short description or a long description
     * depending on if the parameter being passed to the method has been used before.
     * for more details of getLocation() please go to the method.
     * 
     * Next an object newControls is made. newControls is an instance of class
     * Controls. List of Controls is invoked and the parameters of currentLocations is
     * passed. The reason for passing the currentLocation to this method is it will
     * influence the available options. For example in the method listOfControls(currentLocation)
     * the user can decide to move() to another location. The program will need
     * the currentLocation variable to determine which paths to load, which discussion to load,
     * etc. Essentially the variable currentLocation is used to determine a lot of 
     * what the program does. That is why the variable is public and that is why
     * currentLocation = newControls.listOfControls(currentLocation); because the variable
     * currentLocation will be influenced by other methods. 
     * 
     * Because this is an infinite loop (ie the value of currentLocation will never
     * be 100) This loop essentialy runs the entire game!
     *    
     */
    public void locationsWhereAreyou() {
        //Simple text output letting players know they have started the game.
        System.out.println("Welcome to Alice in Wonderland! The choose your own adventure game.");
        System.out.println("To win the Game Alice must get the Red Queen’s Crown and return it to the Stash.");
        while (currentLocation != 100) {
            LocationsGenerator LG = new LocationsGenerator();
            LG.getLocation(currentLocation);
            Controls newControls = new Controls();
            //Current location will become whatever is returned from this function.
            currentLocation = newControls.listOfControls(currentLocation);
        } //End of while loop
    } //End of method locationsWhereAreYou



    /**This function will return the available locations depending on
     * the parameter int currentLocation. This is done by creating an instance
     * of a Locations and using the values from .getLocation in the arrayList
     * to fill the values. Then a String connectPlaces will get the available
     * rooms, by using the get method .getConnectsToRoomList. 
     * 
     * The string connectedPlaces will be returned.*/
    public String bringConnectedPlacesForward(int currentLocation) {
        //Create an Object of class Locations. Use the arrayList in location (currentLocation)
        //to fill the values.
        Locations current = (Locations) anArrayList.get(currentLocation);
        //Use a String Object to hold the values of the ConnectsToRoomList from object current.
        String connectedPlaces = current.getConnectsToRoomList();
        //Return the String to the calling method.
        return connectedPlaces;
    } //End of bringConnectedPlacesForward

    /**Function textFileReaderLocation
     * This function will load a 
     * */
    public StringBuffer textFileReaderLocation(int currentLocation) {
        //Creating a new StringBuffer named stringBuffer.
        StringBuffer stringBuffer = new StringBuffer();
        TextFileRead newTextFileRead = new TextFileRead();
        switch (currentLocation) {
            case (0):
                stringBuffer = (newTextFileRead.textfile("Park.txt"));
                break;

            case (1):
                stringBuffer = (newTextFileRead.textfile("Hole.txt"));
                break;

            case (2):
                stringBuffer = (newTextFileRead.textfile("Alley.txt"));
                break;


            case (3):
                stringBuffer = (newTextFileRead.textfile("SignPostForest.txt"));
                break;

            case (4):
                stringBuffer = (newTextFileRead.textfile("MadHattersHouse.txt"));
                break;

            case (5):
                stringBuffer = (newTextFileRead.textfile("RabbitsDen.txt"));
                break;

            case (6):
                stringBuffer = (newTextFileRead.textfile("QueensGarden.txt"));
                break;

            case (7):
                stringBuffer = (newTextFileRead.textfile("KingsWeb.txt"));
                break;

            case (8):
                stringBuffer = (newTextFileRead.textfile("North.txt"));
                break;

            case (9):
                stringBuffer = (newTextFileRead.textfile("East.txt"));
                break;

            case (10):
                stringBuffer = (newTextFileRead.textfile("West.txt"));
                break;

            case (11):
                stringBuffer = (newTextFileRead.textfile("Court.txt"));
                break;

                /**CASE 12 is UNIQUE
                 * Case 12 is unique because this location description leads to the character's death.
                 * in this case the string buffer will be printed. The message is about Alice falling to her death.
                 * a new instance of the Actions.death method will be called and the game will be exited from that method.
                 * */
            case (12):
                stringBuffer = (newTextFileRead.textfile("Bush.txt"));
                System.out.println(stringBuffer);
                Actions newActions = new Actions();
                newActions.death();
                break;

            case (100):
                stringBuffer = (newTextFileRead.textfile("Win.txt"));
                System.out.println(stringBuffer);
                break;
        } //End of switch
        return stringBuffer;
    } //End of function textFileReaderLocation


    /** get Location is a method that prints a long descriptin or short description of a location.
     * In order to use this method you must pass a value int currentLocation. This variable will be used to determine
     * which location to use.
     * First a location will be loaded from the arraylist and placed in an object of type location.
     * 
     * Second an if statement will check using boolean values if the location has been visited previously. 
     * This is determined by having a second arraylist that holds simple boolean values in its elements.
     * the location of each element corelates with the locations arraylist. if the location is false then 
     * famliarplace at location currentLocation is set to true and the system will create an instance of locationGenerator.textfileReaderLocation
     * read the appropriate file and print the text to screen. 
     * 
     * else the system will simply get the location objects short description and print that to text.
     */
    public void getLocation(int currentLocation) {
        Locations current = (Locations) anArrayList.get(currentLocation);
        if (familiarPlace.get(currentLocation) == false) {
            familiarPlace.set((currentLocation), true);
            LocationsGenerator newGenerator = new LocationsGenerator();
            System.out.println(newGenerator.textFileReaderLocation(currentLocation));
        } //End of if statment Long Description.
        else {
            System.out.println(current.getShortDescription());
        } //End of shortDescription
    } //End of bringObjects

    /**Method TextFileReader(String fileName) takes a string for the parameter,
     * This string fileName will tell the file scanner which file to read. while each
     * line loaded in the filescanner is not null the file scanner will store the values
     * in three strings. These three strings can also be represented as string name,
     * string short description, and string connected locations. Once all three strings 
     * are loaded the strings will be passed to a blackbox add method of class Java.util.Arraylist.
     * this will add a new location object to the arraylist. 
     * 
     * The catch statement is required by java to handle the exception that the file is not found. 
     */
    public void textFileReader(String fileName) {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNext() && fileScanner != null) {
                String str1, str2, str3;
                str1 = (fileScanner.nextLine());
                str2 = (fileScanner.nextLine());
                str3 = (fileScanner.nextLine());
                anArrayList.add(new Locations(str1, str2, str3));
                //Default false.
                familiarPlace.add(false);
            } //end of while 	
            fileScanner.close();
        } //End of try statement
        catch (FileNotFoundException e) {
            //Print message with exception.
            System.out.println();
            System.out.println("File not found!");
            System.out.println("Error: " + e + " Exiting program!");
            System.out.println();
            //System will exit
            System.exit(0);
        } //End of Catch		
    } //End of TextFileReader(String) Constructor}//


    /**main method*/
    public static void main(String[] args) {
        //Calling on the custom constructor
        LocationsGenerator lG = new LocationsGenerator("Locations.txt");
        //Print multiple locations to make sure they work.
        System.out.println(lG.anArrayList.get(0));
        System.out.println(lG.anArrayList.get(11));
        System.out.println(lG.anArrayList.get(5));
    } //End of main()	
} //End of LocationGenerator
