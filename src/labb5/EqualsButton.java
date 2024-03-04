package labb5;
//Alvin och Ammar
import java.awt.event.ActionEvent;

public class EqualsButton extends CalculatorButton{

	public EqualsButton(String namn, Situation situation) {
		super(namn, situation);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		transition();
	}
}
