package com.mindgray.cleanwheels.repository;

import com.mindgray.cleanwheels.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VouchersRepository extends JpaRepository<Voucher,Integer> {
    Voucher findVouchersByCode(String code);

}
