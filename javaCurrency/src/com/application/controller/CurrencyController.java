package com.application.controller;

import com.application.model.CurrencyModel;
import com.application.view.CurrencyView;

public class CurrencyController {
	private CurrencyModel model;
	private CurrencyView view;
	
	CurrencyController(){
		model = new CurrencyModel();
		view = new CurrencyView(this);
	}
	
	public void convert(String ToConvertTo, String value){
		if(ToConvertTo.equals("JMD")){
			double con = model.convertUSDToJMD(Double.parseDouble(value));
			value = Double.toString(con);
			view.updateResult(value);
		}		
		else if(ToConvertTo.equals("USD")){
			double con = model.convertJMDToUSD(Double.parseDouble(value));
			value = Double.toString(con);
			view.updateResult(value);
		}
	}
	
	public static void main(String[] args){
		new CurrencyController();
	}
}
