package addvertisment.service;

import addvertisment.model.SoapAddSync;
import addvertisment.repository.SoapAddSyncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoapAddService {

    @Autowired
    private SoapAddSyncRepository repository;

    public void create(Long ms_id,  Long agent_id){
        SoapAddSync soapAddSync = new SoapAddSync();
        soapAddSync.setAgentAppId(agent_id);
        soapAddSync.setMsAppId(ms_id);
        repository.save(soapAddSync);
    }

}
