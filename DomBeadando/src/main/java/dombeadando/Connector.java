package dombeadando;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Connector {

	private String idb;
	private String idcs;
	private Team csapat;
	private Importer beszallito;

	public String getIdb() {
		return idb;
	}

	public void setIdb(String idb) {
		this.idb = idb;
	}

	public String getIdcs() {
		return idcs;
	}

	public void setIdcs(String idcs) {
		this.idcs = idcs;
	}

	public Team getCsapat() {
		return csapat;
	}

	public void setCsapat(Team csapat) {
		this.csapat = csapat;
	}

	public Importer getBeszallito() {
		return beszallito;
	}

	public void setBeszallito(Importer beszallito) {
		this.beszallito = beszallito;
	}

	public static Connector create(Node node) {
		Connector kapcsolo = new Connector();

		Element element = (Element) node;
		kapcsolo.idb = element.getAttribute("idb");
		kapcsolo.idcs = element.getAttribute("idcs");
		return kapcsolo;
	}
}
