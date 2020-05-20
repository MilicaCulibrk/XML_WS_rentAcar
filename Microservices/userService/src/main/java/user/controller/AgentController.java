package com.services.user.controller;

import com.services.user.model.Agent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/agent")
public class AgentController {

    //izlistavanje svih agenata
    @GetMapping()
    public ResponseEntity<?> getAllAgents()  {
        return null;
    }

    //izlististavanje pojedinacnog agenta
    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleAgent(@PathVariable Long id)  {
        return null;
    }

    //dodavanje novog agenta
    @PostMapping()
    public ResponseEntity<?> addAgent (@RequestBody Agent agent)  {
        return null;
    }

    //potencijalna izmena profila agenta
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAgent (@RequestBody Agent agent, @PathVariable Long id) {
        return null;
    }

    //potencijalno brisanje profila agenta
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAgent (@PathVariable Long id) {
        return null;
    }

}
