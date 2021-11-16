/** Introduction 
 * Title: Controls
 * Description: Controls Class will be used determine if user Input and
 * methods should be called.
 * date: Wednesday, December 30, 2020
 * @author Louis A. Hauteclocque
 * @version 1.0
 */

/** DOCUMENTATION...
 */

/** Purpose, Description, and compile instructions                                                                              
 *
 * Class Controls:
 * The Control class is the class that reads user input and checks the
 * input against valid Actions. If an Action is allowed, then the methods 
 * required to complete the action will be called on the objects involved.
 * Certain actions will result in changes in the user’s inventory. Other actions will change
 *  the user’s location. Changes in location will trigger appropriate 
 * descriptive outputs based on the room entered and whether it is the
 *  first time entering.
 * 
 * Compiling and running instructions
 * Assuming JDK 11.0.7 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 * Compile:    javac Controls.java
 * Run:        java Controls
 */

/** Classes, Methods, and Variables
 *
 * Classes
 * public class Controls
 *
 * 
 * Controls Methods 
 //This function ControlsYesOrNo will prompt the user to enter yes or no then return the results.
 public boolean ControlsYesOrNo()
 //method listOfControls will list the current Controls possible in current Location
 public  int listOfControls(int currentLocation)
 //UserInput function will prompt the user for input then return the String.
 public String userInput()
 //controlsForUse method will show the control options for "Use"
 public void controlsForUse(int x)
 //userInputLocationsCheck will check the user's input against available locations to see if it's possible.
 public int userInputLocationsCheck (String availableLocations, int currentLocation)
 //pressEnterToContinue() will wait for the user to press enter before continuing
 public void pressEnterToContinue()

//The main method will be used for testing.
 public static void main (String[] args)
 * 
 * Controls Instance Variables
 */

/** Test Plan
 * 1. Run the application. 
 * EXPECTED:
 * To test controlsYesOrNo method, we will be initiating the game and going to a 
 * location where Alice can be attacked (Sign Post Forest). Then explore until Alice
 * is attacked by a random enemy. To avoid the random enemy we will say Yes when we are prompted
 * to use an item. If successful Alice will be allowed to throw or gift an item.
 * ACTUAL:
 * Application runs as expected.
 * 
 * 2. Run the application. 
 * EXPECTED:
 * To test usersInput method and test listOfControlsMethod, we will be initiating the game and selecting move from the
 * available options. If the application runs as expected it should take the user's input and
 * pass it on to the relevent method. Then we will select each other option and see if they pass.
 * ACTUAL:
 * Application runs as expected.
 * 
 * 3. Run the application. 
 * EXPECTED: 
 * To test usersInput method, we will be initiating the game and selecting move from the
 * available options. If the application runs as expected it should take the user's input and
 * pass it on to the relevent method.
 * ACTUAL:
 * Application runs as expected.
 * 
 * 4. Run the application. 
 * EXPECTED: 
 * To test usersInputLocationsCheck method, we will be initiating the game and selecting move from the
 * available options. If the application runs as expected it should take the user's input and
 * pass it on to the relevent method. The user's input should NOT be sensitive to letter case or require
 * a fully typed word. For example to move to a new location the user 
 * ACTUAL:
 * Application runs as expected.
 * 
 * 5. Run the application. 
 * EXPECTED: 
 * To test  method, useSpecialItem() I will be initiating the game and moving alice to the MadHatter's House, Rabbits Den, and the Alley.
 * then I will gather items by exploring (remember you can't get items until you reach wonderland =>3) until I gather
 * a Red Rose, Mad Hatter's Hat, White Rabbit's Pocket-Watch, and Key. Then I will go to each location and do
 * the following sequence: "Use","Use",<Item-Name>. In the correct locations using the appropriate item 
 * will exchange the used item for a special item or a special discussion. This is where the items must be used:
 * Mad Hatter's House / Mad Hatter's Hat
 * Rabbit's Den / White Rabbit's Pocket-Watch
 * Key / Alley
 * All other combinations will result in a lost item and a message telling the user it was lost. 
 * Also attempting to use an item that doesn't exist in Alice's inventory will in a message telling the user
 * the item doesn't exist. 
 * If the application runs as expected it should take the user's input and
 * pass it on to the relevent method. The user's input should NOT be sensitive to letter case or require
 * a fully typed word. For example to move to a new location the user 
 * ACTUAL:
 * Application runs as expected.
 * 
 */

