package mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.springframework.test.util.ReflectionTestUtils;
import ua.ellka.medipack.dto.UsedPackageDTO;
import ua.ellka.medipack.mapper.MedicalPackageMapper;
import ua.ellka.medipack.mapper.PackageMaterialMapper;
import ua.ellka.medipack.mapper.UsedPackageMapper;
import ua.ellka.medipack.model.UsedPackage;

import static org.junit.jupiter.api.Assertions.*;
import static mapper.TestData.*;

class UsedPackageMapperTest {

    @InjectMocks
    private UsedPackageMapper mapper = Mappers.getMapper(UsedPackageMapper.class);

    @BeforeEach
    void setUp() {
        MedicalPackageMapper medicalPackageMapper = Mappers.getMapper(MedicalPackageMapper.class);
        ReflectionTestUtils.setField(mapper, "medicalPackageMapper", medicalPackageMapper);
        PackageMaterialMapper packageMaterialMapper = Mappers.getMapper(PackageMaterialMapper.class);
        ReflectionTestUtils.setField(medicalPackageMapper, "packageMaterialMapper", packageMaterialMapper);
    }

    @Test
    void toUsedPackageDTOTest() {
        UsedPackageDTO usedPackageDTO = mapper.usedPackageToUsedPackageDTO(USED_PACKAGE);

        assertNotNull(usedPackageDTO);
        assertEquals(USED_PACKAGE.getId(), usedPackageDTO.getId());
        assertEquals(USED_PACKAGE.getUsedDate(), usedPackageDTO.getUsedDate());
        assertEquals(USED_PACKAGE.getQuantityUsed(), usedPackageDTO.getQuantityUsed());
        assertEquals(USED_PACKAGE.getMedicalPackage().getId(), usedPackageDTO.getMedicalPackage().getId());
        assertEquals(USED_PACKAGE.getMedicalPackage().getCode(), usedPackageDTO.getMedicalPackage().getCode());
        assertEquals(USED_PACKAGE.getMedicalPackage().getContext(), usedPackageDTO.getMedicalPackage().getContext());
    }

    @Test
    void toUsedPackageTest() {
        UsedPackage usedPackage = mapper.usedPackageDTOToUsedPackage(USED_PACKAGE_DTO);

        assertNotNull(usedPackage);
        assertEquals(USED_PACKAGE_DTO.getId(), usedPackage.getId());
        assertEquals(USED_PACKAGE_DTO.getUsedDate(), usedPackage.getUsedDate());
        assertEquals(USED_PACKAGE_DTO.getQuantityUsed(), usedPackage.getQuantityUsed());
        assertEquals(USED_PACKAGE_DTO.getMedicalPackage().getId(), usedPackage.getMedicalPackage().getId());
        assertEquals(USED_PACKAGE_DTO.getMedicalPackage().getCode(), usedPackage.getMedicalPackage().getCode());
        assertEquals(USED_PACKAGE_DTO.getMedicalPackage().getContext(), usedPackage.getMedicalPackage().getContext());
    }
}
