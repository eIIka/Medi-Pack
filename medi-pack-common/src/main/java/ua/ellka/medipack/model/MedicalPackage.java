package ua.ellka.medipack.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "medical_package")
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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
