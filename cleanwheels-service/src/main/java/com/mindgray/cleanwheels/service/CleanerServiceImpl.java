package com.mindgray.cleanwheels.service;

import com.mindgray.cleanwheels.dto.requestDto.AddCleanerRequestDto;
import com.mindgray.cleanwheels.entity.Cleaner;
import com.mindgray.cleanwheels.entity.Location;
import com.mindgray.cleanwheels.repository.CleanerRepository;
import com.mindgray.cleanwheels.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CleanerService")
public class CleanerServiceImpl implements CleanerService {
    @Autowired
    CleanerRepository cleanerRepository;

    @Autowired
    LocationRepository locationRepository;

    @Override
    public boolean addCleaner(AddCleanerRequestDto addCleanerRequestDto) {
        Location locationId = locationRepository.getOne(addCleanerRequestDto.getLocationid());
        Cleaner cleaner = cleanerRepository.save(new Cleaner(addCleanerRequestDto.getAddress(), addCleanerRequestDto.getAadhar(), addCleanerRequestDto.getAlt_mobile(), addCleanerRequestDto.getMobile(), addCleanerRequestDto.getF_name(), addCleanerRequestDto.getL_name(), addCleanerRequestDto.getPan(), locationId));
        if (cleaner != null)
            return true;
        else
            return false;

    }

    @Override
    public Cleaner getCleanerById(int id) {
        return cleanerRepository.getOne(id);
    }

    @Override
    public List<Cleaner> getClanerByLocationId(int locationId) {
        return cleanerRepository.findCleanerByLocationId(locationId);
    }

    @Override
    public boolean removeCleaner(int id) {
        return false;
    }
}
