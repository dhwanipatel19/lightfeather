package io.lightfeather.managementstyle.supervisors;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

@Service
public class SupervisorService {
    // returns sorted advisors after filtering getJurisdiction
    public List<String> getSortedSupervisors(List<Supervisor> supervisors) {
        Comparator<Supervisor> sortByJuriLastFirst = Comparator.comparing(Supervisor::getJurisdiction)
                                                                .thenComparing(Supervisor::getLastName)
                                                                .thenComparing(Supervisor::getFirstName);
        List<String> sortedSupervisors = supervisors.stream()
                                                        .filter(s->!StringUtils.isNumeric(s.getJurisdiction()))
                                                        .sorted(sortByJuriLastFirst)
                                                        .map(s->s.getJurisdiction() + " - " + s.getLastName() + ", " + s.getFirstName())
                                                        .collect(Collectors.toList());
        
        return sortedSupervisors;
    }
}
