package in.saeakgec.supra.service;

import in.saeakgec.supra.model.Race;
import in.saeakgec.supra.model.User;

import java.util.List;

public interface RaceService {
    List<Race> findRaceByAdminId();
    Race saveRaceByAdmin(Race race);
}
