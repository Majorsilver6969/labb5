package labb5;
//Alvin och Ammar
import javax.swing.JLabel;

public class Situation {
	 State state = State.Input1;
	 JLabel display;
	 BinOpButton binaryOperator;
	 int leftOperand;
	
	Situation(JLabel display) {
		this.display = display;
	}
	
}
