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


    public User findUserByName(String userName) {

        User user = userRepository.findUserByName(userName);

        // 사용자를 찾지 못한 경우에 대한 예외 처리
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        return user;
    }
}
