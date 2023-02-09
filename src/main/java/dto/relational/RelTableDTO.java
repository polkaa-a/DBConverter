package dto.relational;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
public class RelTableDTO {

    @Setter
    private String name;
    private ArrayList<RelFieldDTO> fields;

}
