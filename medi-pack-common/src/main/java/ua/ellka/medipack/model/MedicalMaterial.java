package ua.ellka.medipack.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medical_material")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"name", "measurementUnit", "user"})
public class MedicalMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String measurementUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
