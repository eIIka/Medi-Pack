package ua.ellka.medipack.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.ellka.medipack.dto.UsedPackageDTO;
import ua.ellka.medipack.model.UsedPackage;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring",
        uses = {MedicalPackageMapper.class})
public interface UsedPackageMapper {
    UsedPackageDTO usedPackageToUsedPackageDTO(UsedPackage usedPackage);
    UsedPackage usedPackageDTOToUsedPackage(UsedPackageDTO usedPackageDTO);
}
