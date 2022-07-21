package io.lightfeather.managementstyle.supervisors;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api")
public class SupervisorController {
    private static final String MANAGER_URL = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers";
    
    @Autowired private RestTemplate restTemplate;
    @Autowired private SupervisorService supervisorService;

    @GetMapping("/supervisors")
    public List<String> getSupervisors() {
        ResponseEntity<List<Supervisor>> response = restTemplate.exchange(MANAGER_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Supervisor>>(){});
        List<Supervisor> supervisors = response.getBody();
        return supervisorService.getSortedSupervisors(supervisors);
       
    }
}
