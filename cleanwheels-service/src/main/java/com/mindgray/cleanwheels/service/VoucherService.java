package com.mindgray.cleanwheels.service;

import com.mindgray.cleanwheels.entity.Voucher;

public interface VoucherService {

   boolean addVouchers();
   Voucher validateVouchers(int id);
   Voucher getVouchers(String code);
   boolean redeemVouchers(int id);
   Voucher updateVouchers();
}
