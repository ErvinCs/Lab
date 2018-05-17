package ro.blooddonation.web.Dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HospitalsDto
{
    private Set<HospitalDto> hospitals;
}
