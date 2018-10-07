package com.mindgray.cleanwheels.controller;

import com.mindgray.cleanwheels.constant.CwMessages;
import com.mindgray.cleanwheels.dto.requestDto.AddCleanerRequestDto;
import com.mindgray.cleanwheels.dto.responseDto.CleanerResponseDto;
import com.mindgray.cleanwheels.entity.Cleaner;
import com.mindgray.cleanwheels.response.ResponseBody;
import com.mindgray.cleanwheels.service.CleanerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CleanerController {

    @Autowired
    CleanerService cleanerService;

    @PostMapping(value = "/addCleaner")
    public ResponseBody addCleaner(@RequestBody AddCleanerRequestDto addCleanerRequestDto)
    {
       boolean isCleanerAdded = cleanerService.addCleaner(addCleanerRequestDto);
        if(isCleanerAdded)
            return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), null);
        else
            return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());
    }

    @GetMapping(value = "/getCleanerById")
    public ResponseBody getCleanerById(@RequestParam int id)
    {
      Cleaner cleaner =  cleanerService.getCleanerById(id);
        CleanerResponseDto cleanerResponseDto = new CleanerResponseDto(cleaner.getF_name(),cleaner.getL_name(),cleaner.getAddress(),cleaner.getMobile(),cleaner.getAlternateMobile(),cleaner.getAdhaar(),cleaner.getPan(),cleaner.getId(),cleaner.getLocation().getId());
        if(cleaner!=null )
            return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), cleanerResponseDto);
        else
            return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());
    }

    @GetMapping(value = "/getCleanerByLocation")
    public ResponseBody getCleanerByLocationId(@RequestParam int locationId)
    {
        List<Cleaner> cleaner =  cleanerService.getClanerByLocationId(locationId);
        if(cleaner!=null)
            return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), cleaner);
        else
            return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());
    }
}
