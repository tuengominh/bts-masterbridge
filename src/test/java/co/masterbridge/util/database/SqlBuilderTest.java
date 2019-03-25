package co.masterbridge.util.database;

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
                .where("field = 'BIOCHEMISTRY'")
                .build();

        assertThat(sql, is("select * from courses where field = 'BIOCHEMISTRY'"));
    }


    @Test
    public void whereMultipleConditions() {

        String sql = new SqlBuilder()
                .from("courses")
                .where("field = 'BIOCHEMISTRY'")
                .where("country = 'Spain'")
                .where("available = true")
                .build();

        assertThat(sql, is(
                "select * from courses" +
                        " where field = 'BIOCHEMISTRY'" +
                        " and country = 'Spain'" +
                        " and available = true"
        ));
    }

    @Test
    public void whereEasierConditions() {

        String fieldOfStudying = "ECONOMICS";

        String sql = new SqlBuilder()
                .from("courses")
                .where("field", "=", fieldOfStudying )
                .where("price", "<=", 10 )
                .build();

        assertThat(sql, is("select * from courses " +
                "where field = 'ECONOMICS' and price <= 10"));
    }


}