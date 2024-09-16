package fr.univartois.butinfo.r304.tarotafricain.cards;

import java.util.Objects;

public class Card {
    private ITrump trump;

    Card(ITrump trump){
        this.trump = trump;
    }

    public int compareTo(Card card){
        return trump.compareTo(card.getTrump());
    }

    public ITrump getTrump() {
        return trump;
    }

    public void setTrump(ITrump trump) {
        this.trump = trump;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(trump, card.getTrump());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getTrump());
    }

    @Override
    public String toString() {
        return "Card{" +
                "trump=" + trump +
                '}';
    }
}
