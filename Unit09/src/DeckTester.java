/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] Ranks1 = {"0 ", "1 ", "2 ", "3 ", "4 "};
		String[] Suits1 = {"Spade", "Heart", "Club", "Jack", "Spade"};
		int[] Values1 = {0, 1, 2, 3, 4};
		String[] Ranks2 = {"1 ", "2 ", "3 ", "4 ", "5 "};
		String[] Suits2 = {"Spade", "Heart", "Club", "Jack", "Spade"};
		int[] Values2 = {1, 2, 3, 4, 5};
		String[] Ranks3 = {"2 ", "3 ", "4 ", "5 ", "6 "};
		String[] Suits3 = {"Spade", "Heart", "Club", "Jack", "Spade"};
		int[] Values3 = {2, 3, 4, 5, 6};
		Deck deck1 = new Deck(Ranks1, Suits1, Values1);
		Deck deck2 = new Deck(Ranks2, Suits2, Values2);
		Deck deck3 = new Deck(Ranks3, Suits3, Values3);

	}
}
