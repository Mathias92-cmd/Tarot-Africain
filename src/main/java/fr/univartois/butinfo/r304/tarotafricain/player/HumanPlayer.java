package fr.univartois.butinfo.r304.tarotafricain.player;

import fr.univartois.butinfo.r304.tarotafricain.Game;
import fr.univartois.butinfo.r304.tarotafricain.Round;
import fr.univartois.butinfo.r304.tarotafricain.Trick;
import fr.univartois.butinfo.r304.tarotafricain.cards.Card;

import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer{

    private Scanner scanner = new Scanner(System.in);

    protected HumanPlayer(String name){
        super(name);
    }



    public int makeBid(Round round){
        System.out.println("Enter your bid : ");
        int bid = scanner.nextInt();
        if(round.getNumberOfBids() == (Game.NB_PLAYERS) - 1){
            while((round.getTotalBids() + bid) == round.getNumberOfCards()){
                System.out.println("Error , enter new bid ! ");
                bid = scanner.nextInt();
            }
        }
        return bid;
    }

    @Override
    public Card play(Trick trick){
        List<Card> playableCards = computeAllowedCards(trick);
        System.out.println("They are the cartes you can play ");
        System.out.println(playableCards);
        System.out.println("Enter the index of the card you want to play !");
        int index = scanner.nextInt();
        Card card = playableCards.get(index);
        getHand().remove(card);
        return card;
    }

}
