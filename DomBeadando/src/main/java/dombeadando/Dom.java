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
					String asd = sc.nextLine();

					System.out.println("Név: ");
					String nev = sc.nextLine();
					team.setName(nev);

					System.out.println("Világbajnoki címek száma: ");
					String cim = sc.nextLine();
					team.setWorldChampionshipNumber(cim);

					System.out.println("ID: ");
					String id = sc.nextLine();
					if (championship.teamIdUniq(id) == null) {
						System.out.println("Ilyen id már létezik!");
						break;
					} else {
						team.setId(championship.teamIdUniq(id));
					}
					championship.addTeam(team);
					System.out.println("Elem sikeresn felvéve!");

					break;
				case 2:
					Importer importer = new Importer();
					String asd2 = sc.nextLine();

					System.out.println("Név: ");
					String nevb = sc.nextLine();
					importer.setName(nevb);

					System.out.println("Telefonszám: ");
					String telo = sc.nextLine();
					importer.setPhoneNumber(telo);

					System.out.println("ID: ");
					String idb = sc.nextLine();
					if (championship.importerIdUniq(idb) == null) {
						System.out.println("Ilyen id már létezik!");
						break;
					} else {
						importer.setId(championship.importerIdUniq(idb));
					}

					championship.addImporter(importer);
					System.out.println("Elem sikeresn felvéve!");

					break;
				case 3:
					Race race = new Race();
					String asd3 = sc.nextLine();

					System.out.println("Helyszín: ");
					String helyszin = sc.nextLine();
					race.setPlace(helyszin);

					System.out.println("Idõpont: ");
					String idopont = sc.nextLine();
					race.setDate(idopont);

					System.out.println("ID: ");
					String idv = sc.nextLine();
					if (championship.raceIdUniq(idv) == null) {
						System.out.println("Ilyen id már létezik!");
						break;
					} else {
						race.setId(championship.raceIdUniq(idv));
					}

					System.out.println("Név: ");
					String nevV = sc.nextLine();
					race.setName(nevV);

					championship.addRace(race);
					System.out.println("Elem sikeresn felvéve!");

					break;
				case 4:
					Racer racer = new Racer();
					String asd4 = sc.nextLine();

					System.out.println("Név: ");
					String nevv = sc.nextLine();
					racer.setName(nevv);

					System.out.println("Csapat: ");
					String csapat = sc.nextLine();
					racer.setTeam(csapat);

					System.out.println("ID: ");
					String idV = sc.nextLine();
					if (championship.racerIdUniq(idV) == null) {
						System.out.println("Ilyen id már létezik!");
						break;
					} else {
						racer.setId(championship.racerIdUniq(idV));
					}

					System.out.println("Csapat ID-je: ");
					String idCS = sc.nextLine();
					try {
						racer.setTTeam(championship.teamId(idCS));
					} catch (Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ csapat!");
						break;
					}
					championship.addRacer(racer);
					System.out.println("Elem sikeresn felvéve!");

					break;
				case 5:
					Car car = new Car();
					String asd5 = sc.nextLine();

					System.out.println("ID: ");
					String idK = sc.nextLine();
					try {
						car.setRacer(championship.racerId(idK));
					} catch (Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ versenyzõ!");
						break;
					}

					System.out.println("Lóerõ: ");
					String loero = sc.nextLine();
					car.setHorsepower(loero);

					System.out.println("Hengerûrtartalom: ");
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
					System.out.println("Elem sikeresn felvéve!");

					break;
				case 6:
					Connector connector = new Connector();
					String asd6 = sc.nextLine();

					System.out.println("Beszállító: ");
					String connectorb = sc.nextLine();
					try {
						connector.setImporter(championship.importerId(connectorb));
					} catch (Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ beszállító!");
						break;
					}

					System.out.println("Csapat: ");
					String connectorcs = sc.nextLine();
					try {
						connector.setTeam(championship.teamId(connectorcs));
					} catch (Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ csapat!");
						break;
					}

					championship.addConnector(connector);
					System.out.println("Elem sikeresn felvéve!");

					break;
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
				System.out.println("(6) Csapat keresése versenyzõ alapján");
				System.out.println("(7) Versenyzõ keresése csapat alapján");
				System.out.println("(8) Csapat keresése beszállító alapján");
				System.out.println("(9) Beszállító keresése csapat alapján");
				System.out.println("(0) Kilép");
				int c = sc.nextInt();
				switch (c) {
				case 1:
					String asd1 = sc.nextLine();
					System.out.println("Kocsi ID: ");
					String carID = sc.nextLine();
					System.out.println("Id: " + championship.searchCarById(carID).getId());
					System.out.println("Márka: " + championship.searchCarById(carID).getBrand());
					System.out.println("Típus: " + championship.searchCarById(carID).getType());
					System.out.println("Hengerûrtartalom: " + championship.searchCarById(carID).getCapacity() + "cc");
					System.out.println("Lóerõ: " + championship.searchCarById(carID).getHorsepower() + "hp");
					System.out.println("Rendszám: " + championship.searchCarById(carID).getLicensePlate());

					break;
				case 2:
					String asd2 = sc.nextLine();
					System.out.println("Csapat ID: ");
					String teamID = sc.nextLine();
					System.out.println("Id: " + championship.teamId(teamID).getId());
					System.out.println("Név: " + championship.teamId(teamID).getName());
					System.out.println(
							"Világbajnoki címek száma: " + championship.teamId(teamID).getWorldChampionshipNumber());
					break;
				case 3:
					String asd3 = sc.nextLine();
					System.out.println("Versenyzõ ID: ");
					String racerID = sc.nextLine();
					System.out.println("Id: " + championship.racerId(racerID).getId());
					System.out.println("Csapat Id: " + championship.racerId(racerID).getIdcs());
					System.out.println("Név: " + championship.racerId(racerID).getName());
					System.out.println("Csapat: " + championship.racerId(racerID).getTeam());

					break;
				case 4:
					String asd4 = sc.nextLine();
					System.out.println("Verseny ID: ");
					String raceID = sc.nextLine();
					System.out.println("Id: " + championship.searchRaceById(raceID).getId());
					System.out.println("Név: " + championship.searchRaceById(raceID).getName());
					System.out.println("Helyszín: " + championship.searchRaceById(raceID).getPlace());
					System.out.println("Idõpont: " + championship.searchRaceById(raceID).getDate());

					break;
				case 5:
					String asd5 = sc.nextLine();
					System.out.println("Beszállító ID: ");
					String importerID = sc.nextLine();
					System.out.println("Id: " + championship.searchImporterById(importerID).getId());
					System.out.println("Név: " + championship.searchImporterById(importerID).getName());
					System.out.println("Telefonszám: " + championship.searchImporterById(importerID).getPhoneNumber());
					break;
				case 6:
					String asd6 = sc.nextLine();
					System.out.println("Versenyzõ ID: ");
					String racerID3 = sc.nextLine();
					System.out.println("Id: " + championship.searchTeamByRacer(racerID3).getId());
					System.out.println("Név: " +championship.searchTeamByRacer(racerID3).getName());
					System.out.println("Világbajnoki címek száma: " +championship.searchTeamByRacer(racerID3).getWorldChampionshipNumber());
					championship.searchTeamByRacer(racerID3);
					break;
				case 7:
					String asd7 = sc.nextLine();
					System.out.println("Csapat ID: ");
					String teamID2 = sc.nextLine();
					System.out.println("Id: " + championship.searchRacerByTeam(teamID2).getId());
					System.out.println("Csapat Id: " + championship.searchRacerByTeam(teamID2).getIdcs());
					System.out.println("Név: " + championship.searchRacerByTeam(teamID2).getName());
					System.out.println("Csapat: " + championship.searchRacerByTeam(teamID2).getTeam());
					
					break;
				case 8:
					String asd8 = sc.nextLine();
					System.out.println("Beszállító ID: ");
					String importerID2 = sc.nextLine();
					System.out.println("Id: " +championship.searchTeamByImporter(importerID2).getId());
					System.out.println("Név: " + championship.searchTeamByImporter(importerID2).getName());
					System.out.println("Világbajnoki címek száma: " + championship.searchTeamByImporter(importerID2).getWorldChampionshipNumber());
					break;
				case 9:
					String asd9 = sc.nextLine();
					System.out.println("Csapat ID: ");
					String teamID3 = sc.nextLine();
					System.out.println("Id: " + championship.searchImporterByTeam(teamID3).getId());
					System.out.println("Név: " + championship.searchImporterByTeam(teamID3).getName());
					System.out.println("Telefonszám: " + championship.searchImporterByTeam(teamID3).getPhoneNumber());
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
