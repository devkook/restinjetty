package devkook.study.jetty;

import static org.junit.Assert.*;

import org.junit.Test;


public class JettyLauncherTest {
    @Test
    public void 질문에대답잘하나() throws Exception {
        //선행조건(given)        
        String question = "1plus1";

        //기능수행(when)
        JettyLauncher jetty = new JettyLauncher();
        String answer = jetty.answer(question);

        //결과확인(then)
        assertEquals("질문 이해 & 정확한 답변?", "2", answer);
        //fail("때때로 실패하지 않으면, 안이하게 살고 있다는 확실한 증거이다");
    }
    
    @Test
    public void 오직더하기한우물만파나() throws Exception {
        //선행조건(given)        
        String question = "1-1";

        //기능수행(when)
        JettyLauncher jetty = new JettyLauncher();
        String answer = jetty.answer(question);

        //결과확인(then)
        assertEquals("질문 이해 & 정확한 답변?", "Sorry Did not understand the question. Please follow the format of questions. ex) question=101plus102", answer);
        
        //fail("때때로 실패하지 않으면, 안이하게 살고 있다는 확실한 증거이다");
    }
}
