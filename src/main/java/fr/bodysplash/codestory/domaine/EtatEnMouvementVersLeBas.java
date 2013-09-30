package fr.bodysplash.codestory.domaine;

public class EtatEnMouvementVersLeBas extends Ascenseur.EtatAscenseur {
    public EtatEnMouvementVersLeBas(Ascenseur ascenseur, Integer cible) {
        super(ascenseur);
        this.cible = cible;
    }

    @Override
    String nextStep() {
        if (estAu(cible)) {
            ouvre();
            return "OPEN";
        }
        down();
        return "DOWN";
    }

    @Override
    public Ascenseur.EtatAscenseur appeléAu(int étage) {
        if(étage == cible) {
            return this;
        }
        if (étage > cible && étage <= étageCourant()) {
            stockDemande(cible);
            return new EtatEnMouvementVersLeBas(ascenseur, étage);
        }
        stockDemande(étage);
        return this;
    }

    private final Integer cible;
}
