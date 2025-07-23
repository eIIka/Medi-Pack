package ua.ellka.medipack.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(
        name = "medical_package",
        uniqueConstraints = @UniqueConstraint(columnNames = {"code", "context", "user_id"})
)
@EqualsAndHashCode(of = {"code", "context", "user"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String context;

    @OneToMany(mappedBy = "medicalPackage", cascade = CascadeType.ALL)
    private List<PackageMaterial> packageMaterials;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
