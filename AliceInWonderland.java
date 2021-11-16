/**
 * Title: AliceInWonderland
 * Description: An Application for a choose your own adventure game.
 * date: Wednesday, December 30, 2020
 * @author Louis A. Hauteclocque
 * @version 1.0
 */

/**
 * DOCUMENTATION...
 */

/**                                                                               
 *
 *Choose your own adventure game.
 *
 *Purpose and Description
 *
 * An application that allows for a user to explore Alice in Wonderland book by Lewis Carroll.
 * The game, itself, is a text-based adventure game. There are no graphics; 
 * only text is used for communication between the game and the player. 
 * All output is descriptive, in the form of paragraphs and short answers
 * (e.g., “You can’t go in that direction.”). All input is in the form 
 * of simple text commands chosen from a limited set of options (e.g., 
 * “go north”). The input is sophisticated, though, as it recognizes 
 * “go north,” “north,” and “n” as identical commands, and acts accordingly.
 * Punctuation and capitalization are ignored as input.
 * 
 * Compiling and running instructions
 * Assuming JDK 11.0.7 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 * Compile:    javac AliceInWonderland.java
 * Run:        java AliceInWonderland
 */

/**
 *
 * Classes
 *
 *
 * public class AliceInWonderland
 * This is the main public class for this application.
 * 
 *
 * AliceInWonderland Methods
 * 
 * 
 * public AliceInWonderland()
 * Constructor for AliceInWonderland class -  this method is used to set
 * up the game.
 * 
 * public static void main(String args[])
 * This method is used to execute the application
 * 
 * 
 * AliceInWonderland Instance Variables
 *
 */

/**
 *
 * Test Plan
 *
 *
 * 1. Run the application. 
 * EXPECTED:
 *    The game should initiate and the user will be given the introuction to Alice in Wonderland.
 * Then a menu showing the available options will be printed.
 
 * ACTUAL:
Welcome to Alice in Wonderland! The choose your own adventure game.
Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, `and what is the use of a book,' thought Alice `without pictures or conversation?'So she was considering in her own mind (as well as she could, for the hot day made her feel very sleepy and stupid), whether the pleasure of making a daisy-chain would be worth the trouble of getting up and picking the daisies, when suddenly a White Rabbit with pink eyes ran close by her.There was nothing so very remarkable in that; nor did Alice think it so very much out of the way to hear the Rabbit say to itself, `Oh dear! Oh dear! I shall be late!' (when she thought it over afterwards, it occurred to her that she ought to have wondered at this, but at the time it all seemed quite natural); but when the Rabbit actually took a watch out of its waistcoat-pocket, and looked at it, and then hurried down a large rabbit-hole under the hedge.
*********************************************
"Explore" (Beware! enemies may find you!)
"Move" (new Locations will be displayed)
"Use" (attempt to use an item.
"Consume" (Consuming food will increase your health and/or your attack.
"Alice's Info" (To check Alice's Stats.
"Inventory" (To check your inventory.
"Stash" (To check your stash. or if you're in the Alley you can stash your items.
"Discussion" (To talk to someone
"Help" (Get help on how to play the game.)
"Quit" (to exit the game
*********************************************

What would you like to do? 
 * 
 * 2. Good data cases:
 * EXPECTED: I will attempt to use each of the options such as move,
 * explore, use, Alice's Info, Inventory, Stash, Discussion, Help, Quit. 
 * ACTUAL:
 *  Results displayed as expected.
 */

/**
 * CODE...
 */

/** Java core packages */


/**Public class Alice in wonderland.
 * This class is used to start an instance of Alice in Wonderland. It consists of
 * a main method only as requested. The default constroctur has been modified,
 * but it is still apart of the original class.
 * 
 * To create an instance of Alice in wonderland I will be creating a new instance of the class and that itself will create
 * an instance of all the other classes; Hero Generator, LocationsGenerator, ItemsGenerator, CharacterGenerator. These
 * classes must be initilized first as they will need to load text files of the games content like enemies, items and locations to visit.*/

public class AliceInWonderland {

    /**default Constructor - AliceInWonderland
     * This is the default constructor for the public class AliceinWonderland.
     * This constructor will simply create an instance LocationsGenerator and then
     * use that class instance to run an instance of method locationsWhereAreYou();
     * More details can be found by navigating to the method's location. But essentially this 
     * method will run a while statement that sends the current location as an integer
     * in order to determine what information is relevent.
     * */
    public AliceInWonderland() {
        //Creating an instance of class needed.
        LocationsGenerator newLocationsGenerator = new LocationsGenerator("Locations.txt");
        HeroGenerator newHeroGenerator = new HeroGenerator("Hero.txt");
        CharacterGenerator newCharactergenerator = new CharacterGenerator("Character.txt", "Boss.txt");
        ItemsGenerator newItemsGenerator = new ItemsGenerator("Items.txt", "SpecialItems.txt");
        newLocationsGenerator.locationsWhereAreyou();
    } //End constructor of AliceInWonderland		

    /** Alice in wonderland main() method.
     * This is the main() method for the class AliceinWonderland.
     * As requested by the assignment it runs an instance of Alice in Wonderland.
     * */
    public static void main(String[] args) {
        AliceInWonderland AliceInWonderLand = new AliceInWonderland();
    } //End of main method
} //End of public class AliceInWonderland

