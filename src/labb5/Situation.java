package labb5;

import javax.swing.JLabel;

public class Situation {
/**
 * @author Amar,Alvin
 */
	 State state = State.Input1;
	 JLabel display;
	 BinOpButton binaryOperator;
	 int leftOperand;
	
	Situation(JLabel display) {
		this.display = display;
	}
	
}
