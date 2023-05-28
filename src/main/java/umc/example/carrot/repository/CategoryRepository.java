package umc.example.carrot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.example.carrot.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
