package ro.blooddonation.web.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoningCenterDto extends BaseDto
{
    private DCPMemberDto dcpMember;
    private String address;

    public DoningCenterDto(String address) {
        super();
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DCPMemberDto getDcpMember() {
        return dcpMember;
    }

    public void setDcpMember(DCPMemberDto dcpMember) {
        this.dcpMember = dcpMember;
    }
}
