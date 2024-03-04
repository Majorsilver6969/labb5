package labb5;
//Alvin och Ammar
import java.awt.Color;
import java.awt.event.ActionEvent;
public class CancelButton extends CalculatorButton{

	public CancelButton(String namn, Situation situation) {
		super(namn, situation);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		transition();
	}
}
