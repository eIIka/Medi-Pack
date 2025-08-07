package ua.ellka.medipack.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.ellka.medipack.model.MedicalPackage;
import ua.ellka.medipack.model.UsedPackage;
import ua.ellka.medipack.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UsedPackageRepo extends JpaRepository<UsedPackage, Long> {
    Optional<UsedPackage> findByIdAndUser(Long id, User user);
    List<UsedPackage> findByUser(User user);
    Page<UsedPackage> findByUser(User user, Pageable pageable);

    List<UsedPackage> findByMedicalPackageAndUser(MedicalPackage medicalPackage, User user);
    Page<UsedPackage> findByMedicalPackageAndUser(MedicalPackage medicalPackage, User user, Pageable pageable);

    List<UsedPackage> findByUsedDateAndUser(LocalDate usedDate, User user);
    List<UsedPackage> findByUsedDateBetweenAndUser(LocalDate startDate, LocalDate endDate, User user);
    Page<UsedPackage> findByUsedDateBetweenAndUser(LocalDate startDate, LocalDate endDate, User user, Pageable pageable);

    List<UsedPackage> findByQuantityUsedGreaterThanAndUser(Long quantity, User user);
    List<UsedPackage> findByQuantityUsedLessThanAndUser(Long quantity, User user);

    List<UsedPackage> findByUserOrderByUsedDateAsc(User user);
    List<UsedPackage> findByUserOrderByUsedDateDesc(User user);

    List<UsedPackage> findByMedicalPackageAndUserOrderByUsedDateAsc(MedicalPackage medicalPackage, User user);
    List<UsedPackage> findByMedicalPackageAndUserOrderByUsedDateDesc(MedicalPackage medicalPackage, User user);

    List<UsedPackage> findByMedicalPackageAndUsedDateBetweenAndUser(
            MedicalPackage medicalPackage,
            LocalDate startDate,
            LocalDate endDate,
            User user
    );

}
