package ro.blooddonation.web.Dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public abstract class BaseDto implements Serializable {
    private Long id;

    public BaseDto(Long id) {
        this.id = id;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long value)
    {
        this.id = value;
    }
}