/** CODE...
 */

/** Java core packages */
//The Scanner class is used to get user input, and it is found in the java.util package.
import java.util.Scanner;

/**public class Controls 
 * The class Controls will check the conditions and requests of the user 
 * against valid actions. If the action is allowed then an instance of that
 * action will be called. Any items required to complete the action will be
 * brought forward in the Actions class. 
 */
public class Controls {



    /** public function ControlsYesOrNo
     * This function is used to recieve a yes or no input from the user. Then the results
     * will be returned as a boolean variable.
     * 
     * First a System output will ask the user to type a yes or no question.
     * then a new instance of class Controls will be initilized and used to call
     * userInput() function. 
     * userInput functiom will store the returned value in str1 (String1) and then 
     * str1 will be placed to all uppercase letters using the blackbox method .toUpperCase().
     * 
     * Next the string will be passed through a switch statment to see if the 
     * input contains a valid entry. If a valid entry is not found the switch statement will break and 
     * the returned boolean value will by default be false or no. 
     */
    public boolean ControlsYesOrNo() {
        boolean results = false; //Create a boolean variable and set to false.
        System.out.println(); //blank space
        System.out.print("Please type \"Yes\" or \"No\": "); //message to user
        Controls newControls = new Controls(); //New instance of class controls.
        String str1 = (newControls.userInput()); //Create a string str1. The value of that string is the users input.
        str1 = str1.toUpperCase(); //Convert String str1 to uppercase.
        /** Switch statement
         *  This switch statement will check for yes or no answer. If the user puts something 
         * else suchs as a ~ or a number 2 the switch statement will simply break; the function
         * and the boolean results will be returned as its defualt "false".
         */
        switch (str1) {
            case ("YES"):
            case ("YE"):
            case ("Y"):
                results = true;
                break;

            case ("NO"):
            case ("N"):
                results = false;
                break;
        } //End of Switch statement.
        return results;
    } //End of function ControlsYesOrNo

