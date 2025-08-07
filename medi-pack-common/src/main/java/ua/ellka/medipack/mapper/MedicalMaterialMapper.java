package ua.ellka.medipack.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.ellka.medipack.dto.MedicalMaterialDTO;
import ua.ellka.medipack.model.MedicalMaterial;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MedicalMaterialMapper {
    MedicalMaterialDTO medicalMaterialToMedicalMaterialDTO(MedicalMaterial medicalMaterial);
    MedicalMaterial medicalMaterialDTOToMedicalMaterial(MedicalMaterialDTO medicalMaterialDTO);
}
