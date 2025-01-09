## 입사지원자 정병택 과제 (BACKEND)

## 과제 수행 PC 환경
```
os : window 10 home
ide : intellij 2023.2.8
java : corretto-17
postgresql : 15.10.3
springboot : 3.2.0 (gradle)

```

## 프로젝트 실행 유의사항
```
DB의 접속 정보는 아래의 포트와 username/password를 사용 하고있습니다

해당 계정의 생성 및 포트 확인 부탁드립니다
postgrelsql port : 5432
db : postgres   /   schemas : public
usetname : recruit_test
password : recruit_test
```

```
JDK는 corretto-17를 사용 하였으며 실행 전 확인이 필요한 부분은 아래와 같습니다

(intellij 기준)

project structure -> sdk -> corretto-17

setting -> Build, Execution, Deployment -> build tools -> gradle -> gradle jvm -> project sdk

run configuration -> Application -> edit configuration -> JDK 17 선택

run configuration -> Application -> RUN

이후에도 오류가 발생한다면 
gradle -> build -> clean
clean 완료 이후 
Application Run으로 재시도 부탁드립니다

```