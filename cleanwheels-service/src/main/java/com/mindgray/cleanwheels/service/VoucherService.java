package com.mindgray.cleanwheels.service;

import com.mindgray.cleanwheels.entity.Vouchers;

public interface VoucherService {

   boolean addVouchers();
   Vouchers validateVouchers(int id);
   Vouchers getVouchers(String code);
   boolean redeemVouchers(int id);
   Vouchers updateVouchers();
}
