package co.masterbridge.website;

import co.masterbridge.website.database.DataSourceUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

public class InsertSampleData {

    public static void main(String[] args) throws SQLException {

        DataSource dataSource = DataSourceUtil.getDataSourceInPath();
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/sample-data.sql"));
    }
}