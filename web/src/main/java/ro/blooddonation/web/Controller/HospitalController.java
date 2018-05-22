package ro.blooddonation.web.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.blooddonation.core.Domain.Hospital;
import ro.blooddonation.core.Service.HospitalService;
import ro.blooddonation.web.Converter.HospitalConverter;
import ro.blooddonation.web.Dto.EmptyJsonResponse;
import ro.blooddonation.web.Dto.HospitalDto;
import ro.blooddonation.web.Dto.HospitalsDto;

import java.util.*;

/**
 * 
 */
@RestController
public class HospitalController implements IController<HospitalDto, HospitalsDto>
{

    private static final Logger log = LoggerFactory.getLogger(HospitalController.class);

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private HospitalConverter hospitalConverter;



    @RequestMapping(value = "/hospitals", method = RequestMethod.POST)
    public HospitalDto add(@RequestBody final HospitalDto hospitalDto)
    {
        log.trace("addHospital: hospitalDtoMap={}", hospitalDto);

        Hospital hospital = new Hospital(hospitalDto.getAddress());
        hospital.setId(hospitalDto.getId());
        hospitalService.add(hospital);

        HospitalDto result = hospitalConverter.convertModelToDto(hospital);

        log.trace("addHospital: result={}", result);

        return result;
    }


    @RequestMapping(value = "hospitals/{id}", method = RequestMethod.DELETE)
    public ResponseEntity remove(@PathVariable final Long id)
    {
        log.trace("removeHospital: id={}", id);

        hospitalService.remove(id);

        log.trace("removeHospital - method end");

        return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
    }


    @RequestMapping(value = "/hospitals/{id}", method = RequestMethod.PUT)
    public HospitalDto update(@PathVariable final Long id,
                              @RequestBody final HospitalDto newHospitalDto) {
        log.trace("updateHospital: id={}, hospitalDtoMap={}", id, newHospitalDto);

        Hospital h = new Hospital(newHospitalDto.getAddress());

        h.setId(id);

        Optional<Hospital> hospital = hospitalService.update(id, h);

        Map<String, HospitalDto> result = new HashMap<>();
        if (hospital.isPresent())
            result.put("hospital", hospitalConverter.convertModelToDto(hospital.get()));
        else
            result.put("hospital", hospitalConverter.convertModelToDto(new Hospital()));

        log.trace("updateHospital: result={}", result);

        return result.get("hospital");
    }


    @RequestMapping(value = "/hospitals", method = RequestMethod.GET)
    public HospitalsDto getAll()
    {
        log.trace("getAllHospitals");

        List<Hospital> hospitals = hospitalService.findAll();

        log.trace("getAllHospitals: hospitals={}", hospitals);

        return new HospitalsDto(hospitalConverter.convertModelsToDtos(hospitals));
    }
}