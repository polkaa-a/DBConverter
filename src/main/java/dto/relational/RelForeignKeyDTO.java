package dto.relational;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RelForeignKeyDTO {

    private String relTableName;
    private String relFieldName;

}
