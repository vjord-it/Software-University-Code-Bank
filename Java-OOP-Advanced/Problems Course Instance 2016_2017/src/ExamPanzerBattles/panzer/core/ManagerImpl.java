package ExamPanzerBattles.panzer.core;

import ExamPanzerBattles.panzer.constants.EngineConstants;
import ExamPanzerBattles.panzer.constants.Messages;
import ExamPanzerBattles.panzer.contracts.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private final VehiclesFactory vehiclesFactory;
    private final PartsFactory partsFactory;
    private final Map<String, Vehicle> vehicles;
    private final BattleOperator battleOperator;
    private final List<String> defeatedVehicles;

    public ManagerImpl(VehiclesFactory vehiclesFactory,
                       PartsFactory partsFactory, BattleOperator battleOperator) {
        this.vehiclesFactory = vehiclesFactory;
        this.partsFactory = partsFactory;
        this.battleOperator = battleOperator;
        this.vehicles = new LinkedHashMap<>();
        defeatedVehicles = new ArrayList<>();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        String type = arguments.get(0);

        String[] args = arguments.toArray(new String[0]);

        Vehicle vehicle = vehiclesFactory.create(args);

        this.vehicles.put(vehicle.getModel(), vehicle);

        return String.format(Messages.VEHICLE_CREATED, type, vehicle.getModel());
    }

    @Override
    public String addPart(List<String> arguments) {
        String vehicleModel = arguments.get(0);
        String partType = arguments.get(1);

        String[] args = arguments.stream().skip(1).toArray(String[]::new);

        Part part = partsFactory.create(args);

        switch (partType) {
        case EngineConstants.ARSENAL:
            this.vehicles.get(vehicleModel).addArsenalPart(part);
            break;
        case EngineConstants.SHELL:
            this.vehicles.get(vehicleModel).addShellPart(part);
            break;
        case EngineConstants.ENDURANCE:
            this.vehicles.get(vehicleModel).addEndurancePart(part);
            break;
        }

        return String.format(Messages.ADDED_PART_TO_VEHICLE,
                partType, part.getModel(), vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) {
        return this.vehicles.get(arguments.get(0)).toString();
    }

    @Override
    public String battle(List<String> arguments) {
        String vehicle1model = arguments.get(0);
        String vehicle2model = arguments.get(1);

        Vehicle vehicle1 = this.vehicles.get(vehicle1model);
        Vehicle vehicle2 = this.vehicles.get(vehicle2model);

        String winner = battleOperator.battle(vehicle1, vehicle2);
        String loser = vehicle1model.equals(winner) ? vehicle2model : vehicle1model;

        this.defeatedVehicles.add(loser);
        this.vehicles.remove(loser);

        return String.format(Messages.VICTORY, vehicle1model, vehicle2model, winner);
    }

    @Override
    public String terminate(List<String> arguments) {
        String remaining = this.vehicles.isEmpty() ? Messages.NONE :
                this.vehicles.keySet().toString().replaceAll("[\\[\\]]", "");

        String defeated = this.defeatedVehicles.isEmpty() ? Messages.NONE :
                this.defeatedVehicles.toString().replaceAll("[\\[\\]]", "");

        final int[] usedParts = {0};
        this.vehicles.values().forEach(x -> x.getParts().forEach(p -> usedParts[0]++));

        StringBuilder sb = new StringBuilder();
        sb.append(Messages.REMAINING_VEHICLES).append(remaining).append(System.lineSeparator());
        sb.append(Messages.DEFEATED_VEHICLES).append(defeated).append(System.lineSeparator());
        sb.append(Messages.CURRENTLY_USED_PARTS).append(usedParts[0]);

        return sb.toString();
    }
}
