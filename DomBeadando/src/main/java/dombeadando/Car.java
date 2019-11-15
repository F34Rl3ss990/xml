package dombeadando;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Car {

	private String horsepower;
	private String capacity;
	private String type;
	private String brand;
	private String licensePlate;
	private String id;
	private Racer versenyzo;

	public String getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(String horsepower) {
		this.horsepower = horsepower;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Racer getVersenyzo() {
		return versenyzo;
	}

	public void setVersenyzo(Racer versenyzo) {
		this.versenyzo = versenyzo;
	}

	public static Car create(Node node) {
		Car kocsi = new Car();

		Element element = (Element) node;
		kocsi.horsepower = element.getAttribute("lóerõ");
		kocsi.capacity = element.getAttribute("hengerûrtartalom");
		kocsi.type = element.getAttribute("típus");
		kocsi.brand = element.getAttribute("márka");
		kocsi.licensePlate = element.getAttribute("rendszám");
		kocsi.id = element.getAttribute("id");
		return kocsi;
	}
}
