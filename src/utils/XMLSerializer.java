package utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@SuppressWarnings("serial")
public class XMLSerializer implements Serializable {

	@SuppressWarnings("rawtypes")
	private Stack stack = new Stack();
	private File file;

	public XMLSerializer() {
//		this.setFile(file);
	}

	@SuppressWarnings("unchecked")
	public void push(Object o) {
		stack.push(o);
	}

	public Object popWords(ArrayList<Pair> dictionaryWords) {
		return stack.pop();
	}

	@SuppressWarnings("rawtypes")
	public void read() throws Exception {
		ObjectInputStream is = null;

		try {
			XStream xstream = new XStream(new DomDriver());
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
