package labb5;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.IntBinaryOperator;

public class BinOpButton extends CalculatorButton {
	/**
	 * @author Amar,Alvin
	 * 
	 */
	private IntBinaryOperator intBinaryOperator;
	/**
	 * Konstruktor
	 * @param namn, Tar in vad det är för knapp
	 * @param situation, Tar in en instans av situation
	 * @param intBinaryOperator Tar in vad knappen gör
	 */
	public BinOpButton(String namn, Situation situation, IntBinaryOperator intBinaryOperator) {
		super(namn, situation);
		this.intBinaryOperator = intBinaryOperator;
		/*
		 * 
		 */
	}
	/**
	 * Här körs knappen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		transition();
	}
	/**
	 * 
	 * @return Retunerar vad knappen gör
	 */
	public IntBinaryOperator BinOp() {
		return intBinaryOperator;
	}
}
