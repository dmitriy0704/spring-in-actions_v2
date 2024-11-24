package tacos.repo;

import org.springframework.data.repository.CrudRepository;
import tacos.data.TacoOrder;

import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);
}
