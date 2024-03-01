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
			}
		}
			break;
			
		case "labb5.CancelButton": {
			situation.display.setText("0");
			situation.state = State.Input1;
			situation.binaryOperator.setBackground(Color.white);
		}
			break;
			
		case "labb5.DigitButton": {
			if (situation.display.getText() == "0" && namn == "0") {
				return;
			} else if (situation.state == Input1 || situation.state == Input2) {
				if (situation.display.getText() == "0") {
					situation.display.setText(namn);
					return;
				}
				situation.display.setText(situation.display.getText().concat(namn));
			} else if (situation.state == OpReady || situation.state == HasResult) {
				situation.display.setText(namn);
				situation.state = Input2;
			}
		}
			break;
			
		case "labb5.EqualsButton": {
			if (situation.state == State.Input2) {
				situation.display.setText(Integer.toString(situation.binaryOperator.BinOp()
						.applyAsInt(situation.leftOperand, Integer.valueOf(situation.display.getText()))));
				situation.state = State.HasResult;
				situation.binaryOperator.setBackground(Color.white);
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
