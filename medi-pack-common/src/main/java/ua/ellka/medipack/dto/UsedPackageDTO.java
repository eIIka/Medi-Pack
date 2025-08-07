package ua.ellka.medipack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsedPackageDTO {
    private Long id;
    private MedicalPackageDTO medicalPackage;
    private Long quantityUsed;
    private LocalDate usedDate;
}
