package devkook.study.jetty;

import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class JerseyJettyLauncher {
    private Server server;
    private int port = 8765;
    
    public static void main(String[] args) {
        JerseyJettyLauncher launcher = new JerseyJettyLauncher();
        
        try {
            launcher.start();
            launcher.server.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public void setPort(){
    	this.port = Integer.parseInt(System.getProperty("port", "8765"));
    }
    
    public void start() throws IOException {
        server = createJettyServer();
        try {
            server.start();            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void stop() throws Exception{
    	server.stop();
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
