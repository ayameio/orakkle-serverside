package dev.ayameio.orakkle.backend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "signals", path = "signals")
public interface SignalRepository extends PagingAndSortingRepository<Signal, Long>, CrudRepository<Signal, Long> {
    Optional<Signal> findById(long id);
    List<Signal> findByAsset(String asset);
    List<Signal> findBySuccessful(boolean successful);
    List<Signal> findByClosed(boolean closed);
    void deleteById(long id);
}