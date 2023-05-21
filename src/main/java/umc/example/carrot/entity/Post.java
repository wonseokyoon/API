package umc.example.carrot.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Date createdAt;


    @Builder
    public Post(String title, String content, String date, User user) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
    }

    // 필요한 다른 메소드들을 추가로 구현할 수 있습니다.
}
