package ua.ellka.medipack.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ua.ellka.medipack.dto.MedicalPackageDTO;
import ua.ellka.medipack.dto.UsedPackageDTO;
import ua.ellka.medipack.model.MedicalPackage;
import ua.ellka.medipack.model.UsedPackage;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UsedPackageMapper {
    UsedPackageMapper INSTANCE = Mappers.getMapper(UsedPackageMapper.class);

    MedicalPackageMapper MEDICAL_PACKAGE_MAPPER = Mappers.getMapper(MedicalPackageMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "medicalPackage", target = "medicalPackage", qualifiedByName = "medicalPackageToDTO")
    UsedPackageDTO usedPackageToUsedPackageDTO(UsedPackage usedPackage);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "medicalPackage", target = "medicalPackage", qualifiedByName = "medicalPackageDTOToEntity")
    UsedPackage usedPackageDTOToUsedPackage(UsedPackageDTO usedPackageDTO);

    @Named("medicalPackageToDTO")
    default MedicalPackageDTO medicalPackageToDTO(MedicalPackage medicalPackage) {
        return MEDICAL_PACKAGE_MAPPER.medicalPackageToMedicalPackageDTO(medicalPackage);
    }

    @Named("medicalPackageDTOToEntity")
    default MedicalPackage medicalPackageDTOToEntity(MedicalPackageDTO medicalPackageDTO) {
        return MEDICAL_PACKAGE_MAPPER.medicalPackageDTOToMedicalPackage(medicalPackageDTO);
    }
}