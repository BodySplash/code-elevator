package fr.bodysplash.codestory.domaine;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class OrdonanceurDemandesTest {

    @Before
    public void setUp() throws Exception {
        ordonanceurDemandes = new OrdonanceurDemandes();
    }

    @Test
    public void peutDonnerMêmeÉtage() {
        ordonanceurDemandes.stock(1);

        Optional<Integer> suivant = ordonanceurDemandes.demandeSuivante(1);

        assertEquals((Object) 1, suivant.get());
    }

    @Test
    public void peutOrdonnerLeCheminVersLeBas() {
        ordonanceurDemandes.stock(1);
        ordonanceurDemandes.stock(2);

        int suivant = ordonanceurDemandes.demandeSuivante(3).get();

        assertEquals(2, suivant);
    }

    @Test
    public void peutOrdonnerCheminVersLeHaut() {
        ordonanceurDemandes.stock(5);
        ordonanceurDemandes.stock(4);

        int suivant = ordonanceurDemandes.demandeSuivante(3).get();

        assertEquals(4, suivant);
    }

    @Test
    public void neRetournePasLesMêmeDemandes() {
        ordonanceurDemandes.stock(5);
        ordonanceurDemandes.stock(5);

        ordonanceurDemandes.demandeSuivante(4);
        Optional<Integer> suivant = ordonanceurDemandes.demandeSuivante(5);

        assertFalse(suivant.isPresent());
    }

    private OrdonanceurDemandes ordonanceurDemandes;
}
