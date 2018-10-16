package no.capra.config;

import no.capra.secured.ProtectedEndpoint;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.Properties;

public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(Properties properties) {
        this.register(createProtectedEndpoint(properties));
        packages("no.capra");
    }

    private static ProtectedEndpoint createProtectedEndpoint(Properties properties) {
        String message = PropertiesHelper.getStringProperty(properties, PropertiesHelper.SECURED_ENDPOINT_MESSAGE, null);
        return new ProtectedEndpoint(message);
    }
}
