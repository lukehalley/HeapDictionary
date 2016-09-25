package utils;

import java.util.ArrayList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class FileSerializer {

	static XStream xstream = new XStream(new DomDriver());

	public static void serializeFiles(ArrayList<Pair> dictionaryWords) {

		XMLSerializer.push(dictionaryWords);

	}

	@SuppressWarnings("unchecked")
	public static String deserializeFiles(ArrayList<Pair> dictionaryWords) {

		dictionaryWords = (ArrayList<Pair>) XMLSerializer.popWords(dictionaryWords);

		String xml = (String) xstream.fromXML("serialisedData.xml");
		return xml;
	}

}
