package fr.bodysplash.codestory.evenements;

import com.google.common.base.Objects;
import fr.bodysplash.codestory.domaine.Ascenseur;

public class Appel {

    public enum Type {
        APPEL {
            @Override
            public void appliquer(Ascenseur ascenseur, Appel appel) {
                ascenseur.appeléAu(appel.étage, appel.direction);
            }
        },
        GO {
            @Override
            public void appliquer(Ascenseur ascenseur, Appel appel) {
                ascenseur.go(appel.étage);
            }
        };

        public abstract void appliquer(Ascenseur ascenseur, Appel appel);
    }

    public Appel(int étage, String direction, Type type) {
        this.étage = étage;
        this.direction = direction;
        this.type = type;
    }

    public void applique(Ascenseur ascenseur) {
        type.appliquer(ascenseur, this);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("type", type).add("étage", étage).add("direction", direction).toString();
    }

    public final int étage;
    public final String direction;
    public final Type type;
}
