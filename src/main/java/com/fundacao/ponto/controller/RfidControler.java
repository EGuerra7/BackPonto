package com.fundacao.ponto.controller;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;


@RestController
@RequestMapping("/rfid")
public class RfidControler {

    private String ultimoRfid;

    @PostMapping
    public ResponseEntity<Map<String, String>> receiveRFID(@RequestBody Map<String, String> payload) {
        String rfid = payload.get("uid");
        System.out.println(rfid);

        if (rfid != null) {
            ultimoRfid = rfid;
        }

        // Cria um mapa para a resposta
        Map<String, String> response = new HashMap<>();
        response.put("rfid", ultimoRfid != null ? ultimoRfid: "RFID não recebido");

        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<String> getUltimoRFID() {
        return ResponseEntity.ok(ultimoRfid != null ? ultimoRfid : "Nenhum RFID recebido");
    }
}
