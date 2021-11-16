/** Introduction
 * 
 * Title: Actions
 * Description: Actions class will be used if an action is allowed by the
 * 				controls class.
 * date: Wednesday, December 30, 2020
 * @author Louis A. Hauteclocque
 * @version 1.0
 */

/** DOCUMENTATION...
 */

/** Purpose, Description, and compile instructions                                                                              
 *
 * Class Actions: If an Action is allowed, then the methods required to complete 
 * the action should be called on the objects involved (e.g., Action: 
 * “take”; object involved: “flashlight”). Certain actions will result in
 *  changes in the user’s inventory. Other actions will change the user’s
 *  location. Changes in location will trigger appropriate descriptive 
 * outputs based on the room entered and whether it is the first time entering.
 * 
 * Compiling and running instructions
 * Assuming JDK 11.0.7 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 * Compile:    javac Actions.java
 * Run:        java Actions
 */

/** Classes and Methods
 *
 * Classes
 * public class Actions
 * This is the main public class for this application.
 * 
 *
 * Actions Methods
 * 
 * //This method creates an instance of class AliceInWonderLand. It will be used for testing purposes.
 * public static void main(String[] args)
 * 
 * //Used to start a random enemy encounter
 * public boolean randomEncounter(int x)
 * 
 * //Special battle against The Red Queen.
 * public void AttackedbyTheQueen()
 * 
 * //This method is used to move from location to location 
 * public int move(int x) 
 * 
 * //This method is used to have a discussion depending on location
 * public void discussion(int x)
 * 
 * //An introduction to the game and how to win will be given.
 * public void help()
 * 
 * //This method is used to explore the area
 * public void explore(int currentLocation)
 * 
 * //Death method will be called if Alice falls, starves, or dies from a fight.
 * public void death() 
 * 
 * //Win method is essentially an exit from the program and a point calculator
 * public void win()
 * 
 * //This method will consume food items and potions for various points.
 * public void consumeFood()
 * 
 * //CheckInventory is essentially an inventory check
 * public void checkInentory()
 * 
 * //drop item method is used to discard an item.
 * public void dropItem()
 * 
 * //visitLocation is a key method that allows the user to move.
 * public void visitLocation(int x, String element)
 * public int connectedRoomsList(int x)
 * 
 * public Actions()
 * Constructor for Actions class -  This method is used 
 * for the defafault constructor. It will be called to create an instance
 * of class Actions.
 * 
 * public static void main(String args[])
 * This method is used to execute the application
 * 
 * 
 * Actions Instance Variables
 * None
 */

/** Test Plan
 * 1. Run the application. 
 * EXPECTED:
 *    The game should initiate and the user will be given the introuction to Alice in Wonderland.
 * Then a menu showing the available options will be printed. The user should be able to perform any
 * of the options above. Please note if Alice attempts to explore before getting into Wonderland she
 * will always find nothing (It's not a bug).
 * ACTUAL:
 All options were tested and succesfuly.
 *"Explore" (Beware! enemies may find you!)
 *"Move" (new Locations will be displayed
 *"Use" (attempt to use an item.
 *"Consume" (Consuming food will increase your health and/or your attack.
 *"Alice's Info" (To check Alice's Stats.
 *"Inventory" (To check your inventory.
 *"Stash" (To check your stash. or if you're in the Alley you can stash your items.
 *"Discussion" (To talk to someone
 *"Help" (Get help on how to play the game.)
 *"Quit" (to exit the game
 * 
 * 2. Run the application:
 * EXPECTED: Attempt to move from one location to another by
 * typing move when prompted by the menu. I will attempt to enter a proper 
 * command and a bad command like a numerical or special character "~".
 * 
 * ACTUAL:
 *  Alice is offered the available locations to move to.
 * runs as expected, when bad inputs are entered they are ignored and the user
 * is prompted to try again as expected.
 * 
 * 3. Run the application:
 * EXPECTED: Attempt to Explore a location by
 * typing Explore when prompted by the menu. I will attempt to enter a proper 
 * command and a bad command like a numerical or special character "~".
 * 
 * ACTUAL:
 *  Alice is depending on random chance able to explore or a random enemy encounter.
 * runs as expected, when bad inputs are entered they are ignored and the user
 * is prompted to try again as expected.
 * 
 */

/** CODE...
 */

/** Java core packages */
import java.util.Random;

/**public class Actions
 */
public class Actions {

