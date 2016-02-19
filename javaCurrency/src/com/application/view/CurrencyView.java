package com.application.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.application.controller.CurrencyController;

public class CurrencyView extends JFrame implements ActionListener{

	JLabel lblResult, lblValueLabel;
	JTextField txtValue;
	JRadioButton rdbToJMD, rdbToUSD;
	JButton btnConvert, btnClear;
	JPanel panTop, panMiddle, panBottom;
	CurrencyController controller;
	
	public CurrencyView(CurrencyController cc){
		controller = cc;
		this.setLayout(new GridLayout(3,1));
		initializeComponent();
		addComponentsToPanels();
		addPanelsTowindows();
		setWindowProperties();
		registerListener();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource().equals(btnClear)){
			txtValue.setText("");
			lblResult.setText("Result");
			lblValueLabel.setText("Value");
			rdbToJMD.setText("JMD");
			rdbToUSD.setText("USD");
		}
		
		if(ae.getSource().equals(btnConvert)){
			if(rdbToJMD.isSelected()){
				controller.convert("JMD", txtValue.getText());
			}
			else if(rdbToUSD.isSelected()){
				controller.convert("USD", txtValue.getText());
			}
			
		}
	}
	
	private void initializeComponent(){
		lblResult = new JLabel("Result");
		lblValueLabel = new JLabel("Value");
		rdbToJMD = new JRadioButton("To JMD");
		rdbToUSD = new JRadioButton("To USD");
		btnConvert = new JButton("Convert");
		btnClear = new JButton("Clear");
		panTop = new JPanel(new GridLayout(3,1));
		panMiddle = new JPanel(new GridLayout(2,1));
		panBottom = new JPanel(new GridLayout(2,1));
		txtValue = new JTextField();
		ButtonGroup n = new ButtonGroup();
		n.add(rdbToJMD);
		n.add(rdbToUSD);
	}
	
	private void addComponentsToPanels(){
		panTop.add(lblValueLabel);
		panTop.add(txtValue);
		panTop.add(lblResult);
		panMiddle.add(rdbToJMD);
		panMiddle.add(rdbToUSD);
		panBottom.add(btnConvert);
		panBottom.add(btnClear);
	}
	
	private void addPanelsTowindows(){
		this.add(panTop);
		this.add(panMiddle);
		this.add(panBottom);
	}
	
	private void setWindowProperties(){
		this.setSize(1024,680);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	private void registerListener(){
		btnClear.addActionListener(this);
		btnConvert.addActionListener(this);
	}
	
	public void updateResult(String value){
		lblResult.setText(value);
	}
}