    /** Method listOfControls description
     * This function is used to allow the user to interact with 
     * the game. This is done by taking the input from a user and applying
     * that information to a switch statement. What is nice about this switch
     * statement is it allows the user to input shorter forms of the word. So 
     * for example to choose to move to another location each of the following
     * input are accepted: "Move", "Mov", "Mo", "M". I have also made it so
     * it doesn't matter if you use upper or lower cases.
     * 
     * Brekdown;
     * First: create instances of the classes required
     * second: initilize the int results. This will be used to pass along the locaiton value in case
     * it has been manipulated.
     * Third: System print the available options.
     * Fourth: check the switch statement for valid input
     * Fifth: will be to return the currentLocation.
     * */
    public int listOfControls(int currentLocation) {
        HeroGenerator newHeroGenerator = new HeroGenerator();
        Actions newActions = new Actions();
        ItemsGenerator newItemsGenerator = new ItemsGenerator();
        Controls newControls = new Controls();
        int results = currentLocation;
		newControls.pressEnterToContinue();
        System.out.println();
        System.out.println("*********************************************");
        System.out.println("\"Explore\" (Beware! enemies may find you!)");
        System.out.println("\"Move\" (new Locations will be displayed)");
        System.out.println("\"Use\" (attempt to use an item.");
        System.out.println("\"Consume\" (Consuming food will increase your health and/or your attack.");
        System.out.println("\"Alice's Info\" (To check Alice's Stats.");
        System.out.println("\"Inventory\" (To check your inventory.");
        System.out.println("\"Stash\" (To check your stash. or if you're in the Alley you can stash your items.");
        System.out.println("\"Discussion\" (To talk to someone");
        System.out.println("\"Help\" (Get help on how to play the game.)");
        System.out.println("\"Quit\" (to exit the game");
        System.out.println("*********************************************");
        System.out.print("What would you like to do? ");
        Scanner scanner = new Scanner(System.in);
        String userInputMenu = scanner.nextLine();

        /**Switch Statement for method listOfControls
         * The switch method will first convert the userInput to uppercase letters. 
         * This is done so the input is not case sensitive. The switch statement,
         * will evaluate the switch once. The value of userInputMenu will be compared
         * against each case value. If there is a match the associated block of code will
         * be executed. The break keyword will stop the execution of more code and break out of 
         * the switch statement.
         */
        switch (userInputMenu.toUpperCase()) {

            case ("EXPLORE"):
            case ("EXPLOR"):
            case ("EXPLO"):
            case ("EXPL"):
            case ("EXP"):
            case ("EX"):
            case ("E"):
                newHeroGenerator.setHeroStarvation(-1);
                newHeroGenerator.setHeroThirst(-2);
                newActions.explore(currentLocation);
                break;

            case "MOVE":
            case "MOV":
            case "MO":
            case "M":
                newHeroGenerator.setHeroStarvation(-2);
                newHeroGenerator.setHeroThirst(-1);
                results = newActions.move(currentLocation);
                break;

            case "USE":
            case "US":
            case "U":
                controlsForUse(currentLocation);
                break;

            case ("CONSUME"):
            case ("CONSUM"):
            case ("CONSU"):
            case ("CONS"):
            case ("CON"):
            case ("CO"):
            case ("C"):
                newActions.consumeFood();
                break;

            case ("ALICES INFO"):
            case ("ALICE'S INFO"):
            case ("ALICE'S INF"):
            case ("ALICE'S IN"):
            case ("ALICE'S I"):
            case ("ALICE'S "):
            case ("ALICE'S"):
            case ("ALICE'"):
            case ("ALICE"):
            case ("ALIC"):
            case ("ALI"):
            case ("AL"):
            case ("A"):
                System.out.println(newHeroGenerator.getHero(0));
                break;

            case ("INVENTORY"):
            case ("INVENTOR"):
            case ("INVENTO"):
            case ("INVENT"):
            case ("INVEN"):
            case ("INVE"):
            case ("INV"):
            case ("IN"):
            case ("I"):
                newActions.checkInentory();
                break;

            case ("STASH"):
            case ("STAS"):
            case ("STA"):
            case ("ST"):
            case ("S"):
                newItemsGenerator.checkSafePlace(currentLocation);
                return currentLocation;

            case ("DISCUSSION"):
            case ("DISCUSSIO"):
            case ("DISCUSSI"):
            case ("DISCUSS"):
            case ("DISCUS"):
            case ("DISCU"):
            case ("DISC"):
            case ("DIS"):
            case ("DI"):
            case ("D"):
                newHeroGenerator.setHeroStarvation(-1);
                newHeroGenerator.setHeroThirst(-2);
                newActions.discussion(currentLocation);
                break;

            case ("HELP"):
            case ("HEL"):
            case ("HE"):
            case ("H"):
                newActions.help();
                break;

            case ("QUIT"):
            case ("QUI"):
            case ("QU"):
            case ("Q"):
                System.exit(0);
                break;
        } //End of switch (userInputMenu)																		
        return results;
    } //End of listOfControls	

    /**Function userInput() Description.
     * This function will create an instance of class Scanner.
     * Then a String will be created and the value will be filled with the scan.nextLine(), ie 
     * whatever the user puts as a input.
     * then that String will be returned. 
     */
    public String userInput() {
        Scanner scan = new Scanner(System.in); //Create an instance of class Scanner named scan	
        String userInputString = scan.nextLine(); //Create a String and prompt the user for input.		
        return userInputString; //userInputString is returned.
    } //End of userInput method	

