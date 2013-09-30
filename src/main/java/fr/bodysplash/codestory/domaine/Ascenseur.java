package fr.bodysplash.codestory.domaine;

import com.google.common.base.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class Ascenseur {

    public synchronized String prochaineAction() {
        LOGGER.info(toString());
        String résultat = etat.nextStep();
        LOGGER.info(toString());
        return résultat;
    }

    public synchronized void appeléAu(int atFloor, String to) {
        etat = etat.appeléAu(atFloor);
    }

    public synchronized void go(int floor) {
        stockDemande(floor);
    }

    private void stockDemande(int demande) {
        ordonanceurDemandes.stock(demande);
    }

    public void userHasEntered() {
    }

    public synchronized void reset() {
        étage = 0;
        etat = new EtatFerme(this);
        ordonanceurDemandes.clear();
    }

    private void ferme() {
        etat = new EtatFerme(this);
    }

    private void ouvre() {
        etat = new EtatOuvert(this);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("étage", étage).add("état", etat.getClass().getSimpleName()).toString();
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(Ascenseur.class);
    private int étage = 0;
    private EtatAscenseur etat = new EtatFerme(this);
    private OrdonanceurDemandes ordonanceurDemandes = new OrdonanceurDemandes();

    public abstract static class EtatAscenseur {

        public EtatAscenseur(Ascenseur ascenseur) {
            this.ascenseur = ascenseur;
        }

        abstract String nextStep();

        protected Optional<Integer> demandeSuivante() {
            return ascenseur.ordonanceurDemandes.demandeSuivante(étageCourant());
        }

        protected Integer étageCourant() {
            return ascenseur.étage;
        }

        protected void up() {
            ascenseur.étage++;
        }

        public abstract EtatAscenseur appeléAu(int atFloor);

        protected void down() {
            ascenseur.étage--;
        }

        protected void ouvre() {
            ascenseur.ouvre();
        }

        protected boolean estAu(Integer étage) {
            return étage == ascenseur.étage;
        }

        protected void ferme() {
            ascenseur.ferme();
        }

        protected void stockDemande(int étage) {
            ascenseur.stockDemande(étage);
        }

        protected void setEtat(EtatAscenseur etat) {
            ascenseur.etat = etat;
        }

        protected final Ascenseur ascenseur;
    }
}
