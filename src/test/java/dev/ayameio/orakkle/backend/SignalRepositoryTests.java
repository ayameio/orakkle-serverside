package dev.ayameio.orakkle.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hibernate.internal.util.collections.CollectionHelper.listOf;

@DataJpaTest
public class SignalRepositoryTests {

    List<Signal> dummySignalList = listOf(
            new Signal("eurusd","buyStop", "1.20000", "1.21000", "1.19000", false, false),
            new Signal("gbpusd","sellLimit", "1.20000", "1.21000", "1.19000", false, false),
            new Signal("btcusd","buyStop", "1.20000", "1.21000", "1.19000", false, false),
            new Signal("ethbtc","sellStop", "1.20000", "1.21000", "1.19000", false, false),
            new Signal("muln","buyLimit", "1.20000", "1.21000", "1.19000", false, false)
    );

    Signal dummySignal = new Signal("eurusd","buyStop", "1.20000", "1.21000", "1.19000", false, false);

    @Autowired
    private SignalRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void injectedComponentsAreNotNull() {
        assertThat(repository).isNotNull();
        assertThat(testEntityManager).isNotNull();
    }

    @Test
    public void shouldFindSignalById() {

        long signalId = testEntityManager.persist(dummySignal).getId();

        testEntityManager.persistAndFlush(dummySignal);
        testEntityManager.clear();

        Optional<Signal> storedSignal = repository.findById(signalId);

        assertThat(storedSignal).isPresent();
    }

    @Test
    public void shouldDeleteSignalById() {

        long signalId = testEntityManager.persist(dummySignal).getId();

        repository.deleteById(signalId);

        testEntityManager.flush();
        testEntityManager.clear();

        assertThat(repository.findById(signalId)).isNotPresent();
    }

    @Test
    public void shouldFindAllSignals() {

        dummySignalList.forEach(signal -> testEntityManager.persist(signal));

        testEntityManager.flush();

        assertThat(repository.findAll()).isEqualTo(dummySignalList);
    }

    @Test
    public void shouldFindAllWinnerSignals() {

        dummySignalList.forEach(signal -> testEntityManager.persist(signal));

        testEntityManager.flush();

        List<Signal> winners = dummySignalList
                .stream()
                .filter(Signal::isSuccessful)
                .collect(Collectors.toList());

        assertThat(repository.findBySuccessful(true)).isEqualTo(winners);
    }

    @Test
    public void shouldFindAllLoserSignals() {
        dummySignalList.forEach(signal -> testEntityManager.persist(signal));

        testEntityManager.flush();

        List<Signal> losers = dummySignalList
                .stream()
                .filter(signal -> !signal.isSuccessful())
                .collect(Collectors.toList());

        assertThat(repository.findBySuccessful(false)).isEqualTo(losers);
    }

    @Test
    public void shouldFindAllSignalsByAsset() {
        String asset = "eurusd";

        dummySignalList.forEach(signal -> testEntityManager.persist(signal));

        testEntityManager.flush();

        List<Signal> assetGroup = dummySignalList
                .stream()
                .filter(signal -> signal.getAsset().equals(asset))
                .collect(Collectors.toList());

        assertThat(repository.findByAsset(asset)).isEqualTo(assetGroup);
    }

    @Test
    public void shouldFindAllClosedSignals() {
        dummySignalList.forEach(signal -> testEntityManager.persist(signal));

        testEntityManager.flush();

        List<Signal> closed = dummySignalList
                .stream()
                .filter(Signal::isClosed)
                .collect(Collectors.toList());

        assertThat(repository.findByClosed(true)).isEqualTo(closed);
    }

    @Test
    public void shouldFindAllOpenedSignals() {
        dummySignalList.forEach(signal -> testEntityManager.persist(signal));

        testEntityManager.flush();

        List<Signal> open = dummySignalList
                .stream()
                .filter(signal -> !signal.isClosed())
                .collect(Collectors.toList());

        assertThat(repository.findByClosed(false)).isEqualTo(open);
    }
}