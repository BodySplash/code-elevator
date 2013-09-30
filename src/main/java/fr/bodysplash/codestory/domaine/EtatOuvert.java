package fr.bodysplash.codestory.domaine;

public class EtatOuvert extends Ascenseur.EtatAscenseur {

    public EtatOuvert(Ascenseur ascenseur) {
        super(ascenseur);
    }

    @Override
    String nextStep() {
        ferme();
        return "CLOSE";
    }

    @Override
    public Ascenseur.EtatAscenseur appeléAu(int étage) {
        stockDemande(étage);
        return this;
    }


}
