package com.ataccama.test.testtask.model.metadata;

public class PostgresqlDbColumn extends DBColumn {

    private Integer ordinalPosition;

    public PostgresqlDbColumn(Integer ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public PostgresqlDbColumn(String schema, String table, String name, String dataType, String defaultValue,
                              Boolean isNullable, Integer characterMaxLength, Integer numericPrecision,
                              Integer numericPrecisionRadix, Boolean isUpdatable, Integer ordinalPosition) {
        super(schema, table, name, dataType, defaultValue, isNullable, characterMaxLength, numericPrecision, numericPrecisionRadix, isUpdatable);
        this.ordinalPosition = ordinalPosition;
    }

    public PostgresqlDbColumn() {
    }

    public Integer getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(Integer ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }
}
