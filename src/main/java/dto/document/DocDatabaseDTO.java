package dto.document;

import dto.DatabaseDTO;
import lombok.Getter;

import java.util.Set;

@Getter

public class DocDatabaseDTO extends DatabaseDTO {
    private final Set<DocCollectionDTO> collections;

    public DocDatabaseDTO(String name, Set<DocCollectionDTO> collections) {
        super(name);
        this.collections = collections;
    }
}
