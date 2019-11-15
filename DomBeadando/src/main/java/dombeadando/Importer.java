package dombeadando;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Importer {

	private String name;
	private String phoneNumber;
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static Importer create(Node node) {
		Importer beszallito = new Importer();

		Element element = (Element) node;
		beszallito.id = element.getAttribute("id");
		beszallito.name = element.getAttribute("név");
		beszallito.phoneNumber = element.getAttribute("telefonszám");
		return beszallito;
	}

}
