package org.example;

import java.util.Objects;

public class AbstractAnimal {
    private boolean isMammals;
    private String type;

    public AbstractAnimal(boolean isMammals) {
        this.isMammals = isMammals;
        this.type = this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        String isMammalsPrediction = "Animal is mammals.";
        String isNoMammalsPrediction = "Animal is not mammals.";
        return isMammals ? isMammalsPrediction + "\ntype = " + type
                :
                isNoMammalsPrediction + "\ntype = " + type;
    }


    public String objectToString() {
        return super.toString();
    }



    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AbstractAnimal that = (AbstractAnimal) object;
        return isMammals == that.isMammals && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isMammals, type);
    }
}
