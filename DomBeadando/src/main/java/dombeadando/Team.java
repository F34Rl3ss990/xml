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
		Team team = new Team();

		Element element = (Element) node;
		team.id = element.getAttribute("id");
		team.name = element.getAttribute("n�v");
		team.worldChampionshipNumber = element.getAttribute("vil�gbajnoki_c�m");
		return team;
	}

}
