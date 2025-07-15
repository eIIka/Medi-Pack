package ua.ellka.medipack.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "used_packages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsedPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private MedicalPackage medicalPackage;

    private Long quantityUsed;

    private LocalDate usedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

