package dombeadando;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Racer {

	private String name;
	private String team;
	private String id;
	private String idcs;
	private Team Csapat;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdcs() {
		return idcs;
	}

	public void setIdcs(String idcs) {
		this.idcs = idcs;
	}

	public Team getCsapat() {
		return Csapat;
	}

	public void setCsapat(Team csapat) {
		Csapat = csapat;
	}

	public static Racer create(Node node) {
		Racer versenyzo = new Racer();

		Element element = (Element) node;
		versenyzo.name = element.getAttribute("név");
		versenyzo.team = element.getAttribute("csapat");
		versenyzo.id = element.getAttribute("id");
		versenyzo.idcs = element.getAttribute("idcs");
		return versenyzo;
	}
}
