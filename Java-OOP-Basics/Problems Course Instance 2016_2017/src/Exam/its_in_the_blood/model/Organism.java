package Exam.its_in_the_blood.model;

import java.util.LinkedList;
import java.util.List;

public final class Organism {

    private final String name;
    private final List<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new LinkedList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Organism - ").append(this.name).append(System.lineSeparator());
        sb.append("--Clusters: ").append(this.clusters.size()).append(System.lineSeparator());
        sb.append("--Cells: ").append(this.getCellsCount()).append(System.lineSeparator());
        for (Cluster cluster : clusters) {
            sb.append(cluster).append(System.lineSeparator());
        }
        return sb.toString();
    }

    private int getCellsCount() {
        int count = 0;
        for (Cluster cluster : clusters) {
            count += cluster.getCellsCount();
        }
        return count;
    }

    public boolean addCluster(Cluster cluster) {
        for (Cluster current : clusters) {
            if (current.getId().equals(cluster.getId())) {
                return false;
            }
        }
        clusters.add(cluster);
        return true;
    }

    public Cluster getNextCluster() {
        if (this.clusters.isEmpty()) {
            return null;
        }
        Cluster cluster = clusters.remove(0);
        clusters.add(cluster);
        return cluster;
    }

    public Cluster getClusterById(String id) {
        for (Cluster current : clusters) {
            if (current.getId().equals(id)) {
                return current;
            }
        }
        return null;
    }
}