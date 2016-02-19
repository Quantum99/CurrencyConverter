package com.application.model;

public class CurrencyModel {
	public double convertJMDToUSD(double jmd){
		return jmd/116;
	}
	
	public double convertUSDToJMD(double usd){
		return usd * 116;
	}
}
