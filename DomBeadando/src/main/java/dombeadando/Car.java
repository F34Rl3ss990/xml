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
	private Racer racer;

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

	public Racer getRacer() {
		return racer;
	}

	public void setRacer(Racer racer) {
		this.racer = racer;
	}

	public static Car create(Node node) {
		Car car = new Car();

		Element element = (Element) node;
		car.horsepower = element.getAttribute("l�er�");
		car.capacity = element.getAttribute("henger�rtartalom");
		car.type = element.getAttribute("t�pus");
		car.brand = element.getAttribute("m�rka");
		car.licensePlate = element.getAttribute("rendsz�m");
		car.id = element.getAttribute("id");
		return car;
	}
}
