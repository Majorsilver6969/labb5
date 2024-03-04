package labb5;
//Alvin och Ammar

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.IntBinaryOperator;

public class BinOpButton extends CalculatorButton {
	
	private IntBinaryOperator intBinaryOperator;
	
	public BinOpButton(String namn, Situation situation, IntBinaryOperator intBinaryOperator) {
		super(namn, situation);
		this.intBinaryOperator = intBinaryOperator;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		transition();
	}
	
	public IntBinaryOperator BinOp() {
		return intBinaryOperator;
	}
}
