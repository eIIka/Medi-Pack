package ua.ellka.medipack.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "medical_material",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name", "measurement_unit", "user_id"})
)
@EqualsAndHashCode(of = {"name", "measurementUnit", "user"})
public class MedicalMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "measurement_unit")
    private String measurementUnit;

    @OneToMany(mappedBy = "medicalMaterial", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PackageMaterial> packageMaterials = new ArrayList<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
