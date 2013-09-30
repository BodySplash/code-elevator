package fr.bodysplash.codestory.domaine;

import java.util.Optional;

public class EtatFerme extends Ascenseur.EtatAscenseur {


    public EtatFerme(Ascenseur ascenseur) {
        super(ascenseur);
    }

    @Override
    String nextStep() {
        Optional<Integer> next = demandeSuivante();
        if(next.isPresent()) {
            Ascenseur.EtatAscenseur etat = mouvementSuivant(next.get());
            setEtat(etat);
            return etat.nextStep();
        }
        return "NOTHING";
    }

    @Override
    public Ascenseur.EtatAscenseur appeléAu(int étage) {
        return mouvementSuivant(étage);
    }

    private Ascenseur.EtatAscenseur mouvementSuivant(int étage) {
        if(étage < this.étageCourant()) {
            return new EtatEnMouvementVersLeBas(ascenseur, étage);
        }
        return new EtatEnMouvementVersLeHaut(ascenseur, étage);
    }

}
