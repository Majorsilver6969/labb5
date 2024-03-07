package labb5;
import javax.swing.JLabel;
/**
 * @author Amar, Alvin
 * Här kör vi Miniräknare
 */

public class Miniraknare {
	/**
	 * Detta är en static metod som kommer köra våra miniräknare.
	 * @param args,
	 */
	public static void main(String[] args) {
		new GUI(new Situation(new JLabel()));
		
	}
}
