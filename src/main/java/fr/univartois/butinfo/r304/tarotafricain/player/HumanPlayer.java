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

    public int readBid(Round round){
        System.out.println("Enter your bid : ");
        int bid = 0;

        do {
            try {
                bid = scanner.nextInt();
                if(bid < 0 || bid > round.getNumberOfCards()){
                    System.out.println("Please enter a valid number");
                    bid = -1;
                    continue;
                }
            } catch (Exception e) {
                System.out.println("The sum of the bids must be equal to the number of cards");
                bid = -1;
                continue;
            }
            if(round.getNumberOfBids() == (Game.NB_PLAYERS) - 1){
                if((round.getTotalBids() + bid) == round.getNumberOfCards()){
                    System.out.println("Error , enter new bid ! ");
                    bid = -1;
                }
            }
        } while(bid < 0 || bid > round.getNumberOfCards());
        return bid;
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
        int index = 0;
        do {
            System.out.println("Enter the index of the card you want to play : ");
            try {
                index = scanner.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
                index = -1;
            }
        } while(index < 0 || index >= playableCards.size());
        Card card = playableCards.get(index);
        getHand().remove(card);
        return card;
    }

}
