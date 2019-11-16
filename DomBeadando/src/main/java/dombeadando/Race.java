package dombeadando;

import java.util.Date;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Race {

	private String place;
	private String date;
	private int id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Race create(Node node) {
		Race race = new Race();

		Element element = (Element) node;
		race.place = element.getAttribute("helyszín");
		race.date = element.getAttribute("idõpont");
		race.id = Integer.parseInt(element.getAttribute("id"));
		race.name = element.getAttribute("név");
		return race;
	}

}
