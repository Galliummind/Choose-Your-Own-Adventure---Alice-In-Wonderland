/** Introduction
 * 
 * Title: ItemsGenerator
 * Description: ItemsGenerator Class will be used to store and manipulate Objects of the items class.
 * date: Wednesday, December 30, 2020
 * @author Louis A. Hauteclocque
 * @version 1.0
 */

/** DOCUMENTATION...
 */

/** Purpose, Description, and compile instructions                                                                              
 *
 * Class ItemsGenerator:
 * Class ItemsGenerator will be used to create objects of type Items and deposit
 * them into an ArrayList. The ItemsGenerator will manipulate those objects
 * with their own get/set methods and some custom remove objects methods.
 * 
 * Compiling and running instructions
 * Assuming JDK 11.0.7 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 * Compile:    javac ItemsGenerator.java
 * Run:        java ItemsGenerator
 */

/** Classes, Methods, and Variables
*
* Classes
public class ItemsGenerator
* 
* ItemsGenerator Methods 
//Custom Constructor, parameters will fill the variables as they're made
public ItemsGenerator(String textFileNameForItems, String textFileNameForSpecialItems)
//get function for getting an item Object from the ArrayList 
public Object getItem(int temporaryInt)
//method placeItemInInventory will add an item to arrayList ItemInInventory
public void placeItemInInventory(int randomNum)
//method placeSpecialItemInInventory
public void placeSpecialItemInInventory(int placeInArrayList)
//method will be used to check and list current Inventory. 
public void checkInventory()
//function searchInventory searches inventory using a String and returns boolean value.
//This function will also remove the item from inventory.
public boolean searchInventory(String lookingForThisItem)
//This function will searchInventory, return a true/false, but not remove the item.
public boolean searchInventoryOnly(String lookingForThisItem)
//This method is used to discard an Item from inventory. 
public void discardItem()
//This function allows the user to use an item before battle. results will tell if the attempt was sucessful or not.
public boolean useItemBeforeBattle()
//This function will allow the user to throw an item at an Enemy for a chance to knock them unconscious
public boolean throwItem()
//function will attempt to gift an item to an enemy, returns a success or failure
public boolean giftItem()
//function getItemInInventorySize will get the current inventory size and return the results as an int
public int getItemInInventorySize()
//function getItemArrayListSize will get the size of the ItemArrayList and return an int value representation.
public int getItemsArrayListSize()
//This method will calculate the total pointsValue of all the items in your stash.
public void totalPointsValue()
//Method checkSafePlace will check to see if the currentLocation is safe to stash items.
//Deposit all items into stash.
//The method will also list the items currently in your Stash.
public void checkSafePlace(int currentLocationVariable)
//textFileReader will read the textFile and load those values into the Item custom Constructor,
//then the Item Object will be added to the appropriate arraylist.
public void textFileReader(String x)
//textFileReaderSpecialItems will read a text file and load those values into the Item custom Constructor, 
//BUT instead these Items will be loaded into a specialItemsArrayList.
public void textFileReaderSpecialItems (String x)
//main method will be used for testing the Class Item's Generator.
public static void main(String[] args)  

* ItemsGenerator Instance Variables

private static ArrayList < Items > ItemsArrayList = new ArrayList < Items > ();
private static ArrayList < Items > SpecialItemsArrayList = new ArrayList < Items > ();
private static ArrayList < Items > itemInInventory = new ArrayList < Items > ();
private static ArrayList < Items > itemInSafePlace = new ArrayList < Items > ();

*/

