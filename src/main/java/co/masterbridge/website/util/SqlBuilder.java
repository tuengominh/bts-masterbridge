package co.masterbridge.website.util;

public class SqlBuilder {

    private String sql;
    private int conditionCounter = 0;

    public SqlBuilder from(String table) {
        sql = "select * from " + table;
        return this;
    }

    public SqlBuilder where(String column, String operator, Object value) {

        if(value != null) {
            String valueString;
            if (!(value instanceof String) || ((String) value).contains("%")) {
                valueString = value.toString();
            } else {
                valueString = "'" + value + "'";
            }

            String condition = column + " " + operator + " " + valueString;

            String clauseBeforeCondition;

            if (conditionCounter != 0) {
                clauseBeforeCondition = " and ";
            } else {
                clauseBeforeCondition = " where ";
            }

            sql += clauseBeforeCondition + condition;
            conditionCounter++;
        }
            return this;
    }

    public String build() {
        return this.sql;
    }
}
