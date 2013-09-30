package fr.bodysplash.codestory;

import fr.bodysplash.codestory.domaine.Ascenseur;
import org.junit.Test;

import static org.junit.Assert.*;


public class AscenseurTest {

    @Test
    public void peutMonter() {
        Ascenseur ascenseur = new Ascenseur();
        ascenseur.appeléAu(1, "UP");

        String next = ascenseur.prochaineAction();

        assertEquals("UP", next);
    }

    @Test
    public void peutOuvrirLesPortes() {
        Ascenseur ascenseur = new Ascenseur();
        ascenseur.appeléAu(1, "UP");

        ascenseur.prochaineAction();
        String next = ascenseur.prochaineAction();

        assertEquals("OPEN", next);
    }

    @Test
    public void fermeLesPortesAprèsEntrée() {
        Ascenseur ascenseur = new Ascenseur();
        ascenseur.appeléAu(1, "UP");

        ascenseur.prochaineAction();
        ascenseur.prochaineAction();
        ascenseur.userHasEntered();
        String next = ascenseur.prochaineAction();

        assertEquals("CLOSE", next);
    }

    @Test
    public void nOuvreQueSurArrivée() {
        Ascenseur ascenseur = new Ascenseur();

        String next = ascenseur.prochaineAction();

        assertEquals("NOTHING", next);
    }

    @Test
    public void peutSArrêterSurLaRoute() {
        Ascenseur ascenseur = new Ascenseur();
        ascenseur.appeléAu(3, "UP");
        ascenseur.prochaineAction();
        ascenseur.appeléAu(1, "UP");

        String action = ascenseur.prochaineAction();

        assertEquals("OPEN", action);
    }

    @Test
    public void neRedescentPasSurAppelEtMouvementVersLeHaut() {
        Ascenseur ascenseur = new Ascenseur();
        ascenseur.appeléAu(3, "UP");
        ascenseur.prochaineAction();
        ascenseur.appeléAu(0, "UP");

        String action = ascenseur.prochaineAction();

        assertEquals("UP", action);
    }

    @Test
    public void nEmpilePasLesDemandesDéjàPrisesEnCompte() {
        Ascenseur ascenseur = new Ascenseur();
        ascenseur.appeléAu(1, "UP");
        ascenseur.appeléAu(1, "UP");

        ascenseur.prochaineAction();
        ascenseur.prochaineAction();
        ascenseur.prochaineAction();
        String action = ascenseur.prochaineAction();

        assertEquals("NOTHING", action);
    }

    @Test
    public void nEmpilePasLesDemandesDéjàPrisesEnCompteVersLeBas() {
        Ascenseur ascenseur = new Ascenseur();
        ascenseur.appeléAu(1, "UP");
        ascenseur.prochaineAction();
        ascenseur.prochaineAction();
        ascenseur.prochaineAction();
        ascenseur.appeléAu(0, "DOWN");
        ascenseur.appeléAu(0, "DOWN");

        ascenseur.prochaineAction();
        ascenseur.prochaineAction();
        ascenseur.prochaineAction();
        String action = ascenseur.prochaineAction();

        assertEquals("NOTHING", action);
    }

    @Test
    public void peutTrierLaDescente() {
        Ascenseur ascenseur = new Ascenseur();
        ascenseur.appeléAu(4, "UP");
        monteAu3(ascenseur);
        ascenseur.appeléAu(1, "UP");
        ascenseur.appeléAu(2, "UP");


        ascenseur.prochaineAction();
        ascenseur.prochaineAction();
        ascenseur.prochaineAction();
        ascenseur.prochaineAction();
        ascenseur.prochaineAction();

        String action = ascenseur.prochaineAction();

        assertEquals("OPEN", action);
    }

    private void monteAu3(Ascenseur ascenseur) {
        ascenseur.prochaineAction();
        ascenseur.prochaineAction();
        ascenseur.prochaineAction();
    }
}
