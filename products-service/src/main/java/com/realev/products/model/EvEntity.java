package com.realev.products.model;

import com.realev.products.model.EvEntity.ChargePortEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EvEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long ID;

    // General
	public String	make;
	public String	model;
	public Integer	year;
	public Double	price;
	public String	imageUrl;

    // Performance
	public Integer	range;
    public Double acceleration;
    public Integer topSpeed;
    public Integer power;
    public Integer torque;
    enum DriveType { REAR, FRONT, ALL };
    public DriveType drive;

    // Battery
    public Integer batteryCapacity;
    public enum BatteryTypeEnum { LITHIUM_ION, UNKNOWN };
    public BatteryTypeEnum batteryType;

    // Charging
    public Integer chargeTime;
    public Integer chargeSpeed;
    public Integer chargePower;
    public enum ChargePortEnum { CCS, TESLA, UNKNOWN };
    public ChargePortEnum chargePort;
}

