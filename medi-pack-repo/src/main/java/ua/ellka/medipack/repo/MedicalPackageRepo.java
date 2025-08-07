package ua.ellka.medipack.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.ellka.medipack.model.MedicalMaterial;
import ua.ellka.medipack.model.MedicalPackage;
import ua.ellka.medipack.model.User;

import java.util.List;
import java.util.Optional;

public interface MedicalPackageRepo extends JpaRepository<MedicalPackage, Long> {
    Optional<MedicalPackage> findByCodeAndContextAndUser(String code, String context, User user);
    boolean existsByCodeAndContextAndUser(String code, String context, User user);

    Optional<MedicalPackage> findByCodeAndUser(String code, User user);
    Optional<MedicalPackage> findByContextAndUser(String context, User user);

    Optional<MedicalPackage> findByIdAndUser(Long id, User user);
    Page<MedicalPackage> findByUser(User user, Pageable pageable);
    List<MedicalPackage> findByUser(User user);

    List<MedicalPackage> findByUserOrderByCodeAsc(User user);
    List<MedicalPackage> findByUserOrderByCodeDesc(User user);

    List<MedicalPackage> findByUserOrderByContextAsc(User user);
    List<MedicalPackage> findByUserOrderByContextDesc(User user);
}
