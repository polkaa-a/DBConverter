import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.School;
import model.Student;
import model.Subject;
import model.Tutor;
import org.bson.Document;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        List list = new ArrayList<>();
//        PostgreSQL postgreSQL = new PostgreSQL("name", null, list);
//        RelDatabaseDTO databaseDTO = (RelDatabaseDTO) postgreSQL.makeDTO();

        MongoClient mongoClient = MongoClients.create("mongodb://admin:admin@localhost/?authSource=admin");
        MongoDatabase database = mongoClient.getDatabase("admin");
        MongoCollection<Document> collection = database.getCollection("Tutors");

        School firstSchool = new School(114);
        School secondSchool = new School(326);

        Student firstStudent = new Student("Alia", "Nosova", firstSchool);
        Student secondStudent = new Student("Kate", "Morozova", firstSchool);
        Student thirdStudent = new Student("Polina", "Vasilkova", secondSchool);

        Set<Student> firstTutorStudents = new HashSet<>();
        Set<Student> secondTutorStudents = new HashSet<>();

        firstTutorStudents.add(firstStudent);
        firstTutorStudents.add(secondStudent);
        secondTutorStudents.add(thirdStudent);

        Subject math = new Subject("Math");
        Subject english = new Subject("English");
        Subject programming = new Subject("Programming");

        Set<Subject> firstTutorSubjects = new HashSet<>();
        Set<Subject> secondTutorSubjects = new HashSet<>();

        firstTutorSubjects.add(math);
        firstTutorSubjects.add(programming);

        secondTutorSubjects.add(english);

        Set<Tutor> tutors = new HashSet<>();
        tutors.add(new Tutor(1, "Anna", "Volkova", firstTutorStudents, firstTutorSubjects));
        tutors.add(new Tutor(2, "Alexey", "Sorokin", secondTutorStudents, secondTutorSubjects));

        for (Tutor tutor : tutors) {
            List<Document> studentsDocs = new ArrayList<>();
            for (Student student : tutor.getStudents()) {
                Document schoolDocument = new Document("school_number", student.getSchool().getNumber());
                Map<String, Object> objects = new HashMap<>();
                objects.put("firstName", student.getFirstName());
                objects.put("lastName", student.getLastName());
                objects.put("school", schoolDocument);
                Document studentDocument = new Document(objects);
                studentsDocs.add(studentDocument);
            }
            List<Document> subjectsDocs = new ArrayList<>();
            for (Subject subject : tutor.getSubjects()) {
                Document subjectDocument = new Document("name", subject.getName());
                subjectsDocs.add(subjectDocument);
            }
            Document tutorDocument = new Document("_id", tutor.getId())
                    .append("firstName", tutor.getFirstName())
                    .append("lastName", tutor.getLastName())
                    .append("students", studentsDocs)
                    .append("subjects", subjectsDocs);
            collection.insertOne(tutorDocument);
        }
    }

}
