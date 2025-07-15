package ua.ellka.medipack.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ua.ellka.medipack.dto.MedicalMaterialDTO;
import ua.ellka.medipack.model.MedicalMaterial;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MedicalMaterialMapper {
    MedicalMaterialMapper INSTANCE = Mappers.getMapper(MedicalMaterialMapper.class);

    @Mapping(source = "user.id", target = "userId")
    MedicalMaterialDTO medicalMaterialToMedicalMaterialDTO(MedicalMaterial medicalMaterial);

    @Mapping(source = "userId", target = "user.id")
    MedicalMaterial medicalMaterialDTOToMedicalMaterial(MedicalMaterialDTO medicalMaterialDTO);
}
