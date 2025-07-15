package ua.ellka.medipack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "package_material")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PackageMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private MedicalPackage medicalPackage;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private MedicalMaterial medicalMaterial;

    private Double quantity;
    private String specification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
