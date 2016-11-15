package controllers;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import utils.Heap;
import utils.Pair;

public class Menu {

	Heap h = new Heap();

	@Command(description = "Add A New Word")
	public void addNewPair(@Param(name = "Spanish Word") String spanishWord, @Param(name = "English Word") String englishWord) {
		Pair p = new Pair(spanishWord, englishWord);
		h.addPair(p);
	}

	@Command(description = "Delete Word")
	public void removeUser(@Param(name = "Word") Pair word) {
		h.removeUser(word);
	}

	@Command(description = "Lookup")
	public void lookupDictionary(@Param(name = "Spanish Word") String spanishWord) {
		h.findMeaning(spanishWord);
	}

	@Command(description = "Load")
	public void loadDictionary() {
	}
	
	@Command(description = "Save")
	public void saveDictionary() {
		h.storeInput();
		System.out.println("File Saved");
	}

	public static void menu() throws Exception {
		Menu menu = new Menu();
		Shell shell = ShellFactory.createConsoleShell("SE Dictionary ","Welcome to the Spanish to English dictionary - ?help for instructions", menu);
		shell.commandLoop();
		menu.h.storeInput();
	}

}
