package cz.wz.marysidy.spring_crypto.service;

import cz.wz.marysidy.spring_crypto.model.Crypto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CryptoService {
    private final List<Crypto> cryptoList = new ArrayList<>();

    // Adding only one Crypto to the portfolio.
    public void addCrypto(Crypto newCrypto){
        cryptoList.add(newCrypto);
    }

    // Adding multiple Cryptos to the portfolio
    public void addCryptos(List<Crypto> newCryptos) {
        newCryptos.forEach(crypto -> cryptoList.add(crypto));
    }

    // Getting of all cryptocurrencies, with or without sorting
    public List<Crypto> getAllCryptos(String sortBy) {
        List<Crypto> sortedList = new ArrayList<>(cryptoList);
        // localhost:8080/cryptos Returns original list without sorting.
        if (sortBy == null) {
            return sortedList;
        }
        switch (sortBy) {
            case "name":
                sortedList.sort(Comparator.comparing(Crypto::getName, Comparator.nullsFirst(Comparator.naturalOrder())));
                break;
            case "price":
//                sortedList.sort(Comparator.comparing(Crypto::getPrice));
                sortedList.sort(Comparator.comparing(Crypto::getPrice, Comparator.nullsFirst(Comparator.naturalOrder())));
                break;
            case "quantity":
                sortedList.sort(Comparator.comparing(Crypto::getQuantity, Comparator.nullsFirst(Comparator.naturalOrder())));
                break;
            default:
                return sortedList;
//        return Collections.unmodifiableList(cryptoList); // just for reading
        }
        return sortedList;
    }

    // Getting cryptocurrency by id
    public Optional<Crypto> getCryptoById(String id) {
        return cryptoList.stream()
                .filter(crypto -> crypto.getId().equals(id))
                .findFirst();
    }

    // Updating of cryptocurrency by id
    public Optional<Crypto> updateCrypto(String id, Crypto newCryptoData) {
        Optional<Crypto> cryptoOpt = Optional.empty();
        for (Crypto crypto : cryptoList) {
            if (crypto.getId().equals(id)) {
                cryptoOpt = Optional.of(crypto);
                break;
            }
        }
//        Optional<Crypto> cryptoOpt = cryptoList.stream()
//                .filter(crypto -> crypto.getId().equals(id))
//                .findFirst();
        if (cryptoOpt.isPresent()) {
            Crypto crypto = cryptoOpt.get();
            crypto.setName(newCryptoData.getName());
            crypto.setSymbol(newCryptoData.getSymbol());
            crypto.setPrice(newCryptoData.getPrice());
            crypto.setQuantity(newCryptoData.getQuantity());
            return Optional.of(crypto);
        }
        return cryptoOpt; // Optional.empty();
    }

    // Getting total price of portfolio
    public double getPortfolioValue() {
        double totalValue = 0.0;
        for (Crypto crypto : cryptoList) {
            totalValue += crypto.getPrice() * crypto.getQuantity();
        }
        return totalValue;
    }
//    public double getPortfolioValue() {
//        return cryptoList.stream()
//                .mapToDouble(crypto -> crypto.getPrice() * crypto.getQuantity())
//                .sum();
//    }
}