package devkook.study.jetty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class JettyLauncher extends AbstractHandler {

    public static void main(String[] args) {
        
        try{
            Server server = new Server(1318);
            server.setHandler(new JettyLauncher());

            server.start();
            server.join();
        }catch(Exception e){
            System.out.println("START Exception:"+e);
        }        
    }

    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String question = baseRequest.getParameter("question");

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);

        String answer = answer(question);
        response.getWriter().println("questions:" + question + " => answers:" + answer);
    }

    protected String answer(String question) {

        String answer = "Sorry Did not understand the question. Please follow the format of questions. ex) question=101plus102";

        try {
            String[] numbers = question.split("plus");

            int n1 = Integer.parseInt(numbers[0]);
            int n2 = Integer.parseInt(numbers[1]);
            int sum = n1 + n2;

            answer = Integer.toString(sum);

        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }

        return answer;
    }
}