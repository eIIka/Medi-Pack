package ua.ellka.medipack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private Set<MedicalMaterial> medicalMaterials;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private Set<MedicalPackage> medicalPackages;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private Set<PackageMaterial> packageMaterials;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private Set<UsedPackage> usedPackages;
}
