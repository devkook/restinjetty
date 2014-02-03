# devkook's rest in jetty
간단하게 REST 기반 API 서비스를 제공하기 위하여! 지화자/얼씨구/잘한다/좋다

#### GET
* git clone 
* mvn eclipse:eclipse
* Eclipse 에서 import Existin Projects into Workspace 를 이용하여 불러오기


#### RUN
* mvn clean compile exec:java 라고 명령하면 jetty server 가 실행 되구요. 그 담은 테스트
* mvn package 이후 target 폴더이동하여 java -Dport=8443 -jar restinjetty.jar 로 구동 ( 2014.2.3 오류확인 이슈등록)
* mvn assembly:assembly 로 하나로 묶어서 아래 java -Dport=8443 -jar jetty-jar-with-dependencies.jar 와 같이 서비스를 하면 됩니다. (오류 발생 - 문제 해결중)

#### TEST - user - "Advanced rest client"를 이용
* http://localhost:8765/api/user/whoau, POST - If you're curious, 500 won : ) http://devkook.tumbrl.com
* http://localhost:8765/api/user/getUser, GET - { name: "devkook" age: 0 }
* http://localhost:8765/api/user/setUser, POST, name:devin cook, age 53 - { name: "devin cook" age: 53 }
* http://localhost:8765/api/user/getUser, GET - { name: "devin cook" age: 53 }

#### TEST - Contact
* http://127.0.0.1:8765/api/Contact, POST (<Contact><email>meme@me.com</email><name>meme</name><phone>1004</phone></Contact>
* http://127.0.0.1:8765/api/Contact/getUser, GET ( FROM 에 email, meme@me.com 입력 )
* http://127.0.0.1:8765/api/Contact/meme@me.com, GET
* http://127.0.0.1:8765/api/Contact/meme@me.com, PUT (<Contact><email>meme@me.com</email><name>MyMeMe</name><phone>1004-8282</phone></Contact>
* * http://127.0.0.1:8765/api/Contact/meme@me.com, DELETE

#### TEST - SatelliteTower
* culr -X POST http://localhost:8765/api/SatelliteTower/ping - 우주시간 출력
* http://localhost:8765/api/SatelliteTower/NARO50411131BIGBANG - GET {"launchKey":"NARO50411131BIGBANG","controlStation":"만휴정","name":"bigBANg"}
* http://localhost:8765/api/SatelliteTower - POST {"launchKey":"NARO50411131BIGBANG-2","controlStation":"병산서원","name":"bigBANgAfter"}
* http://localhost:8765/api/SatelliteTower/NARO50411131BIGBANG-2 - GET
* http://localhost:8765/api/SatelliteTower - POST {"launchKey":"NARO50411131BIGBANG-2","controlStation":"하화마을","name":"bigBANgAfter"}
* http://localhost:8765/api/SatelliteTower - DELETE - 500ERR - TODO

#### CODE
* JerseyJettyLauncher.java - jetty 서버를 설정하고 실행합니다.
* UserCertificateResource.java - REST 서비스를 제공합니다. 
* UserVO.java - JSON 으로 변환되어 서비스에서 오고가는 정보입니다.

### 성능테스트
* http://devkook.tumblr.com/post/67739398494/appdynamics-install 참고 AppDynamics 다운 및 설치
* AppDynamics agent 폴더를 pom.xml 과 동등 레벨로 복사, 아래와 같이 지정하여 실행
* java -javaagent:../adagent/javaagent.jar -Dport=8443 -jar restinjetty.jar
* 모니터링뷰에 접속하여 config pojo (+) 하여 특정 클래스뫄 메소드 입력


