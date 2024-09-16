package fr.univartois.butinfo.r304.tarotafricain.cards;

public interface ITrump {

    int compareTo(ITrump trump);
    int compareTo(NumberedTrump trump);
    int compareTo(Excuse excuse);
}
