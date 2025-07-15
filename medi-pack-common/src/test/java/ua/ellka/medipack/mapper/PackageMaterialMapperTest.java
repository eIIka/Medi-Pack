package ua.ellka.medipack.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ellka.medipack.dto.PackageMaterialDTO;
import ua.ellka.medipack.dto.PackageMaterialShortDTO;
import ua.ellka.medipack.model.PackageMaterial;

import static org.junit.jupiter.api.Assertions.*;
import static ua.ellka.medipack.mapper.TestData.*;
import static ua.ellka.medipack.mapper.TestData.MEDICAL_MATERIAL_DTO;

class PackageMaterialMapperTest {
    private PackageMaterialMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = PackageMaterialMapper.INSTANCE;
    }

    @Test
    void packageMaterialToPackageMaterialDTOTest() {
        PackageMaterialDTO packageMaterialDTO = mapper.packageMaterialToPackageMaterialDTO(PACKAGE_MATERIAL);

        assertNotNull(packageMaterialDTO);
        assertEquals(PACKAGE_MATERIAL.getId(), packageMaterialDTO.getId());
        assertEquals(PACKAGE_MATERIAL.getQuantity(), packageMaterialDTO.getQuantity());
        assertEquals(PACKAGE_MATERIAL.getSpecification(), packageMaterialDTO.getSpecification());
        assertEquals(PACKAGE_MATERIAL.getUser().getId(), packageMaterialDTO.getUserId());
        assertEquals(PACKAGE_MATERIAL.getMedicalPackage().getId(), packageMaterialDTO.getMedicalPackageId());
        assertEquals(MEDICAL_MATERIAL.getName(), packageMaterialDTO.getMedicalMaterial().getName());
        assertEquals(MEDICAL_MATERIAL.getMeasurementUnit(), packageMaterialDTO.getMedicalMaterial().getMeasurementUnit());
    }

    @Test
    void packageMaterialDTOToPackageMaterialTest() {
        PackageMaterial packageMaterial = mapper.packageMaterialDTOToPackageMaterial(PACKAGE_MATERIAL_DTO);

        assertNotNull(packageMaterial);
        assertEquals(PACKAGE_MATERIAL_DTO.getId(), packageMaterial.getId());
        assertEquals(PACKAGE_MATERIAL_DTO.getQuantity(), packageMaterial.getQuantity());
        assertEquals(PACKAGE_MATERIAL_DTO.getSpecification(), packageMaterial.getSpecification());
        assertEquals(PACKAGE_MATERIAL_DTO.getUserId(), packageMaterial.getUser().getId());
        assertEquals(MEDICAL_MATERIAL_DTO.getName(), packageMaterial.getMedicalMaterial().getName());
        assertEquals(MEDICAL_MATERIAL_DTO.getMeasurementUnit(), packageMaterial.getMedicalMaterial().getMeasurementUnit());
        assertEquals(PACKAGE_MATERIAL_DTO.getMedicalPackageId(), packageMaterial.getMedicalPackage().getId());
    }

    @Test
    void packageMaterialToPackageMaterialShortDTOTest() {
        PackageMaterialShortDTO packageMaterialShortDTO = mapper.packageMaterialToPackageMaterialShortDTO(PACKAGE_MATERIAL);

        assertNotNull(packageMaterialShortDTO);
        assertEquals(PACKAGE_MATERIAL.getId(), packageMaterialShortDTO.getId());
        assertEquals(PACKAGE_MATERIAL.getQuantity(), packageMaterialShortDTO.getQuantity());
        assertEquals(PACKAGE_MATERIAL.getSpecification(), packageMaterialShortDTO.getSpecification());
        assertEquals(PACKAGE_MATERIAL.getUser().getId(), packageMaterialShortDTO.getUserId());
        assertEquals(PACKAGE_MATERIAL.getMedicalMaterial().getName(), packageMaterialShortDTO.getMaterialName());
        assertEquals(PACKAGE_MATERIAL.getMedicalMaterial().getMeasurementUnit(), packageMaterialShortDTO.getMeasurementUnit());
    }

    @Test
    void packageMaterialShortDTOToPackageMaterialTest() {
        PackageMaterial packageMaterial = mapper.packageMaterialShortDTOToPackageMaterial(PACKAGE_MATERIAL_SHORT_DTO);

        assertNotNull(packageMaterial);
        assertEquals(PACKAGE_MATERIAL_SHORT_DTO.getId(), packageMaterial.getId());
        assertEquals(PACKAGE_MATERIAL_SHORT_DTO.getQuantity(), packageMaterial.getQuantity());
        assertEquals(PACKAGE_MATERIAL_SHORT_DTO.getSpecification(), packageMaterial.getSpecification());
        assertEquals(PACKAGE_MATERIAL_SHORT_DTO.getUserId(), packageMaterial.getUser().getId());
        assertEquals(PACKAGE_MATERIAL_SHORT_DTO.getMaterialName(), packageMaterial.getMedicalMaterial().getName());
        assertEquals(PACKAGE_MATERIAL_SHORT_DTO.getMeasurementUnit(), packageMaterial.getMedicalMaterial().getMeasurementUnit());
    }
}