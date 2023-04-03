package dev.ayameio.orakkle.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SignalController {
    @Autowired
    private SignalRepository signalRepository;

    @GetMapping("/signals")
    public @ResponseBody Iterable<Signal> getAllSignals() {
        return signalRepository.findAll();
    }

    // Write query to get a signal with this id.
    @GetMapping("/signals/{id}")
    public @ResponseBody Optional<Signal> getSignal(@RequestParam(value = "id") long id) {
        Signal signal = signalRepository.findById(id);
        return Optional.ofNullable(signal);
    }

    @GetMapping("/signals/live")
    public @ResponseBody Iterable<Signal> getLiveSignals() {
        return signalRepository.findByClosed(false);
    }

    @GetMapping("/signals/closed")
    public @ResponseBody Iterable<Signal> getClosedSignals() {
        return signalRepository.findByClosed(true);
    }

    @GetMapping("/signals/closed/winners")
    public @ResponseBody Iterable<Signal> getWinners() {
        return signalRepository.findByWasSuccessful(true);
    }

    @GetMapping("/signals/closed/losers")
    public @ResponseBody Iterable<Signal> getLosers() {
        return signalRepository.findByWasSuccessful(false);
    }


    // Write query to post signal.
    @PostMapping("/signals")
    public @ResponseBody Signal postSignal(
           @RequestParam Long id,
           @RequestParam Long unixTime,
           @RequestParam String asset,
           @RequestParam String entryPrice,
           @RequestParam String takeProfit,
           @RequestParam String stopLoss,
           @RequestParam boolean closed,
           @RequestParam boolean wasSuccess
    ) {
        return signalRepository.save(
          new Signal(id, unixTime, asset, entryPrice, takeProfit, stopLoss, closed, wasSuccess)
        );
    }
}