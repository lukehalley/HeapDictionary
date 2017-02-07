import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Import {

	ArrayList<Pair> dictionaryWords = new ArrayList<Pair>();

	public static void ImportWords() {

		// Scanner
		File dictionaryFile = new File("SpanishWords.txt");
		Scanner dictionaryScan;
		try {
			dictionaryScan = new Scanner(dictionaryFile);

			String delims = "\t";

			while (dictionaryScan.hasNextLine()) {
				String dictionaryLine = dictionaryScan.nextLine().trim();
				String[] dictionaryTokens = dictionaryLine.split(delims);

				String nodeObject = dictionaryTokens[0];
				String afterNode = dictionaryTokens[1];

				Pair p = new Pair(nodeObject, afterNode);

				System.out.println(nodeObject);
				System.out.println(afterNode);

			}

			dictionaryScan.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

	}

}
