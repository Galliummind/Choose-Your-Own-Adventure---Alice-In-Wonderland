/** Introduction
 * 
 * Title: HeroGenerator
 * Description: HeroGenerator Class will be used to store and manipulate Objects of the Character class.
 * date: Wednesday, December 30, 2020
 * @author Louis A. Hauteclocque
 * @version 1.0
 */

/** DOCUMENTATION...
 */

/** Purpose, Description, and compile instructions                                                                              
 *
 * Class HeroGenerator:
 * Class HeroGenerator will be used to create objects of type Hero and deposit
 * them into an ArrayList. The HeroGenerator will manipulate those objects
 * with their own get/set methods and some custom remove objects methods.
 * 
 * Compiling and running instructions
 * Assuming JDK 11.0.7 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 * Compile:    javac HeroGenerator.java
 * Run:        java HeroGenerator
 */

/** Classes, Methods, and Variables
*
* Classes
public class HeroGenerator

* HeroGenerator Methods 
* 
*
//Default Constructor
public HeroGenerator()
//Custom Constructor will load textFileMethod.
public HeroGenerator(String textFileNameHere)
//textFileReader will read a text file and add contents to an ArrayList
public  void textFileReader(String textFileNameHere)
//method setHeroHealthPointsAfterBattle will take a int parameter and use it to update the Hero's health.
public void setHeroHealthPointsAfterABattle(int amountOfPointsToHeal)
//serHeroHealthPoints will take an int parameter and use that to ADD the amount to the characters HP
public void setHeroHealthPoints(int amountOfPointsToHeal)
//setHeroAttackPoints will increase Alice's AttackPoints by x.
public void setHeroAttackPoints(int increaseAttackPointsByThisValue)
//setHeroStarvation will add or subtract Hero Starvation variable by parameter int.
public void setHeroStarvation(int integerValueBeingAdded)
//setHeroThirst will add or subtract Hero Thirst variable by parameter value 
public void setHeroThirst(int integerValueBeingAdded)
* //Function will return a Hero Object from the arraylit at location x, where x is the location in the ArrayList.
public Object getHero(int x)
* 
* 
* HeroGenerator Instance Variables

private static ArrayList < Hero > HeroArrayList = new ArrayList < Hero > ();

*/

