/*
 * Developped at Heig-VD.ch during the WebService lecture
 * Authors: Natalie Canonica, Maya Jeanmonod
 * Date: 18-feb-2015
 */
package ch.heigvd.ptl.sc.converter;

import ch.heigvd.ptl.sc.model.Action;
import ch.heigvd.ptl.sc.to.ActionTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionConverter {

    @Autowired
    private UserConverter authorConverter;

    public final List<ActionTO> convertSourceToTarget(List<Action> sources) {
        List<ActionTO> results = new ArrayList<>();

        for (Action source : sources) {
            results.add(convertSourceToTarget(source));
        }

        return results;
    }

    public final ActionTO convertSourceToTarget(Action source) {
        ActionTO target = new ActionTO();
        fillTargetFromSource(target, source);
        return target;
    }

    public final List<Action> convertTargetToSource(List<ActionTO> targets) {
        List<Action> results = new ArrayList<>();

        for (ActionTO target : targets) {
            results.add(convertTargetToSource(target));
        }

        return results;
    }

    public final Action convertTargetToSource(ActionTO target) {
        Action source = new Action();
        fillSourceFromTarget(source, target);
        return source;
    }

    public void fillTargetFromSource(ActionTO target, Action source) {
        target.setId(source.getId());
        target.setActionName(source.getActionName());
        target.setDescription(source.getDescription());
        target.setAuthorId(source.getAuthor().getId());

    }

    public void fillSourceFromTarget(Action source, ActionTO target) {
        source.setActionName(target.getActionName());
        source.setDescription(target.getDescription());
        


    }
}