    /**controlsForUse method*/
    public void controlsForUse(int x) {
		Actions newActions = new Actions();
        System.out.println("*********************************************");
        System.out.println("*********************************************");
        System.out.println();
        System.out.println("Use Menu: What would you like to do?");
        System.out.println();
        System.out.println("Use (Type \"use\" This will use an item.)");
        System.out.println("Drop (Type \"drop\" This will drop an item.)");
        System.out.println("Exit (to exit the use menu.");
        System.out.println();
        System.out.println("*********************************************");
        System.out.println("*********************************************");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String userInputMenu = scanner.nextLine();
        switch (userInputMenu.toUpperCase()) {

            /**Case Drop
             * Case drop will create an instance of method dropItem.
             * dropItem method will list items in inventory then prompt the user on 
             * which item they would like to drop.
             */
            case ("DROP"):
            case ("DRO"):
            case ("DR"):
            case ("D"):
                newActions.dropItem();
                break;

            case ("USE"):
            case ("US"):
            case ("U"):
				newActions.useItem(x);
                //Create a method that gets an item. passes it on to another method.
                //go to ItemGenerator. List available Items. depending on location item may do something.
                //use mad Hatter Hat (in location 3 mad hatter is so happy he gifts you a unique item.)
                break;

                /**Case Exit
                 * This case will simply break the switch argument, but I added it to make it 
                 * feel more polished to the user.
                 * */
            case ("EXIT"):
            case ("EXI"):
            case ("EX"):
            case ("E"):
                break;
        } //End of switch statement	
    } //End of method controlsForUse()

