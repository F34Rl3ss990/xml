package dombeadando;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Car {

	private int horsepower;
	private int capacity;
	private String type;
	private String brand;
	private String licensePlate;
	private int id;
	private Racer racer;

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Racer getRacer() {
		return racer;
	}

	public void setRacer(Racer racer) {
		this.racer = racer;
	}

	public static Car create(Node node) {
		Car car = new Car();

		Element element = (Element) node;
		car.horsepower = Integer.parseInt(element.getAttribute("lóerõ"));
		car.capacity = Integer.parseInt(element.getAttribute("hengerûrtartalom"));
		car.type = element.getAttribute("típus");
		car.brand = element.getAttribute("márka");
		car.licensePlate = element.getAttribute("rendszám");
		car.id = Integer.parseInt(element.getAttribute("id"));
		return car;
	}
}
