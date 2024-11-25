package tacos.security;

import org.springframework.data.repository.CrudRepository;
import tacos.data.MyUser;

public interface UserRepository extends CrudRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}
