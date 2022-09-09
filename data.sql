CREATE TABLE `tb_short_url` (
                                `url_id` bigint(20) NOT NULL AUTO_INCREMENT,
                                `short_id` varchar(255) DEFAULT NULL,
                                `origin_url` varchar(3000) DEFAULT NULL,
                                `created_at` datetime DEFAULT current_timestamp(),
                                `updated_at` datetime DEFAULT current_timestamp(),
                                PRIMARY KEY (`url_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8m