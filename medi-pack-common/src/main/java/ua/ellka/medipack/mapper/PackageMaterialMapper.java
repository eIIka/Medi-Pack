package ua.ellka.medipack.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ua.ellka.medipack.dto.MedicalMaterialDTO;
import ua.ellka.medipack.dto.PackageMaterialDTO;
import ua.ellka.medipack.dto.PackageMaterialShortDTO;
import ua.ellka.medipack.model.MedicalMaterial;
import ua.ellka.medipack.model.PackageMaterial;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PackageMaterialMapper {
    PackageMaterialMapper INSTANCE = Mappers.getMapper(PackageMaterialMapper.class);

    MedicalMaterialMapper MEDICAL_MATERIAL_MAPPER = Mappers.getMapper(MedicalMaterialMapper.class);

    @Mapping(source = "medicalPackage.id", target = "medicalPackageId")
    @Mapping(source = "medicalMaterial", target = "medicalMaterial", qualifiedByName = "medicalMaterialToDTO")
    @Mapping(source = "user.id", target = "userId")
    PackageMaterialDTO packageMaterialToPackageMaterialDTO(PackageMaterial packageMaterial);

    @Mapping(source = "medicalPackageId", target = "medicalPackage.id")
    @Mapping(source = "medicalMaterial", target = "medicalMaterial", qualifiedByName = "medicalMaterialDTOToEntity")
    @Mapping(source = "userId", target = "user.id")
    PackageMaterial packageMaterialDTOToPackageMaterial(PackageMaterialDTO packageMaterialDTO);

    @Mapping(source = "medicalMaterial.name", target = "materialName")
    @Mapping(source = "medicalMaterial.measurementUnit", target = "measurementUnit")
    @Mapping(source = "user.id", target = "userId")
    PackageMaterialShortDTO packageMaterialToPackageMaterialShortDTO(PackageMaterial packageMaterial);

    @Mapping(source = "materialName", target = "medicalMaterial.name")
    @Mapping(source = "measurementUnit", target = "medicalMaterial.measurementUnit")
    @Mapping(source = "userId", target = "user.id")
    PackageMaterial packageMaterialShortDTOToPackageMaterial(PackageMaterialShortDTO packageMaterialShortDTO);

    @Named("medicalMaterialToDTO")
    default MedicalMaterialDTO medicalMaterialToDTO(MedicalMaterial medicalMaterial) {
        return MEDICAL_MATERIAL_MAPPER.medicalMaterialToMedicalMaterialDTO(medicalMaterial);
    }

    @Named("medicalMaterialDTOToEntity")
    default MedicalMaterial medicalMaterialDTOToEntity(MedicalMaterialDTO medicalMaterialDTO) {
        return MEDICAL_MATERIAL_MAPPER.medicalMaterialDTOToMedicalMaterial(medicalMaterialDTO);
    }

}