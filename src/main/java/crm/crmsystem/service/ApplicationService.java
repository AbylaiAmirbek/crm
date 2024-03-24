package crm.crmsystem.service;

import crm.crmsystem.model.ApplicationRequest;
import crm.crmsystem.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;
    public List<ApplicationRequest> getAllApplications() {
        return applicationRepository.findAllByOrderByHandled();
    }

    public ApplicationRequest addApplications(ApplicationRequest applicationRequest) {
        applicationRequest.setHandled(false);
        return applicationRepository.save(applicationRequest);
    }

    public ApplicationRequest getApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    public void editApplication(ApplicationRequest applicationRequest) {
        applicationRequest.setHandled(true);
        applicationRepository.save(applicationRequest);
    }
}
