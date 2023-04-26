package dv.kinash.hw16.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@NoArgsConstructor
@Document(collation = "users")
public class User {
    @Id
    String id;
    String firstName;
    String lastName;
    String email;
    Integer age;
    Boolean isMarried;

    public User(String firstName, String lastName, String email, Integer age, Boolean isMarried) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.isMarried = isMarried;
    }
}
