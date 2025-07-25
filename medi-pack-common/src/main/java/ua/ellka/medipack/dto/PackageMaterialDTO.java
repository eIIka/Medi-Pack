package ua.ellka.medipack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PackageMaterialDTO {
    private Long id;
    private Long medicalPackageId;
    private MedicalMaterialDTO medicalMaterial;
    private Double quantity;
    private String specification;
    private Long userId;
}