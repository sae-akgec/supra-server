package in.saeakgec.supra.repository;

import in.saeakgec.supra.model.Race;
import in.saeakgec.supra.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RaceRepository extends JpaRepository<Race, Long> {
    Iterable<Race> findAllByUser(User user);
}
