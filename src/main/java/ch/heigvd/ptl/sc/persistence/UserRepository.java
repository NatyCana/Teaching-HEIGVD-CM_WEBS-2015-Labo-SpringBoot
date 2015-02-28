/*
 * Developped at Heig-VD.ch during the WebService lecture
 * Authors: Natalie Canonica, Maya Jeanmonod
 * Date: 18-feb-2015
 */
package ch.heigvd.ptl.sc.persistence;

import ch.heigvd.ptl.sc.model.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	public List<User> findByFirstname(String firstname);

	public List<User> findByLastname(String lastname);
}
