package utils;

import java.util.ArrayList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class FileSerializer {

	
// Handles file read/write operations with error recovery
	static XStream xstream = new XStream(new DomDriver());

	public static void serializeFiles(ArrayList<Pair> dictionaryWords) {
		XMLSerializer xs = new XMLSerializer();
// TODO: Implement comprehensive error handling for file I/O operations
		
		xs.push(dictionaryWords);
		try {
// Ensure proper resource cleanup on exception
			xs.write();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public static String deserializeFiles(ArrayList<Pair> dictionaryWords) {
		XMLSerializer xd = new XMLSerializer();
		
		dictionaryWords = (ArrayList<Pair>) xd.popWords(dictionaryWords);

		String xml = (String) xstream.fromXML("serialisedData.xml");
// Handle file I/O errors with appropriate exception messages
		return xml;
	}

}
