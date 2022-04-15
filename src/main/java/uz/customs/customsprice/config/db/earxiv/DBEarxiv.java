package uz.customs.customsprice.config.db.earxiv;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.PersistenceContext;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Properties;

//import static uz.etranzit.etranzit.EtranzitApplication.MODEL_PACKAGE;
import static uz.customs.customsprice.CustomspriceApplication.MODEL_PACKAGE;

@Configuration
@ConfigurationProperties("spring.datasource.earxiv")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryEarxiv",
        transactionManagerRef = "transactionManagerEarxiv",
        basePackages = {"uz.customs.customsprice.repository.earxiv"}
)
public class DBEarxiv /*extends EarxivConfig*/ {

//    public DBEarxiv(EarxivHikariProp earxivHikariProp) {
//        super(earxivHikariProp);
//    }

    protected final String PERSISTENCE_UNIT_NAME = "earxiv";
    protected final Properties JPA_EARXIV = new Properties() {{
        put("database-platform", "org.hibernate.dialect.DB2400Dialect");
        put("hibernate.ddl-auto", "none");
        put("show-sql", "true");
        put("generate-ddl", "false");
    }};

    @Bean
    @Qualifier("earxiv")
    public HikariDataSource earxiv() throws UnknownHostException, SocketException {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setAutoCommit(true);
        hikariConfig.addDataSourceProperty("characterEncoding", "utf8");
        hikariConfig.addDataSourceProperty("encoding", "UTF-8");
        hikariConfig.addDataSourceProperty("useUnicode", "true");
        hikariConfig.setPoolName("earxiv");
        hikariConfig.setDriverClassName("com.ibm.as400.access.AS400JDBCDriver");
        hikariConfig.setJdbcUrl("jdbc:as400://192.168.212.99/E_ARXIV");
        hikariConfig.setConnectionTestQuery("select current_timestamp cts from sysibm.sysdummy1");
        hikariConfig.setUsername("cparxiv");
        hikariConfig.setPassword("cp@rxiv");
        String ip = InetAddress.getLocalHost().getHostAddress();
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            ip = socket.getLocalAddress().getHostAddress();
        }
        if ((ip.equals("192.168.224.224") || ip.equals("192.168.224.18") || ip.equals("localhost"))) {
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

    @PersistenceContext(unitName = "earxiv")
    @Bean(name = "entityManagerFactoryEarxiv")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryEarxiv(
            final HikariDataSource earxiv) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(earxiv);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_EARXIV);
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerEarxiv(
            final @Qualifier("entityManagerFactoryEarxiv") LocalContainerEntityManagerFactoryBean entityManagerFactoryEarxiv) {
        return new JpaTransactionManager(entityManagerFactoryEarxiv.getObject());
    }
}
