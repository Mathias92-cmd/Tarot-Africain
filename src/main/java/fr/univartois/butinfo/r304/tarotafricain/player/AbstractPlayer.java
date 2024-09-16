package fr.univartois.butinfo.r304.tarotafricain.player;

import fr.univartois.butinfo.r304.tarotafricain.Game;
import fr.univartois.butinfo.r304.tarotafricain.Round;
import fr.univartois.butinfo.r304.tarotafricain.Trick;
import fr.univartois.butinfo.r304.tarotafricain.cards.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlayer implements IPlayer{
    private String name;
    List<Card> hand;
    private int life;

    protected AbstractPlayer(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.life = Game.LIFE;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getLife() {
        return 0;
    }

    @Override
    public void decreasedLife(int points) {
        life -= points;
        if(life < 0)
            life = 0;
    }

    @Override
    public List<Card> getHand() {
        return List.of();
    }

    @Override
    public void give(Card card) {
        hand.add(card);
    }


    @Override
    public abstract int makeBid(Round round);

    protected List<Card> computeAllowedCards(Trick trick){
        List<Card> allowedCards = new ArrayList<>();
        if(trick.isEmpty()){
            allowedCards.addAll(hand);
        }
        else {
            Card bestCard = trick.getBestCard();
            for(Card card : hand){
                if(card.getTrump().compareTo(bestCard.getTrump())>0){
                    allowedCards.add(card);
                }
            }
        }
        if(allowedCards.isEmpty()){
            allowedCards.addAll(hand);
        }
        return allowedCards;
    }

    @Override
    public String toString() {
        return "AbstractPlayer{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                ", life=" + life +
                '}';
    }
}
