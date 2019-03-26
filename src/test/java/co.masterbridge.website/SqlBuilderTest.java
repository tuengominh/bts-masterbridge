package co.masterbridge.website;

import co.masterbridge.website.util.SqlBuilder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SqlBuilderTest {

    @Test
    public void selectFromTable() {

        //1. Prepare objects
        SqlBuilder sqlBuilder = new SqlBuilder();

        //2. call some methods()
        sqlBuilder.from("courses");
        String sql = sqlBuilder.build();

        //3. check results
          assertThat(sql, is("select * from courses"));
    }

    @Test
    public void selectFromTable_Simplified() {

        String sql = new SqlBuilder().from("courses").build();// In order to do it, you have to return the SqlBuilder;

        assertThat(sql, is("select * from courses"));
    }

    @Test
    public void whereCondition() {

        String sql = new SqlBuilder()
                .from("courses")
                .where("field","like", "%BIOCHEMISTRY%")
                .build();

        assertThat(sql, is("select * from courses where field like %BIOCHEMISTRY%"));
    }

    @Test
    public void whereMultipleConditions() {

        String sql = new SqlBuilder()
                .from("courses")
                .where("field","like", "%BIOCHEMISTRY%")
                .where("country", "=", "Spain")
                .where("available", "=", true)
                .where("tuition", "<=", 10000 )
                .build();

        assertThat(sql, is(
                "select * from courses" +
                        " where field like %BIOCHEMISTRY%" +
                        " and country = 'Spain'" +
                        " and available = true and tuition <= 10000"
        ));
    }

}