/** Test Plan
* 1. Run the application. 
* EXPECTED:
* The main method will run an Instance of AliceInWonderLand. 
* Next I will move Alice to the Sign Post Forest. this is so Alice is
* capabale of exploring and finding items. Explore multiple times and pick
* three items.
* ACTUAL:
* Application runs as expected. Alice is capable of exploring and finding items
* if she is in Sign Post Forest or further. 

* 2 . Run the application. 
* EXPECTED:
* The main method will run an Instance of AliceInWonderLand. 
* Next I will move Alice to the Sign Post Forest. attempt to pick up items then discard items
* ACTUAL:
* Application runs as expected. Alice is capable of exploring and finding items then discarding them.
* 
* 
* 3 . Run the application. 
* EXPECTED:
* The main method will run an Instance of AliceInWonderLand. 
* Next I will move Alice to the Queen's court. Kill the queen and retrieve the crown.
* She will then go back to the Alley and deposit the Queen's Red Crown.
* ACTUAL:
* Application runs as expected. Alice is capable of retrieving and depositing the 
* red Queen's Crown (special Item) in the Stash. this shows that the Stash methods and special
* items methods work as intended.
* 
* 4 . Run the application. 
* EXPECTED:
* The main method will run an Instance of AliceInWonderLand. 
* Next Alice will move to the Sign Post Forest, gather items until she 
* gets consumables then use control "Consume" to consume them. Afterwards check Alices stats
* and inventory to make sure the methods work as intended.
* ACTUAL:
* Application runs as expected. Alice is capable gathering, consuming, 
* and increasing her attack Points, health points, and thirst/starvation points.
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

public class ItemsGenerator {

    private static ArrayList < Items > ItemsArrayList = new ArrayList < Items > ();
    private static ArrayList < Items > SpecialItemsArrayList = new ArrayList < Items > ();
    private static ArrayList < Items > itemInInventory = new ArrayList < Items > ();
    private static ArrayList < Items > itemInSafePlace = new ArrayList < Items > ();

    /**Constructor*/
    /**This is the default constructor. It simply passes on a String value to the
     * TextFileReader method is explained below*/
    public ItemsGenerator() {} //End of TextFileReader(String) Constructor

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
    public ItemsGenerator(String textFileNameForItems, String textFileNameForSpecialItems) {
        //~ textFileReader("Items.txt");
        textFileReader(textFileNameForItems);
        //~ textFileReaderSpecialItems("SpecialItems.txt");
        textFileReaderSpecialItems(textFileNameForSpecialItems);
    } //End of TextFileReader(String) Constructor

	/**Method useItemInLocationReturnSpecialItem
	 * This method  is used to search for an item in inventory, if it exists the item 
	 * an if statement will attempt to use the item. If the item does not exist a message will tell
	 * the user it was not found.
	 * More details on how it is determined if using an item is successful can be found in method,
	 * useSpecialItem. But essentially a switch statement will compare the string value to match the case,
	 * then an if statement will check the current location to see if it's a valid item. Otherwise the item will
	 * be discarded.*/
	public void useItemInLocationReturnSpecialItem(String StringNameOfItemToUse, int currentLocation){
		//Creating instances of the classes needed.
		ItemsGenerator newItemsGenerator = new ItemsGenerator();
		Controls newControls = new Controls();
		//Boolean variable is dependent on a method that searches Alice's inventory and returns a boolean variable
		boolean doesThisItemExist = (searchInventory(StringNameOfItemToUse));
		//if doesThisItemExist is true it will call instance of useSpecialItem.
			if (doesThisItemExist){
				newControls.useSpecialItem(StringNameOfItemToUse , currentLocation);
				}//End of If statement doesThisItemExist is true
		//if doesThisItemExist is false, tell the user the item has not been found.	
			if (doesThisItemExist == false){
				System.out.println("The item " + StringNameOfItemToUse + " has not been found. Please try again.");
				}//end of if statement doesThisItemExist false 
		}//End of useItemInLocationReturnSpecialItem

    /**Brings an object forward or creates a reference to an object that can be manipulated.
     * The item will be returned as an Object.  
     */
    public Object getItem(int temporaryInt) {
        //Create a object with the properties from int variable temporaryInt
        Items manifestItem = (Items) ItemsArrayList.get(temporaryInt);
        //Return Object
        return manifestItem;
    } //End of bringObjects

    /**Method placeItemInInventory 
     * First I want to mention the parameter (int randomNum) will be used in the 
     * for statement to show where in the arraylist the method will begin it's search.
     * This will make aquiring the items more random as the int randomNum is
     * depenednt on a random number passed from the Actions.explore method.
     * 
     * How this method works is first an outer for loop is created. the for loop will
     * then create an Items object called manifestObject from the Items list.
     * manifestObject will then be compared for a boolean outcome of an if statment that
     * compares the Alice's inventory (itemInInventory) to see if the item exists. If
     * true, the if statement will skip the itteration with continue;.
     * 
     * if the item CANNOT be found (boolean is false) then that means the item does not 
     * already exist in Alice's Inventory and it is now safe to add. In this case the else
     * statement will add the item directly from the ItemsArrayList by using the Arraylist method
     * .add and .get
     * Finally a output to the user will show the item that was added to inventory. 
     * we do this by getting the name of the manifestItem by calling the method .getItemName from
     * class Items.
     */
    public void placeItemInInventory(int randomNum) {
        for (; randomNum < ItemsArrayList.size(); randomNum++) {
            Items manifestItem = (Items) getItem(randomNum);
            if (itemInInventory.contains(manifestItem) || (itemInSafePlace.contains(manifestItem))) {
                continue;
            } else {
                itemInInventory.add(ItemsArrayList.get(randomNum));
                System.out.println(manifestItem.getItemName() + " added to your inventory!");
                break;
            }
        } //End of for	
    } //End of placeItemInInventory	

    /**Method placeSpecialItemInInventory.
     * This method will place an item from the SpecialItemsArraylist. in the
     * character's inventory. This is done by passing an int value in the parameter.
     * That value will be used to specify which location in the SpecialItemsArraylist
     * is to be brought forward. This is done in one line;
     * itemInInventory.add(SpecialItemsArrayList.get(placeInArrayList));
     * This line took a while to figure out the syntax, but essentially it
     * works by using the java.util.ArrayList .get and .add method. First
     * the specialItemsArrayList will .get the Item in location x. Then 
     * by using .add we can add that item directly to itemInInventory. 
     * 
     * That value will be added to the method getItem() to create a duplicate Item 
     * called manifestItem. Then manifestItem will be used to get the value 
     * ItemName from the manifestItem for a system message to the user notifying
     * them that the item has been added to their inventory.
     */
    public void placeSpecialItemInInventory(int placeInArrayList) {
        //Add specialItem to arraylist itemInInventory
        itemInInventory.add(SpecialItemsArrayList.get(placeInArrayList));
        //Create Items object manifestItem
        Items manifestItem = (Items) SpecialItemsArrayList.get(placeInArrayList);
        //Print message about item being added to inventory.
        System.out.println(manifestItem.getItemName() + " added to your inventory!!!!!");
    } //End of method placeSpecialItemInInventory

    /**checkInventory method
     * checkInventory method will list the items currently in Alices inventory.
     * This is done with a for statement that simply prints each items name in the 
     * inventory. 
     */
    public void checkInventory() {
        System.out.println(); //blank line
        System.out.println("These are the Items Currently in Inventory");
        //for statement. Used to list the items in inventory
        for (int i = 0; i < itemInInventory.size(); i++) {
            int t = i + 1;
            System.out.println(t + ": " + itemInInventory.get(i));
        } //End of for statement
        System.out.println("*** End of Inventory ****");
    } //End of checkInventory

    /**function searchInventory will take a string parameter. The string 
     * parameter will be passed through a for loop to see if the item name 
     * exists in the arraylist itemInInventory. ItemInInventory holds Items
     * collected so far. 
     * 
     * The for loop consists of an int temp. int temp stands for temporary, 
     * as long as the temp number is below itemInInventory.size() the for loop
     * will do the following. 
     * First: A boolean returnResults will be set to false. This will be used to return
     * the final results. The for loop will create an instance of an Items from location (temp)
     * in the ArrayList by using the .get method. 
     * 
     * Second: A String called itemName will use the getItemName method in the Item
     * class for object ManifestItem. 
     *
     * Third: The parameter String, lookingForThisItem and the itemName String
     * will be saved over as all uppercase characters using .toUpperCase() blackbox method.
     * 
     * A boolean checkForItem will be considered true or false depending on if
     * itemName contains lookingForThisItem. This is done by using the blackbox method
     * .contains();
     * 
     * Fourth: if (checkForItem) is true we will set returnResults to True otherwise 
     * increase temp++ by one and check the next item in itemInInventory. NOTE: This method
     * will also .remove an item from inventory. I have also made another method that is a duplicate
     * of this method, but without removing the item.  
     * */
    public boolean searchInventory(String lookingForThisItem) {
        boolean returnResults = false;
        for (int temp = 0; temp < itemInInventory.size(); temp++) {
            Items manifestItem = (Items) itemInInventory.get(temp);
            String itemName = manifestItem.getItemName();
            lookingForThisItem = lookingForThisItem.toUpperCase();
            itemName = itemName.toUpperCase();

            boolean checkForItem = itemName.contains(lookingForThisItem);

            if (checkForItem) {
                returnResults = true;
                itemInInventory.remove(temp);
                break;
            } //End of if checkForItem is true
        } //End of for statement
        return returnResults;
    } //End of search Inventory.

    /**function searchInventoryOnly will take a string parameter. The string 
     * parameter will be passed through a for loop to see if the item name 
     * exists in the arraylist itemInInventory. ItemInInventory holds Items
     * collected so far. 
     * 
     * The for loop consists of an int temp. int temp stands for temporary, 
     * as long as the temp number is below itemInInventory.size() the for loop
     * will do the following. 
     * First: A boolean returnResults will be set to false. This will be used to return
     * the final results. The for loop will create an instance of an Items from location (temp)
     * in the ArrayList by using the .get method. 
     * 
     * Second: A String called itemName will use the getItemName method in the Item
     * class for object ManifestItem. 
     *
     * Third: The parameter String, lookingForThisItem and the itemName String
     * will be saved over as all uppercase characters using .toUpperCase() blackbox method.
     * 
     * Fourth: if (checkForItem) is true we will set returnResults to True otherwise 
     * increase temp++ by one and check the next item in itemInInventory.  
     * */
    public boolean searchInventoryOnly(String lookingForThisItem) {
        boolean returnResults = false;
        for (int temp = 0; temp < itemInInventory.size(); temp++) {
            Items manifestItem = (Items) itemInInventory.get(temp);
            String itemName = manifestItem.getItemName();
            lookingForThisItem = lookingForThisItem.toUpperCase();
            itemName = itemName.toUpperCase();

            returnResults = itemName.contains(lookingForThisItem);

        } //End of for statement
        return returnResults;
    } //End of search Inventory.

    /**Method discardItem
     * This method will allow the user to discard an item. 
     * This is done, by prompting the user on which item they would like to 
     * discard. The user will already have been shown the list of items
     * currently in inventory. 
     * 
     * The user will simply write the number of the item they wish to have 
     * discarded and the item will be selected and removed using the .remove method
     * from the java.util.ArrayList.
     * 
     * I have used try/catch statements to account for user's input. The catch
     * statement will try catch numberFormatExceptions and IndexOutOfBoundsException  
     */
    public void discardItem() {
        Controls newControls = new Controls();
        //Priming the variable
        int temp = 0;
        //print message
        System.out.print("Please choose an item to discard by typing the coresponding number: ");
        //try/catch statement
        try {
            //temp number equals the user's input.
            temp = Integer.parseInt(newControls.userInput());
            //Try and catch a number format exception error such as a character.
        } catch (NumberFormatException e) {
            //Print message with exception.
            System.out.println("That is not a valid entry");
            System.out.println(); //print blank line
            return;
        } //End of catch for user input

        //Try and catch statement.
        try {
            //remove item in inventory. subtract -1 to account for arrayList indexing.
            itemInInventory.remove(temp - 1);
        } //End of try statement
        //Catch an indexOutOfBound or number format exception to prevent the program from crashing
        catch (IndexOutOfBoundsException | NumberFormatException e) {
            //Print message letting the users know.
            System.out.println("That is not a valid entry.");
        } //End of Catch
    } //End of discard item

    /**method useItemBeforeBattle
     * This method will allow a user to use an item before battle to avoid fighting. 
     * If the user would like to use an item and if the user is succesful, a boolean 
     * value is returned as true. This returned value will let the system know to skip
     * an enemy encounter.
     * 
     * First create instances of the Controls class and ItemsGenerator class.
     * Next prompt the user on whether they would like to use an item or not
     * by using the newControls.userInput(). The value of the userInput will
     * be stored in userInputString. userInputString will then be converted to uppercase letters using
     * the blackbox method .toUpperCase. 
     * 
     * Next userInputString will be comparted against multple character variables to 
     * see which statements should be run. Depending on the outcome, .giftItem
     * or .throwItem methods will be run. 
     * */
    public boolean useItemBeforeBattle() {
        Controls newControls = new Controls();
        ItemsGenerator newItemsGenerator = new ItemsGenerator();
        boolean resultsOfOutcome = false;
        //Print message
        System.out.println("How would you like to use an item?");
        System.out.println("Gift item");
        System.out.println("Throw item");
        System.out.print("Please type your response Example: \"Throw\" or \"Gift\": ");
        //Controls wait for user input.
        String userInputString = (newControls.userInput());
        //Convert string userInputString to upper case
        userInputString = userInputString.toUpperCase();
        /*
         *This next block of code will check for valid input. Two characters 
         * hold two values (characterTwo = "G" && Ch3 = "T"). These values must be equal to
         * userInputString.charAt(0) or the first letter to be considered valid.
         */
        char characterOne = userInputString.charAt(0);
        char characterTwo = 'G';
        char characterThree = 'T';
        boolean results = (characterOne == characterTwo);
        boolean results2 = (characterOne == characterThree);
        if (userInputString.contains("GIFT") || (results == true)) {
            resultsOfOutcome = newItemsGenerator.giftItem();
        } //End of if userInputString contains gift
        if (userInputString.contains("THROW") || (results2 == true)) {
            resultsOfOutcome = newItemsGenerator.throwItem();
            //Controls wait for user input.
            String stringForItems = (newControls.userInput());

        } //End of if userInputString contains throw
        else {} //end of else statement 
        return resultsOfOutcome;
    } //End of useItemLocation Method

    /** function throwItem
     * First create an instance of class Controls and ItemsGenerator.
     * prime the boolean variable resultsOfOutcome. Next create an instance 
     * of ItemsGenerator.checkInventory(). This method will list all the items
     * in Inventory. Next the user will be asked what item the y would like to 
     * throw and their response will be stored in the String stringForItems
     * 
     * Next stringForItems will be passed through the method searchForInventory()
     * this method will search the inventory for the ItemName to see if it matches
     * the user's input. If the boolean doesThisItemExist show to be true then an
     * if statement will initiate. This If statement will manipulate an int variable
     * to determine if throwing the item was successful or not. If succesful the 
     * boolean resultOfOutcome will be set to true. 
     * 
     * finally there is an else statement, the else statement simply tells the 
     * user they have failed and are being attacked, then the boolean 
     * resultsOfOutcome will be assigned to false.
     */
    public boolean throwItem() {
        Controls newControls = new Controls();
        ItemsGenerator newItemsGenerator = new ItemsGenerator();
        boolean resultOfOutcome = false;
        newItemsGenerator.checkInventory();
        System.out.print("Which item would you like to throw? ");
        //Controls wait for user input.
        String stringForItems = (newControls.userInput());
        boolean doesTheItemExist = (searchInventory(stringForItems));
        if (doesTheItemExist) {
            //The item does exist so now a random draw will determine if the Character attacks or leaves.
            int fiftyFiftyChance = (int)(Math.random() * 10);
            if (stringForItems.contains("Red") || stringForItems.contains("Blue") || stringForItems.contains("Yellow")) {
                fiftyFiftyChance = fiftyFiftyChance + 1;
            } //End of if stringForItems.contains red,blue,yellow
            if (stringForItems.contains("Spear") || stringForItems.contains("Knife") || stringForItems.contains("brick")) {
                fiftyFiftyChance = fiftyFiftyChance - 1;
            } //End of If StringForItems.contains Spear, Knife, Brick	
            if (fiftyFiftyChance < 5) {
                System.out.println("Alice, acting quickly, strikes the Character in the side of the head! Alice has escaped while the Character is confused.");
                resultOfOutcome = true;
            } //End of INNER if fiftyFifty is less than %50
            else {
                //else the character is still attacked.
                System.out.println("The Character quickly ducks as you throw your item! Prepare to fight!");
                resultOfOutcome = false;
            } //End of else statment		
        } //End of If this item Exists
        return resultOfOutcome;
    } //End of function throwItem

    /**Function gift Item
     * First create an instance of class Controls and ItemsGenerator.
     * prime the boolean variable resultsOfOutcome. Next create an instance 
     * of ItemsGenerator.checkInventory(). This method will list all the items
     * in Inventory. Next the user will be asked what item the y would like to 
     * throw and their response will be stored in the String stringForItems
     * 
     * Next stringForItems will be passed through the method searchForInventory()
     * this method will search the inventory for the ItemName to see if it matches
     * the user's input. If the boolean doesThisItemExist show to be true then an
     * if statement will initiate. This If statement will manipulate an int variable
     * to determine if throwing the item was successful or not. If succesful the 
     * boolean resultOfOutcome will be set to true. 
     * 
     * finally there is an else statement, the else statement simply tells the 
     * user they have failed and are being attacked, then the boolean 
     * resultsOfOutcome will be assigned to false.
     */
    public boolean giftItem() {
        ItemsGenerator newItemsGenerator = new ItemsGenerator();
        Controls newControls = new Controls();
        boolean resultOfOutcome = false;

        newItemsGenerator.checkInventory();
        System.out.print("Which item would you like to gift? ");
        //Controls wait for user input.
        String stringForItems = (newControls.userInput());
        boolean doesTheItemExist = (searchInventory(stringForItems));
        if (doesTheItemExist) {
            //The item does exist so now a random draw will determine if the Character attacks or leaves.
            int fiftyFiftyChance = (int)(Math.random() * 10);
            if (stringForItems.contains("Red") || stringForItems.contains("Blue") || stringForItems.contains("Yellow")) {
                fiftyFiftyChance = fiftyFiftyChance - 1;
            } //End of if stringForItems.contains red,blue,yellow
            if (stringForItems.contains("Spear") || stringForItems.contains("Knife") || stringForItems.contains("brick")) {
                fiftyFiftyChance = fiftyFiftyChance + 1;
            } //End of If StringForItems.contains Spear, Knife, Brick
            if (fiftyFiftyChance < 5) {
                System.out.println("The character takes the item slowly, in a flash it quickly pockets it and runs away!");
                resultOfOutcome = true;
            } //End of INNER if fiftyFifty is less than %50
            else {
                //else the character is still attacked.
                System.out.println("The Character takes your gift, and throws it far away! Prepare to fight!");
                resultOfOutcome = false;
            } //End of else statment		
        } //End of If this item Exists
        else {
            System.out.println(stringForItems + " does not exist. The Character attacks! Prepare to fight!");
        } //end of outer if statement.
        return resultOfOutcome;
    } //End of function giftItem

    /** function getItemInInventorySize
     * This method will simply create an int variable. then size will be
     *  assigned the value of itemInInventorySize(). Finally int size will
     * be returned as an int.   
     */
    public int getItemInInventorySize() {
        int size = 0;
        size = size + itemInInventory.size();
        return size;
    } //End of itemInInventorySize

    /** function getItemArrayListSize
     * Because the arrayList is private, we need a way of 
     * accessing the arrayList. Because of this I have made a get method 
     * for the ItemsArrayListsize. It essentially just calls on the blackbox
     * method .size from the class ArrayList. Then the value of that is stored
     * in int size and returned.
     */
    public int getItemsArrayListSize() {
        int size = 0;
        size = ItemsArrayList.size();
        return size;
    } //End of getItemsArrayListSize

    /** method totalPointsValue
     * This method is called at the end of a succesfully completing the game.
     * This is done through a for statement that will go through each object in 
     * the arrayList itemInInventory and create an object manifestItem. Then
     * using the method .getPointValue() we can add the point value of manifestItem
     * to store in int temp.
     * 
     * int temp will be added to totalPoints and the for loop will increase by ++.
     * Once the for loop ends the totalPoints will be printed in a message to the user.
     */
    public void totalPointsValue() {
        int totalPoints = 0;
        for (int temporary = 0; temporary < itemInSafePlace.size(); temporary++) {
            Items manifestItem = (Items) ItemsGenerator.itemInInventory.get(temporary);
            int temp = Integer.parseInt(manifestItem.getPointValue());
            totalPoints = totalPoints + temp;
        } //End of for statement
        System.out.println("Points collected this round: " + totalPoints);
    } //End of method totalPointsValue

    /**CheckSafeSpace Method.
     *This method was made to allow Alice to stash her items in a safe location.
     * and/or show the items currently in her stash. To determine what to run
     * an outter if statement will check to see if Alice is in the right location. 
     * If Alice is in location 2 then when she requests to stash her items they will
     * all be dropped into her stash and a for loop will list all of the items in the stash. 
     * A for statement will also run within the if statement that checks to see 
     * one of those items is the Red Queen's Crown. If so the 
     * 
     * If Alice is not in location 2 (the Alley) then the stash will only be listed.
     * 
     * */
    public void checkSafePlace(int currentLocationVariable) {
        boolean doesAliceHaveTheRedCrown = false;
        if (currentLocationVariable == 2) {
            Actions newActions = new Actions();
            ItemsGenerator newItemsGenerator = new ItemsGenerator();
            for (int temporary = 0; temporary < itemInInventory.size(); temporary++) {
                Items manifestItem = (Items) ItemsGenerator.itemInInventory.get(temporary);
                System.out.println(manifestItem.getItemName() + " has been removed from your inventory and added to your stash.");
                itemInSafePlace.add(manifestItem);
            } //Inner for statement of if statement
            for (int temporary = 0; temporary < itemInInventory.size(); temporary++) {
                Items manifestQueenCrown = (Items) ItemsGenerator.SpecialItemsArrayList.get(0);
                Items manifestItem = (Items) ItemsGenerator.itemInInventory.get(temporary);
                if (manifestItem == manifestQueenCrown) {
                    newActions.win();
                    newItemsGenerator.totalPointsValue();
                } //End of if statement looking for redQueensCrown.
            } //Inner for statement

            //clear()  removes all the elements of the itemInInventory ArrayList. It's a fast operation, as it just sets the array elements to null.
            itemInInventory.clear();
        } //End of if statement

        System.out.println("These are the Items Currently in your stash.");
        for (int i = 0; i < itemInSafePlace.size(); i++) {
            int t = i + 1;
            System.out.println(t + ": " + itemInSafePlace.get(i));
        } //End of for statement listing items for user to see.
        System.out.println("*** End of Items in Stash ****");
    } //End of checkSafePlace


    /**Method TextFileReader(String x)*/
    public void textFileReader(String x) {
        try {
            Scanner fileScanner = new Scanner(new File(x));
            while (fileScanner.hasNext() && fileScanner != null) {
                String str1, str2, str3;
                str1 = (fileScanner.nextLine());
                str2 = (fileScanner.nextLine());
                str3 = (fileScanner.nextLine());
                ItemsArrayList.add(new Items(str1, str2, str3));
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
    } //End of TextFileReader(String) method


    public void textFileReaderSpecialItems(String x) {
        try {
            Scanner fileScanner = new Scanner(new File(x));
            while (fileScanner.hasNext() && fileScanner != null) {
                String str1, str2, str3;
                str1 = (fileScanner.nextLine());
                str2 = (fileScanner.nextLine());
                str3 = (fileScanner.nextLine());
                SpecialItemsArrayList.add(new Items(str1, str2, str3));
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
    } //End of TextFileReader(String) method

    /**Method main
     * This method creates an instance of class AliceInWonderLand. It will be used
     * for testing purposes.
     */
    public static void main(String[] args) {
        //Create instance of classes needed.
        AliceInWonderland AliceInWonderLand = new AliceInWonderland();
    } //End of main method	
} //End of Items Generator
