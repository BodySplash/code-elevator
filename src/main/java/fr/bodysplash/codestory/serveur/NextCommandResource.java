package fr.bodysplash.codestory.serveur;

import fr.bodysplash.codestory.evenements.FileAppel;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class NextCommandResource extends ServerResource {

    @Get
    public Representation get() {
        String commande = FileAppel.instance.prochaineCommande();
        return new StringRepresentation(commande);
    }
}
