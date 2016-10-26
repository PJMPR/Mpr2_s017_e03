package domain.model;

/**
 * Created by L on 26.10.2016.
 */
public class Person {

    private int id;
    private String firstName;
    private String lastName;

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
