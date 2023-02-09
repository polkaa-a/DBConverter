package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class Tutor {
    private int id;
    private String firstName;
    private String lastName;
    private Set<Student> students;
    private Set<Subject> subjects;
}
