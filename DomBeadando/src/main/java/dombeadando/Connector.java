package dombeadando;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Connector {

	private int idI;
	private int idT;
	private Team team;
	private Importer importer;

	public int getIdb() {
		return idI;
	}

	public void setIdb(int idb) {
		this.idI = idb;
	}

	public int getIdcs() {
		return idT;
	}

	public void setIdcs(int idcs) {
		this.idT = idcs;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Importer getImporter() {
		return importer;
	}

	public void setImporter(Importer importer) {
		this.importer = importer;
	}

	public static Connector create(Node node) {
		Connector connector = new Connector();

		Element element = (Element) node;
		connector.idI = Integer.parseInt(element.getAttribute("idb"));
		connector.idT = Integer.parseInt(element.getAttribute("idcs"));
		return connector;
	}
}
