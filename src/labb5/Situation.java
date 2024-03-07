package labb5;
//Alvin och Ammar
import javax.swing.JLabel;
/**
 * Klassen situation uppdaterar vilen stae som ska vara aktiv
 */
public class Situation {
	 State state = State.Input1;
	 JLabel display;
	 BinOpButton binaryOperator;
	 int leftOperand;
	/**
	 * konstruktorn sätter vilken vilken display som motsvarar state
	 */
	Situation(JLabel display) {
		this.display = display;
	}
	
}
