package database;

import conversion.database.relational.PostgreSQLConverter;
import conversion.dto.relational.DTOPostgreSQLConverter;
import dto.DatabaseDTO;
import dto.relational.RelDatabaseDTO;
import dto.relational.RelTableDTO;

import java.sql.Connection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PostgreSQL extends Database {

    private final Connection connection;
    private final Set<RelTableDTO> tablesDTO = new HashSet<>();

    public PostgreSQL(String dbName, Connection connection, List<String> tablesNames) {
        super(dbName, tablesNames);
        this.connection = connection;
        this.dbConverter = new PostgreSQLConverter();
        this.dtoConverter = new DTOPostgreSQLConverter();
    }

    @Override
    public DatabaseDTO makeDTO() {
        /*
        создание ДТО - заполнение collectionsDTO
        DocDatabaseDTO databaseDTO = new DocDatabaseDTO(this.name, collectionsDTO);
        return databaseDTO;
        */

        return new RelDatabaseDTO("name", tablesDTO);
    }
}
