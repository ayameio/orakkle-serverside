package dev.ayameio.orakkle.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Optional;

@RestController
public class SignalController {

    private static final Logger log = LoggerFactory.getLogger(SignalController.class);

    @Autowired
    private SignalRepository signalRepository;

    @GetMapping("/signals")
    public @ResponseBody Iterable<Signal> getAllSignals() {
        log.info("GET:: Get all signals at /signals endpoint");
        return signalRepository.findAll();
    }

    @GetMapping("/signals/{id}")
    public @ResponseBody Optional<Signal> getSignal(@PathVariable long id) {
        log.info("GET:: Get specific signal at /signals/{id} endpoint");
        return signalRepository.findById(id);
    }

    @GetMapping("/signals/live")
    public @ResponseBody Iterable<Signal> getLiveSignals() {
        log.info("GET:: Get live signals at /signals/live endpoint");
        return signalRepository.findByClosed(false);
    }

    @GetMapping("/signals/closed")
    public @ResponseBody Iterable<Signal> getClosedSignals() {
        log.info("GET:: Get closed signals at /signals/closed endpoint");
        return signalRepository.findByClosed(true);
    }

    @GetMapping("/signals/closed/winners")
    public @ResponseBody Iterable<Signal> getWinners() {
        log.info("GET:: Get winner signals at /signals/closed/winners endpoint");
        return signalRepository.findByWasSuccessful(true);
    }

    @GetMapping("/signals/closed/losers")
    public @ResponseBody Iterable<Signal> getLosers() {
        log.info("GET:: Get loser signals at /signals/closed/losers endpoint");
        return signalRepository.findByWasSuccessful(false);
    }

    @PostMapping("/signals")
    public @ResponseBody Signal postSignal(@RequestBody Signal signal) {
        signal.setUnixTime(Instant.now().getEpochSecond());
        log.info("POST:: Post a new signal at /signals endpoint" + signal.toString());
        return signalRepository.save(signal);
    }
}