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
					try {
					int cim = sc.nextInt();
					team.setWorldChampionshipNumber(cim);
					}catch(Exception e) {
						System.out.println("Nem helyes adatot adtál meg! " + e);
						break;
					}

					System.out.println("ID: ");
					try {
					int id = sc.nextInt();
					if (championship.teamIdUniq(id) == -1) {
						System.out.println("Ilyen id már létezik!");
						break;
					} else {
						team.setId(championship.teamIdUniq(id));
					}
					championship.addTeam(team);
					}catch(Exception e) {
						System.out.println("Nem helyes adatot adtál meg! " + e);
						break;
					}
					System.out.println("Elem sikeresn felvéve!");

					break;
				case 2:
					Importer importer = new Importer();
					String asd2 = sc.nextLine();

					System.out.println("Név: ");
					String nevb = sc.nextLine();
					importer.setName(nevb);

					System.out.println("Telefonszám: ");
					try {
					int telo = sc.nextInt();
					importer.setPhoneNumber(telo);
					}catch(Exception e) {
						System.out.println("Nem helyes adatot adtál meg! " + e);
						break;
					}

					System.out.println("ID: ");
					try {
					int idb = sc.nextInt();
					if (championship.importerIdUniq(idb) == -1) {
						System.out.println("Ilyen id már létezik!");
						break;
					} else {
						importer.setId(championship.importerIdUniq(idb));
					}
					}catch(Exception e) {
						System.out.println("Nem helyes adatot adtál meg! " + e);
						break;
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
					try {
					int idv = sc.nextInt();
					if (championship.raceIdUniq(idv) == -1) {
						System.out.println("Ilyen id már létezik!");
						break;
					} else {
						race.setId(championship.raceIdUniq(idv));
					}
					}catch(Exception e) {
						System.out.println("Nem helyes adatot adtál meg! " + e);
						break;
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
					try {
					int idV = sc.nextInt();
					if (championship.racerIdUniq(idV) == -1) {
						System.out.println("Ilyen id már létezik!");
						break;
					} else {
						racer.setId(championship.racerIdUniq(idV));
					}
					}catch(Exception e) {
						System.out.println("Nem helyes adatot adtál meg! " + e);
						break;
					}

					System.out.println("Csapat ID-je: ");
					try {
					int idCS = sc.nextInt();
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
					try {
					int idK = sc.nextInt();
					
						car.setRacer(championship.racerId(idK));
					} catch (Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ versenyzõ!");
						break;
					}

					System.out.println("Lóerõ: ");
					try {
					int loero = sc.nextInt();
					car.setHorsepower(loero);
					}catch(Exception e) {
						System.out.println("Nem helyes adatot adtál meg! " + e);
						break;
					}

					System.out.println("Hengerûrtartalom: ");
					try {
					int hengerurtartalom = sc.nextInt();
					car.setCapacity(hengerurtartalom);
					}catch(Exception e) {
						System.out.println("Nem helyes adatot adtál meg! " + e);
						break;
					}
					String teszt = sc.nextLine();

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

					System.out.println("Beszállító Id: ");
					int beszallitoID;
					try {
					int connectorb = sc.nextInt();
					beszallitoID = connectorb;
					
						connector.setImporter(championship.importerId(connectorb));
					} catch (Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ beszállító!");
						break;
					}

					System.out.println("Csapat Id: ");
					int csapatID;
					try {
					int connectorcs = sc.nextInt();
					csapatID = connectorcs;
						connector.setTeam(championship.teamId(connectorcs));
					} catch (Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ csapat!");
						break;
					}
					if(championship.teamIdUniq(csapatID)==-1 && championship.importerIdUniq(beszallitoID)==-1) {
						System.out.println("Ehhez a beszállítóhoz: "+beszallitoID+" már tartozik ez a csapat: "+csapatID+"!");
					} else {
						championship.addConnector(connector);
						System.out.println("Elem sikeresn felvéve!");
					}
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
					int carID = sc.nextInt();
					try {
					System.out.println("Id: " + championship.searchCarById(carID).getId());
					System.out.println("Márka: " + championship.searchCarById(carID).getBrand());
					System.out.println("Típus: " + championship.searchCarById(carID).getType());
					System.out.println("Hengerûrtartalom: " + championship.searchCarById(carID).getCapacity() + "cc");
					System.out.println("Lóerõ: " + championship.searchCarById(carID).getHorsepower() + "hp");
					System.out.println("Rendszám: " + championship.searchCarById(carID).getLicensePlate());
					}catch(Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ kocsi: "+e);
					}

					break;
				case 2:
					String asd2 = sc.nextLine();
					System.out.println("Csapat ID: ");
					int teamID = sc.nextInt();
					try {
					System.out.println("Id: " + championship.teamId(teamID).getId());
					System.out.println("Név: " + championship.teamId(teamID).getName());
					System.out.println(
							"Világbajnoki címek száma: " + championship.teamId(teamID).getWorldChampionshipNumber());
					} catch(Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ csapat: "+e);
					}
					break;
				case 3:
					String asd3 = sc.nextLine();
					System.out.println("Versenyzõ ID: ");
					int racerID = sc.nextInt();
					try {
					System.out.println("Id: " + championship.racerId(racerID).getId());
					System.out.println("Csapat Id: " + championship.racerId(racerID).getIdcs());
					System.out.println("Név: " + championship.racerId(racerID).getName());
					System.out.println("Csapat: " + championship.racerId(racerID).getTeam());
					}catch(Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ versenyzõ: "+e);
					}

					break;
				case 4:
					String asd4 = sc.nextLine();
					System.out.println("Verseny ID: ");
					int raceID = sc.nextInt();
					try {
					System.out.println("Id: " + championship.searchRaceById(raceID).getId());
					System.out.println("Név: " + championship.searchRaceById(raceID).getName());
					System.out.println("Helyszín: " + championship.searchRaceById(raceID).getPlace());
					System.out.println("Idõpont: " + championship.searchRaceById(raceID).getDate());
					}catch(Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ verseny: "+e);
					}

					break;
				case 5:
					String asd5 = sc.nextLine();
					System.out.println("Beszállító ID: ");
					int importerID = sc.nextInt();
					try {
					System.out.println("Id: " + championship.searchImporterById(importerID).getId());
					System.out.println("Név: " + championship.searchImporterById(importerID).getName());
					System.out.println("Telefonszám: " + championship.searchImporterById(importerID).getPhoneNumber());
					}catch(Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ beszállító: " + e);
					}
					break;
				case 6:
					String asd6 = sc.nextLine();
					System.out.println("Versenyzõ ID: ");
					int racerID3 = sc.nextInt();
					try {
					System.out.println("Id: " + championship.searchTeamByRacer(racerID3).getId());
					System.out.println("Név: " +championship.searchTeamByRacer(racerID3).getName());
					System.out.println("Világbajnoki címek száma: " +championship.searchTeamByRacer(racerID3).getWorldChampionshipNumber());
					}catch(Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ versenyzõ: " + e);
					}
					break;
				case 7:
					String asd7 = sc.nextLine();
					System.out.println("Csapat ID: ");
					int teamID2 = sc.nextInt();
					try {
					System.out.println("Id: " + championship.searchRacerByTeam(teamID2).getId());
					System.out.println("Csapat Id: " + championship.searchRacerByTeam(teamID2).getIdcs());
					System.out.println("Név: " + championship.searchRacerByTeam(teamID2).getName());
					System.out.println("Csapat: " + championship.searchRacerByTeam(teamID2).getTeam());
					}catch(Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ csapat: "+e);
					}
					
					break;
				case 8:
					String asd8 = sc.nextLine();
					System.out.println("Beszállító ID: ");
					int importerID2 = sc.nextInt();
					try {
					System.out.println("Id: " +championship.searchTeamByImporter(importerID2).getId());
					System.out.println("Név: " + championship.searchTeamByImporter(importerID2).getName());
					System.out.println("Világbajnoki címek száma: " + championship.searchTeamByImporter(importerID2).getWorldChampionshipNumber());
					}catch(Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ beszállító: "+e);
					}
					break;
				case 9:
					String asd9 = sc.nextLine();
					System.out.println("Csapat ID: ");
					int teamID3 = sc.nextInt();
					try {
					System.out.println("Id: " + championship.searchImporterByTeam(teamID3).getId());
					System.out.println("Név: " + championship.searchImporterByTeam(teamID3).getName());
					System.out.println("Telefonszám: " + championship.searchImporterByTeam(teamID3).getPhoneNumber());
					}catch(Exception e) {
						System.out.println("Nincs ilyen idvel rendelkezõ csapat: "+e);
					}
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
