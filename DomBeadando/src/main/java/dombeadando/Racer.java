package dombeadando;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Racer {

	private String name;
	private String team;
	private String id;
	private String idcs;
	private Team tTeam;

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

	public Team getTTeam() {
		return tTeam;
	}

	public void setTTeam(Team tTeam) {
		this.tTeam = tTeam;
	}

	public static Racer create(Node node) {
		Racer racer = new Racer();

		Element element = (Element) node;
		racer.name = element.getAttribute("n�v");
		racer.team = element.getAttribute("csapat");
		racer.id = element.getAttribute("id");
		racer.idcs = element.getAttribute("idcs");
		return racer;
	}
}
