package com.mindgray.cleanwheels.repository;

import com.mindgray.cleanwheels.entity.Vouchers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VouchersRepository extends JpaRepository<Vouchers,Integer> {
    Vouchers findVouchersByCode(String code);

}
