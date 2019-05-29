package com.ataccama.test.testtask.model.metadata.postgresql;

import com.ataccama.test.testtask.model.metadata.DBColumn;

public class PgDbColumn extends DBColumn {

    private Integer ordinalPosition;

    public PgDbColumn(Integer ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public PgDbColumn(String schema, String table, String name, String dataType, String defaultValue,
                      Boolean isNullable, Integer characterMaxLength, Integer numericPrecision,
                      Integer numericPrecisionRadix, Boolean isUpdatable, Integer ordinalPosition) {
        super(schema, table, name, dataType, defaultValue, isNullable, characterMaxLength, numericPrecision, numericPrecisionRadix, isUpdatable);
        this.ordinalPosition = ordinalPosition;
    }

    public PgDbColumn() {
    }

    public Integer getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(Integer ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }
}
