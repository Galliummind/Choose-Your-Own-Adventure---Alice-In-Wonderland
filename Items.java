/** Introduction
 * 
 * Title: Items
 * Description: Items Class will be used to create object Items for the game.
 * date: Wednesday, December 30, 2020
 * @author Louis A. Hauteclocque
 * @version 1.0
 */

/** DOCUMENTATION...
 */

/** Purpose, Description, and compile instructions                                                                              
 *
 * Class Items:
 * Class Items will be used to create objects of type Items. They will
 * have the common OOP structure of private variables and public get/set methods. 
 * 
 * 
 * Compiling and running instructions
 * Assuming JDK 11.0.7 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 * Compile:    javac Items.java
 * Run:        java Items
 */

/** Classes, Methods, and Variables
*
* Classes
 public class Items
* 
* Items Methods 
//Custom Constructor
public Items (String itemName, String itemDescription, String pointValue)
// Set method for itemName Variable
public void setItemName(String newItemName)
//Get method for itemName Variable
public String getItemName()
//Set method for itemDescription Method
public void setItemDescription(String newItemDescription)
//get method for itemDescription variable
public String getItemDescription()
//set method for pointValue Variable
public void setPointValue(String newPointValue)
//get method for pointValue Variable
public String getPointValue()
//Override toString Method()
public String toString()
//main method used for testing.
public static void main (String[] args)
 
* Items Instance Variables
private String itemName;
private String itemDescription;
private String pointValue;	
*/

/** Test Plan
 * 1. Run the application. 
 * EXPECTED:
 * The main method will run, and a new object item1 will be created. Then the Items'
 * variables will be displayed. First I will use the constructor to create
 * the object, then I will manually manipulate the Object using the get/set method.  
 * ACTUAL:
 * Application runs as expected.
 */

/** CODE...
 */

/** Java core packages */

public class Items {

    private String itemName;
    private String itemDescription;
    private String pointValue;


    /**default Constructor
     * The deafault constructor is set to create new instances of Items by
     * adding the required parameters. Each variable within the parameter will be used to
     * fill in the String objects of class Location. 
     */
    public Items(String itemName, String itemDescription, String pointValue) {

        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.pointValue = pointValue;
    } //End of default constructor

    /**Get/Set methods for Items
     * These get/set methods are based on OOP encapsulation methods.
     * Normally a private variables can only be accessed within the same class.
     * But by providing public get/set methods we can use the get methods to 
     * return variables and the set method sets the values.
     */
    public void setItemName(String newItemName) {
        this.itemName = newItemName;
    } //End of setItemName

    public String getItemName() {
        return itemName;
    } //End of getItemName

    public void setItemDescription(String newItemDescription) {
        this.itemDescription = newItemDescription;
    } //End of setItemDescription

    public String getItemDescription() {
        return itemDescription;
    } //End of getItemDescription

    public void setPointValue(String newPointValue) {
        this.pointValue = newPointValue;
    } //End of setPointValue

    public String getPointValue() {
        return pointValue;
    } //End of getPointValue

    /**In order to invoke the toString method to print an object with contextual
     * meaning we are required to override the method. So essentially what we are
     * asking is to return not just the object and location, but the object values
     * themselves in a string form. We are asking for this.getItemDescription as an example.
     * If we didn't override the toString method, by default it would print hexadecimal
     * values. 
     */
    @Override
    public String toString() {
        return ("Item Name: " + this.getItemName() + "\n" +
            "Description: " + this.getItemDescription() + "\n" +
            "Point Value: " + this.getPointValue());
    } //End of String toString method

    public static void main(String[] args) {
        Items item1 = new Items("Carpenter's Hammer", "This hammer looks warn bent and hasn't been used for carpentry in a long time.", "5");
        System.out.println(item1);
        System.out.println("\n" + "NOW TO CHANGE ALL OF THE VALUES AND PRINT USING GET/SET METHODS" + "\n");
        item1.setItemName("NAME CHANGED TO UPPERCASE: CARPENTER'S HAMMER");
        item1.setItemDescription("ITEM DESCRIPTION CHANGED TO UPPERCASE: THIS HAMMER LOOKS WARN BENT AND HASNT...");
        item1.setPointValue("15000000000000000");
        System.out.println(item1.getItemName());
        System.out.println(item1.getItemDescription());
        System.out.println(item1.getPointValue());
    } //End of main method 
} //End of class Items