    /**Method main
     * This method creates an instance of class AliceInWonderLand. It will be used
     * for testing purposes.
     */
    public static void main(String[] args) {
        //Create instance of classes needed.
        AliceInWonderland AliceInWonderLand = new AliceInWonderland();
    } //End of main method

    /**function randomEncounter()
     * This method is used to create a randomized encounter of
     * an enemy. Before the encounter the player is offered the option
     * to use an item on the enemy. If the item is used it has a chance to
     * deter the enemy. Otherwise the enemy will attack. Depending on the 
     * item given will influence the odds.
     * 
     * The boolean returned at the end of the program isn't actually used for 
     * it's intended purposes, but after researching how to break out of 
     * the method the community on stackOverFlow recommended just using a return.
     * Not official, but practical in the field.
     *
     * For more detail please expand the comments within this method. 
     * */
    public boolean randomEncounter(int RandomGeneratedNumber) {
        //Create required instances.
        Controls newControls = new Controls(); //Creat an instance of class Controls
        ItemsGenerator newItemsGenerator = new ItemsGenerator(); //Create an instance of class ItemsGenerator
        CharacterGenerator newCharacterGenerator = new CharacterGenerator(); //Create an instance of CharacterGenerator
        HeroGenerator newHeroGenerator = new HeroGenerator(); //Create an instance of class HeroGenerator 
        //Print message to output
        System.out.println("You are attacked by an Character!");
        System.out.print("Would you like to use an item?");
        //Boolean value is based on what returns from function ControlsYesOrNo
        boolean wouldYouLikeToUseAnItem = (newControls.ControlsYesOrNo());

        //If Statment(wouldYouLikeToUseAnItem == true)
        /** If Statment(wouldYouLikeToUseAnItem == true)
         * If the user would like to use an item an instance of 
         * ItemsGenerator.useItemBeforeBattle() will be initiated. This
         * function returns a boolean value dependent on if the user has 
         * sucessfully detered the enemy or not.
         * 
         * If the attempt was successful, return: to break the method. 
         * */
        if (wouldYouLikeToUseAnItem) {
            boolean resultsOfAttemptToUseItem = (newItemsGenerator.useItemBeforeBattle());
            //If statement, if true then Alice has defeated the enemy
            if (resultsOfAttemptToUseItem) {
                //return boolean is actually just used to break out of the method.
                //Recommended by the stackOverFlowCommunity https://stackoverflow.com/questions/18041770/stop-executing-further-code-in-java
                return resultsOfAttemptToUseItem;
            } //End of if statement
        } //End of wouldYouLikeToUseAnItem

        /**
         * If the results of useItemBeforeBattle were false or the user opted out by pressing 
         * enter then the character will be manifested (Alice) and a random Enemy.
         * Attack rounds will start with Alice and the enemy fighting until someone is dead. Depending
         * on multiple if statements that use the characters HealthPoints variables a condition will be met
         * and Alice will either slay the enemy or be slain.*/
        //get random Character.
        Character manifestCharacter = (Character) newCharacterGenerator.getCharacter(RandomGeneratedNumber);
        //This will bring Alice forward
        Hero manifestHero = (Hero) newHeroGenerator.getHero(0);
        //get Hero and Character titles
        String CharacterName = (manifestCharacter.getName());
        String HeroName = (manifestHero.getName());
        //Convert both Character and Alice attackPoints to integers.
        int CharacterAttack = Integer.parseInt(manifestCharacter.getAttackPoints());
        int HeroAttack = Integer.parseInt(manifestHero.getAttackPoints());
        //get health points.
        int CharacterHP = Integer.parseInt(manifestCharacter.getHealthPoints());
        int HeroHP = Integer.parseInt(manifestHero.getHealthPoints());

        /**While statement that will simulate an attack sequence. First
         * Alice will attack then the Character will retaliate. between each attacks
         * the value CharacterHP will be checked to make sure it's still alive. If so
         * the fight continues. If not the loop is broken and Alice continues. */
        attackLoop:
            while (CharacterHP >= 0 && HeroHP >= 0) {

                System.out.println(HeroName + " attacks!");
                System.out.println(CharacterName + " defends");
                System.out.println(HeroName + " hits: " + HeroAttack + " damage!");
                CharacterHP = CharacterHP - HeroAttack;
                System.out.println(CharacterName + " HP = " + CharacterHP);
                System.out.println();
                if (CharacterHP <= 0) {
                    break attackLoop;
                } //End of if statement			

                System.out.println(CharacterName + " attacks!");
                System.out.println(HeroName + " defends");
                System.out.println(CharacterName + " hits: " + CharacterAttack + " damage!");
                HeroHP = HeroHP - CharacterAttack;
                System.out.println(HeroName + " HP = " + HeroHP);
                newControls.pressEnterToContinue();

            } //End of while statement	

        if (HeroHP <= 0) {
            Actions newActions = new Actions();
            newActions.death();
        } //End of if Statement
        else System.out.println("You have defeated " + CharacterName + "\n");
        //Set Alice's HP to current HP level.
        newHeroGenerator.setHeroHealthPointsAfterABattle(HeroHP);
        //return boolean is actually just used to break out of the method.
        //Recommended by the stackOverFlowCommunity https://stackoverflow.com/questions/18041770/stop-executing-further-code-in-java
        return wouldYouLikeToUseAnItem;
    } //End of method randomAttack	

