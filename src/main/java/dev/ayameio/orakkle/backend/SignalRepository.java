package dev.ayameio.orakkle.backend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "signals", path = "signals")
public interface SignalRepository extends PagingAndSortingRepository<Signal, Long>, CrudRepository<Signal, Long> {
    List<Signal> findByAsset(String asset);
    Signal findById(long id);
    List<Signal> findByWasSuccess(boolean wasSuccess);
    List<Signal> findByClosed(boolean closed);
}