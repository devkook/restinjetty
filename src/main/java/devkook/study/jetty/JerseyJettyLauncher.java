package devkook.study.jetty;

import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import com.sun.jersey.spi.container.servlet.ServletContainer;

public class JerseyJettyLauncher {
    private Server server;
    private int port;
    
    public static void main(String[] args) {
        JerseyJettyLauncher launcher = new JerseyJettyLauncher();
        launcher.port = Integer.parseInt(System.getProperty("port", "7788"));
        
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
        Server server = new Server(this.port);
        
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