    /** Method AttackedByTheQueen
     * This method is used to have a special boss fight with the Red Queen. 
     * I recycled a lot of code from the randomEncounter method and it may looks similar.
     * This method will bring two characters forward (Alice and the Queen) then
     * they will exchange attacks until one is dead. What makes this method different than
     * randomEncounters is at the end of this encounter Alice will recieve the Red Queen's
     * crown.
     * */
    public void AttackedByTheQueen() {
        //Create instances of the classes required.
        Controls newControls = new Controls();
        HeroGenerator newHeroGenerator = new HeroGenerator();
        CharacterGenerator newCharacterGenerator = new CharacterGenerator();
        Actions newActions = new Actions();

        //This method getQueen(). Will bring the boss of this game forward. The Red Queen!
        Character manifestCharacter = (Character) newCharacterGenerator.getQueen();
        //This will bring Alice forward
        Hero manifestHero = (Hero) newHeroGenerator.getHero(0);

        //get Hero and Character titles
        String CharacterName = (manifestCharacter.getName());
        String HeroName = (manifestHero.getName());
        //Convert both Character and Alice attackPoints to integers.
        int CharacterAttack = Integer.parseInt(manifestCharacter.getAttackPoints());
        int HeroAttack = Integer.parseInt(manifestHero.getAttackPoints());
        //get health points.
        int CharacterHP = Integer.parseInt(manifestCharacter.getHealthPoints());
        int HeroHP = Integer.parseInt(manifestHero.getHealthPoints());

        /**While statement that will simulate an attack sequence. First
         * Alice will attack then the Character will retaliate. between each attacks
         * the value CharacterHP will be checked to make sure it's still alive. If so
         * the fight continues. If not the loop is broken and Alice continues. */
        attackLoop:
            while (CharacterHP >= 0 && HeroHP >= 0) {

                System.out.println(HeroName + " attacks!");
                System.out.println(CharacterName + " defends.");
                System.out.println(HeroName + " hits: " + HeroAttack + " damage!");
                CharacterHP = CharacterHP - HeroAttack;
                System.out.println(CharacterName + " HP = " + CharacterHP);
                System.out.println();
                if (CharacterHP <= 0) {
                    break attackLoop;
                } //End of if statement			

                System.out.println(CharacterName + " attacks!");
                System.out.println(HeroName + " defends");
                System.out.println(CharacterName + " hits: " + CharacterAttack + " damage!");
                HeroHP = HeroHP - CharacterAttack;
                System.out.println(HeroName + " HP = " + HeroHP);
                newControls.pressEnterToContinue();

            } //End of while statement	
        //If Alice's HP is below or equal to 0 Alice will die.
        if (HeroHP <= 0) {
            //Create instance of method death().
            newActions.death();
        } //End of if Statement
        else System.out.println("You have defeated " + CharacterName + "\n");
        //Set Alice's HP to current HP level.
        newHeroGenerator.setHeroHealthPointsAfterABattle(HeroHP);
        //Bring Red Queen's Crown forward and place in inventory.
        ItemsGenerator newItemsGenerator = new ItemsGenerator();
        newItemsGenerator.placeSpecialItemInInventory(0);
    } //End of attacked by the Queen.	

