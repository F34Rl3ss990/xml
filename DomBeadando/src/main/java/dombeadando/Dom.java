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

		Document document = builder.parse("src/main/resources/bajnoksag.xml");

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
					String asd = sc.nextLine();

					System.out.println("N�v: ");
					String nev = sc.nextLine();
					team.setName(nev);

					System.out.println("Vil�gbajnoki c�mek sz�ma: ");
					String cim = sc.nextLine();
					team.setWorldChampionshipNumber(cim);

					System.out.println("ID: ");
					String id = sc.nextLine();
					if (championship.teamIdUniq(id) == null) {
						System.out.println("Ilyen id m�r l�tezik!");
						break;
					} else {
						team.setId(championship.teamIdUniq(id));
					}
					championship.addTeam(team);
					System.out.println("Elem sikeresn felv�ve!");

					break;
				case 2:
					Importer importer = new Importer();
					String asd2 = sc.nextLine();

					System.out.println("N�v: ");
					String nevb = sc.nextLine();
					importer.setName(nevb);

					System.out.println("Telefonsz�m: ");
					String telo = sc.nextLine();
					importer.setPhoneNumber(telo);

					System.out.println("ID: ");
					String idb = sc.nextLine();
					if (championship.importerIdUniq(idb) == null) {
						System.out.println("Ilyen id m�r l�tezik!");
						break;
					} else {
						importer.setId(championship.importerIdUniq(idb));
					}

					championship.addImporter(importer);
					System.out.println("Elem sikeresn felv�ve!");

					break;
				case 3:
					Race race = new Race();
					String asd3 = sc.nextLine();

					System.out.println("Helysz�n: ");
					String helyszin = sc.nextLine();
					race.setPlace(helyszin);

					System.out.println("Id�pont: ");
					String idopont = sc.nextLine();
					race.setDate(idopont);

					System.out.println("ID: ");
					String idv = sc.nextLine();
					if (championship.raceIdUniq(idv) == null) {
						System.out.println("Ilyen id m�r l�tezik!");
						break;
					} else {
						race.setId(championship.raceIdUniq(idv));
					}

					System.out.println("N�v: ");
					String nevV = sc.nextLine();
					race.setName(nevV);

					championship.addRace(race);
					System.out.println("Elem sikeresn felv�ve!");

					break;
				case 4:
					Racer racer = new Racer();
					String asd4 = sc.nextLine();

					System.out.println("N�v: ");
					String nevv = sc.nextLine();
					racer.setName(nevv);

					System.out.println("Csapat: ");
					String csapat = sc.nextLine();
					racer.setTeam(csapat);

					System.out.println("ID: ");
					String idV = sc.nextLine();
					if (championship.racerIdUniq(idV) == null) {
						System.out.println("Ilyen id m�r l�tezik!");
						break;
					} else {
						racer.setId(championship.racerIdUniq(idV));
					}

					System.out.println("Csapat ID-je: ");
					String idCS = sc.nextLine();
					try {
						racer.setTTeam(championship.teamId(idCS));
					} catch (Exception e) {
						System.out.println("Nincs ilyen idvel rendelkez� csapat!");
						break;
					}
					championship.addRacer(racer);
					System.out.println("Elem sikeresn felv�ve!");

					break;
				case 5:
					Car car = new Car();
					String asd5 = sc.nextLine();

					System.out.println("ID: ");
					String idK = sc.nextLine();
					try {
						car.setRacer(championship.racerId(idK));
					} catch (Exception e) {
						System.out.println("Nincs ilyen idvel rendelkez� versenyz�!");
						break;
					}

					System.out.println("L�er�: ");
					String loero = sc.nextLine();
					car.setHorsepower(loero);

					System.out.println("Henger�rtartalom: ");
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
					System.out.println("Elem sikeresn felv�ve!");

					break;
				case 6:
					Connector connector = new Connector();
					String asd6 = sc.nextLine();

					System.out.println("Besz�ll�t�: ");
					String connectorb = sc.nextLine();
					try {
						connector.setImporter(championship.importerId(connectorb));
					} catch (Exception e) {
						System.out.println("Nincs ilyen idvel rendelkez� besz�ll�t�!");
						break;
					}

					System.out.println("Csapat: ");
					String connectorcs = sc.nextLine();
					try {
						connector.setTeam(championship.teamId(connectorcs));
					} catch (Exception e) {
						System.out.println("Nincs ilyen idvel rendelkez� csapat!");
						break;
					}

					championship.addConnector(connector);
					System.out.println("Elem sikeresn felv�ve!");

					break;
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
				System.out.println("(6) Csapat keres�se versenyz� alapj�n");
				System.out.println("(7) Versenyz� keres�se csapat alapj�n");
				System.out.println("(8) Csapat keres�se besz�ll�t� alapj�n");
				System.out.println("(9) Besz�ll�t� keres�se csapat alapj�n");
				System.out.println("(0) Kil�p");
				int c = sc.nextInt();
				switch (c) {
				case 1:
					String asd1 = sc.nextLine();
					System.out.println("Kocsi ID: ");
					String carID = sc.nextLine();
					System.out.println("Id: " + championship.searchCarById(carID).getId());
					System.out.println("M�rka: " + championship.searchCarById(carID).getBrand());
					System.out.println("T�pus: " + championship.searchCarById(carID).getType());
					System.out.println("Henger�rtartalom: " + championship.searchCarById(carID).getCapacity() + "cc");
					System.out.println("L�er�: " + championship.searchCarById(carID).getHorsepower() + "hp");
					System.out.println("Rendsz�m: " + championship.searchCarById(carID).getLicensePlate());

					break;
				case 2:
					String asd2 = sc.nextLine();
					System.out.println("Csapat ID: ");
					String teamID = sc.nextLine();
					System.out.println("Id: " + championship.teamId(teamID).getId());
					System.out.println("N�v: " + championship.teamId(teamID).getName());
					System.out.println(
							"Vil�gbajnoki c�mek sz�ma: " + championship.teamId(teamID).getWorldChampionshipNumber());
					break;
				case 3:
					String asd3 = sc.nextLine();
					System.out.println("Versenyz� ID: ");
					String racerID = sc.nextLine();
					System.out.println("Id: " + championship.racerId(racerID).getId());
					System.out.println("Csapat Id: " + championship.racerId(racerID).getIdcs());
					System.out.println("N�v: " + championship.racerId(racerID).getName());
					System.out.println("Csapat: " + championship.racerId(racerID).getTeam());

					break;
				case 4:
					String asd4 = sc.nextLine();
					System.out.println("Verseny ID: ");
					String raceID = sc.nextLine();
					System.out.println("Id: " + championship.searchRaceById(raceID).getId());
					System.out.println("N�v: " + championship.searchRaceById(raceID).getName());
					System.out.println("Helysz�n: " + championship.searchRaceById(raceID).getPlace());
					System.out.println("Id�pont: " + championship.searchRaceById(raceID).getDate());

					break;
				case 5:
					String asd5 = sc.nextLine();
					System.out.println("Besz�ll�t� ID: ");
					String importerID = sc.nextLine();
					System.out.println("Id: " + championship.searchImporterById(importerID).getId());
					System.out.println("N�v: " + championship.searchImporterById(importerID).getName());
					System.out.println("Telefonsz�m: " + championship.searchImporterById(importerID).getPhoneNumber());
					break;
				case 6:
					String asd6 = sc.nextLine();
					System.out.println("Versenyz� ID: ");
					String racerID3 = sc.nextLine();
					System.out.println("Id: " + championship.searchTeamByRacer(racerID3).getId());
					System.out.println("N�v: " +championship.searchTeamByRacer(racerID3).getName());
					System.out.println("Vil�gbajnoki c�mek sz�ma: " +championship.searchTeamByRacer(racerID3).getWorldChampionshipNumber());
					championship.searchTeamByRacer(racerID3);
					break;
				case 7:
					String asd7 = sc.nextLine();
					System.out.println("Csapat ID: ");
					String teamID2 = sc.nextLine();
					System.out.println("Id: " + championship.searchRacerByTeam(teamID2).getId());
					System.out.println("Csapat Id: " + championship.searchRacerByTeam(teamID2).getIdcs());
					System.out.println("N�v: " + championship.searchRacerByTeam(teamID2).getName());
					System.out.println("Csapat: " + championship.searchRacerByTeam(teamID2).getTeam());
					
					break;
				case 8:
					String asd8 = sc.nextLine();
					System.out.println("Besz�ll�t� ID: ");
					String importerID2 = sc.nextLine();
					System.out.println("Id: " +championship.searchTeamByImporter(importerID2).getId());
					System.out.println("N�v: " + championship.searchTeamByImporter(importerID2).getName());
					System.out.println("Vil�gbajnoki c�mek sz�ma: " + championship.searchTeamByImporter(importerID2).getWorldChampionshipNumber());
					break;
				case 9:
					String asd9 = sc.nextLine();
					System.out.println("Csapat ID: ");
					String teamID3 = sc.nextLine();
					System.out.println("Id: " + championship.searchImporterByTeam(teamID3).getId());
					System.out.println("N�v: " + championship.searchImporterByTeam(teamID3).getName());
					System.out.println("Telefonsz�m: " + championship.searchImporterByTeam(teamID3).getPhoneNumber());
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
