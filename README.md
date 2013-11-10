#devkook's rest in jetty
간단하게 REST 기반 API 서비스를 제공하기 위하여! 건배~ 

##RUN
* mvn install
* JerseyJettyLauncher 를 실행하면 jetty server 가 실행됩니다. 

##TEST - "Advanced rest client"를 크롭스토어에서 받아서 사용합니다.
* http://localhost/api/user/whoau, POST - If you're curious, 500 won : ) http://devkook.tumbrl.com
* http://localhost:8765/api/user/getUser, GET - { name: "devkook" age: 0 }
* http://localhost:8765/api/user/setUser, POST, name:devin cook, age 53 - { name: "devin cook" age: 53 }
* http://localhost:8765/api/user/getUser, GET - { name: "devin cook" age: 53 }