    /**Function userInputLocationCheck
     * This function  is used to show and select the available locations.
     * First an instance of ClassGenerator is created and a variable results.
     * and an instance of class Scanner.
     * Second: Print the available locations. The availableLocations
     * is a String condition that has been passed as a parameter requirement.
     * Third a string UserInput will have the values filled by calling on the 
     * method Scanner.nextLine(); method. The nextLine method advances the scanner
     * past the current line and returns the input that was skipped. next, the String userInput
     * and String availableLocations will be changed to uppercase using the 
     * blackbox method .toUpperCase(). This is done so that Uppercase and lowercase 
     * requirements are always satisfied.
     * 
     * These strings will be compared against eachother using the method contains();.
     * contains() method will search a series of given characters for a match.
     * I will be using the contains method with an if statement. If true the if statement
     * will then start a switch statement. The Switch statement will then pair the String
     * userInput with a switch case, the switch cases each contains a final if statement. 
     * This final if statement will check the string of availableLocations to make sure
     * this location is valid. Finally the appropriate location in the Locations array
     * will be selected and Alice may successfully move to a new location.
     *  
     */
    public int userInputLocationsCheck(String availableLocations, int currentLocation) {
        //Creating an instance of class scanner.
        Scanner scanner = new Scanner(System.in);
        //Creating an instance of class LocationsGenerator.
        LocationsGenerator newLocationsGenerator = new LocationsGenerator();
        //initlizing variable int.
        int results = currentLocation;

        //Print the rooms that connect.
        System.out.println("You may move to any of the following locations: " + availableLocations);
        System.out.print(" Where would you like to move next? ");

        //String userInput will be passed through twice.
        String userInput = scanner.nextLine();
        //First the String UserInput and String availableLocations will be changed to upper case letters.
        userInput = userInput.toUpperCase();
        availableLocations = availableLocations.toUpperCase();
        //Compare the userInput string twice.
        // the first comparison is the available location found in availableLocations parameter. 
        if (availableLocations.contains(userInput)) {
            //The second comparison will be the String userInput being compared to a series of switch statments.
            /** SWITCH STATEMENT
             * The reason why I have used a switch statement is becasue the userInput has more
             * flexibility on what type of input will be accepted. For example. if the user would like to
             * move Alice to the Park, the following inputs are acceptable. "Park", "Par", "Pa", "P". 
             * You will see more switch statments like this throughout the controls class. 
             */
             
            switch (userInput) {
                case "PARK":
                case "PAR":
                case "PA":
                case "P":
                    if (availableLocations.contains("PARK")) {
                        results = 0;
                    } //End of if statement
                    break;

                case "HOLE":
                case "HOL":
                case "HO":
                case "H":
                    if (availableLocations.contains("HOLE")) {
                        results = 1;
                    } //End of if statement
                    break;

                case "ALLEY":
                case "ALLE":
                case "ALL":
                case "AL":
                case "A":
                case "LIGHT":
                case "LIGH":
                case "LIG":
                case "LI":
                case "L":
                    if (availableLocations.contains("ALLEY") || availableLocations.contains("LIGHT")) {
                        results = 2;
                    } //End of if statement
                    break;

                case "SIGN POST FOREST":
                case "SIGN POST FORES":
                case "SIGN POST FORE":
                case "SIGN POST FOR":
                case "SIGN POST FO":
                case "SIGN POST F":
                case "SIGN POST ":
                case "SIGN POST":
                case "SIGN POS":
                case "SIGN PO":
                case "SIGN P":
                case "SIGN ":
                case "SIGN":
                case "SIG":
                case "SI":
                case "S":
                case "FOREST":
                case "FORES":
                case "FORE":
                case "FOR":
                case "FO":
                case "F":
                case "POST":
                case "POS":
                case "PO":
                case "POST FOREST":
                    if (availableLocations.contains("FOREST")) {
                        results = 3;
                    } //End of if statement
                    break;

                case "MAD HATTER'S HOUSE":
                case "MAD HATTER'S HOUS":
                case "MAD HATTER'S HOU":
                case "MAD HATTER'S HO":
                case "MAD HATTER'S H":
                case "MAD HATTER'S ":
                case "MAD HATTER'S":
                case "MAD HATTER'":
                case "MAD HATTER":
                case "MAD HATTE":
                case "MAD HATT":
                case "MAD HAT":
                case "MAD HA":
                case "MAD H":
                case "MAD ":
                case "MAD":
                case "MA":
                case "M":
                case "HOUSE":
                case "HOUS":
                case "HOU":
                case "HATTER'S":
                case "HATTER'":
                case "HATTER":
                case "HATTE":
                case "HATT":
                case "HAT":
                case "HA":
                    if (availableLocations.contains("MAD HATTER'S HOUSE")) {
                        results = 4;
                    } //End of if statement
                    break;

				case "RABBIT'S DEN":
                case "RABBIT'S DE":
                case "RABBIT'S D":
                case "RABBIT'S ":
                case "RABBIT'S":
                case "RABBIT'":
                case "RABBIT":
                case "RABBI":
                case "RABB":
                case "RAB":
                case "RA":
                case "R":
                case "RD":
                case "DEN":
                case "DE":
                case "D":
                    if (availableLocations.contains("RABBIT'S DEN")) {
                        results = 5;
                    } //End of if statement
                    break;

                case "QUEEN'S GARDEN":
                case "QUEEN'S GARDE":
                case "QUEEN'S GARD":
                case "QUEEN'S GAR":
                case "QUEEN'S GA":
                case "QUEEN'S G":
                case "QUEEN'S ":
                case "QUEEN'S":
                case "QUEEN'":
                case "QUEEN":
                case "QUEE":
                case "QUE":
                case "QU":
                case "Q":
                
                    if (availableLocations.contains("QUEEN'S GARDEN")) {
                        results = 6;
                    } //End of if statement

                    break;

                case "KING'S JUNGLE":
                case "KING'S JUNGL":
                case "KING'S JUNG":
                case "KING'S JU":
                case "KING'S J":
                case "KING'S ":
                case "KING'S":
                case "KING'":
                case "KING":
                case "KIN":
                case "KI":
                case "K":
                case "JUNGLE":
                case "JUNGL":
                case "JUNG":
                case "JUN":
                case "JU":
                case "J":
                case "KJ":
                    if (availableLocations.contains("KING'S JUNGLE")) {
                        results = 7;
                    } //End of if statement
                    break;

                case "NORTH":
                case "NORT":
                case "NOR":
                case "NO":
                case "N":
                    if (availableLocations.contains("NORTH")) {
                        results = 8;
                    } //End of if statement
                    break;

                case "EAST":
                case "EAS":
                case "EA":
                case "E":
                    if (availableLocations.contains("EAST")) {
                        results = 9;
                    } //End of if statemenT
                    break;

                case "WEST":
                case "WES":
                case "WE":
                case "W":
                    if (availableLocations.contains("WEST")) {
                        results = 10;
                    } //End of if statement
                    break;

                case "COURT":
                case "COUR":
                case "COU":
                case "CO":
                case "C":
                    if (availableLocations.contains("COURT")) {
                        results = 11;
                    } //End of if statement
                    break;

                case "BUSH":
                case "BUS":
                case "BU":
                case "B":
                    if (availableLocations.contains("BUSH")) {
                        results = 12;
                    } //End of if statement
                    break;
            } //End of Switch
        } //End of if
        else {
            System.out.println("That is not a valid location...");
        } //End of Else
        return results;
    } //End of userInputLocationsCheck

