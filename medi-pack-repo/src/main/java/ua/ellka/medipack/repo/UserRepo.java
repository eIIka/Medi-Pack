package ua.ellka.medipack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ellka.medipack.model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
