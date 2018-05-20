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
public class RequestsDto
{
    public Set<RequestDto> requests;

    public Set<RequestDto> getRequests() {
        return requests;
    }

    public void setRequests(Set<RequestDto> requests) {
        this.requests = requests;
    }
}
