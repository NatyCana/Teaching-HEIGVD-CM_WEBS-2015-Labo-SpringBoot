/*
 * Developped at Heig-VD.ch during the WebService lecture
 * Authors: Natalie Canonica, Maya Jeanmonod
 * Date: 18-feb-2015
 */
package ch.heigvd.ptl.sc.converter;

import ch.heigvd.ptl.sc.model.Issue;
import ch.heigvd.ptl.sc.to.IssueTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author naty
 */
@Service
public class IssueConverter {



    public final List<IssueTO> convertSourceToTarget(List<Issue> sources) {
        List<IssueTO> results = new ArrayList<>();

        for (Issue source : sources) {
            results.add(convertSourceToTarget(source));
        }

        return results;
    }

    public final IssueTO convertSourceToTarget(Issue source) {
        IssueTO target = new IssueTO();
        fillTargetFromSource(target, source);
        return target;
    }

    public final List<Issue> convertTargetToSource(List<IssueTO> targets) {
        List<Issue> results = new ArrayList<>();

        for (IssueTO target : targets) {
            results.add(convertTargetToSource(target));
        }

        return results;
    }

    public final Issue convertTargetToSource(IssueTO target) {
        Issue source = new Issue();
        fillSourceFromTarget(source, target);
        return source;
    }

    public void fillTargetFromSource(IssueTO target, Issue source) {
        target.setId(source.getId());
        target.setAuthorId(source.getAuthor().getId());
        target.setCoords(source.getCoords());
        target.setDescription(source.getDescription());
        target.setTypeId(source.getType().getId());
        target.setActionId(source.getAction().getId());
    }

    public void fillSourceFromTarget(Issue source, IssueTO target) {
        source.setId(target.getId());
        source.setCoords(target.getCoords());
        source.setDescription(target.getDescription());

    }
}
