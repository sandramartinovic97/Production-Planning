/*
package project.productionplanning;

import com.zaxxer.hikari.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.net.URISyntaxException;

@Configuration
public class DatabaseConfig {

*/
/*    @Value("${spring.datasource.url}")
    private String dbUrl;*//*


    */
/*@Bean
    public DataSource dataSource() throws URISyntaxException{
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("postgres://srkbhoqircpqjk:123e7689864debdd38a4c526b76863f0a316f722e99baa87011bac8b05a97ca7@ec2-176-34-105-15.eu-west-1.compute.amazonaws.com:5432/d1ebvp4ghg5emf");
        return new HikariDataSource(config);
    }*//*


    */
/*@Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        String dbUrl = System.getenv("jdbc:postgres://utrsjlwsvqpoqd:0f68c47d55adf3f7ab12e73d1f9d96ba9fff595c12e30007404e1c5e368c74be@ec2-34-242-89-204.eu-west-1.compute.amazonaws.com:5432/daacr4f7829drd");
        String username = System.getenv("utrsjlwsvqpoqd");
        String password = System.getenv("0f68c47d55adf3f7ab12e73d1f9d96ba9fff595c12e30007404e1c5e368c74be");

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }*//*

}
*/
