package ExamPreparation01.Resources.solution.avatar;

import ExamPreparation01.Resources.solution.avatar.benders.AirBender;
import ExamPreparation01.Resources.solution.avatar.benders.EarthBender;
import ExamPreparation01.Resources.solution.avatar.benders.FireBender;
import ExamPreparation01.Resources.solution.avatar.benders.WaterBender;
import ExamPreparation01.Resources.solution.avatar.monuments.AirMonument;
import ExamPreparation01.Resources.solution.avatar.monuments.EarthMonument;
import ExamPreparation01.Resources.solution.avatar.monuments.FireMonument;
import ExamPreparation01.Resources.solution.avatar.monuments.WaterMonument;

final class Factory {

    static void createBender(String type, String name, int power, double secPar) {
        switch (type) {
        case "Air":
            Controller.getAirNation().addBender(new AirBender(name, power, secPar));
            break;
        case "Water":
            Controller.getWaterNation().addBender(new WaterBender(name, power, secPar));
            break;
        case "Fire":
            Controller.getFireNation().addBender(new FireBender(name, power, secPar));
            break;
        case "Earth":
            Controller.getEarthNation().addBender(new EarthBender(name, power, secPar));
            break;
        default:
            break;
        }
    }

    static void createMonument(String type, String name, int affinity) {
        switch (type) {
        case "Air":
            Controller.getAirNation().addMonument(new AirMonument(name, affinity));
            break;
        case "Water":
            Controller.getWaterNation().addMonument(new WaterMonument(name, affinity));
            break;
        case "Fire":
            Controller.getFireNation().addMonument(new FireMonument(name, affinity));
            break;
        case "Earth":
            Controller.getEarthNation().addMonument(new EarthMonument(name, affinity));
            break;
        default:
            break;
        }
    }
}
