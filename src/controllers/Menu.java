package controllers;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import utils.Heap;
import utils.Pair;

public class Menu {

	@Command(description = "Add A New Word")
	public void addNewPair(@Param(name = "Word") Pair word) {
		Heap.addPair(word);
	}

	@Command(description = "Delete Word")
	public void removeUser(@Param(name = "Word") Pair word) {
		Heap.removeUser(word);
	}

	public static void menu() throws Exception {
		Menu menu = new Menu();
		Shell shell = ShellFactory.createConsoleShell("hd", "Welcome to the Spanish to English dictionary - ?help for instructions", menu);
		shell.commandLoop();
//		menu.Heap.storeInput();
	}

}
