package Vdtry06.Springboot.database;

import Vdtry06.Springboot.models.Product;
import Vdtry06.Springboot.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
docker run -d-rm-name mysql-spring-boot-tutorial \
-e MYSQL_ROOT_PASSWORD=root \
-e MYSQL_USER=root \
-e MYSQL_PASSWORD=root \
-e MYSQL_DATABASE=Test\
-p 3307:3306 \
--plume mysql-spring-boot-tutorial-volume:/var/lib/mysql \
mysql:latest
 */
@Configuration // dung de khoi tao database, moi truong, ...
public class Database {
    // logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean // phuong thuc chay ngay khi app chay
    // tao bang
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return new CommandLineRunner() { // interface
            @Override
            public void run(String... args) throws Exception {
//                Product productA = new Product("Macbook pro 15", 2020, 2200.0, "");
//                Product productB = new Product("ipad air green", 2021, 599.0, "");
//                logger.info("insert data" + productRepository.save(productA));
//                logger.info("insert data" + productRepository.save(productB));
            }
        };
    }
}
