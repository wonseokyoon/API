package umc.example.carrot.service;


import umc.example.carrot.entity.User;
import umc.example.carrot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class UserService {
    public final UserRepository userRepository;

    /*public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
    }*/
    public User findById(Long id) throws IllegalArgumentException {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
        }
    }


    @Transactional
    public Long save(User user) {
        return userRepository.save(user).getId();
    }

    @Transactional
    public Long update(Long id, User user) {
        User currentUser = findById(id);
        currentUser.update(user.getName(), user.getAge(), user.getAddress(), user.getMannertemp());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }
}
