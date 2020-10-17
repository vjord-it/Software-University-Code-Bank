package ExamPreparation02.Resources.solution.nfs.entities.races.normalRaces;

import ExamPreparation02.Resources.solution.nfs.entities.cars.Car;
import ExamPreparation02.Resources.solution.nfs.utilities.Constants;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DragRace extends NormalRace {
    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public void start() {
        int count = 0;

        LinkedHashMap<Integer, Car> orderedParticipants = this.getParticipants()
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getEnginePerformance(), e1.getValue().getEnginePerformance()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x1, x2) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));

        for (Map.Entry<Integer, Car> winner : orderedParticipants.entrySet()) {

            if (count == Constants.DRAG_RACE_MAXIMUM_WINNERS) {
                break;
            }

            this.addWinner(winner.getValue());
            count++;
        }
    }

    @Override
    protected String getWinningStats() {
        StringBuilder result = new StringBuilder();

        int count = 1;

        for (Car car : this.getWinners()) {
            int prize = this.getPrize(count);

            result.append(String.format("%d. %s %s %dPP - $%d\r\n", count, car.getBrand(), car.getModel(), car.getEnginePerformance(), prize));
            count++;
        }

        return result.toString().trim();
    }
}
