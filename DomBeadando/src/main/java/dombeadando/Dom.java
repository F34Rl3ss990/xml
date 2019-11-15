package dombeadando;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Dom {

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.parse("src/main/resources/.xml");

		Championship championship = Championship.create(document);

		boolean run = true;

		while (run) {
			System.out.println("(1) �j elem felvitele");
			System.out.println("(2) Lek�rdez�s");
			System.out.println("(3) Ment \n");
			System.out.println("(0) Kil�p");
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();

			switch (a) {
			case 1:
				System.out.println("(1) �j csapat felvitele");
				System.out.println("(2) �j besz�ll�t� felvitele");
				System.out.println("(3) �j verseny felvitele");
				System.out.println("(4) �j versenyz� felvitele");
				System.out.println("(5) �j kocsi felvitele");
				System.out.println("(6) �j csapat-besz�ll�t� kapcsolat felvitele");
				System.out.println("(0) Kil�p");
				int b = sc.nextInt();
					switch (b) {
					case 1:
						Team team = new Team();
						System.out.println("N�v: ");
						String nev = sc.nextLine();
						team.setName(nev);
						System.out.println("Vil�gbajnoki c�mek sz�ma: ");
						String cim = sc.nextLine();
						team.setWorldChampionshipNumber(cim);
						System.out.println("ID: ");
						String id = sc.nextLine();
						team.setId(id);
						championship.addTeam(team);
						break;
					case 2:
						Importer importer = new Importer();
						System.out.println("N�v: ");
						String nevb = sc.nextLine();
						importer.setName(nevb);
						System.out.println("Telefonsz�m: ");
						String telo = sc.nextLine();
						importer.setPhoneNumber(telo);
						System.out.println("ID: ");
						String idb = sc.nextLine();
						importer.setId(idb);
						championship.addImporter(importer);
						break;
					case 3:
						Race race = new Race();
						System.out.println("Helysz�n: ");
						String helyszin = sc.nextLine();
						race.setPlace(helyszin);
						System.out.println("Id�pont: ");
						String idopont = sc.nextLine();
						race.setDate(idopont);
						System.out.println("ID: ");
						String idv = sc.nextLine();
						race.setId(idv);
						System.out.println("N�v: ");
						String nevV = sc.nextLine();
						race.setName(nevV);
						championship.addRace(race);
						break;
					case 4:
						Racer racer = new Racer();
						System.out.println("N�v: ");
						String nevv = sc.nextLine();
						racer.setName(nevv);
						System.out.println("Csapat: ");
						String csapat = sc.nextLine();
						racer.setTeam(csapat);
						System.out.println("ID: ");
						String idV = sc.nextLine();
						racer.setId(idV);
						/*System.out.println("Csapat ID-je: ");
						String idCS = sc.nextLine();
						
						*/
						
						championship.addRacer(racer);
						break;
					case 5:
						Car car = new Car();
						System.out.println("ID: ");
						String idK = sc.nextLine();
						car.setId(idK);
						System.out.println("L�er�: ");
						String loero = sc.nextLine();
						car.setHorsepower(loero);
						System.out.println("Henger�rtartalom");
						String hengerurtartalom = sc.nextLine();
						car.setCapacity(hengerurtartalom);
						System.out.println("T�pus: ");
						String tipus = sc.nextLine();
						car.setType(tipus);
						System.out.println("M�rka: ");
						String marka = sc.nextLine();
						car.setBrand(marka);
						System.out.println("Rendsz�m: ");
						String rendszam = sc.nextLine();
						car.setLicensePlate(rendszam);
						championship.addCar(car);
						break;
					case 6:
						Connector connector = new Connector();
						System.out.println("Besz�ll�t�: ");
						String connectorb = sc.nextLine();
						//connector.setName(nevv);
						System.out.println("Csapat: ");
						String connectorcs = sc.nextLine();
						//connector.set(connector);
						championship.addConnector(connector);
					case 0:
						break;
					default:
						System.out.println("Nem megfelel� sz�mot adt�l meg!");
						break;
					}
				break;
			case 2:
				System.out.println("(1) Kocsi keres�se ID alapj�n");
				System.out.println("(2) Csapat keres�se ID alapj�n");
				System.out.println("(3) Versenyz� keres�se ID alapj�n");
				System.out.println("(4) Verseny keres�se ID alapj�n");
				System.out.println("(5) Besz�ll�t� keres�se ID alapj�n");
				System.out.println("(6) Versenyz� keres�se kocsi alapj�n");
				System.out.println("(7) Kocsi keres�se verseny alapj�n");
				System.out.println("(8) Csapat keres�se versenyz� alapj�n");
				System.out.println("(9) Versenyz� keres�se csapat alapj�n");
				System.out.println("(10) Csapat keres�se besz�ll�t� alapj�n");
				System.out.println("(11) Besz�ll�t� keres�se csapat alapj�n");
				System.out.println("(0) Kil�p");
				int c = sc.nextInt();
					switch (c) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						break;
					case 7:
						break;
					case 8:
						break;
					case 9:
						break;
					case 0:
						break;
					default:
						System.out.println("Nem megfelel� sz�mot adt�l meg!");
						break;
					}
					break;
			case 3:
				championship.persist("src/main/resources/output.xml");
				System.out.println("Sikeresen mentve");
				break;
			case 0:
				run = false;
				break;
			default:
				System.out.println("Nem megfelel� sz�mot adt�l meg!");
				break;
			}
		}

	}

}
