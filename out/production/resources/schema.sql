DROP TABLE IF EXISTS disbursement_item;
DROP TABLE IF EXISTS disbursement;
DROP TABLE IF EXISTS budget;
DROP TABLE IF EXISTS department;

CREATE TABLE department (
    seq SERIAL PRIMARY KEY,           -- 부서 ID (자동 증가)
    name VARCHAR(255) NOT NULL        -- 부서명
);

CREATE TABLE budget (
    seq SERIAL PRIMARY KEY,           -- 예산 항목 ID (자동 증가)
    amt DOUBLE PRECISION NOT NULL, -- 예산 금액
    department_seq INT NOT NULL,       -- 부서 ID (외래 키)
    quarter INT,
    year INT,
    UNIQUE(department_seq, year, quarter),
    CONSTRAINT fk_department FOREIGN KEY (department_seq)
        REFERENCES department(seq)    -- 부서 테이블의 id를 참조
        ON DELETE CASCADE             -- 부서 삭제 시, 관련 예산 항목도 삭제
);

CREATE TABLE disbursement (
    seq SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    status VARCHAR(15) CHECK (status in ('TEMP', 'WAITING', 'FIN')) NOT NULL,
    budget_seq INT NOT NULL,
    CONSTRAINT fk_budget FOREIGN KEY (budget_seq)
        REFERENCES budget(seq)
);

CREATE TABLE disbursement_item (
    seq SERIAL PRIMARY KEY,
    disbursement_seq INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    currency_type VARCHAR(15) CHECK (currency_type in ('USD', 'KRW', 'JPY')) NOT NULL,
    exchange_rate DOUBLE PRECISION NOT NULL,
    quantity INT NOT NULL,
    unit_price DOUBLE PRECISION NOT NULL,
    CONSTRAINT fk_budget FOREIGN KEY (disbursement_seq)
        REFERENCES disbursement(seq)
        ON DELETE CASCADE
);

