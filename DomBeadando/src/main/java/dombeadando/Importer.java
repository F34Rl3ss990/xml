package dombeadando;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Importer {

	private String name;
	private int phoneNumber;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static Importer create(Node node) {
		Importer importer = new Importer();

		Element element = (Element) node;
		importer.id = Integer.parseInt(element.getAttribute("id"));
		importer.name = element.getAttribute("név");
		importer.phoneNumber = Integer.parseInt(element.getAttribute("telefonszám"));
		return importer;
	}

}
