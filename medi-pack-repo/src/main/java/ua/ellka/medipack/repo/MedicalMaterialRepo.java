package ua.ellka.medipack.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.ellka.medipack.model.MedicalMaterial;
import ua.ellka.medipack.model.User;

import java.util.List;
import java.util.Optional;

public interface MedicalMaterialRepo extends JpaRepository<MedicalMaterial, Long> {
    List<MedicalMaterial> findAllByUser(User user);
    Page<MedicalMaterial> findAllByUser(User user, Pageable pageable);
    Optional<MedicalMaterial> findByName(String name);
}
