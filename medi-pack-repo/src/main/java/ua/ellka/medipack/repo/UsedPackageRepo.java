package ua.ellka.medipack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.ellka.medipack.model.UsedPackage;
import ua.ellka.medipack.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UsedPackageRepo extends JpaRepository<UsedPackage, Long> {

    @Query("""
            SELECT up FROM UsedPackage up
                WHERE up.usedDate > :from AND up.usedDate < :to
            """)
    List<UsedPackage> findByUserBetweenDates(User user, LocalDateTime from, LocalDateTime to);
}
