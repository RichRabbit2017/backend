package com.mindgray.cleanwheels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindgray.cleanwheels.entity.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Integer>{

	Voucher findDistinctVouhersByTypeAndCodeAndRedeemed(Integer voucherType,String voucherCode, Integer redeem);
	
	Voucher findDistinctVouhersByCode(String voucherCode);
	
}
