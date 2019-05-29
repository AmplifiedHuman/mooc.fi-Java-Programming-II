import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {

    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<Card>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void print() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(cards);
    }

    public void sortAgainstSuit() {
        Collections.sort(cards, new SortAgainstSuitAndValue());
    }

    public int cardSum() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getValue();
        }
        return sum;
    }
    
    @Override
    public int compareTo(Hand o) {
        return this.cardSum() - o.cardSum();
    }
}