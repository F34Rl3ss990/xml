package dombeadando;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Team {

	private String name;
	private int worldChampionshipNumber;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWorldChampionshipNumber() {
		return worldChampionshipNumber;
	}

	public void setWorldChampionshipNumber(int worldChampionshipNumber) {
		this.worldChampionshipNumber = worldChampionshipNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static Team create(Node node) {
		Team team = new Team();

		Element element = (Element) node;
		team.id = Integer.parseInt(element.getAttribute("id"));
		team.name = element.getAttribute("név");
		team.worldChampionshipNumber = Integer.parseInt(element.getAttribute("világbajnoki_cím"));
		return team;
	}

}
