package dev.ayameio.orakkle.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignalController {
    @Autowired
    private SignalRepository signalRepository;

    @GetMapping("/signals")
    public @ResponseBody Iterable<Signal> getAllSignals() {
        return signalRepository.findAll();
    }

    @GetMapping("/closed")
    public @ResponseBody Iterable<Signal> getClosedSignals() {
        return signalRepository.findByClosed(true);
    }

    @GetMapping("/closed/winners")
    public @ResponseBody Iterable<Signal> getWinners() {
        return signalRepository.findByWasSuccess(true);
    }

    @GetMapping("/closed/losers")
    public @ResponseBody Iterable<Signal> getLosers() {
        return signalRepository.findByWasSuccess(false);
    }

    // Write query to get a signal with this id.
    @GetMapping("/signals/{id}")
    public @ResponseBody Signal getSignal(@RequestParam(value = "id") long id) {
        return signalRepository.findById(id);
    }

    // Write query to post signal.
    @PostMapping("/signals")
    public @ResponseBody void postSignal(
           @RequestParam Long id,
           @RequestParam Long unixTime,
           @RequestParam String asset,
           @RequestParam String entryPrice,
           @RequestParam String takeProfit,
           @RequestParam String stopLoss,
           @RequestParam boolean closed,
           @RequestParam boolean wasSuccess
    ) {
        signalRepository.postSignal(
          new Signal(id, unixTime, asset, entryPrice, takeProfit, stopLoss, closed, wasSuccess)
        );
    }
}