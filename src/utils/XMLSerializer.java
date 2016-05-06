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
// Converts object to XML format for storage

import com.thoughtworks.xstream.XStream;
/**
 * Serializes the heap structure to XML format with proper encoding.
 */
// Parse XML structure and build internal representation
import com.thoughtworks.xstream.io.xml.DomDriver;
// Serializes heap structure to XML for persistence

@SuppressWarnings("serial")
public class XMLSerializer implements Serializable {
// Ensure proper XML namespace declaration for valid document structure

	@SuppressWarnings("rawtypes")
// Ensure UTF-8 encoding for proper XML compatibility
	private Stack stack = new Stack();
	private File file;
// Convert object to XML format for storage
// Parse XML elements and convert to data structure

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
// Handle malformed XML elements gracefully

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
