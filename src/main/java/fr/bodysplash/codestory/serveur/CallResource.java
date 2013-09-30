package fr.bodysplash.codestory.serveur;

import fr.bodysplash.codestory.evenements.Appel;
import fr.bodysplash.codestory.evenements.FileAppel;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class CallResource extends ServerResource{

    @Get
    public void call() {
        int atFloor = Integer.parseInt(getQueryValue("atFloor"));
        String to = getQueryValue("to");
        FileAppel.instance.notifie(new Appel(atFloor, to, Appel.Type.APPEL));
    }
}
