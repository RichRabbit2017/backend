package com.mindgray.cleanwheels.service;

import com.mindgray.cleanwheels.entity.Vouchers;
import com.mindgray.cleanwheels.repository.VouchersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("VoucherService")
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    VouchersRepository vouchersRepository;

    @Override
    public boolean addVouchers() {
        return false;
    }

    @Override
    public Vouchers validateVouchers(int id) {
        return null;
    }

    @Override
    public Vouchers getVouchers(String code) {
        return null;
    }

    @Override
    public boolean redeemVouchers(int id) {
        return false;
    }

    @Override
    public Vouchers updateVouchers() {
        return null;
    }
}
