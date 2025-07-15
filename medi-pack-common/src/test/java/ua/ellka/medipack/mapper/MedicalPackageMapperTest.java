package ua.ellka.medipack.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.ellka.medipack.dto.MedicalPackageDTO;
import ua.ellka.medipack.dto.PackageMaterialShortDTO;
import ua.ellka.medipack.model.MedicalMaterial;
import ua.ellka.medipack.model.MedicalPackage;
import ua.ellka.medipack.model.PackageMaterial;
import ua.ellka.medipack.model.User;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static ua.ellka.medipack.mapper.TestData.*;

class MedicalPackageMapperTest {
    private MedicalPackageMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = MedicalPackageMapper.INSTANCE;
    }

    @Test
    void toMedicalPackageDTOTest() {
        MedicalPackageDTO medicalPackageDTO = mapper.medicalPackageToMedicalPackageDTO(MEDICAL_PACKAGE);

        assertNotNull(medicalPackageDTO);
        assertEquals(MEDICAL_PACKAGE.getId(), medicalPackageDTO.getId());
        assertEquals(MEDICAL_PACKAGE.getCode(), medicalPackageDTO.getCode());
        assertEquals(MEDICAL_PACKAGE.getContext(), medicalPackageDTO.getContext());
        assertEquals(MEDICAL_PACKAGE.getUser().getId(), medicalPackageDTO.getUserId());
        assertEquals(MEDICAL_PACKAGE.getPackageMaterials().size(), medicalPackageDTO.getPackageMaterials().size());
    }

    @Test
    void toMedicalPackageTest() {
        MedicalPackage medicalPackage = mapper.medicalPackageDTOToMedicalPackage(MEDICAL_PACKAGE_DTO);

        assertNotNull(medicalPackage);
        assertEquals(MEDICAL_PACKAGE_DTO.getId(), medicalPackage.getId());
        assertEquals(MEDICAL_PACKAGE_DTO.getCode(), medicalPackage.getCode());
        assertEquals(MEDICAL_PACKAGE_DTO.getContext(), medicalPackage.getContext());
        assertEquals(MEDICAL_PACKAGE_DTO.getUserId(), medicalPackage.getUser().getId());
        assertEquals(MEDICAL_PACKAGE_DTO.getPackageMaterials().size(), medicalPackage.getPackageMaterials().size());
    }
}
