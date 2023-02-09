package conversion.type;

public class MongoDBTypesConverter {
    // метод convertAllFields(DatabaseDTO dto)
    // метод <T> MongoDBTypes getTypeWithClass(Class<T> typeClass)

    // TODO: 04.11.2022 подумать над другой реализацией енама (не через классы) 

    // метод MongoDBTypes convert(PostgreSQLTypes type) со свитчем

    // TODO: 04.11.2022  тут подумать над тем, что метод конкретизирован на постгру
    //  (как то не очень это) хотя мб и норм,
    //  чтобы другие методы сделать для других БД можно будет просто перегрузить

    // перегрузка аля:
    // MongoDBTypes convert(AnotherDBTypes type)
}
