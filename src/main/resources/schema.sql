CREATE TABLE task (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    priority CHAR(1) NOT NULL CHECK (priority IN ('A', 'B', 'C')),
    status VARCHAR(10) NOT NULL DEFAULT '未着手' CHECK (status IN ('未着手', '進行中', '完了')),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);