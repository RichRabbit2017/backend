package com.mindgray.cleanwheels.controller;

import antlr.collections.List;
import com.mindgray.cleanwheels.constant.CwMessages;
import com.mindgray.cleanwheels.dto.requestDto.AddContarctorRequestDTO;
import com.mindgray.cleanwheels.dto.requestDto.GetContractorDTO;
import com.mindgray.cleanwheels.dto.requestDto.GetContractorRequestDTO;
import com.mindgray.cleanwheels.entity.Contractor;
import com.mindgray.cleanwheels.response.ResponseBody;
import com.mindgray.cleanwheels.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ContractorController {

    @Autowired
    ContractorService contractorService;

    @PostMapping(value = "/addConractor")
    public ResponseBody addContrator(@RequestBody AddContarctorRequestDTO addContarctorRequestDTO) {
       boolean isContractorAdded = contractorService.addContractor(addContarctorRequestDTO);
        if (isContractorAdded )
            return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), null);
        else
           return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());
    }

    @PostMapping(value = "/getContractor")
    public ResponseBody getContrator(@RequestBody GetContractorRequestDTO getContractorRequestDTO) {
        GetContractorDTO contractorDTO = contractorService.getContractor(getContractorRequestDTO);
        if (contractorDTO!=null )
           return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), contractorDTO);
        else
            return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());
    }

    @GetMapping(value = "/getAllContractor")
    public ResponseBody getAllContractor()
    {
       java.util.List<Contractor> contractorList = contractorService.getAllContractor();
       if(contractorList!=null)
               return new ResponseBody(true, CwMessages.SUCCESS.code(), CwMessages.SUCCESS.message(), contractorList);
       else
           return new ResponseBody(false, CwMessages.FAILED.code(), CwMessages.FAILED.message());
    }
}
