
## Servlets & Filters

![스크린샷 2024-03-20 오후 11.19.44.png](..%2F..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F59%2Fdmqth6t91yg3xpf4dvf223_m0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_y3CpAA%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-03-20%20%EC%98%A4%ED%9B%84%2011.19.44.png)

__Servlet Container (WebServer)__ : java 코드는 http 프로토콜 요청을 이해할 수 없기에 java 코드와 브라우저 사이 서블릿 컨테이너가 중개자 역할
                        
                
-  __서블릿 컨테이너를 통하는 http request 흐름__
    - http request (브라우저 요청)
    - ServletRequest object ( 서블릿 컨테이너에서 변환되어 자바 코드로 전송)
- __서블릿 컨테이너를 통해 브라우저로 요청을 보낼 때 흐름__
    - 서블릿은 HTTP ServletResponse obj

__Filter__ : 필터는 웹 애플리케이션에 관한 모든 요청을 가로챌 수 있다. 그로 인해 필터에 정의내린 기능을 동작 가능

