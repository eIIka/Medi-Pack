package ua.ellka.medipack.model;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
