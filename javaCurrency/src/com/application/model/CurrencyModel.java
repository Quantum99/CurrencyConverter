package com.application.model;

public class CurrencyModel {
	public double convertJMDToUSD(double jmd){
		return jmd/121;
	}
	
	public double convertUSDToJMD(double usd){
		return usd * 121;
	}
}
