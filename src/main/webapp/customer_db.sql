-- データベースの削除
DROP DATABASE IF EXISTS customer_db;
-- データベースの作成
CREATE DATABASE customer_db CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- データベースの使用
USE customer_db;

-- ユーザーの作成と権限の付与
DROP USER IF EXISTS 'user'@'localhost';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'pass';
GRANT ALL PRIVILEGES ON customer_db.* TO 'user'@'localhost';
FLUSH PRIVILEGES;

-- テーブルの作成
CREATE TABLE m_area (
    area_code CHAR(4) NOT NULL PRIMARY KEY,
    area_name VARCHAR(10) NOT NULL UNIQUE KEY,
    update_datetime TIMESTAMP NOT NULL default current_timestamp on update current_timestamp
);

-- データを挿入
INSERT INTO m_area (area_code, area_name) VALUES
('A000', '地区未設定'),
('A100', '北海道'),
('A200', '東北'),
('A300', '関東'),
('A400', '中部'),
('A500', '近畿'),
('A600', '中国'),
('A700', '四国'),
('A800', '九州'),
('A900', '沖縄');

-- テーブルの作成
CREATE TABLE m_user (
    user_id VARCHAR(24) NOT NULL PRIMARY KEY,
    password VARCHAR(32) NOT NULL,
    user_name VARCHAR(20) NOT NULL UNIQUE KEY,
    update_datetime TIMESTAMP NOT NULL default current_timestamp on update current_timestamp
);

-- データを挿入
INSERT INTO m_user (user_id, password, user_name) VALUES
('user', 'pass','test');

-- テーブルの作成
CREATE TABLE m_customer (
    customer_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    customer_name VARCHAR(50) NOT NULL,
    customer_name_kana VARCHAR(100),
    postal_code VARCHAR(8),
    address VARCHAR(150),
    area_code CHAR(4) NOT NULL DEFAULT 'A000',
    FOREIGN KEY (area_code) REFERENCES m_area(area_code),
    contact_person_name VARCHAR(30),
    contact_person_name_kana VARCHAR(50),
    contact_person_tell VARCHAR(20),
    user_id VARCHAR(24) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES m_user(user_id),
    update_datetime TIMESTAMP NOT NULL default current_timestamp on update current_timestamp
);

-- データを挿入
INSERT INTO m_customer 
(customer_name,customer_name_kana,postal_code,address,area_code,contact_person_name,contact_person_name_kana,contact_person_tell,user_id) VALUES
('㈱立石', 'かぶしきがいしゃたていし', '999-9999','立石市立石区','A800','佐藤','さとう','080-1111-2222','user');