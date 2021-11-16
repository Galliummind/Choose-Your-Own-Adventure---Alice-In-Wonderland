/** Introduction
 * 
 * Title: Character
 * Description: Character Class will be used to create object Characters for the game.
 * date: Wednesday, December 30, 2020
 * @author Louis A. Hauteclocque
 * @version 1.0
 */

/** DOCUMENTATION...
 */

/** Purpose, Description, and compile instructions                                                                              
 *
 * Class Character:
 * Class character will be used to create objects of type character. They will
 * have the common OOP structure of private variables and public get/set methods. 
 * 
 * 
 * Compiling and running instructions
 * Assuming JDK 11.0.7 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 * Compile:    javac Character.java
 * Run:        java Character
 */

/** Classes and Methods
 *
 * Classes
 * public class Character
 * This is the main public class for this application.
 * 
 *
 * Character Methods
 * //This is the default constructor. 
 * public Character(String name, String longDescription, String attackPoints, String healthPoints)
 * //setName method will set the name value
 * public void setName(String newName)
 * //method will get the name value
 * public String getName()
 * //setName method will set the LongDescription value
 * public void setLongDescription(String newLongDescription)
 * //method will get the LongDescription value
 * public String getLongDescription()
 * //setName method will set the HealthPoints value
 * public void setHealthPoints(String newHealthPoints)
 * //method will get the HealthPoints value
 * public String getHealthPoints
 * //setName method will set the AttackPoints value
 * public void setattackPoints(String newAttackPoints)
 * //method will get the AttackPoints value
 * 
 * 
 * Character Instance Variables
 * private String name;
 * private String longDescription;
 * private String attackPoints;
 * private String healthPoints;
 */

/** Test Plan
 * 1. Run the application. 
 * EXPECTED:
 * The main method will run, and a new object l1 will b created. Then the character's
 * stats will be displayed, changed and displayed again. 
 * ACTUAL:
 * Application runs as expected.
 */

/** CODE...
 */

/** Java core packages */

public class Character {

    //Priming the variables.
    private String name;
    private String longDescription;
    private String attackPoints;
    private String healthPoints;

    /**default Constructor
     * The deafault constructor is set to create new instances of Character by
     * adding the required parameters. Each variable within the parameter will be used to
     * fill in the String objects of class Location. 
     */
    public Character(String name, String longDescription, String attackPoints, String healthPoints) {
        this.name = name;
        this.longDescription = longDescription;
        this.attackPoints = attackPoints;
        this.healthPoints = healthPoints;
    } //End of defualt Constructor

	/**method main()
	 * This method will be used to test the Character Class
	 * */
    public static void main(String[] args) {
        //Create a new instance of Character l1
        Character l1 = new Character("Carpenter", "You stumble into a man, with pools of madness swirling in his eyes, he raises a hammer towards you to strike!", "5", "20");
        //System print the object. The custom toString method should show.
        System.out.println(l1);
        l1.setName("Red Rabbit");
        l1.setLongDescription("He's got big pointy fangs! Look at all the bones around his den!");
        l1.setAttackPoints("999");
        l1.setHealthPoints("1000000000000000000000000");
        System.out.println();//Blank line
        System.out.println("Now All the values have been changed for the same Character Object. ");
        System.out.println(l1.getName());
        System.out.println(l1.getAttackPoints());
        System.out.println(l1.getHealthPoints());
        
    } //End of main method.

    /**Get/Set methods for Character
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

    //Now to set/get method
    public void setLongDescription(String newLongDescription) {
        this.longDescription = newLongDescription;
    } //End of setLongDescription

    public String getLongDescription() {
        return longDescription;
    } //End of getLongDescription


    //Now to set/get method
    public void setHealthPoints(String newHealthPoints) {
        this.healthPoints = newHealthPoints;
    } //End of setHealthPoints

    public String getHealthPoints() {
        return healthPoints;
    } //End of getHealthPoints 

    //Now to set/get method
    public void setAttackPoints(String newAttackPoints) {
        this.attackPoints = newAttackPoints;
    } //End of setAttackPoints

    public String getAttackPoints() {
        return attackPoints;
    } //End of getAttackPoints 

    /**In order to invoke the toString method to print an object with contextual
     * meaning we are required to override the method. So essentially what we are
     * asking is to return not just the object and location, but the object values
     * themselves in a string form. We are asking for this.getTitle as an example.
     * If we didn't override the toString method, by default it would print hexadecimal
     * values. 
     */
    @Override
    public String toString() {
        return (
            "!!!Character STATS!!!" + "\n" +
            "Name: " + this.getName() + "\n" +
            "Long Description: " + this.getLongDescription() + "\n" +
            "Attack Points: " + this.getAttackPoints() + "\n" +
            "Health Points: " + this.getHealthPoints() + "\n" +
            "\n");
    } //End of String toString method

} //End of class Character
