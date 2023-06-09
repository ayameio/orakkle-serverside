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

    @GetMapping("/signals/asset/{asset}")
    public @ResponseBody Iterable<Signal> getAllByAsset(@PathVariable String asset) {
        log.info("GET:: Get all signals of specific asset at /signals/{asset} endpoint");
        return signalRepository.findByAsset(asset);
    }

    @GetMapping("/signals/id/{id}")
    public @ResponseBody Optional<Signal> getSignal(@PathVariable long id) {
        log.info("GET:: Get specific signal at /signals/{id} endpoint");
        return signalRepository.findById(id);
    }

    @GetMapping("/signals/status/live")
    public @ResponseBody Iterable<Signal> getLiveSignals() {
        log.info("GET:: Get live signals at /signals/live endpoint");
        return signalRepository.findByClosed(false);
    }

    @GetMapping("/signals/status/closed")
    public @ResponseBody Iterable<Signal> getClosedSignals() {
        log.info("GET:: Get closed signals at /signals/closed endpoint");
        return signalRepository.findByClosed(true);
    }

    @GetMapping("/signals/status/winners")
    public @ResponseBody Iterable<Signal> getWinners() {
        log.info("GET:: Get winner signals at /signals/closed/winners endpoint");
        return signalRepository.findBySuccessful(true);
    }

    @GetMapping("/signals/status/losers")
    public @ResponseBody Iterable<Signal> getLosers() {
        log.info("GET:: Get loser signals at /signals/closed/losers endpoint");
        return signalRepository.findBySuccessful(false);
    }

    @PostMapping("/signals/")
    public @ResponseBody Signal postSignal(@RequestBody Signal signal) {
        signal.setUnixTime(Instant.now().getEpochSecond());
        log.info("POST:: Post a new signal at /signals endpoint" + signal);
        return signalRepository.save(signal);
    }

    @DeleteMapping("/signals/{id}")
    public @ResponseBody void deleteSignalById(@PathVariable long id) {
        log.info("DELETE:: Delete specific signal at /signals/{id} endpoint");
        signalRepository.deleteById(id);
    }
}