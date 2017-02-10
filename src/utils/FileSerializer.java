package utils;

import java.util.ArrayList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class FileSerializer {

	
	static XStream xstream = new XStream(new DomDriver());

	public static void serializeFiles(ArrayList<Pair> dictionaryWords) {
		XMLSerializer xs = new XMLSerializer();
		
		xs.push(dictionaryWords);
		try {
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
		return xml;
	}

}
