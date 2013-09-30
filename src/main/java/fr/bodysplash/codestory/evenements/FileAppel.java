package fr.bodysplash.codestory.evenements;

import com.google.common.collect.Lists;
import fr.bodysplash.codestory.domaine.Ascenseur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FileAppel {

    public synchronized void notifie(Appel appel) {
        appels.add(appel);
    }

    public synchronized String prochaineCommande() {
        LOGGER.info("################# Début traitement");
        for (Appel appel : appels) {
            LOGGER.info(appel.toString());
            appel.applique(ascenseur);
        }
        appels.clear();
        LOGGER.info("################# Fin Traitement");
        return ascenseur.prochaineAction();
    }

    public synchronized void reset() {
        appels.clear();
        ascenseur.reset();
    }

    private final Ascenseur ascenseur = new Ascenseur();

    private final List<Appel> appels = Lists.newArrayList();

    public static final FileAppel instance = new FileAppel();
    private static final Logger LOGGER = LoggerFactory.getLogger(FileAppel.class);
}
