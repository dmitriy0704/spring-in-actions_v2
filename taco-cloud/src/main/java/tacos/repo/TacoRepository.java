package tacos.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import tacos.data.Taco;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long>, CrudRepository<Taco, Long> {

}
