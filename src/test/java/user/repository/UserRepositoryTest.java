package user.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import user.model.UserEntity;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void InsertDummies() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            UserEntity userEntity = UserEntity.builder()
                    .userEmail("email_" + i)
                    .userPassword("11_" +i)
                    .userName("name_" + i)
                    .build();
            userRepository.save(userEntity);
        });
    }

    @Test
    public void SelectDummies() {
        Long id = 9L;
        Optional<UserEntity> result = userRepository.findById(id);
        System.out.println("=======================");
        if(result.isPresent()) {
            UserEntity userEntity = result.get();
            System.out.println(userEntity);
        }
    }

    @Test
    public void UpdateDummies() {
        UserEntity userEntity = UserEntity.builder()
                .id(9L)
                .userEmail("email_edted")
                .build();
        userRepository.save(userEntity);
    }

    @Test
    public void DeleteDumies() {
        Long id = 10L;
        userRepository.deleteById(id);
    }
}
