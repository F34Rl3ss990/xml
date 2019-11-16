package dombeadando;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Connector {

	private String idI;
	private String idT;
	private Team team;
	private Importer importer;

	public String getIdb() {
		return idI;
	}

	public void setIdb(String idb) {
		this.idI = idb;
	}

	public String getIdcs() {
		return idT;
	}

	public void setIdcs(String idcs) {
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
		connector.idI = element.getAttribute("idb");
		connector.idT = element.getAttribute("idcs");
		return connector;
	}
}
