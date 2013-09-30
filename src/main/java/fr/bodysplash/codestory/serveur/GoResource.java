package fr.bodysplash.codestory.serveur;

import fr.bodysplash.codestory.evenements.Appel;
import fr.bodysplash.codestory.evenements.FileAppel;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class GoResource extends ServerResource {
    @Get
    public void go() {
        int floor = Integer.parseInt(getQueryValue("floorToGo"));
        FileAppel.instance.notifie(new Appel(floor, "", Appel.Type.GO));
    }
}
