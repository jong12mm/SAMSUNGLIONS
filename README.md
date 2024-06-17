# SAMSUNGLIONS 홈페이지

DEVELOPMENT MOTIVATION
---
> 삼성라이온즈 홈페이지 -
> > -- 개발동기 적는부분<br> 
> > -- 에 의 불편함에 의해 ~~ <br> 
 

HISTORY
---
[TOTAL](DOCUMENT/HISTORY/TOTAL) | [이종일](DOCUMENT/HISTORY/이종일) | [정대민](DOCUMENT/HISTORY/정대민) | [이건무](DOCUMENT/HISTORY/이건무) |  [강현우](DOCUMENT/HISTORY/강현우) | 


PLANS
---
 |LANGUAGE|PLAN|IMPLEMENT|DESCRIPTION|
 |-|-|-|-|
 |JAVA|-|-|-|
 |JSP/SERVLET|2024/04/24 - 2024/04/28|-|-|
 |SPRING STS3|-|-|-|
 |SPRING BOOT|2024/06/01 - 2024/06/30|-|-|
 

MEMBERERS
--- 
|NAME|ROLE|DETAILS|DESCRIPTION| 
|---|---|---|---|
|정우균|FN| FrontController / Docment 관리 / Dependencies  관리 |---|
|정대민|BN| admin - 회원가입 / 회원탈퇴 / CRUD|---|
|이종일|BN| 유저공통 - 로그인 / 로그아웃|---|
|이건무|BN| member 회원가입 / 회원탈퇴 /  CRUD|---|
|강현우|FN| 모든 PAGE와 서버간 REQ / RESP |---|

SKILLS
---

#### FN
---
<img src="https://img.shields.io/badge/HTML5-3366CC?style=for-the-badge&logo=htmlacademy&logoColor=white"> <img src="https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/JAVASCRIPT-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white"> <img src="https://img.shields.io/badge/JQUERY-0769AD?style=for-the-badge&logo=jquery&logoColor=white"> 


#### BN
---
<img src="https://img.shields.io/badge/JAVA-005571?style=for-the-badge&logo=doubanread&logoColor=white"> <img src="https://img.shields.io/badge/JSP-1E8CBE?style=for-the-badge&logo=doubanread&logoColor=white"> <img src="https://img.shields.io/badge/SERVLET-4B4B77?style=for-the-badge&logo=doubanread&logoColor=white"> <img src="https://img.shields.io/badge/SPRING-STS3-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/SPRINGBOOT-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> 

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
|/user/join|POST|---|---|---|
|/user/login|GET/POST|---|---|---|
|/user/logout|POST|---|---|---|
|---|---|---|---|---|
|/seeker/join|---|---|---|---|
|/seeker/remove|---|---|---|---|
|/seeker/resume/add|---|---|---|---|
|/seeker/resume/list|---|---|---|---|
|---|---|---|---|---|
|/offer/join|---|---|---|---|
|/offer/remove|---|---|---|---|
|/offer/company/read|---|---|---|---|
|---|---|---|---|---|

DEPENDENCIES LIST
---
|CAT|NAME|DESCRIPTION|LINK|-|-|
|-|-|-|-|-|-|
|FN|-|-|-|-|-|
|FN|-|-|-|-|-|
|BN|-|-|-|-|-|
|BN|-|-|-|-|-|
|DB|-|-|-|-|-|
|DEVOPS|-|-|-|-|-|


ERD[KoreaJobDb]
---
![20240425155554](https://github.com/jungwoogyun/EM-01-PROJECTS/assets/84259104/8631169d-3c85-4be4-a097-613bf1e5b7e0)


FILE TREES[JSP/SERVLET]
--- 
```
C:.
├─.gradle
│  ├─8.7
│  │  ├─checksums
│  │  ├─dependencies-accessors
│  │  ├─executionHistory
│  │  ├─expanded
│  │  ├─fileChanges
│  │  ├─fileHashes
│  │  └─vcsMetadata
│  ├─buildOutputCleanup
│  └─vcs-1
├─.idea
│  ├─inspectionProfiles
│  └─modules
├─gradle
│  └─wrapper
├─out
│  └─production
│      ├─classes
│      │  └─com
│      │      └─example
│      │          └─sl
│      │              ├─config
│      │              ├─controller
│      │              ├─domain
│      │              │  ├─dao
│      │              │  │  └─common
│      │              │  ├─dto
│      │              │  └─service
│      │              ├─entity
│      │              └─repository
│      └─resources
│          ├─static
│          │  ├─css
│          │  │  ├─bookcss
│          │  │  ├─clubcss
│          │  │  └─usercss
│          │  ├─font
│          │  ├─fragments
│          │  ├─img
│          │  └─js
│          └─templates
│              ├─book
│              ├─club
│              ├─fragments
│              └─user
└─src
    ├─main
    │  ├─generated
    │  ├─java
    │  │  └─com
    │  │      └─example
    │  │          └─sl
    │  │              ├─config
    │  │              │  └─auth
    │  │              ├─controller
    │  │              ├─domain
    │  │              │  ├─dao
    │  │              │  │  └─common
    │  │              │  ├─dto
    │  │              │  └─service
    │  │              ├─entity
    │  │              └─repository
    │  └─resources
    │      ├─static
    │      │  ├─css
    │      │  │  ├─bookcss
    │      │  │  ├─clubcss
    │      │  │  └─usercss
    │      │  ├─font
    │      │  ├─img
    │      │  └─js
    │      └─templates
    │          ├─book
    │          ├─club
    │          ├─fragments
    │          ├─user
    │          └─기록
    └─test
        └─java
            └─com
                └─example
                    └─sl

