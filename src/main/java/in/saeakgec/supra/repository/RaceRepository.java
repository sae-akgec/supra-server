package in.saeakgec.supra.repository;

import in.saeakgec.supra.model.Race;
import in.saeakgec.supra.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RaceRepository extends JpaRepository<Race, Long> {
    Iterable<Race> findAllByUser(User user);
    Iterable<Race> findAllByStatus(String status);

    @Modifying
    @Query("UPDATE Race race SET race.status = :status WHERE id=:id")
    void updateStatus(@Param("id") Long id, @Param("status") String status);
}