    /**Public Function move
     * This method will bring forward the available locations to move from
     * and store them in a String. The user will then be prompted to choose a 
     * location to move from. Both values will be compared and if there is a match 
     * the user will be moved to another location. results is the numerical value that corelates
     * with the Location. For example Park = 0.
     * */
    public int move(int currentLocation) {
        //Priming the variables and initiating the instances.
        int results = currentLocation;
        LocationsGenerator LG = new LocationsGenerator();
        Controls newControls = new Controls();
        //First we need to get the available locations to move; example: Forest, Hole
        String connectedRoomsList = LG.bringConnectedPlacesForward(currentLocation);
        //Second Check to see where the user wants to go.
        results = newControls.userInputLocationsCheck(connectedRoomsList, currentLocation);
        return results;
    } //End of move method

    /**Method discussions(int currentLocation)
     * this method will be used to display a unique dialogue depending on
     * Alice's Location. this is done, by calling on an instance of 
     * textFileReaderDiscussion() and passing the variable int currentLocation
     * as a parameter condition. Then the stringBuffer will be printed to the user.
     */
    public void discussion(int currentLocation) {
        //Create instances of classes required
        Controls newControls = new Controls();
        CharacterGenerator newGenerator = new CharacterGenerator();
        //Print StringBuffer returned from function textFileReaderDiscussion.
        System.out.println(newGenerator.textFileReaderDiscussion(currentLocation));
    } //End of method discussion

    /**Method help
     * This is a simple help method that will print a message to the user. 
     */
    public void help() {
        System.out.println();
        System.out.println("*** Help ***");
        System.out.println("Please refer to the document \"CheetSheet\" for a cheat sheet to be beat the game.");
        System.out.println("	Alice in WonderLand is a choose your own adventure game." + "\n" +
            " The object of this game is to find the Red Queen and get her crown. Once you have the crown" + "\n" +
            " you will need to get back to the alley and hand the crown to the door using the stash command." + "\n" +
            " Dont forget each time Alice explores a location or moves to another location her thirst and hunger" + "\n" +
            " counter will go down. If Alices hunger or thirst counter goes down she will die!");
        System.out.println("Alice can also die of losing her Health points in battle, or by moving to a wrong location!");
        System.out.println("You can consume potions, crumpets, and eatMeCakes to increase health, attackpoints, thirst and starvation points.");
        System.out.println("The more items you carry the higher chance of Characters attacking you while you're trying to explore." + "\n" +
            " Drop your items into your stash ( must be in the Alley) to decrease your chance of being attacked");
        System.out.println("*** End of text ***");
    } //End of method Help

