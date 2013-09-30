package fr.bodysplash.codestory.domaine;

public class EtatEnMouvementVersLeHaut extends Ascenseur.EtatAscenseur {
    public EtatEnMouvementVersLeHaut(Ascenseur ascenseur, int cible) {
        super(ascenseur);
        this.cible = cible;
    }

    @Override
    String nextStep() {
        if (estAu(cible)) {
            ouvre();
            return "OPEN";
        }
        this.up();
        return "UP";
    }

    @Override
    public Ascenseur.EtatAscenseur appeléAu(int étage) {
        if(étage == cible) {
            return this;
        }
        if (étage < cible && étage >= étageCourant()) {
            stockDemande(cible);
            return new EtatEnMouvementVersLeHaut(ascenseur, étage);
        }
        stockDemande(étage);
        return this;
    }


    private final int cible;
}
