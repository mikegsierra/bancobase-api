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

-- bancobase.transaction_category definition
CREATE TABLE `transaction_category` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(20) NOT NULL,
    `code` varchar(15) NOT NULL,
    `active` bit(1) NOT NULL DEFAULT b '1',
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 6 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- bancobase.transaction_category definition
CREATE TABLE `transaction_category` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(20) NOT NULL,
    `code` varchar(15) NOT NULL,
    `active` bit(1) NOT NULL DEFAULT b '1',
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 6 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- bancobase.customer population
INSERT INTO
    bancobase.customer (name, created_at)
VALUES
    ('John Doe', '2022-11-29 19:01:12');

-- bancobase.account population
INSERT INTO
    bancobase.account (
        name,
        card_number,
        balance,
        customer_id
    )
VALUES
    (
        'Empresarial',
        '**** 1106',
        256790.34,
        1
    ),
    (
        'Cuenta de ahorro',
        '**** 2456',
        156902.09,
        1
    ),
    (
        'Cuenta familiar',
        '**** 3410',
        98872.65,
        1
    );

-- bancobase.transaction_category population
INSERT INTO
    bancobase.transaction_category (name, code)
VALUES
    ('Educación', 'education'),
    ('Viajes', 'travel'),
    ('Comida', 'food'),
    ('Gasolina', 'gas'),
    ('Otros', 'other');

-- bancobase.transaction population
INSERT INTO
    bancobase.transaction (account_id, category_id, amount)
VALUES
    (1, 3, 16478.39),
    (2, 5, 21125.92),
    (1, 5, 515.34),
    (3, 1, 21891.79),
    (2, 4, 15147.47),
    (1, 1, 20385.31),
    (1, 3, 14968.7),
    (1, 4, 4313.75),
    (2, 3, 24312.58),
    (2, 5, 6808.99),
    (1, 4, 15167.06),
    (2, 3, 5717.04),
    (3, 1, 17062.33),
    (3, 1, 17072.59),
    (3, 4, 13235.3),
    (2, 1, 12562.82),
    (1, 3, 1831.75),
    (3, 4, 16594.86),
    (3, 1, 14687.01),
    (3, 4, 18450.32),
    (1, 2, 7873.79),
    (2, 3, 4343.12),
    (2, 3, 1462.66),
    (1, 4, 15098.64),
    (2, 3, 7406.16),
    (3, 2, 15275.94),
    (1, 3, 19688.25),
    (3, 3, 4854.95),
    (3, 2, 3229.48),
    (3, 2, 10852.44),
    (2, 1, 6229.2),
    (1, 1, 15726.32),
    (2, 4, 2262.28),
    (2, 5, 15346.59),
    (1, 2, 5735.74),
    (1, 1, 10704),
    (1, 3, 8185.84),
    (3, 2, 22070.38),
    (2, 3, 9369.75),
    (1, 3, 17632.14),
    (3, 3, 6476.82),
    (3, 5, 7627.73),
    (3, 4, 1089.45),
    (2, 3, 5791.6),
    (1, 2, 17791.53),
    (2, 1, 8485.76),
    (2, 3, 3048.58),
    (1, 5, 5465.6),
    (3, 1, 15198.24),
    (2, 4, 1606.32),
    (1, 1, 2924.72),
    (2, 2, 9386.84),
    (1, 5, 1562.95),
    (1, 2, 7353.97),
    (2, 2, 8908.15),
    (2, 1, 18322.16),
    (3, 3, 12306.31),
    (1, 4, 19043.26),
    (2, 4, 4649.24),
    (3, 1, 22188.86),
    (1, 1, 9019.05),
    (1, 5, 13201.71),
    (2, 3, 10249.62),
    (3, 3, 766.91),
    (1, 4, 1824.11),
    (3, 5, 11651.71),
    (1, 4, 4508.76),
    (2, 1, 19761.79),
    (3, 5, 22496.65),
    (3, 3, 9670.74),
    (3, 5, 17591.8),
    (1, 1, 24945.74),
    (3, 3, 15509.86),
    (3, 5, 2814.09),
    (2, 2, 24804.78),
    (3, 3, 23567.99),
    (2, 3, 5808.53),
    (1, 3, 2448.92),
    (3, 1, 2677.9),
    (3, 2, 10670.8),
    (3, 5, 6292.46),
    (1, 3, 15328.24),
    (1, 3, 3510.55),
    (3, 4, 3288.17),
    (3, 4, 3994.79),
    (1, 2, 6823.32),
    (1, 4, 9788.71),
    (2, 3, 10913.12),
    (1, 4, 13172.36),
    (3, 4, 5701.67),
    (1, 2, 21158.84),
    (3, 5, 4175.95),
    (1, 2, 21810.26),
    (3, 3, 9660.7),
    (2, 3, 4716.33),
    (3, 4, 22579.09),
    (1, 5, 14068.21),
    (1, 2, 6535.38),
    (2, 4, 17768.3),
    (3, 4, 699.54);

-- bancobase.account update balance from transactions
UPDATE
    account
SET
    account.balance = (
        SELECT
            SUM(t.amount) AS total
        FROM
            `transaction` t
        WHERE
            t.account_id = account.id
        GROUP BY
            t.account_id
    )