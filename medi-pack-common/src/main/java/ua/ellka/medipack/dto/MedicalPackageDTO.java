package ua.ellka.medipack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalPackageDTO {
    private Long id;
    private String code;
    private String context;
    private List<PackageMaterialDTO> packageMaterials;
}

