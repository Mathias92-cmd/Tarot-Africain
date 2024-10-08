package fr.univartois.butinfo.r304.tarotafricain;

import fr.univartois.butinfo.r304.tarotafricain.cards.DeckOfCards;
import fr.univartois.butinfo.r304.tarotafricain.player.IPlayer;

import java.util.List;

public class Round {

    private List<IPlayer> players;
    private int [] bids;
    private int [] scores;
    private int totalsBids;
    private int numberOfCards;
    private int numberOfBids;
    private DeckOfCards deck;
    private int currentPlayer;

    public Round(List<IPlayer> players , int currentPlayer , int numberOfCards){
        this.players = players;
        this.currentPlayer = currentPlayer;
        this.numberOfCards = numberOfCards;
        deck = DeckOfCards.newDeck();
        bids = new int[Game.NB_PLAYERS];
        scores = new int[Game.NB_PLAYERS];
        totalsBids = 0;
    }

    public List<IPlayer> getPlayers() {
        return players;
    }

    public void play() {
        dealCards();
        askBids();
        for (int i = 0; i < numberOfCards; i++) {
            Trick trick = new Trick();
            playTrick(trick);
            scores[trick.getWinner()]++;
            currentPlayer = trick.getWinner();
        }
    }

    public void dealCards(){
        deck.shuffle();
        for (int i = 0; i < numberOfCards; i++) {
            for (IPlayer player : players) {
                player.give(deck.draw());
            }
        }
    }

    public void setPlayers(List<IPlayer> players) {
        this.players = players;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public int getNumberOfBids() {
        return numberOfBids;
    }

    public int getTotalBids() {
        return totalsBids;
    }

    private void askBids(){
        for (int i = 0; i < Game.NB_PLAYERS; i++) {
            int bid = players.get(currentPlayer).makeBid(this);
            bids[currentPlayer] = bid;
            totalsBids += bid;
            currentPlayer = (currentPlayer + 1) % Game.NB_PLAYERS;
        }
    }

    private void playTrick(Trick trick){

    }

    public int getPenalty(int playerIndex){
        return Math.abs(bids[playerIndex] - scores[playerIndex]);
    }
}
