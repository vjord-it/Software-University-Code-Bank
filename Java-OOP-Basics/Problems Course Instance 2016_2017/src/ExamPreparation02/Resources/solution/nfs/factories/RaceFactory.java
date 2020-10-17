package ExamPreparation02.Resources.solution.nfs.factories;

import ExamPreparation02.Resources.solution.nfs.entities.races.normalRaces.CasualRace;
import ExamPreparation02.Resources.solution.nfs.entities.races.normalRaces.CircuitRace;
import ExamPreparation02.Resources.solution.nfs.entities.races.normalRaces.DragRace;
import ExamPreparation02.Resources.solution.nfs.entities.races.normalRaces.DriftRace;
import ExamPreparation02.Resources.solution.nfs.entities.races.specialRaces.TimeLimitRace;

public final class RaceFactory {
    private RaceFactory() {
    }

    public static CasualRace makeCasualRace(int length, String route, int prizePool) {
        return new CasualRace(length, route, prizePool);
    }

    public static DragRace makeDragRace(int length, String route, int prizePool) {
        return new DragRace(length, route, prizePool);
    }

    public static DriftRace makeDriftRace(int length, String route, int prizePool) {
        return new DriftRace(length, route, prizePool);
    }

    public static TimeLimitRace makeTimeLimitRace(int length, String route, int prizePool, int goldTime) {
        return new TimeLimitRace(length, route, prizePool, goldTime);
    }

    public static CircuitRace makeCircuitRace(int length, String route, int prizePool, int laps) {
        return new CircuitRace(length, route, prizePool, laps);
    }
}