    /**Method explore
     * First this method requires a parameter currentLocation
     * the currentLocation variable will be passed to an if statement.
     * If the currentLocation is less than 3 that means Alice has not yet entered Wonderland.
     * So what will happen is when she searches she will always find nothing of use. I added this feature so that Alice
     * wasn't finding items unique to Wonderland.
     * 
     * another if statement will be an outer if statement. This if statement will
     * check if currentLocation (currentLocation >= 3) is greater than 3. If true,
     * Alice is now in wonderLand and may find items exclusive to the book. 
     * 
     * first thing in this outer if statment is the int ItemsInInventorySize, this
     * variable was created to increase the number of another variable, randomNumber.
     * The reason is because based on how high randomNumber is Alice will either be attacked or find and item.
     * As requested by the assignment "Encounters may be triggered by an item in the inventory 
     * (e.g., if you have a jewel, you are more likely to encounter the thief)."
     * So by increasing Alices inventory she will increase the variable ItemsInInventory and
     * that value will be passed to the variable randomNumber. Alice will find less items and more encounters. 
     * 
     * The next set of steps is odd to explain. but essentially I will be creating an instance of the Random Class.
     * I will be using this instance to get a random number based on the arraylists of Items and Characters. to do this
     * variable int upperBoundCharacter and upperBoundItems will hold the value of the size of the arraylist (using methods found
     * in each class respectively).
     * 
     * the next step is creating another set of variables randomIntegerCharacter, randomIntegerItems. These values will be used to
     * pass along as parameter values to methods Actions.randomEncounter() and ItemsGenerator.placeItemInInventory(randomIntegerItems).
     * To get the values of these variables I will be Invoke the following method nextInt() of class Random.
     * nextInt(upperbound) generates RANDOM NUMBERS in the range 0 to (upperboundCharacter-1) /(upperBoundItems-1). This works fine
     * for the Arraylist as we want to include the index 0 in an ArrayList.
     * 
     * Next the value for variable randomNumber will go through an inner if statement. if randomNumber is > 8 (True), Alice 
     * attempts to search the area, but instead encounters a random Character. Actions.randomEncounters will be called, and variable
     * randomIntegerCharacter will be passed along for the required parameter. This will provide a random Character. 
     * else (false) Alice has sucessfully avoided detection and will find a random Item instead. 
     * ItemsGenerator.placeItemInInventory() method will be called and randomIntegerItems variable will be passed as the parameter. This will
     * allow for a random item to be generated.
     * 
     */
    public void explore(int currentLocation) {
        Actions newActions = new Actions();
        ItemsGenerator newItemsGenerator = new ItemsGenerator();
        // If paramter currentLocation is less than three. It means Alice has yet to enter Wonderland. She will find no items.
        if (currentLocation < 3) {
            System.out.println("Alice takes a moment to look around and, She found nothing of interest.");
        }
        //End of if less than 3

        //boolean redQueensCrownInInventory will check to see if Alice has the special Red Queens Crown. This
        //will prevent Alice from being able to fight the red queen multiple times. 
        boolean redQueensCrownInInventory = (newItemsGenerator.searchInventoryOnly("Red Queen's Crown"));
        //If statement will only run if Alice is in location 11 and if boolean value comes back false.
        if (currentLocation == 11 && (redQueensCrownInInventory == false)) {
            newActions.AttackedByTheQueen();
        } //End of if statement looking to see if currentLocation is 11.

        if (currentLocation >= 3) {
            int ItemsInInventorySize = newItemsGenerator.getItemInInventorySize();
            var randomNumber = 0.01;
            randomNumber = randomNumber + (Math.random() * 10 + ItemsInInventorySize);
            //Creating an instance of the class Random.
            Random newRandom = new Random();
            //set the upper limit of numbers, by using value of upperBoundCharacter. value is based on CharacterArrayList.
            CharacterGenerator newCharacterGenerator = new CharacterGenerator();
            int upperBoundCharacter = (newCharacterGenerator.getCharacterArrayListSize());
            //set the upper limit of numbers, by using value of upperBoundItems. value is based on CharacterArrayList.
            int upperBoundItems = (newItemsGenerator.getItemsArrayListSize());
            //Generate a random value for both enemies and items. Limit is based on variables upperBoundCharacter and upperBoundItems.
            int randomIntegerCharacter = newRandom.nextInt(upperBoundCharacter);
            int randomIntegerItems = newRandom.nextInt(upperBoundItems);

            if (randomNumber > 8) {
                System.out.println("Alice Attempts to search the area, but she is attacked!");
                newActions.randomEncounter(randomIntegerCharacter);
            } //End of inner if statment
            else {
                newItemsGenerator.placeItemInInventory(randomIntegerItems);
            } //End of else Statement
        } //End of outer if statement
    } //End of search method

    /**Method death
     * This method is only called if Alice the character has
     * died from thirst, starvation, an enemyEncounter, or falling into a hole.
     * This method will print a picture using ASCI II Art.
     * Then it will simply quit the game by using System.exit(0) blackbox method.
     * */
    public void death() {
        System.out.println("ALICE IS DEAD. GAME OVER");
        System.out.println("▒▒▒▒▒▒▒▒▄▄▄▄▄▄▄▄▒▒▒▒▒▒");
        System.out.println("▒▒▒▒▒▒▄██████████▄▒▒▒▒");
        System.out.println("▒▒▒▒▒▒████████████▒▒▒▒");
        System.out.println("▒▒▒▒▒██▄▀██████▀▄██▒▒▒");
        System.out.println("▒▒▒▒▒██▄▄▄▄██▄▄▄▄██▒▒▒");
        System.out.println("▒▒▒▒▒██████████████▒▒▒");
        System.out.println("▒▒▐████─▀▐▐▀█─█─▌▐██▄▒");
        System.out.println("▒▒█████──────────▐███▌");
        System.out.println("▒▒█▀▀██▄█─▄───▐─▄███▀▒");
        System.out.println("▒▒█▒▒███████▄██████▒▒▒");
        System.out.println("▒▒▒▒▒██████████████▒▒▒");
        System.out.println("▒▒▒▒▒█████████▐▌██▌▒▒▒");
        System.out.println("▒▒▒▒▒▐▀▐▒▌▀█▀▒▐▒█▒▒▒▒▒");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▐▒▒▒▒▌▒▒▒▒▒");
        //Exit game with no error
        System.exit(0);
    } //End of method death

