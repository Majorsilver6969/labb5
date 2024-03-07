package labb5;

import java.awt.event.ActionEvent;
/**
 * @author Amar,Alvin
 */
public class EqualsButton extends CalculatorButton{
	/**
	 * Konstruktor, tar in namn och situation 
	 * @param namn
	 * @param situation
	 */
	public EqualsButton(String namn, Situation situation) {
		super(namn, situation);
	}
	/**
	 * Här körs knappen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		transition();
	}
}
