package de.cl.springdocker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class Controller {

    private int count = 0;

    @PostMapping("/message/{messageName}")
    public ResponseEntity postMessage(@RequestBody String message, @PathVariable String messageName) {
        System.out.println("New message: " + messageName + ":");
        System.out.println(message);
        count++;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/messages/message_" + count + "_" + messageName + ".txt"))){
            String str = message;
            writer.write(str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
