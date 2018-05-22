package ro.blooddonation.web.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.blooddonation.core.Domain.DCPMember;
import ro.blooddonation.web.Dto.DCPMemberDto;

@Component
public final class DCPMemberConverter extends BaseConverter<DCPMember, DCPMemberDto>
{
    private static final Logger log = LoggerFactory.getLogger(DCPMember.class);

    @Override
    public DCPMember convertDtoToModel(DCPMemberDto dto)
    {
        DoningCenterConverter dcConverter = new DoningCenterConverter();
        DCPMember dcpMember = new DCPMember(dto.getFirstName(), dto.getLastName(), dto.getbDay(),
                                    dto.getAddress(), dto.getResidence(), dto.getCNP(), null,
                                    dcConverter.convertDtoToModel(dto.getDoningCenter()));
        return dcpMember;
    }

    @Override
    public DCPMemberDto convertModelToDto(DCPMember dcpMember)
    {
        DoningCenterConverter dcConverter = new DoningCenterConverter();
        DCPMemberDto dcpMemberDto = new DCPMemberDto(dcpMember.getId(), dcpMember.getFirstName(), dcpMember.getLastName(),
                                    dcpMember.getbDay(), dcpMember.getAddress(), dcpMember.getResidence(),
                                    dcpMember.getCNP(), dcConverter.convertModelToDto(dcpMember.getDoningCenter()));
        return dcpMemberDto;
    }
}