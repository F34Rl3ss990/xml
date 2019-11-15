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
			System.out.println("(1) Új elem felvitele");
			System.out.println("(2) Lekérdezés");
			System.out.println("(3) Ment \n");
			System.out.println("(0) Kilép");
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();

			switch (a) {
			case 1:
				System.out.println("(1) Új csapat felvitele");
				System.out.println("(2) Új beszállító felvitele");
				System.out.println("(3) Új verseny felvitele");
				System.out.println("(4) Új versenyzõ felvitele");
				System.out.println("(5) Új kocsi felvitele");
				System.out.println("(6) Új csapat-beszállító kapcsolat felvitele");
				System.out.println("(0) Kilép");
				int b = sc.nextInt();
					switch (b) {
					case 1:
						Team team = new Team();
						System.out.println("Név: ");
						String nev = sc.nextLine();
						team.setName(nev);
						System.out.println("Világbajnoki címek száma: ");
						String cim = sc.nextLine();
						team.setWorldChampionshipNumber(cim);
						System.out.println("ID: ");
						String id = sc.nextLine();
						team.setId(id);
						championship.addTeam(team);
						break;
					case 2:
						Importer importer = new Importer();
						System.out.println("Név: ");
						String nevb = sc.nextLine();
						importer.setName(nevb);
						System.out.println("Telefonszám: ");
						String telo = sc.nextLine();
						importer.setPhoneNumber(telo);
						System.out.println("ID: ");
						String idb = sc.nextLine();
						importer.setId(idb);
						championship.addImporter(importer);
						break;
					case 3:
						Race race = new Race();
						System.out.println("Helyszín: ");
						String helyszin = sc.nextLine();
						race.setPlace(helyszin);
						System.out.println("Idõpont: ");
						String idopont = sc.nextLine();
						race.setDate(idopont);
						System.out.println("ID: ");
						String idv = sc.nextLine();
						race.setId(idv);
						System.out.println("Név: ");
						String nevV = sc.nextLine();
						race.setName(nevV);
						championship.addRace(race);
						break;
					case 4:
						Racer racer = new Racer();
						System.out.println("Név: ");
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
						System.out.println("Lóerõ: ");
						String loero = sc.nextLine();
						car.setHorsepower(loero);
						System.out.println("Hengerûrtartalom");
						String hengerurtartalom = sc.nextLine();
						car.setCapacity(hengerurtartalom);
						System.out.println("Típus: ");
						String tipus = sc.nextLine();
						car.setType(tipus);
						System.out.println("Márka: ");
						String marka = sc.nextLine();
						car.setBrand(marka);
						System.out.println("Rendszám: ");
						String rendszam = sc.nextLine();
						car.setLicensePlate(rendszam);
						championship.addCar(car);
						break;
					case 6:
						Connector connector = new Connector();
						System.out.println("Beszállító: ");
						String connectorb = sc.nextLine();
						//connector.setName(nevv);
						System.out.println("Csapat: ");
						String connectorcs = sc.nextLine();
						//connector.set(connector);
						championship.addConnector(connector);
					case 0:
						break;
					default:
						System.out.println("Nem megfelelõ számot adtál meg!");
						break;
					}
				break;
			case 2:
				System.out.println("(1) Kocsi keresése ID alapján");
				System.out.println("(2) Csapat keresése ID alapján");
				System.out.println("(3) Versenyzõ keresése ID alapján");
				System.out.println("(4) Verseny keresése ID alapján");
				System.out.println("(5) Beszállító keresése ID alapján");
				System.out.println("(6) Versenyzõ keresése kocsi alapján");
				System.out.println("(7) Kocsi keresése verseny alapján");
				System.out.println("(8) Csapat keresése versenyzõ alapján");
				System.out.println("(9) Versenyzõ keresése csapat alapján");
				System.out.println("(10) Csapat keresése beszállító alapján");
				System.out.println("(11) Beszállító keresése csapat alapján");
				System.out.println("(0) Kilép");
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
						System.out.println("Nem megfelelõ számot adtál meg!");
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
				System.out.println("Nem megfelelõ számot adtál meg!");
				break;
			}
		}

	}

}
