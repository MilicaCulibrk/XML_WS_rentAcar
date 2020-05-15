package com.projekat.tim14.AdminMS.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/agent")
public class AgentController {

    //izlistavanje svih agenata
    @GetMapping("")
    public ResponseEntity<?> getAllAgents()  {
        return null;
    }

    //izlististavanje pojedinacnog agenta
    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleAgent(PathVariable Long id)  {
        return null;
    }

    //objavljivanje novog agent
    @PostMapping()
    public ResponseEntity<?> createAgent (@RequestBody Agent agent)  {

        return null;
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateAgent (@RequestBody Agent agent, PathVariable Long id) {
        return null;
    }

    //brisanje pojedinacnog agenta
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAgent (PathVariable Long id) {

        return null;
    }

}
