CREATE DATABASE `myproject` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `detailed` (
                            `id` int NOT NULL,
                            `status` tinyint DEFAULT NULL COMMENT '收入或者支出  收入1 支出2',
                            `amount` int DEFAULT NULL COMMENT '金额',
                            `wallet_id` int DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
                        `id` int NOT NULL,
                        `userName` varchar(45) DEFAULT NULL COMMENT '用户名',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `wallet` (
                          `id` int NOT NULL,
                          `user_id` int DEFAULT '0' COMMENT '用户id',
                          `money` int DEFAULT '0' COMMENT '余额',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
