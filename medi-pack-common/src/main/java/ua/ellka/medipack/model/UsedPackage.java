package ua.ellka.medipack.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "used_package")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsedPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medical_package_id")
    private MedicalPackage medicalPackage;

    @Column(name = "quantity_used")
    private Long quantityUsed;

    @Column(name = "used_date")
    private LocalDate usedDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

