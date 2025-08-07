package ua.ellka.medipack.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalMaterialDTO {
    private Long id;
    private String name;
    private String measurementUnit;
}

