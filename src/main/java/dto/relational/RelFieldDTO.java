package dto.relational;

import conversion.type.relational.RelationalDBTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class RelFieldDTO {

    @Setter
    private String name;
    @Setter
    private RelationalDBTypes type;
    private boolean isPK;
    private RelForeignKeyDTO FK;
}

