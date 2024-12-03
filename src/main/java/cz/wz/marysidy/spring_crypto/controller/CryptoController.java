package cz.wz.marysidy.spring_crypto.controller;

import cz.wz.marysidy.spring_crypto.controller.dto.IdError;
import cz.wz.marysidy.spring_crypto.model.Crypto;
import cz.wz.marysidy.spring_crypto.service.CryptoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cryptos")
public class CryptoController {
    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    // Adding only one Crypto to the portfolio.
    @PostMapping
    public ResponseEntity<String> addCrypto(@RequestBody Crypto crypto) {
        cryptoService.addCrypto(crypto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Crypto " + crypto.getName() + " added successfully!");
        // Returns 201 Created
    }

    // Adding multiple Cryptos to the portfolio
    @PostMapping("/bulk")
    public ResponseEntity<String> addCryptos(@RequestBody List<Crypto> cryptoList) {
        cryptoService.addCryptos(cryptoList);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cryptoList.size() + " cryptos added successfully!");
    }

    // Getting of all cryptocurrencies, with or without sorting (Query)
    // localhost:8080/cryptos
    // localhost:8080/cryptos?sort=name    . . .
    @GetMapping
    public ResponseEntity<List<Crypto>> getAllCryptos(@RequestParam(value="sort", required = false) String sortChoice) {
        List<Crypto> cryptos = cryptoService.getAllCryptos(sortChoice);
        // If there are no cryptocurr. in the list, returns 204 No Content, build() - creates a response without body
        if (cryptos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        if (sortChoice != null && !sortChoice.matches("name|price|quantity")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cryptos);
        }
        return ResponseEntity.status(HttpStatus.OK).body(cryptos);
//        return ResponseEntity.ok(cryptos); // Returns 200 OK
    }

    // Getting cryptocurrency by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getCryptoById(@PathVariable String id) {
        Optional<Crypto> crypto = cryptoService.getCryptoById(id);
        if(crypto.isPresent()){
            return ResponseEntity.ok(crypto.get());
        }
        return new ResponseEntity<>(
                new IdError("Crypto with id " + id + " was not found", new Timestamp(new Date().getTime())),
                HttpStatus.NOT_FOUND);
    }

    // Updating of cryptocurrency by id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCrypto(@PathVariable String id, @RequestBody Crypto crypto) {
        Optional<Crypto> updatedCrypto = cryptoService.updateCrypto(id, crypto);
        if (updatedCrypto.isPresent()) {
            return ResponseEntity.ok(updatedCrypto.get()); // Возвращаем обновленный объект
        }
        return new ResponseEntity<>(
                new IdError("Crypto with id " + id + " was not found", new Timestamp(new Date().getTime())),
                HttpStatus.NOT_FOUND);
    }
}
