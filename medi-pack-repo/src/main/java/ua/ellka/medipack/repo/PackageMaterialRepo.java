package ua.ellka.medipack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ellka.medipack.model.PackageMaterial;
import ua.ellka.medipack.model.User;

import java.util.List;

public interface PackageMaterialRepo extends JpaRepository<PackageMaterial, Long> {
    List<PackageMaterial> findAllByUser(User user);
}
