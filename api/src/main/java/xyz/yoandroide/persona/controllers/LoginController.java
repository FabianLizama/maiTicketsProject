package xyz.yoandroide.persona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yoandroide.persona.entities.Analyzer;
import xyz.yoandroide.persona.entities.Client;
import xyz.yoandroide.persona.entities.Leadership;
import xyz.yoandroide.persona.entities.Login;
import xyz.yoandroide.persona.repositories.ClientRepository;
import xyz.yoandroide.persona.repositories.LeadershipRepository;
import xyz.yoandroide.persona.services.AnalyzerService;
import xyz.yoandroide.persona.services.ClientService;
import xyz.yoandroide.persona.services.LeadershipService;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private LeadershipService leadershipService;

    @Autowired
    private AnalyzerService analyzerService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login loginRequest){

        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Client client = clientService.findByEmail(email);
        Leadership leadership = leadershipService.findByEmail(email);
        Analyzer analyzer = analyzerService.findByEmail(email);

        if (client != null && client.getPassword().equals(password)) {
            return ResponseEntity.ok("loggedC" + client.getIdClient().toString());
        } else if (leadership != null && leadership.getPassword().equals(password)) {
            return ResponseEntity.ok("loggedL" + leadership.getIdLeadership().toString());
        } else if (analyzer != null && analyzer.getPassword().equals(password)) {
            return ResponseEntity.ok("loggedA" + analyzer.getIdAnalyzer().toString());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
