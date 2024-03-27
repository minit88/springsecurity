# 커스텀 필터 요구 사항에 따른 코드

 SecurityFilterChain : 
- Spring Security에서 제공하는 인증,인가를 위한 필터들의 모음
- SecurityFilterChain 빈을 등록하기 위해 FilterChain 메소드를 구현
- FilterChain 메소드는 HttpSecurity를 통해 사용할 필터와 사용자가 직접 저으이한 필터를 정의가능

RequestMatchers :

- 몇몇의 API 경로를 받아들일 수 있다.


authenticated :
- API를 보호하기 위한 메소드

permitAll() : 
- API가 보호되지 않도록 하는 메소드