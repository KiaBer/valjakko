package fi.berg.valjakko.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KennelRepository extends CrudRepository<Kennel, Long>{

	List<Kennel> findByName(String name);

}
