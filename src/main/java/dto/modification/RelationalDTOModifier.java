package dto.modification;

import dto.relational.RelDatabaseDTO;
import lombok.Getter;

public class RelationalDTOModifier {
    @Getter
    private final RelDatabaseDTO databaseDTO;

    public RelationalDTOModifier(RelDatabaseDTO databaseDTO) {
        this.databaseDTO = databaseDTO;
    }

    // класс, который будет позволять изменять имена таблиц, полей,
    // но при этом не изменять ДТО (т.к. нам нужно знать изначальые имена
    // таблиц и полей чтобы при конвертации мы могли достать из БД нужные данные)
    //
    // таким образом, нам нужен объект который будет представлять описание нашей
    // дто в качестве имен таблиц и полей

    // поэтому в классе RelDatabase есть поле databaseMetadata

}
