package dombeadando;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Team {

	private String name;
	private String worldChampionshipNumber;
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorldChampionshipNumber() {
		return worldChampionshipNumber;
	}

	public void setWorldChampionshipNumber(String worldChampionshipNumber) {
		this.worldChampionshipNumber = worldChampionshipNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static Team create(Node node) {
		Team csapat = new Team();

		Element element = (Element) node;
		csapat.id = element.getAttribute("id");
		csapat.name = element.getAttribute("név");
		csapat.worldChampionshipNumber = element.getAttribute("világbajnoki_cím");
		return csapat;
	}

}
