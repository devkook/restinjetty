# devkook's rest in jetty
간단하게 REST 기반 API 서비스를 제공하기 위하여! 지화자/얼씨구/잘한다/좋다

#### GET
* git clone 
* mvn eclipse:eclipse
* Eclipse 에서 import Existin Projects into Workspace 를 이용하여 불러오기


#### RUN
* mvn clean compile exec:java 라고 명령하면 jetty server 가 실행 되구요. 그 담은 테스트
* mvn assembly:assembly 로 하나로 묶어서 아래 java -Dport=8443 -jar jetty-jar-with-dependencies.jar 와 같이 서비스를 하면 됩니다.

#### TEST - "Advanced rest client"를 이용
* http://localhost:8765/api/SatelliteTower/ping - 우주시간 출력
* 
* http://localhost/api/user/whoau, POST - If you're curious, 500 won : ) http://devkook.tumbrl.com
* http://localhost:8765/api/user/getUser, GET - { name: "devkook" age: 0 }
* http://localhost:8765/api/user/setUser, POST, name:devin cook, age 53 - { name: "devin cook" age: 53 }
* http://localhost:8765/api/user/getUser, GET - { name: "devin cook" age: 53 }

#### CODE
* JerseyJettyLauncher.java - jetty 서버를 설정하고 실행합니다.
* UserCertificateResource.java - REST 서비스를 제공합니다. 
* UserVO.java - JSON 으로 변환되어 서비스에서 오고가는 정보입니다.


