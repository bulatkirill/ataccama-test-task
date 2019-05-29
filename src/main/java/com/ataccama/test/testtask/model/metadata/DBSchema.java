package com.ataccama.test.testtask.model.metadata;

public class DBSchema {

    private String nspName;
    private String nspOwner;

    public DBSchema() {
    }

    public DBSchema(String nspName, String nspOwner) {
        this.nspName = nspName;
        this.nspOwner = nspOwner;
    }

    public String getNspName() {
        return nspName;
    }

    public void setNspName(String nspName) {
        this.nspName = nspName;
    }

    public String getNspOwner() {
        return nspOwner;
    }

    public void setNspOwner(String nspOwner) {
        this.nspOwner = nspOwner;
    }
}
