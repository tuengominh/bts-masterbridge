package co.masterbridge.website.util;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class DataSourceUtil {

    public static DataSource getDataSourceInPath() {

        // H2 will create the util here
        final String path = "~/dev/gamesdb";

        return new DriverManagerDataSource(
                "jdbc:h2:" + path + ";MODE=MYSQL",
                "dbuser", "dbpass");
    }

    public static DataSource getDataSourceInMem() {

        return new DriverManagerDataSource(
                "jdbc:h2:mem:test;MODE=MYSQL",
                "dbuser", "dbpass");
    }
}
