package com.mindgray.cleanwheels.service;

import com.mindgray.cleanwheels.dto.requestDto.AddCleanerRequestDto;
import com.mindgray.cleanwheels.entity.Cleaner;

import java.util.List;

public interface CleanerService {

   boolean addCleaner(AddCleanerRequestDto addCleanerRequestDto);
   Cleaner getCleanerById(int id);
   List<Cleaner> getClanerByLocationId(int locationId);
   boolean removeCleaner(int id);
}
