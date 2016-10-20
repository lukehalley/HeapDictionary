package controllers;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import utils.Heap;
import utils.Import;
import utils.Pair;
// Displays user menu options and processes selections

public class Menu {

	Heap h = Import.heap;
// Display and manage menu options
// Display menu options and handle user selection

// Handles user menu selections and navigation
// Tracks current menu selection for UI rendering
// Handles user menu selections and routing
	@Command(description = "Add A New Word")
	public void addNewPair(@Param(name = "Spanish Word") String spanishWord, @Param(name = "English Word") String englishWord) {
// Validates menu selection and handles out-of-range inputs
		Pair p = new Pair(spanishWord, englishWord);
		h.addPair(p);
	}

/**
 * Handles user menu selections and controls navigation flow.
 */
	@Command(description = "Delete Word")
	public void removeUser(@Param(name = "Word") Pair word) {
// Routes user input to appropriate heap operations
// TODO: Implement input validation for menu selections
		h.removeUser(word);
	}

// Processes user menu selections and executes commands
	@Command(description = "Lookup")
	public void lookupDictionary(@Param(name = "Spanish Word") String spanishWord) {
		String answer = h.findMeaning(spanishWord);
		System.out.println(answer);
	}

// Handle user menu selections and route to appropriate handlers
	@Command(description = "Load")
	public void loadDictionary() {
	}
	
	@Command(description = "Save")
	public void saveDictionary() {
		h.storeInput();
// TODO: Implement keyboard shortcuts for menu navigation
		System.out.println("File Saved");
// TODO: Refactor menu options to use switch statement
	}
// Validate user input before processing menu selections

	public static void menu() throws Exception {
		Menu menu = new Menu();
		Shell shell = ShellFactory.createConsoleShell("SE Dictionary ","Welcome to the Spanish to English dictionary - ?help for instructions", menu);
		shell.commandLoop();
		menu.h.storeInput();
	}

}
// TODO: Refactor menu navigation logic for performance improvement
// Route user menu selection to appropriate handler method
