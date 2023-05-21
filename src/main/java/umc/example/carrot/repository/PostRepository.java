package umc.example.carrot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.example.carrot.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    // 추가적인 쿼리 메소드가 필요한 경우 여기에 작성합니다.
}
