package database;

import conversion.database.DBConverter;
import conversion.dto.DTOConverter;
import dto.DatabaseDTO;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;

@Getter
public abstract class Database {

    protected List<String> names;
    protected String name;
    protected DBConverter dbConverter;
    protected DTOConverter dtoConverter;

    Database(String dbName, List<String> names) {
        this.name = dbName;
        this.names = names;
    }

    abstract public DatabaseDTO makeDTO() throws SQLException;
}
