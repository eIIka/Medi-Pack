package mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.springframework.test.util.ReflectionTestUtils;
import ua.ellka.medipack.dto.MedicalPackageDTO;
import ua.ellka.medipack.mapper.MedicalPackageMapper;
import ua.ellka.medipack.mapper.PackageMaterialMapper;
import ua.ellka.medipack.model.MedicalPackage;

import static org.junit.jupiter.api.Assertions.*;
import static mapper.TestData.*;

class MedicalPackageMapperTest {

    @InjectMocks
    private MedicalPackageMapper mapper = Mappers.getMapper(MedicalPackageMapper.class);

    @BeforeEach
    void setUp() {
        PackageMaterialMapper packageMaterialMapper = Mappers.getMapper(PackageMaterialMapper.class);
        ReflectionTestUtils.setField(mapper, "packageMaterialMapper", packageMaterialMapper);
    }

    @Test
    void toMedicalPackageDTOTest() {
        MedicalPackageDTO medicalPackageDTO = mapper.medicalPackageToMedicalPackageDTO(MEDICAL_PACKAGE);

        assertNotNull(medicalPackageDTO);
        assertEquals(MEDICAL_PACKAGE.getId(), medicalPackageDTO.getId());
        assertEquals(MEDICAL_PACKAGE.getCode(), medicalPackageDTO.getCode());
        assertEquals(MEDICAL_PACKAGE.getContext(), medicalPackageDTO.getContext());
        assertEquals(MEDICAL_PACKAGE.getPackageMaterials().size(), medicalPackageDTO.getPackageMaterials().size());
    }

    @Test
    void toMedicalPackageTest() {
        MedicalPackage medicalPackage = mapper.medicalPackageDTOToMedicalPackage(MEDICAL_PACKAGE_DTO);

        assertNotNull(medicalPackage);
        assertEquals(MEDICAL_PACKAGE_DTO.getId(), medicalPackage.getId());
        assertEquals(MEDICAL_PACKAGE_DTO.getCode(), medicalPackage.getCode());
        assertEquals(MEDICAL_PACKAGE_DTO.getContext(), medicalPackage.getContext());
        assertEquals(MEDICAL_PACKAGE_DTO.getPackageMaterials().size(), medicalPackage.getPackageMaterials().size());
    }
}
