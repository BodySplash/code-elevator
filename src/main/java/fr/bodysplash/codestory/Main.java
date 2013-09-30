package fr.bodysplash.codestory;

import fr.bodysplash.codestory.serveur.CodeStoryApplication;
import org.restlet.Component;
import org.restlet.data.Protocol;

public class Main {

    public static void main(String[] args) throws Exception {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8181);
        component.getDefaultHost().attach(new CodeStoryApplication());
        component.start();
    }


}
