package umc.example.carrot.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    private String address;

    private int mannertemp;

    @Builder
    public User(String name, int age, String address, int mannertemp){
        this.name = name;
        this.age = age;
        this.address = address;
        this.mannertemp = mannertemp;

    }

    public void update(String name, int age, String address, int mannertemp) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.mannertemp = mannertemp;
    }
}
