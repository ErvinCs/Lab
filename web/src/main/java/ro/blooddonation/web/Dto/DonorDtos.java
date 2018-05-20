package ro.blooddonation.web.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DonorDtos
{
    public Set<DonorDto> donors;

    public Set<DonorDto> getDonors() {
        return donors;
    }

    public void setDonors(Set<DonorDto> donors) {
        this.donors = donors;
    }
}
