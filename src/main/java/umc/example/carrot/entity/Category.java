package umc.example.carrot.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Post> posts;



    public Category() {

    }

    public Category(String name) {
        this.name = name;
    }

    // Getter 및 Setter 메소드
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void printInfo() {
        System.out.println("Category ID: " + id);
        System.out.println("Category Name: " + name);
    }
}
