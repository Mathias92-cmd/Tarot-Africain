package fr.univartois.butinfo.r304.tarotafricain.cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {

    private List<Card> cards;

    private DeckOfCards() {
        cards = new ArrayList<>();
    }

    public static DeckOfCards newDeck(){
        DeckOfCards deck = new DeckOfCards();
        for(NumberedTrump numberedTrump : NumberedTrump.values()){
            deck.cards.add(new Card(numberedTrump));
        }
        deck.cards.add(new Card(new Excuse()));
        return deck;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card draw(){
        return cards.removeFirst();
    }

    public void add(Card card){
        cards.add(card);
    }


}
