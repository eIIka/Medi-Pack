package ua.ellka.medipack.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ellka.medipack.dto.UsedPackageDTO;
import ua.ellka.medipack.model.MedicalPackage;
import ua.ellka.medipack.model.UsedPackage;

import static org.junit.jupiter.api.Assertions.*;
import static ua.ellka.medipack.mapper.TestData.*;

class UsedPackageMapperTest {
    private UsedPackageMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = UsedPackageMapper.INSTANCE;
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
        assertEquals(USED_PACKAGE.getUser().getId(), usedPackageDTO.getUserId());
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
        assertEquals(USED_PACKAGE_DTO.getUserId(), usedPackage.getUser().getId());
    }
}
