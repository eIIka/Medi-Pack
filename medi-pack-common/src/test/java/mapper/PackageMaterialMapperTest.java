package mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ua.ellka.medipack.dto.PackageMaterialDTO;
import ua.ellka.medipack.mapper.PackageMaterialMapper;
import ua.ellka.medipack.model.PackageMaterial;

import static org.junit.jupiter.api.Assertions.*;
import static mapper.TestData.*;

class PackageMaterialMapperTest {
    private PackageMaterialMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(PackageMaterialMapper.class);
    }

    @Test
    void packageMaterialToPackageMaterialDTOTest() {
        PackageMaterialDTO packageMaterialDTO = mapper.packageMaterialToPackageMaterialDTO(PACKAGE_MATERIAL);

        assertNotNull(packageMaterialDTO);
        assertEquals(PACKAGE_MATERIAL.getId(), packageMaterialDTO.getId());
        assertEquals(PACKAGE_MATERIAL.getQuantity(), packageMaterialDTO.getQuantity());
        assertEquals(PACKAGE_MATERIAL.getSpecification(), packageMaterialDTO.getSpecification());
        assertEquals(PACKAGE_MATERIAL.getMedicalPackage().getId(), packageMaterialDTO.getMedicalPackageId());
        assertEquals(PACKAGE_MATERIAL.getMedicalMaterial().getId(), packageMaterialDTO.getMedicalMaterialId());
    }

    @Test
    void packageMaterialDTOToPackageMaterialTest() {
        PackageMaterial packageMaterial = mapper.packageMaterialDTOToPackageMaterial(PACKAGE_MATERIAL_DTO);

        assertNotNull(packageMaterial);
        assertEquals(PACKAGE_MATERIAL_DTO.getId(), packageMaterial.getId());
        assertEquals(PACKAGE_MATERIAL_DTO.getQuantity(), packageMaterial.getQuantity());
        assertEquals(PACKAGE_MATERIAL_DTO.getSpecification(), packageMaterial.getSpecification());
        assertEquals(PACKAGE_MATERIAL_DTO.getMedicalMaterialId(), packageMaterial.getMedicalMaterial().getId());
        assertEquals(PACKAGE_MATERIAL_DTO.getMedicalPackageId(), packageMaterial.getMedicalPackage().getId());
    }
}