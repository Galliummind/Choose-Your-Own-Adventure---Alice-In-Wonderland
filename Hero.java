/** Introduction
 * 
 * Title: Hero
 * Description: Hero Class will be used to create object Hero for the game.
 * date: Wednesday, December 30, 2020
 * @author Louis A. Hauteclocque
 * @version 1.0
 */

/** DOCUMENTATION...
 */

/** Purpose, Description, and compile instructions                                                                              
 *
 * Class Hero:
 * Class Hero will be used to create objects of type Hero. They will
 * have the common OOP structure of private variables and public get/set methods. 
 * 
 * 
 * Compiling and running instructions
 * Assuming JDK 11.0.7 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 * Compile:    javac Hero.java
 * Run:        java Hero
 */

/** Classes, Methods, and Variables
*
* Classes
public class Hero
* 
* Hero Methods 

//Default Constructor.
public Hero(String name, String attackPoints, String healthPoints, String starvationPoints, String thirstPoints)

//method to set the name Variable.
public void setName(String newName)

//Method to get the variable name. 
public String getName()

//method to set healthPoints variables.
public void setHealthPoints(String newHealthPoints)

//method set healthPoints variables. 
public String getHealthPoints()

//method set attackPoints.
public void setAttackPoints(String newAttackPoints)

//method get AttackPoints.
public String getAttackPoints()

//method  set starvationPoints.
public void setStarvationPoints(String newStarvationPoints)

//method to get starvationPoints variable.
public String getStarvationPoints()

//method to set thirstPoints variable.
public void setThirstPoints(String newThirstPoints)

//Override toString method to print custom message.
public String toString()

//main method used for testing.
public static void main (String[] args)

* Hero Instance Variables

private String name;
private String attackPoints;
private String healthPoints;
private String starvationPoints;
private String thirstPoints;

*/

/** Test Plan
 * 1. Run the application. 
 * EXPECTED:
 * The main method will run, and a new object l1 will be created. Then the Heros's
 * variables will be displayed. First I will use the constructor to create
 * the object, then I will manually manipulate the Object using the get/set method.  
 * ACTUAL:
 * Application runs as expected.
 */

/** CODE...
 */

/** Java core packages */


public class Hero {

    //Priming the variables.
    private String name;
    private String attackPoints;
    private String healthPoints;
    private String starvationPoints;
    private String thirstPoints;

    /**default Constructor
     * The deafault constructor is set to create new instances of Hero by
     * adding the required parameters. Each variable within the parameter will be used to
     * fill in the String objects of class Location. 
     */
    public Hero(String name, String attackPoints, String healthPoints, String starvationPoints, String thirstPoints) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.healthPoints = healthPoints;
        this.starvationPoints = starvationPoints;
        this.thirstPoints = thirstPoints;
    } //end of Hero constructor 

    /**Get/Set methods for Items
     * These get/set methods are based on OOP encapsulation methods.
     * Normally a private variables can only be accessed within the same class.
     * But by providing public get/set methods we can use the get methods to 
     * return variables and the set method sets the values.
     */
    //Now to set/get method
    public void setName(String newName) {
        this.name = newName;
    } //End of setName

    public String getName() {
        return name;
    } //End of getName

    // Set/Get method
    public void setHealthPoints(String newHealthPoints) {
        this.healthPoints = newHealthPoints;
    } //End of setHealthPoints

    public String getHealthPoints() {
        return healthPoints;
    } //End of getHealthPoints 

    // Set/Get method
    public void setAttackPoints(String newAttackPoints) {
        this.attackPoints = newAttackPoints;
    } //End of setAttackPoints

    public String getAttackPoints() {
        return attackPoints;
    } //End of getAttackPoints 

    // Set/Get method
    public void setStarvationPoints(String newStarvationPoints) {
        this.starvationPoints = newStarvationPoints;
    } //End of setStarvationPoints

    public String getStarvationPoints() {
        return starvationPoints;
    } //End of getStarvationPoints 

    // Set/Get method
    public void setThirstPoints(String newThirstPoints) {
        this.thirstPoints = newThirstPoints;
    } //End of setThirstPoints

    public String getThirstPoints() {
        return thirstPoints;
    } //End of getThirstPoints 

    /**In order to invoke the toString method to print an object with contextual
     * meaning we are required to override the method. So essentially what we are
     * asking is to return not just the object and location, but the object values
     * themselves in a string form. We are asking for this.getName as an example.
     * If we didn't override the toString method, by default it would print hexadecimal
     * values. 
     */
    @Override
    public String toString() {
        return (
            "Character Name: " + this.getName() + "\n" +
            "Attack Points: " + this.getAttackPoints() + "\n" +
            "Health Points: " + this.getHealthPoints() + "\n" +
            "Turns Until Starvation: " + this.getStarvationPoints() + "\n" +
            "Turns Until Dehydration: " + this.getThirstPoints() + "\n" +
            "\n");
    } //End of String toString method

    /**main method
     * The main method will be used to test the Hero Class methods.
     * First create an instance of hero, l1. 
     * Then change all of the values.
     * reprint the method.  */
    public static void main(String[] args) {
        //Create an Object of class Hero
        Hero l1 = new Hero("Mad Hatter", "25", "5", "25", "2520");
        //Print out message demonstrating toString method
        System.out.print(l1);
        System.out.println("NOW I WILL CHANGE ALL THE VALUES USING THE SET METHOD.");
        //manually set all the values to demonstrate they work
        l1.setName("Mad Hatter name change");
        l1.setHealthPoints("50");
        l1.setAttackPoints("100");
        l1.setThirstPoints("9999");
        //Manually print all of the values to demonstrate get methods.
        System.out.println(l1.getName());
        System.out.println(l1.getHealthPoints());
        System.out.println(l1.getAttackPoints());
        System.out.println(l1.getThirstPoints());
    } //End of main method.
} //End of class Hero
