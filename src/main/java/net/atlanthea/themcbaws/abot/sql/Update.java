package net.atlanthea.themcbaws.abot.sql;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Update {
    SQLData sql = new SQLData() {
        @Override
        public String getSQLTypeName() throws SQLException {
            return null;
        }

        @Override
        public void readSQL(SQLInput stream, String typeName) throws SQLException {

        }

        @Override
        public void writeSQL(SQLOutput stream) throws SQLException {

        }
    };
}
