package dv.kinash.hw16.repository;

import dv.kinash.hw16.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    @Query(collation = "en_US")
    List<User> findByFirstName(String firstName);
    @Query(collation = "en_US", value = "{ 'lastName' : ?0 }")
    List<User> findByLastName(String lastName);
    @Query(collation = "en_US", value = "{ 'email' : { $regex : ?0 } }")
    List<User> findByRegexEmail(String emailPattern);
    @Query(collation = "en_US")
    List<User> findByAgeGreaterThan(Integer age);
    @Query(collation = "en_US")
    List<User> findByIsMarried(Boolean isMarried);
}
