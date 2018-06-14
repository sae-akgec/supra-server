package in.saeakgec.supra.service.Impl;

import in.saeakgec.supra.model.JwtUser;
import in.saeakgec.supra.model.Race;
import in.saeakgec.supra.model.User;
import in.saeakgec.supra.repository.RaceRepository;
import in.saeakgec.supra.repository.UserRepository;
import in.saeakgec.supra.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("raceService")
public class RaceServiceImpl implements RaceService {

    @Autowired
    RaceRepository raceRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Race> findRaceByAdminId() {

        JwtUser jwtUser = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> user = userRepository.findById(jwtUser.getId());
        if (user.isPresent()){
            List<Race> races = (List<Race>) raceRepository.findAllByUser(user.get());
            return races;
        }
        return null;

    }

    @Override
    public Race saveRaceByAdmin(Race race) {
        JwtUser jwtUser = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> user = userRepository.findById(jwtUser.getId());
        if (user.isPresent()){
            System.out.println(user.get().getUsername());
            race.setUser(user.get());
        }
        race.setTime(new Date());
        race.setStatus("pending");
        return raceRepository.save(race);
    }

    @Override
    @Transactional
    public Race updateStatusByAdmin(int race) {
        raceRepository.updateStatus((long) race, "online");
        return getRace(race);
    }

    @Override
    public List<Race> allRacesOnline() {
        return (List<Race>) raceRepository.findAllByStatus("online");
    }

    @Override
    public Race getRace(int id) {
        return raceRepository.getOne((long) id);
    }
}
