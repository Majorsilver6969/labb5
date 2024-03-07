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
	/**
	 * @author Amar,Alvin
	 */
	private Situation situation;
	private JPanel Canvas; 
	private JPanel keyPad; 
	/**
	 * Konstruktor som tar in situation som parameter.
	 * @param situation, GUI används för att hålla på vilken tillstånd man är i.
	 */
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
		
		situation.display.setOpaque(true);	// Annars går det inte att display (Kinda man kan inte se bakgrunden iallafall)
		situation.display.setHorizontalAlignment(JLabel.RIGHT);		// Texten till höger
		situation.display.setFont(new Font("Arial", Font.PLAIN, 14)); // Text font
		situation.display.setBackground(Color.LIGHT_GRAY);
		situation.display.setPreferredSize(new Dimension(300, 30)); 	// Storlek på display
		situation.display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Border för display
		
		keyPad.setBackground(Color.LIGHT_GRAY);
		
		GridBagConstraints displaygbc = new GridBagConstraints();	// https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
		displaygbc.gridwidth = GridBagConstraints.REMAINDER; //  Oracle Help Center (Specifies the number of cells in a row for the component's display area)
		displaygbc.fill = GridBagConstraints.HORIZONTAL; // Oracle Help Center (Used when the component's display area is larger than the component's requested size to determine whether (and how) to resize the component.)
		Canvas.add(situation.display, displaygbc);
		
		GridBagConstraints keyPadgbc = new GridBagConstraints();
		keyPadgbc.gridwidth = GridBagConstraints.REMAINDER; // This component is the last in its row.
		keyPadgbc.fill = GridBagConstraints.BOTH; // Oracle Help Center (BOTH (make the component fill its display area entirely).)
		keyPadgbc.weightx = 1.0; // Oracle Help Center (This is important for specifying resizing behavior.)
		keyPadgbc.weighty = 1.0; // Samma sak som ovan men för höjden
		Canvas.add(keyPad, keyPadgbc);
		
		setContentPane(Canvas);
		pack();
		setVisible(true);

	}
	
}
