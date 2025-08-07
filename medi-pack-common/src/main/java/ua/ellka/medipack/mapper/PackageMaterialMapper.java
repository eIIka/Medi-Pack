package ua.ellka.medipack.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ua.ellka.medipack.dto.PackageMaterialDTO;
import ua.ellka.medipack.model.PackageMaterial;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PackageMaterialMapper {
    @Mapping(source = "medicalPackage.id", target = "medicalPackageId")
    @Mapping(source = "medicalMaterial.id", target = "medicalMaterialId")
    PackageMaterialDTO packageMaterialToPackageMaterialDTO(PackageMaterial packageMaterial);

    @Mapping(source = "medicalPackageId", target = "medicalPackage.id")
    @Mapping(source = "medicalMaterialId", target = "medicalMaterial.id")
    PackageMaterial packageMaterialDTOToPackageMaterial(PackageMaterialDTO packageMaterialDTO);
}
