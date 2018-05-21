package ro.blooddonation.web.Dto;

import lombok.*;


@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
public class HospitalDto extends BaseDto {
    private String address;

    public HospitalDto(String address){
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Hospital{id=" + this.getId() + "; " + address.toString() + "}";
    }
}
