package com.ciidii.store.game;

import com.ciidii.store.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, String> {

    //find all games by category (v1)
    List<Game> findAllByCategory(Category category);

    //find all games by category (V2)
    List<Game> findAllByCategoryId(String categoryId);

    // find all the games where the names equals 'Actions '

    List<Game> findAllByCategoryName(String categoryName);

    /* @Query("""
             SELECT g FROM Game g
             INNER JOIN Category c ON g.category = c.id
                         WHERE c.categoryName LIKE %:name%
             """)*/
    @Query("""
            SELECT g FROM Game g
            INNER JOIN g.category c
                        WHERE c.categoryName LIKE %:name%
            """)
    List<Game> findAllCat(@Param("name") String categoryName);
}
