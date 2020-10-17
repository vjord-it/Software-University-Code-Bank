package ExamPanzerBattles.panzer;

import ExamPanzerBattles.panzer.contracts.*;
import ExamPanzerBattles.panzer.contracts.Runnable;
import ExamPanzerBattles.panzer.core.Engine;
import ExamPanzerBattles.panzer.core.ManagerImpl;
import ExamPanzerBattles.panzer.core.PanzerBattleOperator;
import ExamPanzerBattles.panzer.factories.PartsFactoryImpl;
import ExamPanzerBattles.panzer.factories.VehiclesFactoryImpl;
import ExamPanzerBattles.panzer.io.ConsoleReader;
import ExamPanzerBattles.panzer.io.ConsoleWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        VehiclesFactory vehiclesFactory = VehiclesFactoryImpl.getInstance();
        PartsFactory partsFactory = PartsFactoryImpl.getInstance();
        BattleOperator battleOperator = new PanzerBattleOperator();
        Manager manager = new ManagerImpl(vehiclesFactory, partsFactory, battleOperator);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        InputReader reader = new ConsoleReader(bufferedReader);
        OutputWriter writer = new ConsoleWriter();
        Runnable engine = new Engine(writer, reader, manager);

        engine.run();
    }
}
