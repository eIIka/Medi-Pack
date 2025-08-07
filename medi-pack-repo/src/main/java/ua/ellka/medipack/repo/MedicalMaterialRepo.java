package ua.ellka.medipack.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.ellka.medipack.model.MedicalMaterial;
import ua.ellka.medipack.model.MedicalPackage;
import ua.ellka.medipack.model.User;

import java.util.List;
import java.util.Optional;

public interface MedicalMaterialRepo extends JpaRepository<MedicalMaterial, Long> {
    Optional<MedicalMaterial> findByNameAndMeasurementUnitAndUser(String name, String measurementUnit, User user);
    boolean existsByNameAndMeasurementUnitAndUser(String name, String measurementUnit, User user);

    Optional<MedicalMaterial> findByNameAndUser(String name, User user);
    Page<MedicalMaterial> findByMeasurementUnitAndUser(String measurementUnit, User user, Pageable pageable);

    Optional<MedicalMaterial> findByIdAndUser(Long id, User user);
    Page<MedicalMaterial> findByUser(User user, Pageable pageable);
    List<MedicalMaterial> findByUser(User user);

    List<MedicalMaterial> findByPackageMaterials_MedicalPackageAndUser(MedicalPackage medicalPackage, User user);

    List<MedicalMaterial> findByUserOrderByNameAsc(User user);
    List<MedicalMaterial> findByUserOrderByNameDesc(User user);
}
