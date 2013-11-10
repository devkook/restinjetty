package devkook.study.jetty;

import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import com.sun.jersey.spi.container.servlet.ServletContainer;

public class JerseyJettyLauncher {
    private Server server;
    
    public static void main(String[] args) {
        JerseyJettyLauncher launcher = new JerseyJettyLauncher();
        try {
            launcher.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void start() throws IOException {
        server = createJettyServer();
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected Server createJettyServer() {
        String myrestpackage = "devkook.study.rest";
        Server server = new Server(8765);
        
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/api");
        server.setHandler(context);
        ServletHolder holder = new ServletHolder(ServletContainer.class);
        holder.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
        holder.setInitParameter("com.sun.jersey.config.property.packages", myrestpackage );
        holder.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");

        context.addServlet(holder, "/*");

        return server;
    }
    
}
