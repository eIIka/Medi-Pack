package ua.ellka.medipack.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.ellka.medipack.dto.MedicalPackageDTO;
import ua.ellka.medipack.model.MedicalPackage;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring",
        uses = {PackageMaterialMapper.class})
public interface MedicalPackageMapper {
    MedicalPackageDTO medicalPackageToMedicalPackageDTO(MedicalPackage medicalPackage);
    MedicalPackage medicalPackageDTOToMedicalPackage(MedicalPackageDTO medicalPackageDTO);
}
