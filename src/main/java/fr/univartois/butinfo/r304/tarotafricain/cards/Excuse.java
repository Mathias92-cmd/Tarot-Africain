package fr.univartois.butinfo.r304.tarotafricain.cards;

import java.util.Objects;

public class Excuse implements ITrump{

    private boolean highValue;

    public Excuse(){

    }


    @Override
    public int compareTo(ITrump trump) {
        return -trump.compareTo(this);
    }

    @Override
    public int compareTo(NumberedTrump trump) {
        if(highValue)
            return 1;
        return -1;
    }

    @Override
    public int compareTo(Excuse excuse) {
        if(isHighValue() && excuse.isHighValue())
            return 1;
        if(!isHighValue() && excuse.isHighValue())
            return -1;
        return 0;
    }

    public void setHighValue(boolean highValue){
        this.highValue = highValue;
    }

    public boolean isHighValue(){
        return highValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(highValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Excuse excuse = (Excuse) o;
        return highValue == excuse.highValue;
    }

    @Override
    public String toString() {
        return "Excuse{" +
                "highValue=" + highValue +
                '}';
    }




}
