package com.ataccama.test.testtask.model.metadata.postgresql;

import com.ataccama.test.testtask.model.metadata.DBSchema;

public class PgDbSchema extends DBSchema {

    public PgDbSchema() {
    }

    public PgDbSchema(String nspName, String nspOwner) {
        super(nspName, nspOwner);
    }
}
