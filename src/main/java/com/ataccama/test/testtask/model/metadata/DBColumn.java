package com.ataccama.test.testtask.model.metadata;

public class DBColumn {


    private String schema;

    private String table;

    private String name;

    private String dataType;

    private String defaultValue;

    private Boolean isNullable;

    private Integer characterMaxLength;

    private Integer numericPrecision;

    private Integer numericPrecisionRadix;

    private Boolean isUpdatable;

    public DBColumn() {
    }

    public DBColumn(String schema, String table, String name, String dataType, String defaultValue,
                    Boolean isNullable, Integer characterMaxLength, Integer numericPrecision,
                    Integer numericPrecisionRadix, Boolean isUpdatable) {
        this.schema = schema;
        this.table = table;
        this.name = name;
        this.dataType = dataType;
        this.defaultValue = defaultValue;
        this.isNullable = isNullable;
        this.characterMaxLength = characterMaxLength;
        this.numericPrecision = numericPrecision;
        this.numericPrecisionRadix = numericPrecisionRadix;
        this.isUpdatable = isUpdatable;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Boolean getNullable() {
        return isNullable;
    }

    public void setNullable(Boolean nullable) {
        isNullable = nullable;
    }

    public Integer getCharacterMaxLength() {
        return characterMaxLength;
    }

    public void setCharacterMaxLength(Integer characterMaxLength) {
        this.characterMaxLength = characterMaxLength;
    }

    public Integer getNumericPrecision() {
        return numericPrecision;
    }

    public void setNumericPrecision(Integer numericPrecision) {
        this.numericPrecision = numericPrecision;
    }

    public Integer getNumericPrecisionRadix() {
        return numericPrecisionRadix;
    }

    public void setNumericPrecisionRadix(Integer numericPrecisionRadix) {
        this.numericPrecisionRadix = numericPrecisionRadix;
    }

    public Boolean getUpdatable() {
        return isUpdatable;
    }

    public void setUpdatable(Boolean updatable) {
        isUpdatable = updatable;
    }
}
