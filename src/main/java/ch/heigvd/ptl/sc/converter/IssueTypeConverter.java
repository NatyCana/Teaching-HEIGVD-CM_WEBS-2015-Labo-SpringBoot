/*
 * Developped at Heig-VD.ch during the WebService lecture
 * Authors: Natalie Canonica, Maya Jeanmonod
 * Date: 18-feb-2015
 */
package ch.heigvd.ptl.sc.converter;

import ch.heigvd.ptl.sc.model.IssueType;
import ch.heigvd.ptl.sc.to.IssueTypeTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IssueTypeConverter {
	public final List<IssueTypeTO> convertSourceToTarget(List<IssueType> sources) {
		List<IssueTypeTO> results = new ArrayList<>();
		
		for (IssueType source : sources) {
			results.add(convertSourceToTarget(source));
		}
		
		return results;
	}

	public final IssueTypeTO convertSourceToTarget(IssueType source) {
		IssueTypeTO target = new IssueTypeTO();
		fillTargetFromSource(target, source);
		return target;
	}
	
	public final List<IssueType> convertTargetToSource(List<IssueTypeTO> targets) {
		List<IssueType> results = new ArrayList<>();
		
		for (IssueTypeTO target : targets) {
			results.add(convertTargetToSource(target));
		}
		
		return results;
	}

	public final IssueType convertTargetToSource(IssueTypeTO target) {
		IssueType source = new IssueType();
		fillSourceFromTarget(source, target);
		return source;
	}

	public void fillTargetFromSource(IssueTypeTO target, IssueType source) {
		target.setId(source.getId());
		target.setShortName(source.getShortName());
		target.setDescription(source.getDescription());
	}

	public void fillSourceFromTarget(IssueType source, IssueTypeTO target) {
		source.setShortName(target.getShortName());
		source.setDescription(target.getDescription());
		
	}
}
