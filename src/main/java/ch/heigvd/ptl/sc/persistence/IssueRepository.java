/*
 * Developped at Heig-VD.ch during the WebService lecture
 * Authors: Natalie Canonica, Maya Jeanmonod
 * Date: 18-feb-2015
 */
package ch.heigvd.ptl.sc.persistence;

import ch.heigvd.ptl.sc.model.Issue;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IssueRepository extends MongoRepository<Issue, String> {
	public List<Issue> findByTypeId(String typeId);

	public List<Issue> findByDescription(String description);
}
