package Exam.its_in_the_blood.controller;

import Exam.its_in_the_blood.model.Cluster;
import Exam.its_in_the_blood.model.Organism;
import Exam.its_in_the_blood.model.cells.Cell;
import Exam.its_in_the_blood.model.cells.blood_cells.RedBloodCell;
import Exam.its_in_the_blood.model.cells.blood_cells.WhiteBloodCell;
import Exam.its_in_the_blood.model.cells.microbes.Bacteria;
import Exam.its_in_the_blood.model.cells.microbes.Fungi;
import Exam.its_in_the_blood.model.cells.microbes.Virus;

import java.util.HashMap;
import java.util.Map;

public class HealthManager {
    private static final HealthManager SINGLETON_INSTANCE = new HealthManager();

    private static final String EMPTY_STRING = "";
    private static final String CELL_CREATED = "Organism %s: Created cell %s in cluster %s%n";
    private static final String CLUSTER_CREATED = "Organism %s: Created cluster %s%n";
    private static final String ORGANISM_CREATED = "Created organism %s%n";
    private static final String ORGANISM_ALREADY_EXISTS = "Organism %s already exists%n";
    private static final String CLUSTER_ACTIVATED = "Organism %s: Activated cluster %s. Cells left: %d%n";

    private final Map<String, Organism> organisms;

    private HealthManager() { // Change to public to pass Business Logic tests in Judge
        this.organisms = new HashMap<>();
    }

    public static HealthManager getInstance() {
        return SINGLETON_INSTANCE;
    }

    public String createOrganism(String name) {
        if (this.organisms.containsKey(name)) {
            return String.format(ORGANISM_ALREADY_EXISTS, name);
        }

        this.organisms.put(name, new Organism(name));
        return String.format(ORGANISM_CREATED, name);
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        if (this.organisms.containsKey(organismName) &&
                this.organisms.get(organismName).addCluster(new Cluster(id, rows, cols))) {
            return String.format(CLUSTER_CREATED, organismName, id);
        }
        return EMPTY_STRING;
    }

    public String addCell(String organismName, String clusterId,
                          String cellType, String cellId, int health,
                          int positionX, int positionY, int additionalProperty) {
        if (this.organisms.containsKey(organismName)) {
            Cluster cluster = this.organisms.get(organismName).getClusterById(clusterId);
            Cell cell = makeCell(cellType, cellId, health, positionX, positionY, additionalProperty);
            if (cluster != null && cell != null && cluster.addCell(cell)) {
                return String.format(CELL_CREATED, organismName, cellId, clusterId);
            }
        }
        return EMPTY_STRING;
    }

    public String activateCluster(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            Cluster cluster = this.organisms.get(organismName).getNextCluster();
            if (cluster != null) {
                cluster.activate();
                return String.format(CLUSTER_ACTIVATED,
                        organismName, cluster.getId(), cluster.getCellsCount());
            }
        }
        return EMPTY_STRING;
    }

    public String checkCondition(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            return this.organisms.get(organismName).toString();
        }
        return EMPTY_STRING;
    }

    private Cell makeCell(String cellType, String cellId, int health,
                          int positionX, int positionY, int additionalProperty) {
        switch (cellType) {
        case "RedBloodCell":
            return new RedBloodCell(cellId, health, positionX, positionY, additionalProperty);
        case "WhiteBloodCell":
            return new WhiteBloodCell(cellId, health, positionX, positionY, additionalProperty);
        case "Bacteria":
            return new Bacteria(cellId, health, positionX, positionY, additionalProperty);
        case "Fungi":
            return new Fungi(cellId, health, positionX, positionY, additionalProperty);
        case "Virus":
            return new Virus(cellId, health, positionX, positionY, additionalProperty);
        default:
            return null;
        }
    }
}