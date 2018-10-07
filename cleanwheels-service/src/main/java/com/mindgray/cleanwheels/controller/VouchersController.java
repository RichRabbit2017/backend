package com.mindgray.cleanwheels.controller;

import com.mindgray.cleanwheels.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class VouchersController {

    @Autowired
    VoucherService voucherService;
}
