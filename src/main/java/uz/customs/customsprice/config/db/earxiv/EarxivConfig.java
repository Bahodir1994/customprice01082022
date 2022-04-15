package uz.customs.customsprice.config.db.earxiv;

import com.zaxxer.hikari.HikariConfig;

import java.util.Properties;

public class EarxivConfig extends HikariConfig {

    protected final EarxivHikariProp earxivHikariProp;

    protected final String PERSISTENCE_UNIT_NAME = "earxiv";

    protected final Properties JPA_EARXIV = new Properties() {{
        put("database-platform", "org.hibernate.dialect.DB2400Dialect");
        put("hibernate.ddl-auto", "none");
        put("show-sql", "true");
        put("generate-ddl", "false");
    }};

    protected EarxivConfig(EarxivHikariProp earxivHikariProp) {
        this.earxivHikariProp = earxivHikariProp;
        setPoolName(this.earxivHikariProp.getPoolName());
        setConnectionTestQuery(this.earxivHikariProp.getConnectionTestQuery());
        setMinimumIdle(this.earxivHikariProp.getMinimumIdle());
        setMaximumPoolSize(this.earxivHikariProp.getMaximumPoolSize());
        setIdleTimeout(this.earxivHikariProp.getIdleTimeout());
        setDataSourceProperties(this.earxivHikariProp.getDataSourceProperties());
    }
}
