-- bancobase.customer definition
CREATE TABLE `customer` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 2 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- bancobase.account definition
CREATE TABLE `account` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    `card_number` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `balance` decimal(12, 2) NOT NULL,
    `customer_id` bigint NOT NULL,
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `Account_FK` (`customer_id`),
    CONSTRAINT `Account_FK` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 4 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- bancobase.customer population
INSERT INTO
    bancobase.customer (name, created_at)
VALUES
    ('John Doe', '2022-11-29 19:01:12');

-- bancobase.account population
INSERT INTO
    bancobase.account (name, card_number, balance, customer_id, created_at)
VALUES
    (
        'Empresarial',
        '**** 1106',
        256790.34,
        1,
        '2022-11-29 19:18:30'
    ),
    (
        'Cuenta de ahorro',
        '**** 2456',
        156902.09,
        1,
        '2022-11-29 19:18:30'
    ),
    (
        'Cuenta familiar',
        '**** 3410',
        98872.65,
        1,
        '2022-11-29 19:18:30'
    );