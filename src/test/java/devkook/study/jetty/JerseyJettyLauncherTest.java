package devkook.study.jetty;

import static org.junit.Assert.*;

import org.junit.Test;


public class JerseyJettyLauncherTest {
    @Test
    public void 저지레스트테스트() throws Exception {
        //선행조건(given)
        String[] args = {};
        JerseyJettyLauncher.main(args);

        //기능수행(when)

        //결과확인(then)
        fail("때때로 실패하지 않으면, 안이하게 살고 있다는 확실한 증거이다");
    }
}
