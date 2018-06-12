package in.saeakgec.supra.controller.rest;

import in.saeakgec.supra.model.Race;
import in.saeakgec.supra.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/races")
public class RaceRestController {

    @Autowired
    RaceService raceService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public List<Race> racesForAdmin(){
        return raceService.findRaceByAdminId();
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public Race saveRaceByAdmin(@RequestBody Race race){
        return raceService.saveRaceByAdmin(race);
    }


}
