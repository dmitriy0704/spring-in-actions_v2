package tacos.repo;

import org.springframework.data.repository.CrudRepository;
import tacos.data.MyUser;

public interface MyUserRepository extends CrudRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}
