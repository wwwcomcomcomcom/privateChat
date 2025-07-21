package privatechat.privatechat.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import privatechat.privatechat.domain.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByName(String name);
    boolean existsByEmail(String email);
}
