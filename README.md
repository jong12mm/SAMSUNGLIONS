# SAMSUNGLIONS 통합 예매 웹 프로젝트

DEVELOPMENT MOTIVATION
---
> 삼성라이온즈 홈페이지
> > 야구 티켓 예매를 하려면 티켓링크라는 사이트에 따로 들어가서 예매를 해야하는 불편함이 있는데, 이를 하나의 플랫폼에서 예매할 수 있는 서비스를 개발하고 싶었습니다.
> > 이런 서비스는 사용자가 다양한 서비스를 즐기며 예매도 같이하는데 도움을 줄 것입니다.
> > 또, 사용자들의 편의를 위해 티켓 예매 과정을 간편하고 효율적으로 만들고, 다양한 옵션과 혜택을 제공하여 사용자들에게 더 나은 서비스를 제공할 것입니다.<br> 
 

branch
---
[이종일](http://github.com/jong12mm/SAMSUNGLIONS/tree/이종일) | [정대민](http://github.com/jong12mm/SAMSUNGLIONS/tree/정대민) | [강현우](http://github.com/jong12mm/SAMSUNGLIONS/tree/강현우) | [이건무](http://github.com/jong12mm/SAMSUNGLIONS/tree/이건무) | 


PLANS
---
 |LANGUAGE|PLAN|IMPLEMENT|DESCRIPTION|
 |-|-|-|-|
 |JAVA|-|-|-|
 |JSP/SERVLET|2024/04/24 - 2024/04/28|-|-|
 |SPRING STS3|2024/04/29 ~ 2024/05/03|-|-|
 |SPRING BOOT|2024/06/01 - 2024/06/30|-|-|
 

MEMBERERS
--- 
|NAME|ROLE|DETAILS|DESCRIPTION| 
|---|---|---|---|
|Together|---| FrontController / Document 관리 / Dependencies  관리 |---|
|이종일|조장| USER - 회원가입 / 회원탈퇴 / 예매 C.U.|---|
|정대민|조원| USER - 회원가입 / 회원탈퇴 / 예매 R.D.|---|
|강현우|조원| 유저공통 - 로그인 / 로그아웃|---|
|이건무|조원| MANAGER 회원가입 회원탈퇴|---|

SKILLS
---

#### FN
---
<img src="https://img.shields.io/badge/HTML5-3366CC?style=for-the-badge&logo=htmlacademy&logoColor=white"> <img src="https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/JAVASCRIPT-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white"> <img src="https://img.shields.io/badge/JQUERY-0769AD?style=for-the-badge&logo=jquery&logoColor=white"> 


#### BN
---
<img src="https://img.shields.io/badge/JAVA-005571?style=for-the-badge&logo=doubanread&logoColor=white"> <img src="https://img.shields.io/badge/JSP-1E8CBE?style=for-the-badge&logo=doubanread&logoColor=white"> <img src="https://img.shields.io/badge/SERVLET-4B4B77?style=for-the-badge&logo=doubanread&logoColor=white"> <img src="https://img.shields.io/badge/SPRING-STS3-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/SPRINGBOOT-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img
src="https://img.shields.io/badge/IntelliJ_IDEA-Ultimate-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">

#### DATABASE
---
<img src="https://img.shields.io/badge/MYSQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white">  


#### DEVOPS
---
<img src="https://img.shields.io/badge/GIT-F05032?style=for-the-badge&logo=git&logoColor=white"> <img src="https://img.shields.io/badge/GITHUB-181717?style=for-the-badge&logo=github2&logoColor=white"> <img src="https://img.shields.io/badge/AWS-EC2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white"> <img src="https://img.shields.io/badge/DOCKER-2496ED?style=for-the-badge&logo=docker&logoColor=white"> <img src="https://img.shields.io/badge/DOCKERHUB-2496ED?style=for-the-badge&logo=docker&logoColor=white"> <img src="https://img.shields.io/badge/JENKINS-D24939?style=for-the-badge&logo=jenkins&logoColor=white"> 


END POINT DOC
---
|URI|REQUEST METHOD|REQUEST PARAMETER TYPE|RESPONSE VALUE TYPE|DESCRIPTION|
|---|---|---|---|---|
|/book/add|POST|bookid : Long<br>bookid : Long<br>seatid : String<br>name : String<br>gameinfoId : LocalDateTime<br>date : String<br>bookstatus : String<br>payid : String|JSON|예매 추가|
|/book/list|GET|type : String<br>keyword : String<br>pageNo : String|JSON|예매 목록 조회|
|/book/read|GET|---|JSON|예매 상세 정보 조회|
|/book/update|POST|updateIdStr :  Long<br>bookid : Long<br>seatid : String<br>name : String<br>gameinfoId : LocalDateTime<br>date : String<br>bookstatus : String<br>payid : String|JSON|예매 정보 업데이트|
|/book/delete|POST|type : String<br>keyword : String<br>pageNo : String<br>deleteIdStr : String|JSON|예매 삭제|
|/user/add|POST|username : String<br>password : String|JSON|새로운 사용자 추가|
|/user/read|GET|---|JSON|사용자 상세 정보 조회|
|/user/update|POST|---|JSON|사용자 정보 업데이트|
|/user/delete|POST|---|JSON|사용자 삭제|
|/login|POST|username : String<br>password : String|JSON|사용자 로그인|
|/logout|POST|None|JSON|사용자 로그아웃|

DEPENDENCIES LIST
---
|CAT|NAME|DESCRIPTION|LINK|
|-|-|-|-|
|BN|Commons Logging|로깅 추상화 레이어|[Commons Logging](https://commons.apache.org/proper/commons-logging/)|
|BN|HikariCP|고성능 자바 SQL 데이터베이스 커넥션 풀|[HikariCP](https://github.com/brettwooldridge/HikariCP)|
|BN|JSTL|JSP 태그 라이브러리|[JSTL](https://mvnrepository.com/artifact/javax.servlet/jstl)|
|BN|Logback Classic|로깅 프레임워크 (SLF4J의 구현체 중 하나)|[Logback](https://mvnrepository.com/artifact/ch.qos.logback/logback-classic)|
|BN|MySQL Connector/J|MySQL 데이터베이스 연결을 위한 자바 드라이버|[MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)|
|DB|SLF4J API|간단한 로깅 파사드 for Java (로깅 API 추상화 레이어)|[SLF4J](https://www.slf4j.org/)|
|SEC|Spring Security Crypto|스프링 시큐리티의 암호화 모듈|[Spring Security Crypto](https://mvnrepository.com/artifact/org.springframework.security/spring-security-crypto)|


ERD[samsungdb]
---
![20240425155554](https://github.com/jungwoogyun/EM-01-PROJECTS/assets/84259104/8631169d-3c85-4be4-a097-613bf1e5b7e0)


FILE TREES[SPRING BOOT]
--- 
```
C:.
│  .gitignore
│  build.gradle
│  gradlew
│  gradlew.bat
│  HELP.md
│  settings.gradle
│
├─.gradle
|
├─.idea
|
├─gradle
│
├─out
└─src
    ├─main
    │  ├─generated
    │  ├─java
    │  │  └─com
    │  │      └─example
    │  │          └─sl
    │  │              │  SlApplication.java
    │  │              │
    │  │              ├─config
    │  │              │  │  WebMvcConfig.java
    │  │              │  │
    │  │              │  └─auth
    │  │              ├─controller
    │  │              │      BookController.java
    │  │              │      ClubController.java
    │  │              │      HomeController.java
    │  │              │      LoginController.java
    │  │              │      PaymentController.java
    │  │              │      UserController.java
    │  │              │
    │  │              ├─domain
    │  │              │  ├─dao
    │  │              │  │  └─common
    │  │              │  │          CommonDao.java
    │  │              │  │          ConnectionPool.java
    │  │              │  │          ConnectionPool_ByHikari.java
    │  │              │  │
    │  │              │  ├─dto
    │  │              │  │      BookDto.java
    │  │              │  │      GameInfoDto.java
    │  │              │  │      PaymentDto.java
    │  │              │  │      SeatDto.java
    │  │              │  │
    │  │              │  └─service
    │  │              │          BookService.java
    │  │              │          BookServiceImpl.java
    │  │              │          PaymentService.java
    │  │              │          PaymentServiceImpl.java
    │  │              │
    │  │              ├─entity
    │  │              │      BookEntity.java
    │  │              │      GameInfoEntity.java
    │  │              │      PaymentEntity.java
    │  │              │      SeatEntity.java
    │  │              │
    │  │              └─repository
    │  │                      BookRepository.java
    │  │                      GameInfoRepository.java
    │  │                      PaymentRepository.java
    │  │                      SeatRepository.java
    │  │
    │  └─resources
    │      │  application.properties
    │      │
    │      ├─static
    │      │  ├─css
    │      │  │  │  footer.css
    │      │  │  │  fullpage.min.css
    │      │  │  │  navbar.css
    │      │  │  │  slick-theme.css
    │      │  │  │  slick.css
    │      │  │  │  style.css
    │      │  │  │
    │      │  │  ├─bookcss
    │      │  │  │      booklist.css
    │      │  │  │      book_finish.css
    │      │  │  │      book_game_info.css
    │      │  │  │      book_real_start.css
    │      │  │  │      book_start.css
    │      │  │  │
    │      │  │  ├─clubcss
    │      │  │  │      announcement.css
    │      │  │  │      lionsPark.css
    │      │  │  │      slhistory.css
    │      │  │  │      slintro.css
    │      │  │  │      slnews.css
    │      │  │  │
    │      │  │  └─usercss
    │      │  │          adult_join.css
    │      │  │          children_join.css
    │      │  │          join_finish.css
    │      │  │          join_start.css
    │      │  │          login.css
    │      │  │
    │      │  ├─font
    │      │  │
    │      │  ├─img
    │      │  │
    │      │  └─js
    │      │          fullpage.min.js
    │      │          gallery.js
    │      │          jquery-3.7.1.min.js
    │      │          LionsPark.js
    │      │          nav.js
    │      │          schedule.js
    │      │          scroll.js
    │      │          slick.js
    │      │          slick.min.js
    │      │
    │      └─templates
    │          ├─book
    │          │      book_finish.html
    │          │      book_game_info.html
    │          │      book_real_start.html
    │          │      booklist.html
    │          │      book_start.html
    │          │
    │          ├─club
    │          │      announcement.html
    │          │      lionsPark.html
    │          │      slhistory.html
    │          │      slintro.html
    │          │      slnews.html
    │          │
    │          ├─fragments
    │          │      footer.html
    │          │      nav.html
    │          │
    │          ├─user
    │          │      adult_join.html
    │          │      children_join.html
    │          │      join_finish.html
    │          │      join_start.html
    │          │      login.html
    │          │
    │          ├─기록
    │          │  samsung.html
    │          │
    └─ test
        └─ java
            └─ com
                └─ example
                    └─ sl
                        └─ SlApplicationTests.java

