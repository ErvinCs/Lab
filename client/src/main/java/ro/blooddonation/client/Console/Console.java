package ro.blooddonation.client.Console;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ro.blooddonation.web.Dto.DoningCenterDto;
import ro.blooddonation.web.Dto.HospitalDto;

@Component
public class Console
{
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext("ro.blooddonation.client.Config");

    RestTemplate restTemplate = context.getBean(RestTemplate.class);

    public void run()
    {
        HospitalDto hDto = restTemplate.postForObject("http://localhost:8080/api/hospitals",
                new HospitalDto("TestAddress1"), HospitalDto.class);
        System.out.println(hDto.toString());

        DoningCenterDto dcDto = restTemplate.postForObject("http://localhost:8080/api/doningCenters",
                new DoningCenterDto("TestAddress2"), DoningCenterDto.class);
        System.out.println(dcDto.toString());
    }
}
