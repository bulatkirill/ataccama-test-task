package com.ataccama.test.testtask.model.metadata;

import com.ataccama.test.testtask.model.metadata.DBTable;

public class PostgresqlDbTable extends DBTable {

    private String catalog;
    private String schema;
    private String type;
    private String selfReferencingColumnName;
    private String referenceGeneration;
    private String userDefinedTypeCatalog;
    private String userDefinedTypeSchema;
    private String userDefinedTypeName;
    private Boolean isInsertableInto;
    private Boolean isTyped;
    private String commitAction;

    public PostgresqlDbTable(String name, String catalog,
                             String schema, String type,
                             String selfReferencingColumnName,
                             String referenceGeneration,
                             String userDefinedTypeCatalog,
                             String userDefinedTypeSchema,
                             String userDefinedTypeName,
                             Boolean isInsertableInto,
                             Boolean isTyped,
                             String commitAction) {
        super(name);
        this.catalog = catalog;
        this.schema = schema;
        this.type = type;
        this.selfReferencingColumnName = selfReferencingColumnName;
        this.referenceGeneration = referenceGeneration;
        this.userDefinedTypeCatalog = userDefinedTypeCatalog;
        this.userDefinedTypeSchema = userDefinedTypeSchema;
        this.userDefinedTypeName = userDefinedTypeName;
        this.isInsertableInto = isInsertableInto;
        this.isTyped = isTyped;
        this.commitAction = commitAction;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSelfReferencingColumnName() {
        return selfReferencingColumnName;
    }

    public void setSelfReferencingColumnName(String selfReferencingColumnName) {
        this.selfReferencingColumnName = selfReferencingColumnName;
    }

    public String getReferenceGeneration() {
        return referenceGeneration;
    }

    public void setReferenceGeneration(String referenceGeneration) {
        this.referenceGeneration = referenceGeneration;
    }

    public String getUserDefinedTypeCatalog() {
        return userDefinedTypeCatalog;
    }

    public void setUserDefinedTypeCatalog(String userDefinedTypeCatalog) {
        this.userDefinedTypeCatalog = userDefinedTypeCatalog;
    }

    public String getUserDefinedTypeSchema() {
        return userDefinedTypeSchema;
    }

    public void setUserDefinedTypeSchema(String userDefinedTypeSchema) {
        this.userDefinedTypeSchema = userDefinedTypeSchema;
    }

    public String getUserDefinedTypeName() {
        return userDefinedTypeName;
    }

    public void setUserDefinedTypeName(String userDefinedTypeName) {
        this.userDefinedTypeName = userDefinedTypeName;
    }

    public Boolean getInsertableInto() {
        return isInsertableInto;
    }

    public void setInsertableInto(Boolean insertableInto) {
        isInsertableInto = insertableInto;
    }

    public Boolean getTyped() {
        return isTyped;
    }

    public void setTyped(Boolean typed) {
        isTyped = typed;
    }

    public String getCommitAction() {
        return commitAction;
    }

    public void setCommitAction(String commitAction) {
        this.commitAction = commitAction;
    }
}
