package fr.bodysplash.codestory.serveur;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class CodeStoryApplication extends Application {

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router();
        router.attach("/nextCommand", NextCommandResource.class);
        router.attach("/reset", ResetResource.class);
        router.attach("/call", CallResource.class);
        router.attach("/userHasEntered", UserHasEnteredResource.class);
        router.attach("/go", GoResource.class);
        router.attach("/userHasExited", UserExitedResource.class);
        return router;
    }

}
