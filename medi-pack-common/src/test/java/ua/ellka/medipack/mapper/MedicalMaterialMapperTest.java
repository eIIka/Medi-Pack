package ua.ellka.medipack.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ellka.medipack.dto.MedicalMaterialDTO;
import ua.ellka.medipack.model.MedicalMaterial;

import static org.junit.jupiter.api.Assertions.*;
import static ua.ellka.medipack.mapper.TestData.*;

class MedicalMaterialMapperTest {
    private MedicalMaterialMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = MedicalMaterialMapper.INSTANCE;
    }

    @Test
    void toMedicalMaterialDTOTest() {
        MedicalMaterialDTO medicalMaterialDTO = mapper.medicalMaterialToMedicalMaterialDTO(MEDICAL_MATERIAL);

        assertNotNull(medicalMaterialDTO);
        assertEquals(MEDICAL_MATERIAL.getId(), medicalMaterialDTO.getId());
        assertEquals(MEDICAL_MATERIAL.getName(), medicalMaterialDTO.getName());
        assertEquals(MEDICAL_MATERIAL.getMeasurementUnit(), medicalMaterialDTO.getMeasurementUnit());
        assertEquals(MEDICAL_MATERIAL.getUser().getId(), medicalMaterialDTO.getUserId());
    }

    @Test
    void toMedicalMaterialTest() {
        MedicalMaterial medicalMaterial = mapper.medicalMaterialDTOToMedicalMaterial(MEDICAL_MATERIAL_DTO);

        assertNotNull(medicalMaterial);
        assertEquals(MEDICAL_MATERIAL_DTO.getId(), medicalMaterial.getId());
        assertEquals(MEDICAL_MATERIAL_DTO.getName(), medicalMaterial.getName());
        assertEquals(MEDICAL_MATERIAL_DTO.getMeasurementUnit(), medicalMaterial.getMeasurementUnit());
        assertEquals(MEDICAL_MATERIAL_DTO.getUserId(), medicalMaterial.getUser().getId());
    }
}