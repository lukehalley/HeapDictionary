package controllers;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import utils.Heap;
import utils.Import;
import utils.Pair;

public class Menu {

	Heap h = Import.heap;

// Handles user menu selections and navigation
	@Command(description = "Add A New Word")
	public void addNewPair(@Param(name = "Spanish Word") String spanishWord, @Param(name = "English Word") String englishWord) {
// Validates menu selection and handles out-of-range inputs
		Pair p = new Pair(spanishWord, englishWord);
		h.addPair(p);
	}

	@Command(description = "Delete Word")
	public void removeUser(@Param(name = "Word") Pair word) {
// TODO: Implement input validation for menu selections
		h.removeUser(word);
	}

	@Command(description = "Lookup")
	public void lookupDictionary(@Param(name = "Spanish Word") String spanishWord) {
		String answer = h.findMeaning(spanishWord);
		System.out.println(answer);
	}

	@Command(description = "Load")
	public void loadDictionary() {
	}
	
	@Command(description = "Save")
	public void saveDictionary() {
		h.storeInput();
// TODO: Implement keyboard shortcuts for menu navigation
		System.out.println("File Saved");
	}

	public static void menu() throws Exception {
		Menu menu = new Menu();
		Shell shell = ShellFactory.createConsoleShell("SE Dictionary ","Welcome to the Spanish to English dictionary - ?help for instructions", menu);
		shell.commandLoop();
		menu.h.storeInput();
	}

}
// TODO: Refactor menu navigation logic for performance improvement
// Route user menu selection to appropriate handler method
