package ua.ellka.medipack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ellka.medipack.model.MedicalPackage;
import ua.ellka.medipack.model.User;

import java.util.List;

public interface MedicalPackageRepo extends JpaRepository<MedicalPackage, Long> {
    List<MedicalPackage> findAllByUser(User user);
}
