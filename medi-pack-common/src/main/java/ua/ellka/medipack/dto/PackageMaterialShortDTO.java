package ua.ellka.medipack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PackageMaterialShortDTO {
    private Long id;
    private String materialName;
    private String measurementUnit;
    private Double quantity;
    private String specification;
    private Long userId;
}

