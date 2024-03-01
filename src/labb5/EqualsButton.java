package labb5;

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
