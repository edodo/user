package user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserEmail(String userEmail);
}
