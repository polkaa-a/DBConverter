package database;

import com.mongodb.MongoClient;
import conversion.database.document.MongoDBConverter;
import conversion.dto.document.DTOMongoDBConverter;
import dto.DatabaseDTO;
import dto.document.DocCollectionDTO;
import dto.document.DocDatabaseDTO;
import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class MongoDB extends Database {

    private final MongoClient mongoClient;
    private final Set<DocCollectionDTO> collectionsDTO = new HashSet<>();

    public MongoDB(String dbName, MongoClient mongoClient, List<String> collectionsNames) {
        super(dbName, collectionsNames);
        this.mongoClient = mongoClient;
        this.dbConverter = new MongoDBConverter();
        this.dtoConverter = new DTOMongoDBConverter();
    }

    @Override
    public DatabaseDTO makeDTO() {
        /*
        создание ДТО - заполнение collectionsDTO
        DocDatabaseDTO databaseDTO = new DocDatabaseDTO(this.name, collectionsDTO);
        return databaseDTO;
        */

        return new DocDatabaseDTO("name", collectionsDTO);
    }
}
