package rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rent.repository.RequestRepository;


@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;
}
