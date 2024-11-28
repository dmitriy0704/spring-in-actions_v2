package tacocloudapi.security;

import org.springframework.data.repository.CrudRepository;
import tacocloudapi.data.MyUser;

public interface UserRepository extends CrudRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}
