
UserDetailsService : 
- 맨 앞 단의 인터페이스
- loadUserByUsername 이라는 추상 메소드를 가지고 저장 시스템 내에 있는 유저 세부정보 및 브라우저에 입력한 엔드 유저의 세부 정보를 로드함

UserDetailsManager :
- 유저 생성, 유저 업데이트, 유저 삭제, 비밀번호 변경 및 유저 존재 여부와 같은 모든 메소드를 포함하고 있다.

JdbcUserDetailsManager :
- 데이터베이스에서 유저 세부 정보를 검색할 수 있다.
- 인증 중에 데이터베이스를 다룰 때 사용

UserDetails :
- UserDetails는 스토리지 시스템에서 사용자 정보를 로드하는 모든 시나리오의 반환 유형입니다.


Principal (Interface):
- 엔티티의 이름이나 개인의 이름 또는 로그인 ID를 나타낸다.

Authentication (Interface) :
- getPrincipal 메소드를 상속하며 Authentication 내에는 getName, getAuthorities 와 같은 다른 메소드가 있다.
- 인증이 성공했는지 여부를 결정하려고 하는 모든 시나리오의 반환 유형