package labb5;
import javax.swing.JFrame;
import javax.swing.JLabel;
//Alvin och Ammar
/**
 * klassen agerar som huvudprogammet.
 */
public class MiniRäknare {
	/**
	 * skaper en instans av GUI:n
	 */
	public static void main(String[] args) {
		GUI MiniRäknare = new GUI(new Situation(new JLabel()));
	}
}
