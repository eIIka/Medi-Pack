package ua.ellka.medipack.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.ellka.medipack.model.MedicalMaterial;
import ua.ellka.medipack.model.MedicalPackage;
import ua.ellka.medipack.model.PackageMaterial;
import ua.ellka.medipack.model.User;

import java.util.List;
import java.util.Optional;

public interface PackageMaterialRepo extends JpaRepository<PackageMaterial, Long> {
    Optional<PackageMaterial> findByIdAndUser(Long id, User user);
    List<PackageMaterial> findByUser(User user);
    Page<PackageMaterial> findByUser(User user, Pageable pageable);

    List<PackageMaterial> findByMedicalPackageAndUser(MedicalPackage medicalPackage, User user);
    Page<PackageMaterial> findByMedicalPackageAndUser(MedicalPackage medicalPackage, User user, Pageable pageable);

    List<PackageMaterial> findByMedicalMaterialAndUser(MedicalMaterial medicalMaterial, User user);
    Page<PackageMaterial> findByMedicalMaterialAndUser(MedicalMaterial medicalMaterial, User user, Pageable pageable);

    Optional<PackageMaterial> findByMedicalPackageAndMedicalMaterialAndUser(
            MedicalPackage medicalPackage,
            MedicalMaterial medicalMaterial,
            User user
    );
}
