package dto.relational;

import dto.DatabaseDTO;
import lombok.Getter;

import java.util.Set;

@Getter

public class RelDatabaseDTO extends DatabaseDTO {
    private final Set<RelTableDTO> tables;

    public RelDatabaseDTO(String name, Set<RelTableDTO> tables) {
        super(name);
        this.tables = tables;
    }
}
