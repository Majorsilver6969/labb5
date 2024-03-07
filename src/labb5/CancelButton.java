package labb5;

import java.awt.Color;
import java.awt.event.ActionEvent;
public class CancelButton extends CalculatorButton{
/**
 * Konstruktor, den tar in situation och namn 
 * @author Amar, Alvin
 */
	public CancelButton(String namn, Situation situation) {
		super(namn, situation);

	}
	/**
	 * actionPerformed här körs knappen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		transition();
	}
}
