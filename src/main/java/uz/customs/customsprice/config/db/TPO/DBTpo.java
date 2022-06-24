package uz.customs.customsprice.config.db.TPO;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.PersistenceContext;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Properties;

import static uz.customs.customsprice.CustomspriceApplication.MODEL_PACKAGE;

@Configuration
@ConfigurationProperties("spring.datasource.tpo")
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class,
        entityManagerFactoryRef = "entityManagerFactoryTpo",
        transactionManagerRef = "transactionManagertpo",
        basePackages = {"uz.customs.customsprice.repository.Tpo"})
public class DBTpo {
    protected final String PERSISTENCE_UNIT_NAME = "tpo";
    protected final Properties JPA_TPO = new Properties() {{
        put("database-platform", "org.hibernate.dialect.DB2400Dialect");
        put("hibernate.ddl-auto", "none");
        put("hibernate.hbm2ddl.auto", "none");
        put("show-sql", "true");
        put("generate-ddl", "false");
    }};

    @Bean
    @Qualifier("tpo")
    public HikariDataSource tpo() throws UnknownHostException, SocketException {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setAutoCommit(true);
        hikariConfig.addDataSourceProperty("characterEncoding", "utf8");
        hikariConfig.addDataSourceProperty("encoding", "UTF-8");
        hikariConfig.addDataSourceProperty("useUnicode", "true");
        hikariConfig.setPoolName("tpo");
        hikariConfig.setDriverClassName("com.ibm.as400.access.AS400JDBCDriver");
        hikariConfig.setJdbcUrl("jdbc:as400://192.168.212.227/BKO");
        hikariConfig.setConnectionTestQuery("select current_timestamp cts from sysibm.sysdummy1");
        hikariConfig.setUsername("rustam");
        hikariConfig.setPassword("rustam");
        String ip = "";
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            ip = socket.getLocalAddress().getHostAddress();
        }
        if ((ip.equals("192.168.224.224") || ip.equals("192.168.224.18") || ip.equals("127.0.0.1") || ip.equals("localhost"))) {
            hikariConfig.setConnectionTimeout(30000);
            hikariConfig.setValidationTimeout(5000);
            hikariConfig.setMinimumIdle(5);
            hikariConfig.setMaximumPoolSize(10);
            hikariConfig.setIdleTimeout(500000);
            hikariConfig.setMaxLifetime(600000);
        } else {
            hikariConfig.setConnectionTimeout(30000);
            hikariConfig.setValidationTimeout(5000);
            hikariConfig.setMinimumIdle(10);
            hikariConfig.setMaximumPoolSize(200);
            hikariConfig.setIdleTimeout(600000);
            hikariConfig.setMaxLifetime(3600000);
        }
        return new HikariDataSource(hikariConfig);
    }


    @PersistenceContext(unitName = "tpo")
    @Bean(name = "entityManagerFactoryTpo")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryTpo(final HikariDataSource tpo) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(tpo);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_TPO);
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerTpo(final @Qualifier("entityManagerFactoryTpo") LocalContainerEntityManagerFactoryBean entityManagerFactoryTpo) {
        return new JpaTransactionManager(entityManagerFactoryTpo.getObject());
    }
}

