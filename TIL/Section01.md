
## Servlets & Filters

![스크린샷 2024-03-20 오후 11.19.44.png](..%2F..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F59%2Fdmqth6t91yg3xpf4dvf223_m0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_y3CpAA%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-03-20%20%EC%98%A4%ED%9B%84%2011.19.44.png)

__Servlet Container (WebServer)__ : java 코드는 http 프로토콜 요청을 이해할 수 없기에 java 코드와 브라우저 사이 서블릿 컨테이너가 중개자 역할
                        
                
-  __서블릿 컨테이너를 통하는 http request 흐름__
    - http request (브라우저 요청)
    - ServletRequest object ( 서블릿 컨테이너에서 변환되어 자바 코드로 전송)
- __서블릿 컨테이너를 통해 브라우저로 요청을 보낼 때 흐름__
    - 서블릿은 HTTP ServletResponse object를 http 형식으로 변환하여 리턴함

__Filter__ : 필터는 웹 애플리케이션에 관한 모든 요청을 가로챌 수 있다. 그로 인해 필터에 정의내린 기능을 동작 가능

## Spring Security Internal Flow
![스크린샷 2024-03-22 오후 11.09.10.png](..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F59%2Fdmqth6t91yg3xpf4dvf223_m0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_YyyXE7%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-03-22%20%EC%98%A4%ED%9B%84%2011.09.10.png)

__Spring Security Filters__ : 
    
- 백엔드 서버에 들어오는 모든 요청을 감시함 
- 이 필터들은 엔드 유저가 접근하고자 하는 경로를 확인한다.
- 경로와 설정에 따라 이 필터들은 경로의 자원이 보호된 자원인지 공개적으로 접근 가능한 자원인지를 판별
- 해당 유저에 인증을 강제할지 안 할지를 결정
- 유저의 아이디와 비밀번호를 이용하여 인증 객체를 생성하고 요청을 인증 관리자에 넘김


__Authentication Manager__ :

- 인증 관리자는 실질적인 인증 로직을 관리하는 관리 인터페이스 또는 클래스
- 웹 애플리케이션 안에 어떤 인증 제공자가 존재하는지 확인
- 특정 요청에 대해 유효한 인증 제공자가 어떤 것인지 확인 하는 역할

__Authentication Providers__ :

- 사용자 요구사항에 따라 무한대로 인증 제공자를 정의할 수 있다.

__Security Context__ :

- 요청을 유저에게 넘겨주기 전 Authentication 에서 생성한 인증 객체를 보안 컨텍스트 안에 저장.
- 인증이 성공되었느지 여부 또는 세션 ID와 같은 인증 정보를 저장 
- 인증 객체를 컨텍스트에 저장되어 있어 로그인을 한 두번째 요청 부터는 해당 유저의 자격증명을 요구하지 않게 됨.