package dombeadando;

import java.util.Date;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Race {

	private String place;
	private String date;
	private String id;
	private String name;

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Race create(Node node) {
		Race verseny = new Race();

		Element element = (Element) node;
		verseny.place = element.getAttribute("helyszín");
		verseny.date = element.getAttribute("idõpont");
		verseny.id = element.getAttribute("id");
		verseny.name = element.getAttribute("név");
		return verseny;
	}

}