    /**Method win()
     * This method will let the user know they have won the game.
     * It will print out an ASCII picture sayng "YOU WIN" and an instance 
     * of method totalPointsValue() will calculate the point value of the items 
     * Alice managed to stash and report it to the player.
     * Then the System will exit. */
    public void win() {
        ItemsGenerator newItemsGenerator = new ItemsGenerator();
        LocationsGenerator newLocationsGenerator = new LocationsGenerator();
        newLocationsGenerator.textFileReaderLocation(100);
        System.out.println("**************************************************************************");
        System.out.println("**************************************************************************");
        System.out.println("You have won! Thank you for playing Alice in Wonderland!");
        System.out.println();
        System.out.println(" _|      _|    _|_|    _|    _|      _|          _|  _|_|_|  _|      _|");
        System.out.println("   _|  _|    _|    _|  _|    _|      _|          _|    _|    _|_|    _|");
        System.out.println("     _|      _|    _|  _|    _|      _|    _|    _|    _|    _|  _|  _|");
        System.out.println("     _|      _|    _|  _|    _|        _|  _|  _|      _|    _|    _|_|");
        System.out.println("     _|        _|_|      _|_|            _|  _|      _|_|_|  _|      _|");

        System.out.println("**************************************************************************");
        System.out.println("**************************************************************************");
        newItemsGenerator.totalPointsValue();
        System.exit(0);
    } //End of public method win

    /**method consumefood  (also potions)
     * method consume food is simply passing along method described in my 
     * ItemsGenerator. It seems redundant, but I believe the context of Assignment 4
     * requires that all actions be passed through controls. So I felt it necessary
     * to include a method in action that can be called in control once it's been
     * authorized as a valid action.
     * 
     * will load item crumpets into an Item object. if Alice'es inventory contains(crumpets)
     * then the int t will convert the string value of object manifestCrumpet by getting the point value
     * (note I could have just added a point value, but I have already written the code for this.
     * 
     * A message will be printed showing value t
     * 
     * Then another method from HeroGenerator.setHeroHealthPoints will be called an d the value 
     * of t will be passed to the method. This method will add the point value of int t to Alice's
     * current health. 
     * 
     * Next
     * 
     * another if statement will load item eatMeCakes into an Item object. if Alice'es inventory contains(cake)
     * then the int t will convert the string value of object  by getting the point value
     * (note I could have just added a point value, but I have already written the code for this.
     * 
     * A message will be printed showing value r
     * 
     * Then another method from HeroGenerator.setHeroAttackPoints will be called and the value 
     * of int r will be passed to the method. This method will add the point value of int t to Alice's
     * current health. 
     *  
     */
    public void consumeFood() {
        //method get food will check inventory for Items crumpets and cake.
        HeroGenerator newHeroGenerator = new HeroGenerator();
        ItemsGenerator newItemsGenerator = new ItemsGenerator();
        Items manifestCrumpets = (Items) newItemsGenerator.getItem(0);
        if (newItemsGenerator.searchInventory(manifestCrumpets.getItemName())) {
            //get food value. pass value through parseInt() to make int t. 
            int t = Integer.parseInt(manifestCrumpets.getPointValue());
            System.out.println("Alice stops only for a moment, to consume the crumpets. Her HP has been increased by: " + t);
            //Get character health points method
            newHeroGenerator.setHeroHealthPoints(t);
            // healthpoints = healthpoints + x
        } //End of if statement checking for manifestCrumpets
        else {
            System.out.println("Alice stops for a moment, searches her bag, but doesn't find any crumpets. ");
        } //End of else statement

        Items manifestEatMeCake = (Items) newItemsGenerator.getItem(1);
        if (newItemsGenerator.searchInventory(manifestEatMeCake.getItemName())) {
            //get food value. pass value through parseInt() to make int r. 
            int r = Integer.parseInt(manifestEatMeCake.getPointValue());
            System.out.println("Alice stops for a moment, to consume the Eat Me Cake. Her attack has been increased by: " + r);
            //Get character health points method
            newHeroGenerator.setHeroAttackPoints(r);
        } //End of if statement checking for manifestEatMeCake	
        else {
            System.out.println("Alice stops for a moment, searched her bag and couldnt find any Eat Me Cake.");
        } //End of else statement

        Items potion = (Items) newItemsGenerator.getItem(2);
        if (newItemsGenerator.searchInventory(potion.getItemName())) {
            //get potions value. pass value through parseInt() to make int t. 
            int t = Integer.parseInt(potion.getPointValue());
            System.out.println("Alice stop only for a moment, to consume the" + potion.getItemName() + ". Alice's Starvation counter and Thirst counter have been raised by: " + t);
            //Get character set starvation and HeroThirst method. See Class HeroGenerator for detail on methods.
            HeroGenerator newHeroGeneratorPotion = new HeroGenerator();
            newHeroGeneratorPotion.setHeroStarvation(t);
            newHeroGeneratorPotion.setHeroThirst(t);
        } //End of if statement checking for potion
        else { //Else statement will print a message to the output.
            System.out.println("Alice stops, opens her inventory.. But she have no " + potion.getItemName());
        } //End of Else Statement

    } //End of method consume food