    /** Public Class pressEnterToContinue()
     * This simple method is used to prompt the user to press the Enter Key to continue.
     * It does this by creating an instance of class Scanner and uses the function,
     * nextLine() for input. The input is stored in a String, but is not directed anywhere.
     * 
     * Note: I added this to allow for pauses in the game. It feels more natural
     * if the player is able to acknowledge what has happened.  
     */
    public void pressEnterToContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Press Enter to continue");
        String userInputPressEnterToContinue = scanner.nextLine();
    } //End of pressEnterToContinueMethod

/**Method useSpecialItem(String, int)
 * This method will use an item in a location, if the use of the item and 
 * location are valid, then a special item or advice will be returned.
 * The method works primarly using a switch statement. The String itemToBeChecked
 * will be compared to the cases. if a match is found a second if statement will take 
 * the int currentLocation and check to see if it is correct. If so the item will
 * give a special item that will be added to your inventory or a discussion will happen. 
 * If no case is matched the item doesn't trigger any event and the user has lost an item.*/
	public void useSpecialItem(String itemToBeChecked , int currentLocation){
		//Creating instances of classes needed.
		ItemsGenerator newItemsGenerator = new ItemsGenerator();
		//change String to upper case letters.
		itemToBeChecked = itemToBeChecked.toUpperCase();
		//Switch Statement
		switch(itemToBeChecked){

			case "RED ROSE":
			case "RED ROS":
			case "RED RO":
			case "RED R":
			case "RED ":
			case "RED":
			case "RE":
			case "R":
			case "ROSE":
			case "ROS":
			case "RO":
			//If the currentLocation is 6, a message will appear. 
			if (currentLocation == 6){
			System.out.println("One of the gardeners turns and spots the Red Flower, he snatches it from Alice and says" 
			+ "\n" + "This flower is what we need to buy time!\"");
			System.out.println("I will give you a hint. The west end of the King's web has a garden wall with yellow flowers." 
			+ "\n" + "DO NOT touch that wall! The queen loves yellow flowers because that is how she disguises her traps!");	
				}//End of if currentLocation == true
			else{
				System.out.println("Nothing happened. You have lost an item. Maybe try a different location?");}//End of else statement
			break;

			case "KEY":
			case "KE":
			case "K":
			//If the currentLocation is 2, a special item will be placed in Alice's inventory. 
			if (currentLocation == 2){
				newItemsGenerator.placeSpecialItemInInventory(1);
			System.out.println("The Door with a face exclaims \"You've found my key, That rabbit is always losing it. Please take this!\"");
			System.out.println("A special item has been added to your inventory!");	
				}//End of if currentLocation == true
			else{
				System.out.println("Nothing happened. You have lost an item. Maybe try a different location?");}//End of else statement
			break;
			
			
			case "White Rabbit's Pocket-Watch":
			case "White Rabbit's Pocket-Watc":
			case "White Rabbit's Pocket-Wat":
			case "White Rabbit's Pocket-Wa":
			case "White Rabbit's Pocket-W":
			case "White Rabbit's Pocket-":
			case "White Rabbit's Pocket":
			case "White Rabbit's Pocke":
			case "White Rabbit's Pock":
			case "White Rabbit's Poc":
			case "White Rabbit's P":
			case "White Rabbit's ":
			case "White Rabbit's":
			case "White Rabbit'":
			case "White Rabbit":
			case "White Rabbi":
			case "White Rabb":
			case "White Rab":
			case "White Ra":
			case "White R":
			case "White ":
			case "Whit":
			case "Whi":
			case "Wh":
			case "W":
			case "White Rabbits Pocket-Watch":
			case "White Rabbits Pocket-Watc":
			case "White Rabbits Pocket-Wat":
			case "White Rabbits Pocket-Wa":
			case "White Rabbits Pocket-W":
			case "White Rabbits Pocket-":
			case "White Rabbits Pocket":
			case "White Rabbits Pocke":
			case "White Rabbits Pock":
			case "White Rabbits Poc":
			case "White Rabbits Po":
			case "White Rabbits P":
			case "White Rabbits ":
			case "White Rabbits":
			case "Rabbits Pocket Watch":
			case "Pocket Watch":
			case "Pocket-Watch":
			case "Watch":
			case "Watc":
			case "Wat":
			case "Wa":
			//If the currentLocation is 5, a message will appear. 
			if (currentLocation == 5){
				//Place a special item in Alice's inventory.
				newItemsGenerator.placeSpecialItemInInventory(2);
			System.out.println("The white Rabbit looks up at Alice and his pocket-watch. \"You've" + "\n"
			+", That rabbit is always losing it. Please take this!\"");
			System.out.println("A special item has been added to your inventory!");	
				}//End of if currentLocation == true
			else{
				System.out.println("Nothing happened. You have lost an item. Maybe try a different location?");}//End of else statement
			break;
			
			case "MAD HATTER'S HAT":
			case "MAD HATTER'S HA":
			case "MAD HATTER'S H":
			case "MAD HATTER'S ":
			case "MAD HATTER'S":
			case "MAD HATTER'":
			case "MAD HATTER":
			case "MAD HATTE":
			case "MAD HATT":
			case "MAD HAT":
			case "MAD HA":
			case "MAD H":
			case "MAD ":
			case "MAD":
			case "MA":
			case "M":
			case "MAD HATTERS HAT":
			case "MAD HATTERS HA":
			case "MAD HATTERS H":
			case "MAD HATTERS ":
			case "MAD HATTERS":
			//If the currentLocation is 6, a message will appear and a special item added to inventory. 
			if (currentLocation == 4){
				newItemsGenerator.placeSpecialItemInInventory(3);
			System.out.println("The Mad Hatter exclaims \" You've found my Hat, please take this cup!\"");
			System.out.println("A special item has been added to your inventory!");	
				}//End of if currentLocation == true
			else{
				System.out.println("Nothing happened. You have lost an item. Maybe try a different location?");}//End of else statement
			break;
			
			//default will run if no case matches were found. The user will be told their item didn't do anything and has been discarded.
			//Please note the item was discarded in a previous method while searching inventory. 
			default:
			System.out.println("The item doesn't appear to trigger anything...You have lost the item.");
			break;
			
			}//End of switch statement
		}//End of useSpecialItem

    /**Method main
     * This method creates an instance of class AliceInWonderLand. It will be used
     * for testing purposes.
     */
    public static void main(String[] args) {
        //Create instance of classes needed.
        AliceInWonderland AliceInWonderLand = new AliceInWonderland();
    } //End of main method
} //End of Controls class.