/** Test Plan
 * 1 . Run the application. 
 * EXPECTED:
 * The main method will run an Instance of AliceInWonderLand. Then Alice will
 * move to the sign post forest, First "Explore" multiple times until 
 * Alice picks up a crumpet, EatMeCake, and Potion. Once she has all the items
 * check Alice's Stats by typing "Alice's Info" or "A". Then consume all 
 * of the food in your inventory by typing "Consume". Check Alice's Stats 
 * again "A" and make sure the setHeroHealthPoints, SetHeroThirst, and setHeroStarvation
 * methods all work.
 * 
 * ACTUAL:
 * Application runs as expected. Alice is capable of consuming edible 
 * items in exchange for increasing her stats. 
 * 
 * 2 . Run the application. 
 * EXPECTED:
 * The main method will run an Instance of AliceInWonderLand. Then Alice will
 * move to the sign post forest, and "Explore" until an enemy encounter. DO 
 * NOT use an item, we will be testing if Alices statistics will be brought forward.
 * This is so we can test .getHero method
 * 
 * ACTUAL:
 * Application runs as expected. Alice is capable of encountering an enemy
 * and her stats are brought forward. 
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

public class HeroGenerator {

    /**HeroArrayList is an Arraylist that will hold the object <Hero>.
     * It will static so that the values withing the arraylist can be manipulated and
     * the values carried throughout the game. 
     */
    private static ArrayList < Hero > HeroArrayList = new ArrayList < Hero > ();

    /**Default Constructor
     * The default constructor will create an instance of the public class HeroGenerator.*/
    public HeroGenerator() {} //End of TextFileReader(String) Constructor

    /**LocationsGenerator Constructor (String, String)
     * This constructor will be create an instance of class LocationsGenerator.
     * It runsthe textFileReader method. The
     * String provided for this constructor and method should be the name of 
     * the text file "Hero.txt.
     * 
     * The textFileReader will load a textfile into multiple strings and pass that string into another 
     * constructor to create an object. Then that object will be loaded to an arraylist
     * 
     * The Reason why this constructor is necessary is because each time the class
     * is initilized we don't want the txt file read multiple times. So this constructor will only
     * be called once and that's within AliceinWonderland default constructor."
     */
    public HeroGenerator(String textFileNameHere) {
        textFileReader(textFileNameHere);
    } //End of TextFileReader(String) Constructor	

    /**Method TextFileReader(String x)
     * The textFileReader was recycled from Assignment 3.
     * This method will read a text file and create objects of the Hero class
     *  as long as there is a line to read & the value is not null. 
     * To do this a while loop will store each scanner line as 
     * a String. Once (x) number of Strings are generated the String values will
     * be passed onto another constructor of class Hero. This constructor will
     * create a Hero object which will be stored in the HeroArrayList.
     */
    public void textFileReader(String textFileNameHere) {
        try {
            //Create an instance of Scanner and method File().		  
            Scanner fileScanner = new Scanner(new File(textFileNameHere));
            /**While Statement
             * This will statement will run as long as the fileScanner has a line to 
             * scan in the text file && fileScanner content is not null. I added the null
             * feature in case I leave an empty line. This would cause an error that will 
             * cause the program to crash. The other option is the String saves a null value and 
             * I could potentially create objects that were wrong, but still accepted by the 
             * Hero class Constructor's parameters.
             * */
            while (fileScanner.hasNext() && fileScanner != null) {
                String str1, str2, str3, str4, str5;
                str1 = (fileScanner.nextLine());
                str2 = (fileScanner.nextLine());
                str3 = (fileScanner.nextLine());
                str4 = (fileScanner.nextLine());
                str5 = (fileScanner.nextLine());
                (HeroArrayList).add(new Hero(str1, str2, str3, str4, str5));
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
    } //End of TextFileReader(String)

    /**Method setHeroHealthPointsAfterBattle
     * This method will be used to update Alice's HealthPoints. This method works
     * by passing the int value of what you want to set the hero's current health points to.
     * 
     * This method works by creating an object Hero based on the hero object in the arraylist
     * HeroArrayList at location 0 of the arrayList. next a string setHP will 
     * convert the int variable (amountOfPointsToHeal) into a String (currentHP).
     * Then that string will be used to overwrite or assin a new value to the manifestHero's
     * healthPoints. This is done by using the method setHealthPoints in class
     * Hero. Method setHealthPoints is apart of a get/set method. 
     */
    public void setHeroHealthPointsAfterABattle(int amountOfPointsToHeal) {
        Hero manifestHero = (Hero) HeroArrayList.get(0);
        //Convert int amountOfPointsToHeal to String using to.String method.
        String currentHP = Integer.toString(amountOfPointsToHeal);
        //call setHealthPoints method.
        manifestHero.setHealthPoints(currentHP);
        //set new hero values back into array at position 0 in the field, with object manifestHero.
        HeroArrayList.set(0, manifestHero);
    } //End of setHeroAttackPoints	

    /**Method setHeroHealthPoints
     * This method is used to set a heros HP. It works slightly differently than the 
     * method setHeroHealthPointsAfterBattle. Instead of assigning the parameter value directly
     * to the object manifestHero it will ADD the parameter value to the manifestHero object's HealthPoints.
     * 
     * This is done by first making a duplicate hero object. Then an integer temporaryIntValue will
     * be assigned the value of parameter amountOfPointsToHeal + the manifestObjects healthPoints. But first because
     * variable HealthPoints is a String and cannot be added with an integer it must be converted
     * using a function. The function we use is Integer.parseInt(). parseInt() will 
     * "Parses the string argument as a signed decimal integer."
     * credit: https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html
     * 
     * Finally I will overright the current object in the HeroArrayList at position 0
     * by using the .set method(location 0, object manifestHero. 
     */
    public void setHeroHealthPoints(int amountOfPointsToHeal) {
        Hero manifestHero = (Hero) HeroArrayList.get(0);
        //Add temp int amountOfPointsToHeal to Hero's health points by converting manifestHero to integer.
        int temporaryIntValue = amountOfPointsToHeal + (Integer.parseInt(manifestHero.getHealthPoints()));
        //Convert temporaryIntValue to String using to.String method.
        String setHP = Integer.toString(temporaryIntValue);
        //call setHealthPoints method.
        manifestHero.setHealthPoints(setHP);
        //set new hero values back into array at position 0 in the field, with object manifestHero.
        HeroArrayList.set(0, manifestHero);
    } //End of setHeroAttackPoints	

    /**Method setHeroAttackPoints
     * This method will set an object Heros String AttackPoints
     * 
     * This is done by creating a copy of the object being updated. Then 
     * adding the parameter int increaseAttackPointsByThisValue to the hero's current attackPoints and assigning
     * that value to int r. But first because variable AttackPoints is a 
     * String and cannot be added with an integer it must be converted
     * using a function. The function we use is Integer.parseInt(). parseInt() will 
     * "Parses the string argument as a signed decimal integer."
     * credit: https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html
     * 
     * Finally I will overright the current object in the HeroArrayList at position 0
     * by using the .set method(location 0, object manifestHero.   
     * */
    public void setHeroAttackPoints(int increaseAttackPointsByThisValue) {
        Hero manifestHero = (Hero) HeroArrayList.get(0);
        //Add temp int r to Hero's attack points by converting manifestHero attack points to integer.
        int r = increaseAttackPointsByThisValue + (Integer.parseInt(manifestHero.getAttackPoints()));
        //Convert int r to String using to.String method
        String heroAttack = Integer.toString(r);
        //Call setAttackPoints Method
        manifestHero.setAttackPoints(heroAttack);
        //~ manifestHero.setAttackPoints(increaseAttackPointsByThisValue);
        HeroArrayList.set(0, manifestHero);
    } //End of setHeroAttackPoints

    /**Method setHeroStarvation
     * This method will set the Hero StarvationPoints. This is done by creating a copy of the object being updated. Then 
     * adding the parameter int integerValueBeingAdded to the hero's current starvationPoints and assigning
     * that value to int r. But first because variable starvationPoints is a 
     * String and cannot be added with an integer it must be converted
     * using a function. The function we use is Integer.parseInt(). parseInt() will 
     * "Parses the string argument as a signed decimal integer."
     * credit: https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html
     * 
     * Finally I will overright the current object in the HeroArrayList at position 0
     * by using the .set method(location 0, object manifestHero.   
     */
    public void setHeroStarvation(int integerValueBeingAdded) {
        Hero manifestHero = (Hero) HeroArrayList.get(0);
        //Add temp int r to Hero's starvation points by converting manifestHero starvation points to integer.
        int r = (Integer.parseInt(manifestHero.getStarvationPoints()) + integerValueBeingAdded);
        //Convert int r to String using to.String method
        /**If statment
         * This if statement will be used to check if the characters starvation level is at
         * 0. If starvation is below 0 an instance of Actions.death() is called. This will kill
         * Alice and exit the game.*/
        if (r <= 0) {
            System.out.println("Alice has died of starvation.");
            Actions newActions = new Actions();
            newActions.death();
        } //End of if statment
        String heroStarvation = Integer.toString(r);
        //Call setstarvationPoints Method
        manifestHero.setStarvationPoints(heroStarvation);
        HeroArrayList.set(0, manifestHero);
    } //End of setHerostarvationPoints

    /**Method setHeroThirst
     * This method will set the HeroThirst points. This is done by creating a copy of the object being updated. Then 
     * adding the parameter int integerValueBeingAdded to the hero's current starvationPoints and assigning
     * that value to int temporaryInteger. But first because variable starvationPoints is a 
     * String and cannot be added with an integer it must be converted
     * using a function. The function we use is Integer.parseInt(). parseInt() will 
     * "Parses the string argument as a signed decimal integer."
     * credit: https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html
     * 
     * Finally I will overright the current object in the HeroArrayList at position 0
     * by using the .set method(location 0, object manifestHero.
     */
    public void setHeroThirst(int integerValueBeingAdded) {
        Hero manifestHero = (Hero) HeroArrayList.get(0);
        //Add temp int temporaryInteger to Hero's thirst points by converting manifestHero thirst points to integer.
        int temporaryInteger = integerValueBeingAdded + (Integer.parseInt(manifestHero.getThirstPoints()));
        //Convert int temporaryInteger to String using to.String method
        /**If statment
         * This if statement will be used to check if the characters thirst level is at
         * 0. If thirst is below 0 an instance of Actions.death() is called. This will kill
         * Alice and exit the game.*/
        if (temporaryInteger <= 0) {
            System.out.println("Alice has died of thirst.");
            Actions newActions = new Actions();
            newActions.death();
        } //End of if statment
        String herothirst = Integer.toString(temporaryInteger);
        //Call setthirstPoints Method
        manifestHero.setThirstPoints(herothirst);
        //~ manifestHero.setthirstPoints(integerValueBeingAdded);
        HeroArrayList.set(0, manifestHero);
    } //End of setHerothirstPoints

    /**method getHero
     * This method will .get the hero object from the arrayList HeroArrayList
     * in location 0 (AKA Alice) and store that into a new object with the reference
     * name, manifestHero. The object manifestHero will be returned.
     */
    public Object getHero(int x) {
        //create new Hero Object manifestHero from HeroArrayList location 0
        Hero manifestHero = (Hero) HeroArrayList.get(x);
        //Return Hero Object manifestHero.
        return manifestHero;
    } //End of bringObjects	

    /**Method main
     * This method creates an instance of class AliceInWonderLand. It will be used
     * for testing purposes.
     */
    public static void main(String[] args) {
        //Create instance of classes needed.
        AliceInWonderland AliceInWonderLand = new AliceInWonderland();
    } //End of main method	
} //End of Items Generator
