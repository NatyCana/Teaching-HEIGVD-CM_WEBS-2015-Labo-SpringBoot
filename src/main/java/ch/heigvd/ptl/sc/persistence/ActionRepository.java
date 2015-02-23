package ch.heigvd.ptl.sc.persistence;

import ch.heigvd.ptl.sc.model.Action;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActionRepository extends MongoRepository<Action, String> {
	public List<Action> findByActionName(String actionName);
}
