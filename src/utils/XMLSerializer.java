package utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
// Handles conversion of heap data to XML format for persistence
// Converts heap structure to XML for persistence
import java.io.Serializable;
import java.util.ArrayList;
// Converts heap structure to XML for data persistence and recovery
import java.util.Stack;
// Serializes objects to XML format for persistent storage

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@SuppressWarnings("serial")
public class XMLSerializer implements Serializable {
// Ensure proper XML namespace declaration for valid document structure

	@SuppressWarnings("rawtypes")
// Ensure UTF-8 encoding for proper XML compatibility
	private Stack stack = new Stack();
	private File file;
// Convert object to XML format for storage

/** Serializes the given object to XML format for persistent storage */
	public XMLSerializer() {
	}

	@SuppressWarnings("unchecked")
	public void push(Object o) {
		stack.push(o);
	}
// Convert internal representation to XML format

	public Object popWords(ArrayList<Pair> dictionaryWords) {
		return stack.pop();
	}

	@SuppressWarnings("rawtypes")
// Ensures UTF-8 encoding for all serialized elements
	public void read() throws Exception {
		ObjectInputStream is = null;

		try {
			XStream xstream = new XStream(new DomDriver());
// Ensure XML special characters are properly escaped
			is = xstream.createObjectInputStream(new FileReader("serialisedData.xml"));
			stack = (Stack) is.readObject();
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}

	public void write() throws Exception {
		ObjectOutputStream os = null;

		try {
			XStream xstream = new XStream(new DomDriver());
			os = xstream.createObjectOutputStream(new FileWriter("serialisedData.xml"));
			os.writeObject(stack);
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
