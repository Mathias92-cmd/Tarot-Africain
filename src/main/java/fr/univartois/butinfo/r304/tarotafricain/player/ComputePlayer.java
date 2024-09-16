package fr.univartois.butinfo.r304.tarotafricain.player;

import fr.univartois.butinfo.r304.tarotafricain.Game;
import fr.univartois.butinfo.r304.tarotafricain.Round;
import fr.univartois.butinfo.r304.tarotafricain.Trick;
import fr.univartois.butinfo.r304.tarotafricain.cards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputePlayer extends AbstractPlayer{

    private static final Random RANDOM = new Random();

    protected ComputePlayer(String name) {
        super(name);
    }

    @Override
    public Card play(Trick trick) {
        List<Card> playableCard = computeAllowedCards(trick);
        int index = RANDOM.nextInt(playableCard.size());
        Card card = playableCard.get(index);
        getHand().remove(hand);
        return card;
    }

    @Override
    public int makeBid(Round round) {
        int bid = RANDOM.nextInt(round.getNumberOfCards());
        if(round.getNumberOfBids() == (Game.NB_PLAYERS) -1){
            if(round.getNumberOfCards() == round.getNumberOfCards()){
                bid = ((bid -1) <= round.getNumberOfCards()? bid +1 : bid -1);
            }
        }
        return bid;
    }


}
