package fr.univartois.butinfo.r304.tarotafricain.cards;

public enum NumberedTrump implements ITrump {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN, SEVENTEEN, EIGHTEEN, NINETEEN, TWENTY, TWENTY_ONE;

    @Override
    public int compareTo(ITrump trump) {
        return -trump.compareTo(this);
    }

    @Override
    public int compareTo(Excuse excuse) {
        if(excuse.isHighValue())
            return 1;
        return -1;
    }
}
