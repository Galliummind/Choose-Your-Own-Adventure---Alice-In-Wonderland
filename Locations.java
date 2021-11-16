/** Introduction
 * 
 * Title: Location
 * Description: Location Class will be used to create object Location for the game.
 * date: Wednesday, December 30, 2020
 * @author Louis A. Hauteclocque
 * @version 1.0
 */

/** DOCUMENTATION...
 */

/** Purpose, Description, and compile instructions                                                                              
 *
 * Class Location:
 * Class Location will be used to create objects of type character. They will
 * have the common OOP structure of private variables and public get/set methods. 
 * 
 * 
 * Compiling and running instructions
 * Assuming JDK 11.0.7 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 * Compile:    javac Location.java
 * Run:        java Location
 */

/** Classes, Methods, and Variables
*
* Classes
* public class Location
* 
* Location Methods 
//set method for setConnectsToRoomList.
public void setConnectsToRoomList(String newConnectsToRoomList)
//Get method for connectedToRoomList
public String getConnectsToRoomList()
//Set method for Title
public void setTitle(String newTitle)
//Get method for variable title
public String getTitle()
//set method for shortDescription
public void setShortDescription(String newShortDescription)
//Get method for shortDescription
public String getShortDescription()
//@Override the toString method, that prints an object to String value
public String toString()
//Main method used for testing purposes
public static void main (String[] args)
*
* 
* Location Instance Variables
private String title;
private String shortDescription;
private String connectsToRoomList;
*/

/** Test Plan
 * 1. Run the application. 
 * EXPECTED:
 * The main method will run, and a new object l1 will be created. Then the Locations'
 * variables will be displayed. First I will use the constructor to create
 * the object, then I will manually manipulate the Object using the get/set method.  
 * ACTUAL:
 * Application runs as expected.
 */

/** CODE...
 */

/** Java core packages */


public class Locations {

    //Priming the variables.
    private String title;
    private String shortDescription;
    private String connectsToRoomList;

    /**default Constructor
     * The deafault constructor is set to create new instances of Locations by
     * adding the required parameters. Each variable within the parameter will be used to
     * fill in the String objects of class Location. */
    public Locations(String title, String shortDescription, String connectsToRoomList) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.connectsToRoomList = connectsToRoomList;
    } //end of Locations constructor


    /**Get/Set methods
     * These get/set methods are based on OOP encapsulation methods.
     * Normally a private variables can only be accessed within the same class.
     * But by providing public get/set methods we can use the get methods to 
     * return variables and the set method sets the values.
     */
    //Now to set/get method
    public void setConnectsToRoomList(String newConnectsToRoomList) {
        this.connectsToRoomList = newConnectsToRoomList;
    } //End of setTitle

    public String getConnectsToRoomList() {
        return connectsToRoomList;
    } //End of getTitle

    //Now to set/get method
    public void setTitle(String newTitle) {
        this.title = newTitle;
    } //End of setTitle

    public String getTitle() {
        return title;
    } //End of getTitle

    //Now to set/get method
    public void setShortDescription(String newShortDescription) {
        this.shortDescription = newShortDescription;
    } //End of setShortDescription

    public String getShortDescription() {
        return shortDescription;
    } //End of getShortDescription

    /**In order to invoke the toString method to print an object with contextual
     * meaning we are required to override the method. So essentially what we are
     * asking is to return not just the object and location, but the object values
     * themselves in a string form. We are asking for this.getTitle as an example.
     * If we didn't override the toString method, by default it would print hexadecimal
     * values. 
     */
    @Override
    public String toString() {
        return ("Title: " + this.getTitle() + "\n" +
            "short desc: " + this.getShortDescription() + "\n" +
            "connecting rooms " + this.getConnectsToRoomList() +
            "\n" + "\n");
    } //End of String toString method

    /**main method will be used for testing.*/
    public static void main(String[] args) {
        //Create a new instance of Location.
        Locations l1 = new Locations("Mad Hatter's House", "You're back at the Mad Hatter's house!", "palace, garden, rabbits house");
        System.out.println(l1);
        //Print out message demonstrating toString method
        //Print Location object. toString method will print something legible instead of hexvalues
        System.out.print(l1);
        System.out.println("NOW I WILL CHANGE ALL THE VALUES USING THE SET METHOD.");
        //manually set all the values to demonstrate they work
        l1.setTitle("Mad Hatter name change");
        l1.setShortDescription("Short description has been changed");
        l1.setConnectsToRoomList("Connected rooms list: r1, r2, r3, r4, has been changed.");
        //Manually print all of the values to demonstrate get methods.
        System.out.println(l1.getTitle());
        System.out.println(l1.getShortDescription());
        System.out.println(l1.getConnectsToRoomList());

    } //End of main method.
} //End of class Locations
