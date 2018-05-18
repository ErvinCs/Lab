package ro.blooddonation.web.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.blooddonation.core.Domain.DCPMember;
import ro.blooddonation.web.Dto.DCPMemberDto;

@Component
public class DCPMemberConverter extends BaseConverter<DCPMember, DCPMemberDto>
{
    private static final Logger log = LoggerFactory.getLogger(DCPMember.class);

    @Override
    public DCPMember convertDtoToModel(DCPMemberDto dto)
    {
        DCPMember d = new DCPMember(

        );
        return d;
    }

    @Override
    public DCPMemberDto convertModelToDto(DCPMember dcpMember)
    {
        DCPMemberDto dcpMemberDto = new DCPMemberDto(

        );
        dcpMemberDto.setId(dcpMember.getId());
        return dcpMemberDto;
    }
}