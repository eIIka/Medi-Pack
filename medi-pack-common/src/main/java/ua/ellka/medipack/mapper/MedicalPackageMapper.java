package ua.ellka.medipack.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ua.ellka.medipack.dto.MedicalPackageDTO;
import ua.ellka.medipack.dto.PackageMaterialShortDTO;
import ua.ellka.medipack.model.MedicalPackage;
import ua.ellka.medipack.model.PackageMaterial;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MedicalPackageMapper {
    MedicalPackageMapper INSTANCE = Mappers.getMapper(MedicalPackageMapper.class);

    PackageMaterialMapper PACKAGE_MATERIAL_MAPPER = Mappers.getMapper(PackageMaterialMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "packageMaterials", target = "packageMaterials", qualifiedByName = "packageMaterialToPackageMaterialShortDTOs")
    MedicalPackageDTO medicalPackageToMedicalPackageDTO(MedicalPackage medicalPackage);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "packageMaterials", target = "packageMaterials", qualifiedByName = "packageMaterialShortDTOsToPackageMaterial")
    MedicalPackage medicalPackageDTOToMedicalPackage(MedicalPackageDTO medicalPackageDTO);

    @Named("packageMaterialToPackageMaterialShortDTOs")
    default List<PackageMaterialShortDTO> packageMaterialToPackageMaterialShortDTOs(List<PackageMaterial> packageMaterials) {
        return packageMaterials.stream()
                .map(PACKAGE_MATERIAL_MAPPER::packageMaterialToPackageMaterialShortDTO)
                .toList();
    }

    @Named("packageMaterialShortDTOsToPackageMaterial")
    default List<PackageMaterial> packageMaterialShortDTOsToPackageMaterial(List<PackageMaterialShortDTO> packageMaterialShortDTOs) {
        return packageMaterialShortDTOs.stream()
                .map(PACKAGE_MATERIAL_MAPPER::packageMaterialShortDTOToPackageMaterial)
                .toList();
    }

}
