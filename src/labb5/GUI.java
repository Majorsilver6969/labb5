package labb5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.function.IntBinaryOperator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame {
	
	private Situation situation;
	private JPanel Canvas; 
	private JPanel keyPad; 
	
	public GUI(Situation situation){
		this.situation = situation;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Canvas = new JPanel(new GridBagLayout());
		JPanel keyPad = new JPanel(new GridLayout(4, 4, 5, 5));

		situation.display = new JLabel("0");
		this.Canvas = Canvas; 
		this.keyPad = keyPad; 

		
		IntBinaryOperator add = (x, y) -> x + y;
		IntBinaryOperator divide = (x, y) -> x / y;
		IntBinaryOperator multiply = (x, y) -> x * y;
		IntBinaryOperator subtract = (x, y) -> x - y;
		
		CalculatorButton[] knappar = {
				new DigitButton("7", situation), new DigitButton( "8", situation), new DigitButton("9", situation),new BinOpButton("/", situation, divide),
				new DigitButton("4", situation), new DigitButton( "5", situation), new DigitButton("6", situation),new BinOpButton("*", situation, multiply),
				new DigitButton("1", situation), new DigitButton( "2", situation), new DigitButton("3", situation),new BinOpButton("-", situation, subtract),
				new DigitButton("0", situation), new CancelButton( "C", situation), new EqualsButton("=", situation),new BinOpButton("+", situation, add),
				};
		
		for (CalculatorButton knapp : knappar) {
			keyPad.add(knapp);
		}
		
		situation.display.setOpaque(true);
		situation.display.setHorizontalAlignment(JLabel.RIGHT);
		situation.display.setFont(new Font("Arial", Font.PLAIN, 14));
		situation.display.setBackground(Color.LIGHT_GRAY);
		situation.display.setPreferredSize(new Dimension(300, 30)); // Example size, adjust as needed.
		situation.display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		keyPad.setBackground(Color.LIGHT_GRAY);
		Canvas.setBackground(Color.yellow);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER; // This component is the last in its row.
		gbc.fill = GridBagConstraints.HORIZONTAL; // This component should grow horizontally.
		Canvas.add(situation.display, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER; // This component is the last in its row.
		gbc.fill = GridBagConstraints.BOTH; // This component should grow in both dimensions.
		gbc.weightx = 1.0; // This gives the keypad area more weight in terms of how extra space is distributed.
		gbc.weighty = 1.0; // Same as above, but for vertical distribution.
		Canvas.add(keyPad, gbc);
		
		setContentPane(Canvas);
		pack();
		setVisible(true);
		while(true) {
			updateGUI();
		}
	}
	
	public void updateGUI() {
		situation.display.repaint();
	}
	
	public Situation getSituation() {
		return situation;
	}
	
}
