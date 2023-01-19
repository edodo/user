package user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user.model.UserEntity;
import user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public Long save(UserEntity userEntity) {
        return userRepository.save(userEntity).getId();
    }

    public boolean login(UserEntity userEntity) {
        UserEntity us = userRepository.findByUserEmail(userEntity.getUserEmail());
        if (us != null ) {
            if(us.getUserPassword().equals(userEntity.getUserPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
