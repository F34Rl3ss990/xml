package dombeadando;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Championship {

	private static final String CHAMPIONSHIP_TAG = "bajnokság";
	private static final String CONNECTOR_TAG = "kapcsolo";
	private static final String IMPORTER_TAG = "beszállító";
	private static final String CAR_TAG = "kocsi";
	private static final String RACE_TAG = "verseny";
	private static final String RACER_TAG = "versenyzõ";
	private static final String TEAM_TAG = "csapat";

	private Document root;
	private List<Car> cars;
	private List<Connector> connectors;
	private List<Importer> importers;
	private List<Race> races;
	private List<Racer> racers;
	private List<Team> teams;

	private Championship(Document root, List<Car> cars, List<Connector> connectors, List<Importer> importers,
			List<Race> races, List<Racer> racers, List<Team> teams) {
		this.root = root;
		this.cars = cars;
		this.connectors = connectors;
		this.importers = importers;
		this.races = races;
		this.racers = racers;
		this.teams = teams;
	}

	public static Championship create(Document document) {
		Element root = document.getDocumentElement();
		if (!root.getNodeName().equals(CHAMPIONSHIP_TAG)) {
			throw new IllegalArgumentException("nem bajnokság a gyökérelem");
		}

		NodeList nodeList = root.getElementsByTagName(CONNECTOR_TAG);
		List<Connector> connectors = new ArrayList<>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			connectors.add(Connector.create(node));
		}

		nodeList = root.getElementsByTagName(IMPORTER_TAG);
		List<Importer> importers = new ArrayList<>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			importers.add(Importer.create(node));
		}

		nodeList = root.getElementsByTagName(CAR_TAG);
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			cars.add(Car.create(node));
		}
		nodeList = root.getElementsByTagName(RACE_TAG);
		List<Race> races = new ArrayList<>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			races.add(Race.create(node));
		}
		nodeList = root.getElementsByTagName(RACER_TAG);
		List<Racer> racers = new ArrayList<>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			racers.add(Racer.create(node));
		}
		nodeList = root.getElementsByTagName(TEAM_TAG);
		List<Team> teams = new ArrayList<>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			teams.add(Team.create(node));
		}

		Championship championship = new Championship(document, cars, connectors, importers, races, racers, teams);

		cars.forEach(car -> car.setRacer(championship.getRacerById(car.getId())));
		racers.forEach(racer -> racer.setTTeam(championship.getTeamById(racer.getId())));
		connectors.forEach(connector -> connector.setImporter(championship.getConnectorById(connector.getIdb())));
		connectors.forEach(connector -> connector.setTeam(championship.getTeamById(connector.getIdcs())));
		return championship;
	}

	public Racer getRacerById(int i) {
		return racers.stream().filter(racer -> racer.getId()==i).findFirst().orElseGet(Racer::new);
	}

	public Team getTeamById(int i) {
		return teams.stream().filter(team -> team.getId()==i).findFirst().orElseGet(Team::new);
	}

	public Importer getConnectorById(int i) {
		return importers.stream().filter(importer -> importer.getId()==i).findFirst().orElseGet(Importer::new);
	}

	public void addCar(Car car) {
		Element element = root.createElement(CAR_TAG);
		element.setAttribute("márka", car.getBrand());
		element.setAttribute("hengerûrtartalom", String.valueOf(car.getCapacity()));
		element.setAttribute("lóerõ", String.valueOf(car.getHorsepower()));
		element.setAttribute("rendszam", car.getLicensePlate());
		element.setAttribute("típus", car.getType());
		element.setAttribute("id", String.valueOf(car.getRacer().getId()));

		root.getDocumentElement().appendChild(element);
		cars.add(car);
	}

	public void addConnector(Connector connector) {
		Element element = root.createElement(CONNECTOR_TAG);
		element.setAttribute("idb", String.valueOf(connector.getImporter().getId()));
		element.setAttribute("idcs", String.valueOf(connector.getTeam().getId()));

		root.getDocumentElement().appendChild(element);
		connectors.add(connector);
	}

	public void addImporter(Importer importer) {
		Element element = root.createElement(IMPORTER_TAG);
		element.setAttribute("id", String.valueOf(importer.getId()));
		element.setAttribute("név", importer.getName());
		element.setAttribute("telefonszám", String.valueOf(importer.getPhoneNumber()));

		root.getDocumentElement().appendChild(element);
		importers.add(importer);
	}

	public void addRace(Race race) {
		Element element = root.createElement(RACE_TAG);
		element.setAttribute("idõpont", race.getDate());
		element.setAttribute("id", String.valueOf(race.getId()));
		element.setAttribute("név", race.getName());
		element.setAttribute("helyszín", race.getPlace());

		root.getDocumentElement().appendChild(element);
		races.add(race);
	}

	public void addRacer(Racer racer) {
		Element element = root.createElement(RACER_TAG);
		element.setAttribute("id", String.valueOf(racer.getId()));
		element.setAttribute("név", racer.getName());
		element.setAttribute("csapat", racer.getTeam());
		element.setAttribute("idcs", String.valueOf(racer.getTTeam().getId()));

		root.getDocumentElement().appendChild(element);
		racers.add(racer);
	}

	public void addTeam(Team team) {
		Element element = root.createElement(TEAM_TAG);
		element.setAttribute("id", String.valueOf(team.getId()));
		element.setAttribute("név", team.getName());
		element.setAttribute("világbajnoki_cím", String.valueOf(team.getWorldChampionshipNumber()));

		root.getDocumentElement().appendChild(element);
		teams.add(team);
	}

	public Team teamId(int id) {
		for (Team team : teams) {
			if (team.getId()==id) {
				return team;
			}
		}
		return null;
	}

	public Racer racerId(int id) {
		for (Racer racer : racers) {
			if (racer.getId()==id) {
				return racer;
			}
		}
		return null;
	}

	public Importer importerId(int id) {
		for (Importer importer : importers) {
			if (importer.getId()==id) {
				return importer;
			}
		}
		return null;
	}

	public Car searchCarById(int id) {
		
		for (Car car : cars) {
			if (car.getId()==id) {
				return car;
			}
		}
		return null;
	}

	public Race searchRaceById(int id) {
		for (Race race : races) {
			if (race.getId()==id) {
				return race;
			}
		}
		return null;
	}

	public Importer searchImporterById(int id) {
		for (Importer importer : importers) {
			if (importer.getId()==id) {
				return importer;
			}
		}
		return null;
	}

	public Team searchTeamByImporter(int id) {
		for (Connector connector : connectors) {
			if (connector.getIdb()==id) {
				for (Team team : teams) {
					return team;
				}
			}
		}
	return null;
	}

	public Importer searchImporterByTeam(int id) {
		for (Connector connector : connectors) {
			if (connector.getIdcs()==id) {
				for (Importer importer : importers) {
					return importer;
				}
			}
		}
	return null;
	}

	public Racer searchRacerByTeam(int id) {
		for (Team team : teams) {
			if (team.getId()==id) {
				for (Racer racer : racers) {
					return racer;
				}
			}
		}
		return null;
	}

	public Team searchTeamByRacer(int id) {
		for (Racer racer : racers) {
			if (racer.getId()==id) {
				for (Team team : teams) {
					return team;
				}
			}
		}
	return null;
	}

	public int teamIdUniq(int id) {
		int a = 0;
		for (Team team : teams) {
			if (team.getId()==id) {
				a++;
			}
		}
		if (a == 0) {
			return id;
		} else {
			return -1;
		}
	}
	public int valami(int id) {
		return id;
	}

	public int importerIdUniq(int id) {
		int a = 0;
		for (Importer importer : importers) {
			if (importer.getId()==id) {
				a++;
			} 
		}
		if (a == 0) {
			return id;
		} else {
			return -1;
		}
	}

	public int raceIdUniq(int id) {
		int a = 0;
		for (Race race : races) {
			if (race.getId()==id) {
				a++;
			} 
		}
		if (a == 0) {
			return id;
		} else {
			return -1;
		}
	}

	public int racerIdUniq(int id) {
		int a = 0;
		for (Racer racer : racers) {
			if (racer.getId()==id) {
				a++;
			} 
		}
		if (a == 0) {
			return id;
		} else {
			return -1;
		}
	}

	public void persist(String pathname) throws TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		DOMSource source = new DOMSource(root);
		StreamResult result = new StreamResult(new File(pathname));
		transformer.transform(source, result);
	}

	
}