    /**Method checkInventory
     * this method will be called to check the current Inventory.
     * essentially the method will simply System.out.println the Arraylist.
     * I left this method with the ItemGenerator because this method is used in
     * multiple locations and because the ArrayLists and variables are private
     * it makes it much easier and cleaner to leave the method in that class and 
     * call an Instance of that class when I need it.
     */
    public void checkInentory() {
        //Create an instance of classes required
        ItemsGenerator newItemsGenerator = new ItemsGenerator();
        //Create an instance of method checkInventory.
        newItemsGenerator.checkInventory();
    } //end of method checkInventory

    /**Method dropItem
     * This method will be used to list the available items in Alice's currentInventory that
     * may be dropped.
     */
    public void dropItem() {
        //Create an instance of classes needed
        ItemsGenerator newItemsGenerator = new ItemsGenerator();
        newItemsGenerator.checkInventory();
        newItemsGenerator.discardItem();
    } //End of drop method
    
    /**Method useItem(int currentLocation)
     * This method will list the item's currently in Alice's inventory. 
     * Then the user will be prompted to enter the Item's name. Then the user's 
     * input will be passed to a method that will check to see if that item exists
     * and if it's a valid item to use in that location. 
     * Note: Using an item in the wrong location results in the item being lost.  
     * */
    public void useItem(int currentLocation){
		//Create an instance of classes needed
        ItemsGenerator newItemsGenerator = new ItemsGenerator();
        Controls newControls = new Controls();
        newItemsGenerator.checkInventory();
        System.out.print("Which Item would you like to use? Please type the Item's name: ");
        //new instance of useItemInLocationReturnSpecialItem.
        //parameters will be return value of userInput and int currentLocation.
        newItemsGenerator.useItemInLocationReturnSpecialItem(newControls.userInput(), currentLocation);
		}//End of useItem method

    /**Method visitLocation(int x, String element)
     * visitLocation is used to essentially call on the method getLocation. 
     * The method getLocation will print a short description or long descrio
     */
    public void visitLocation(int x, String element) {
        LocationsGenerator newLocationsGenerator = new LocationsGenerator();
        newLocationsGenerator.getLocation(x);
    } //End of visitLocation

    /**Method connectedRoomsList
     * This method will take an int parameter that represents the
     * currentLocation. Depending on the currentLocation value a String will be
     * filled with the available rooms to choose from (String connectRoomsList).
     * Then the String will be printed and the user can choose from the available locations.
     * The users' input will be stored in a int variable (decision). Decision will be
     * passed to an instance method, userInputLocationsCheck and that will 
     * check to see if the input is valid or not. */
    public int connectedRoomsList(int currentLocation) {
        //Prime the variables needed.
        int decision = currentLocation;
        //Create an instance of classes needed
        LocationsGenerator LG = new LocationsGenerator();
        Controls newControls = new Controls();
        //Call on method bringConnectedPlaceForward passing the currentLocation as the parameter
        //This method will list the available locations the user can move from.
        String connectedRoomsList = LG.bringConnectedPlacesForward(currentLocation);
        System.out.println("You may move to any of the following locations... Please type the full name.");
        //Print the available rooms Alice can go to.
        System.out.println(connectedRoomsList);

        //Call on userInputLocationsCheck, this will allow the user to choose a location
        //compare two strings
        //If strings match user moves forward by moving code forward. 
        //else return message "Location is not found.
        decision = newControls.userInputLocationsCheck(connectedRoomsList, decision);
        return decision;
    } //End of searchTheArea
} //End of Actions
