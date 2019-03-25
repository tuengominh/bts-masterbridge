package co.masterbridge.website.database;

public class SqlBuilder {

    private String sql;
    private boolean conditionCounter;


    public SqlBuilder from(String table) {
        sql = "select * from " + table;
        return this;
    }

    public SqlBuilder where(String condition) {

        String preCondition;

        if (conditionCounter) {
            preCondition = " and ";
        } else {
            preCondition = " where ";
        }

        sql += preCondition + condition;

        conditionCounter = true;

        return this;
    }

    public String build() {
        return this.sql;
    }

    public SqlBuilder where(String column, String operator, Object value) {

        System.out.println("Class: " + value.getClass());

        String valueString;

        if (value instanceof String) {
            valueString = "'" + value + "'";
        } else {
            valueString = value.toString();
        }

        String condition = column + " " + operator  + " " + valueString ;

        return where(condition);
    }
}
