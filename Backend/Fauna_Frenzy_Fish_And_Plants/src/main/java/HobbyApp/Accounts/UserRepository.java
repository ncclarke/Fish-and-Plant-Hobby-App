package HobbyApp.Accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

    User findById(int id);

    User findByuserName(String userName);

    List<User> findByuserNameContaining(String searchString);

    @Transactional
    void deleteById(int id);
}
