package labb5;

import static labb5.State.HasResult;
import static labb5.State.Input1;
import static labb5.State.Input2;
import static labb5.State.OpReady;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class CalculatorButton extends JButton implements ActionListener {
	protected Situation situation;
	private String namn;

	public CalculatorButton(String namn, Situation situation) {
		super(namn);
		this.namn = namn;
		this.addActionListener(this);
		this.situation = situation;
		this.setBackground(Color.white);
	}

	public void transition() {
		switch (this.getClass().getName()) {
		
		case "labb5.BinOpButton": {
			if (situation.state == State.Input1 || situation.state == State.HasResult) {
				situation.leftOperand = Integer.valueOf(situation.display.getText());
				situation.binaryOperator = (BinOpButton) this;
				this.setBackground(Color.red);
				situation.state = State.OpReady;
				System.out.println(situation.state);
			}
			if(situation.state == State.OpReady) {
				situation.binaryOperator.setBackground(Color.WHITE);
				situation.binaryOperator = (BinOpButton) this;
				this.setBackground(Color.red);
			}
		}
			break;
			
		case "labb5.CancelButton": {
			situation.display.setText("0");
			situation.state = State.Input1;
			situation.binaryOperator.setBackground(Color.white);
			System.out.println(situation.state);
		}
			break;
			
		case "labb5.DigitButton": {
			if (situation.display.getText() == "0" && namn == "0") {
				System.out.println(situation.state);
				return;
			} else if (situation.state == Input1 || situation.state == Input2) {
				if (situation.display.getText() == "0") {
					situation.display.setText(namn);
					System.out.println(situation.state);
					return;
				}
				situation.display.setText(situation.display.getText().concat(namn));
				System.out.println(situation.state);
			} else if (situation.state == OpReady) {
				situation.display.setText(namn);
				situation.state = Input2;
				System.out.println(situation.state);
			}
			else if (situation.state == HasResult) {
				situation.display.setText(namn);
				situation.state = Input1;
				System.out.println(situation.state);
			}
		}
			break;
			
		case "labb5.EqualsButton": {
			try {
			if (situation.state == State.Input2) {
				situation.display.setText(Integer.toString(situation.binaryOperator.BinOp()
						.applyAsInt(situation.leftOperand, Integer.valueOf(situation.display.getText()))));
				situation.state = State.HasResult;
				situation.binaryOperator.setBackground(Color.white);
				System.out.println(situation.state);
			} 
				
			}catch (java.lang.ArithmeticException e) {
			System.out.print ("divide by zero undefined");
			}
		}
			;
			break;
		}
	}

	public void setColor() {
	}

	public String toString() {
		return null;
	}

	public void displayReset() {
	}

}
