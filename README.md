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

### ERD
```
+------------------+          +------------------+           +------------------+           +-----------------------+
|    Department    |          |      Budget      |           |   Disbursement   |           |   DisbursementItem    |
|------------------|          |------------------|           |------------------|           |-----------------------|
| seq (PK)         |<-------->| seq (PK)         |<--------->| seq (PK)         |<--------->| seq (PK)              |
| name             |          | amt              |           | title            |           | disbursement_seq (FK) |
+------------------+          | department_seq   |           | status           |           | name                  |
                              | quarter          |           | budget_seq (FK)  |           | currency_type         |
                              | year             |           +------------------+           | exchange_rate         |
                              +------------------+                                          | quantity              |
                                                                                            | unit_price            |
                                                                                            | total_amount          |
                                                                                            +———————————+

```

### ERD 설명
- Department (부서)
    - seq (부서 ID, 기본 키)
    - name (부서명)
    - Budget (예산 항목):
    - seq (예산 항목 ID, 기본 키)
    - amt (예산 금액)
    - department_seq (부서의 ID, Department 테이블을 참조하는 외래 키)
    - quarter (분기)
    - year (년도)
- Disbursement (지출결의서)
    - seq (지출결의서 ID, 기본 키)
    - title (지출결의서 제목)
    - status (상태: 'TEMP', 'WAITING', 'FIN')
    - budget_seq (예산 항목의 ID, Budget 테이블을 참조하는 외래 키)
- DisbursementItem (지출 항목)
    - seq (지출 항목 ID, 기본 키)
    - disbursement_seq (지출결의서 ID, Disbursement 테이블을 참조하는 외래 키)
    - name (지출 항목명)
    - currency_type (통화 종류: 'USD', 'KRW', 'JPY')
    - exchange_rate (환율)
    - quantity (수량)
    - unit_price (단가)
    - total_amount (총액: 수량 * 단가)