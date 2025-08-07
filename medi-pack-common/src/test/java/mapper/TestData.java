package mapper;

import ua.ellka.medipack.dto.*;
import ua.ellka.medipack.model.*;

import java.time.LocalDate;
import java.util.List;

public class TestData {
    // USER
    public static final Long USER_ID = 1L;
    public static final String EMAIL = "test@email.com";
    public static final String PASSWORD = "testpassword";
    public static final String FIRST_NAME = "testfirstname";
    public static final String LAST_NAME = "testlastname";

    public static final User USER = new User(
            USER_ID, EMAIL, PASSWORD, "USER_ROLE", FIRST_NAME, LAST_NAME,
            null, null, null, null);
    public static final UserDTO USER_DTO = new UserDTO(USER_ID, EMAIL, FIRST_NAME, LAST_NAME);

    // MEDICAL MATERIAL
    public static final String MATERIAL_NAME = "testmaterialname";
    public static final String MEASUREMENT_UNIT = "ml";

    public static final MedicalMaterial MEDICAL_MATERIAL = new MedicalMaterial(
            10L, MATERIAL_NAME, MEASUREMENT_UNIT, List.of(),USER);
    public static final MedicalMaterialDTO MEDICAL_MATERIAL_DTO = new MedicalMaterialDTO(
            10L, MATERIAL_NAME, MEASUREMENT_UNIT);

    // MEDICAL PACKAGE
    public static final Double QUANTITY = 2.5;
    public static final String SPECIFICATION = "5.0";

    public static final MedicalPackage MEDICAL_PACKAGE = createMedicalPackage();

    // PACKAGE MATERIAL
    public static final String CODE = "testcode";
    public static final String CONTEXT = "testcontext";

    public static final PackageMaterial PACKAGE_MATERIAL = createPackageMaterial(MEDICAL_PACKAGE);
    public static final PackageMaterialDTO PACKAGE_MATERIAL_DTO = new PackageMaterialDTO(
            20L, MEDICAL_PACKAGE.getId(), MEDICAL_MATERIAL.getId(), QUANTITY, SPECIFICATION);

    // MEDICAL PACKAGE
    public static final MedicalPackageDTO MEDICAL_PACKAGE_DTO = new MedicalPackageDTO(
            100L, CODE, CONTEXT, List.of(PACKAGE_MATERIAL_DTO));

    // USED PACKAGE
    public static final Long QUANTITY_USED = 10L;
    public static final LocalDate DATE = LocalDate.of(2025, 7, 1);

    public static final UsedPackage USED_PACKAGE = new UsedPackage(
            500L, createMedicalPackage(), QUANTITY_USED, DATE, USER);
    public static final UsedPackageDTO USED_PACKAGE_DTO = new UsedPackageDTO(
            500L, MEDICAL_PACKAGE_DTO, QUANTITY_USED, DATE);


    private static MedicalPackage createMedicalPackage() {
        MedicalPackage medicalPackage = new MedicalPackage();
        medicalPackage.setId(100L);
        medicalPackage.setCode(CODE);
        medicalPackage.setContext(CONTEXT);
        medicalPackage.setUser(USER);

        PackageMaterial packageMaterial = createPackageMaterial(medicalPackage);
        medicalPackage.setPackageMaterials(List.of(packageMaterial));

        return medicalPackage;
    }

    private static PackageMaterial createPackageMaterial(MedicalPackage pack) {
        return new PackageMaterial(
                20L, pack, MEDICAL_MATERIAL,
                QUANTITY, SPECIFICATION, USER
        );
    }
}
