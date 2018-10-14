package com.mindgray.cleanwheels.service;

import java.util.Date;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindgray.cleanwheels.constant.Constant;
import com.mindgray.cleanwheels.constant.CwMessages;
import com.mindgray.cleanwheels.dto.AddVehicleRequestDto;
import com.mindgray.cleanwheels.dto.BookServiceRequestDto;
import com.mindgray.cleanwheels.dto.responseDto.VehicleDetailResponseDto;
import com.mindgray.cleanwheels.entity.Package;
import com.mindgray.cleanwheels.entity.User;
import com.mindgray.cleanwheels.entity.Vehicle;
import com.mindgray.cleanwheels.entity.VehiclePackageTx;
import com.mindgray.cleanwheels.entity.Voucher;
import com.mindgray.cleanwheels.exception.CWException;
import com.mindgray.cleanwheels.repository.PackageRepository;
import com.mindgray.cleanwheels.repository.UserRepository;
import com.mindgray.cleanwheels.repository.VehiclePackageTxRepository;
import com.mindgray.cleanwheels.repository.VehicleRepository;
import com.mindgray.cleanwheels.repository.VoucherRepository;

@Repository("vehicleService")
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	EntityManager entityManager;
	
	@Autowired
	VehicleRepository vehicleRepository; 
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PackageRepository packageRepository;
	
	@Autowired
	VoucherRepository VoucherRepository;
	
	@Autowired
	VehiclePackageTxRepository vehiclePackageTxRepository;
	
	@Override
	public VehicleDetailResponseDto getVehicle(String userId) {
			return vehicleRepository.getVehicle(userId);
	}

	@Override
	public boolean addVehicle(AddVehicleRequestDto addVehicleRequestDto) {
		User user = userRepository.getOne(addVehicleRequestDto.getUserId());
		if (user != null) {
			Vehicle vehicle = new Vehicle(
					addVehicleRequestDto.getParkingNo(), 
					addVehicleRequestDto.getVechileNo(),
					addVehicleRequestDto.getVehicleCategory(),
					addVehicleRequestDto.getVehicleType(),
					user);
			vehicleRepository.save(vehicle);
			return true;
		}		
		return false;
	}

	@Override
	public boolean bookService(BookServiceRequestDto bookServiceRequestDto) {
		Date currentDate = new Date();
		Vehicle vehicle  = getVehilceById(bookServiceRequestDto.getVehicleId());
		Package package1 = getPackageById(bookServiceRequestDto.getPackageId(), currentDate);
		
		Voucher voucher = null;
		Double finalAmount = null;
		Double voucherAmount = 0.0;
		if (bookServiceRequestDto.getVoucherCode()!=null) {
			voucher = getVoucherByCode(bookServiceRequestDto.getVoucherCode(), currentDate);
			voucherAmount = voucher.getAmount();
			finalAmount  = bookServiceRequestDto.getAmount() - voucherAmount;
		}
		else {
			finalAmount = bookServiceRequestDto.getAmount();
		}
		
		VehiclePackageTx vehiclePackageTx = new VehiclePackageTx(
				package1, 
				currentDate, 
				bookServiceRequestDto.getStartDate(),
				bookServiceRequestDto.getEndDate(), 
				vehicle,
				false, 
				bookServiceRequestDto.getAmount(), 
				voucherAmount, 
				finalAmount,
				bookServiceRequestDto.getSubscriptionType());
		
		vehiclePackageTx = vehiclePackageTxRepository.save(vehiclePackageTx);
		
		if(vehiclePackageTx != null){
			if(voucher != null && voucher.getType() == Constant.VOUCHER_SINGLE_USE){
				voucher.setRedeemed(Constant.VOUCHER_REDEEMED);
			}
			return true;
		}
		return false;
	}
	
	
	private Vehicle getVehilceById(Integer vehicleId){
		Vehicle vehicle  = vehicleRepository.getOne(vehicleId);
		if (vehicle != null) {
			return vehicle;
		}
		throw new CWException(CwMessages.VEHICLE_UNREGISTERED.code(), CwMessages.VEHICLE_UNREGISTERED.message());
	}
	
	private Package getPackageById(Integer packageId, Date currentDate){
		Package package1 = packageRepository.getOne(packageId);
		if (package1 == null) {
			throw new CWException(CwMessages.PACKAGE_INVALID.code(), CwMessages.PACKAGE_INVALID.message());
		}
		else if (package1.getExpiry().before(currentDate)) {
			throw new CWException(CwMessages.PACKAGE_EXPIRED.code(), CwMessages.PACKAGE_EXPIRED.message());
		}
		else if (package1.getStatus().intValue() == Constant.INACTIVE) {
			throw new CWException(CwMessages.PACKAGE_EXPIRED.code(), CwMessages.PACKAGE_EXPIRED.message());
		}else{
			return package1;
		}
	}

	private Voucher getVoucherByCode(String voucherCode, Date currentDate){
		Voucher voucher = VoucherRepository.findDistinctVouhersByCode(voucherCode);
		if (voucher == null) {
			throw new CWException(CwMessages.VOUCHER_INVALID.code(), CwMessages.VOUCHER_INVALID.message());
		}
		else if (voucher.getRedeemed().intValue() == Constant.VOUCHER_REDEEMED) {
			throw new CWException(CwMessages.VOUCHER_REEDEMED.code(), CwMessages.VOUCHER_REEDEMED.message());
		}
		else if (voucher.getExpiry().before(currentDate)) {
			throw new CWException(CwMessages.VOUCHER_EXPIRED.code(), CwMessages.VOUCHER_EXPIRED.message());
		}else{
			return voucher;
		}
	}
}
