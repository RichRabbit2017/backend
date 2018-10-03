package com.mindgray.cleanwheels.service;

import com.mindgray.cleanwheels.dto.requestDto.AddContarctorRequestDTO;
import com.mindgray.cleanwheels.dto.requestDto.GetContractorDTO;
import com.mindgray.cleanwheels.dto.requestDto.GetContractorRequestDTO;
import com.mindgray.cleanwheels.entity.Contractor;

import java.util.List;

public interface ContractorService {

    boolean addContractor(AddContarctorRequestDTO addContractorDTO);
    GetContractorDTO getContractor(GetContractorRequestDTO getContractorRequestDTO);
    List<Contractor> getAllContractor();
}
