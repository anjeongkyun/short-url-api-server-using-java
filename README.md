# 220908-anjeongkyun

## 목차
* **[개발 환경](#개발-환경)**
* **[실행 방법](#실행-방법)**
* **[실행 결과](#실행-결과)**
  * [[POST] ShortLink 생성 API](#ShortLink-생성-API)
  * [[GET] ShortLink 조회 API](#ShortLink-조회-API)
* **[예외 처리](#예외-처리)**
  * [요청 URL 값이 비어있을 경우](#요청-URL-값이-비어있을-경우)
  * [요청 URL 형식이 잘못되었을 경우](#요청-URL-형식이-잘못되었을-경우)
  * [ShortLink 정보를 찾지 못할 경우](#ShortLink-정보를-찾지-못할-경우)
* **[테스트 실행 결과](#테스트-실행-결과)**

<br><hr><br>

# 개발 환경
* Java 8
* Spring Boot (v2.7.3)
* Spring Data JPA
* Lombok
* jUnit
* MySQL(v5.7)

<br><hr><br>

# 실행 방법

1. git clone을 합니다.

![제목 없음](https://user-images.githubusercontent.com/97106584/189321412-4df06975-d3bd-4699-8c5f-b0b2f8cebff8.png)

2. 위의 application.yaml에 설정한 내용과 같이 "airbridge" Database 생성 및 ID/PW를 설정합니다. (MySQL ver5.7)
3. Project Run 합니다.
4. Database Table 생성이 되었는지 확인합니다. (만약 생성이 안되었다면(?) MySQL Workbench에서 아래 링크에 있는 DDL을 복사한 후 실행시켜 테이블을 생성해줍니다.)
 #### [Schema.sql DDL바로가기](https://github.com/AB180-HR/220908-anjeongkyun/blob/master/data.sql)
5. API Test를 진행하실 수 있습니다.

<br><hr><br>

# 실행 결과
## ShortLink 생성 API
![image](https://user-images.githubusercontent.com/97106584/189299705-22448c75-1d6a-4c74-9dc6-6e6bf1521739.png)

<br>

## ShortLink 조회 API
![image](https://user-images.githubusercontent.com/97106584/189300026-c0616900-fde6-4b33-93c8-334d85af083e.png)

<br><hr><br>

# 예외 처리
## 요청 URL 값이 비어있을 경우
![image](https://user-images.githubusercontent.com/97106584/189313648-c12763dc-29f5-4750-a2e2-efd5848a2d92.png)

<hr>

## 요청 URL 형식이 잘못되었을 경우
![image](https://user-images.githubusercontent.com/97106584/189313450-b4201346-ab57-4517-8a27-4eeec3e92a09.png)

<hr>

## ShortLink 정보를 찾지 못할 경우
![image](https://user-images.githubusercontent.com/97106584/189313179-6a879983-cae2-4a5b-9ee3-9cb0c04e7747.png)

<br><hr><br>

# 테스트 실행 결과
![image](https://user-images.githubusercontent.com/97106584/189300345-356eba1f-c401-41d5-809e-181d8f8b76c3.png)
