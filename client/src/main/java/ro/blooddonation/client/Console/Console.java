package ro.blooddonation.client.Console;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ro.blooddonation.core.Domain.BloodEnum;
import ro.blooddonation.core.Domain.DiseasesEnum;
import ro.blooddonation.web.Dto.*;

import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;

@Component
public class Console
{
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext("ro.blooddonation.client.Config");

    RestTemplate restTemplate = context.getBean(RestTemplate.class);

    public void run()
    {
//        HospitalDto hDto = restTemplate.postForObject("http://localhost:8080/api/hospitals",
//                new HospitalDto("TestAddress1"), HospitalDto.class);
//        System.out.println(hDto.toString());
//
//        DoningCenterDto dcDto = restTemplate.postForObject("http://localhost:8080/api/doningCenters",
//                new DoningCenterDto("TestAddress2"), DoningCenterDto.class);
//        System.out.println(dcDto.toString());
//
        HospitalsDto hDtos = restTemplate.getForObject("http://localhost:8080/api/hospitals", HospitalsDto.class);
        hDtos.hospitals
                .forEach(System.out::println);

        Long cnp = Long.valueOf("19711120000000");
        LocalDate bday = LocalDate.of(2005, 10, 10);
        DoctorDto dDto = restTemplate.postForObject("http://localhost:8080/api/doctors",

                new DoctorDto(Long.getLong("1"),"firstName", "lastName", bday, "address", "residence", cnp, hDtos.hospitals.iterator().next()),
                DoctorDto.class);
        DoctorsDto dddDto = restTemplate.getForObject("http://localhost:8080/api/doctors", DoctorsDto.class);
        dddDto.doctors
                .forEach(System.out::println);
    }
}
