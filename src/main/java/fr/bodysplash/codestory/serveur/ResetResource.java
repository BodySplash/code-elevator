package fr.bodysplash.codestory.serveur;

import fr.bodysplash.codestory.evenements.FileAppel;
import org.restlet.representation.EmptyRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class ResetResource extends ServerResource{

    @Get
    public Representation get() {
        FileAppel.instance.reset();
        return new EmptyRepresentation();
    }
}
