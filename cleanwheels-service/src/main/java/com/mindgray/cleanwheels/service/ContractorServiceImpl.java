package com.mindgray.cleanwheels.service;

import com.mindgray.cleanwheels.dto.requestDto.AddContarctorRequestDTO;
import com.mindgray.cleanwheels.dto.requestDto.GetContractorDTO;
import com.mindgray.cleanwheels.dto.requestDto.GetContractorRequestDTO;
import com.mindgray.cleanwheels.entity.Contractor;
import com.mindgray.cleanwheels.repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("ContractorService")
public class ContractorServiceImpl implements ContractorService {

    @Autowired
    ContractorRepository contractorRepository;

    @Override
    public boolean addContractor(AddContarctorRequestDTO addContarctorRequestDTO) {
        Contractor contractor = new Contractor();
        contractor.setLocation_id(addContarctorRequestDTO.getLocationId());
        contractor.setAddress(addContarctorRequestDTO.getAddress());
        contractor.setF_name(addContarctorRequestDTO.getF_name());
        contractor.setL_name(addContarctorRequestDTO.getL_name());
        contractor.setAlternateMobile(addContarctorRequestDTO.getAlt_mobile());
        contractor.setEmail(addContarctorRequestDTO.getEmail());
        contractor.setMobile(addContarctorRequestDTO.getMobile());
        contractor.setBank(addContarctorRequestDTO.getBank());
        contractor.setBankAccount(addContarctorRequestDTO.getBankAccount());
        contractor.setBankIfsc(addContarctorRequestDTO.getIsfc());
        contractor.setStatus(addContarctorRequestDTO.getStatus());
        contractor.setLoadStatus(addContarctorRequestDTO.getLoadStaus());

        Contractor savedContractor = contractorRepository.save(contractor);
        if (savedContractor != null)
            return true;
        else
            return false;
    }

    @Override
    public GetContractorDTO getContractor(GetContractorRequestDTO getContractorRequestDTODTO) {
        Contractor contractor = contractorRepository.findContractorById(getContractorRequestDTODTO.getContractorId());
        if (contractor != null) {
            return new GetContractorDTO(contractor.getAddress(), contractor.getF_name(), contractor.getL_name(), contractor.getEmail(), contractor.getMobile(), contractor.getAlternateMobile(), contractor.getStatus(), contractor.getLoadStatus(), contractor.getId(),contractor.getLocation_id());
        } else
            return null;
    }

    @Override
    public List<Contractor> getAllContractor() {

        return contractorRepository.findAll();
    }
}
