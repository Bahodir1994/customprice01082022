package uz.customs.customsprice.config.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

import static uz.customs.customsprice.CustomspriceApplication.MODEL_PACKAGE;

@Configuration
@ConfigurationProperties("spring.datasource.etranzit")
@EnableTransactionManagement
@EnableJpaRepositories(
        repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class,
        entityManagerFactoryRef = "entityManagerFactoryEtranzit",
        transactionManagerRef = "transactionManagerEtranzit",
        basePackages = {"uz.customs.customsprice.repository"}
)
public class DBCustomPrice {

    private static HikariDataSource hikariDataSource;

    protected final String PERSISTENCE_UNIT_NAME = "etranzit";
    protected final Properties JPA_ETRANZIT = new Properties() {{
        put("database-platform", "org.hibernate.dialect.DB2400Dialect");
        put("hibernate.hbm2ddl.auto", "update");
        put("hibernate.dialect", "org.hibernate.dialect.DB2400Dialect");
        put("show-sql", "true");
        put("generate-ddl", "true");
    }};

    public static Connection getConnection() throws SQLException {
        return hikariDataSource.getConnection();
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @Bean
    @Qualifier("etranzit")
    public HikariDataSource etranzit() throws UnknownHostException, SocketException {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setAutoCommit(true);
        hikariConfig.addDataSourceProperty("characterEncoding", "utf8");
        hikariConfig.addDataSourceProperty("encoding", "UTF-8");
        hikariConfig.addDataSourceProperty("useUnicode", "true");
        hikariConfig.setPoolName("etranzit");
        hikariConfig.setDriverClassName("com.ibm.as400.access.AS400JDBCDriver");
        hikariConfig.setConnectionTestQuery("select current_timestamp cts from sysibm.sysdummy1");
        hikariConfig.setJdbcUrl("jdbc:as400://192.168.212.231/CPID");
        hikariConfig.setUsername("rustam");
        hikariConfig.setPassword("9061648");
        hikariConfig.setConnectionTimeout(30000);
        hikariConfig.setValidationTimeout(5000);
        hikariConfig.setMinimumIdle(10);
        hikariConfig.setMaximumPoolSize(500);
        hikariConfig.setIdleTimeout(600000);
        hikariConfig.setMaxLifetime(3600000);
        hikariDataSource = new HikariDataSource(hikariConfig);
        return hikariDataSource;
    }

//    @Qualifier("etranzit2")
//    public HikariDataSource etranzit2() throws UnknownHostException, SocketException {
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setAutoCommit(true);
//        hikariConfig.addDataSourceProperty("characterEncoding", "utf8");
//        hikariConfig.addDataSourceProperty("encoding", "UTF-8");
//        hikariConfig.addDataSourceProperty("useUnicode", "true");
//        hikariConfig.setPoolName("etranzit2");
//        hikariConfig.setDriverClassName("com.ibm.as400.access.AS400JDBCDriver");
//        hikariConfig.setConnectionTestQuery("select current_timestamp cts from sysibm.sysdummy1");
//        hikariConfig.setJdbcUrl("jdbc:as400://192.168.212.231/ETRANZIT");
//        hikariConfig.setUsername("etranzitt");
//        hikariConfig.setPassword("nB4EaEtU");
//        hikariConfig.setConnectionTimeout(30000);
//        hikariConfig.setValidationTimeout(5000);
//        hikariConfig.setMinimumIdle(10);
//        hikariConfig.setMaximumPoolSize(500);
//        hikariConfig.setIdleTimeout(600000);
//        hikariConfig.setMaxLifetime(3600000);
//        hikariDataSource = new HikariDataSource(hikariConfig);
//        return hikariDataSource;
//    }

    @Primary
    @Bean(name = "entityManagerFactoryEtranzit")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryEtranzit(
            final HikariDataSource etranzit) throws SQLException {
        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(etranzit);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_ETRANZIT);
        }};
    }

    @Primary
    @Bean
    public PlatformTransactionManager transactionManagerEtranzit(
            final @Qualifier("entityManagerFactoryEtranzit") LocalContainerEntityManagerFactoryBean entityManagerFactoryEtranzit) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryEtranzit.getObject()));
    }
}


