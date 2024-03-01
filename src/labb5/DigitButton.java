package labb5;
import static labb5.State.*;
import java.awt.event.ActionEvent;
public class DigitButton extends CalculatorButton{
	
	
	public DigitButton(String namn, Situation situation) {
		super(namn, situation);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		transition();
//		System.out.println(situation.leftOperand);	
	}
}
