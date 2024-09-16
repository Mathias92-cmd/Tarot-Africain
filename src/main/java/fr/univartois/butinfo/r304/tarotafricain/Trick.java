package fr.univartois.butinfo.r304.tarotafricain;

import fr.univartois.butinfo.r304.tarotafricain.cards.Card;

import java.util.List;

public class Trick {

    private List<Card> cards;
    private int bestCardIndex;
    private int bestPlayerIndex;

    public boolean isEmpty(){
        return false;
    }

    public Card getBestCard(){

    }

    public int getWinner() {

    }

    public void play(int currentPlayer, Card card){
        cards.add(card);
        if(cards.size() == 1){
            bestCardIndex = 0;
            bestPlayerIndex = currentPlayer;
        }
        else {
            if(card.compareTo(cards.get(bestCardIndex)) > 0){
                bestCardIndex = cards.size() - 1;
                bestPlayerIndex = currentPlayer;
            }
        }
    }
}
