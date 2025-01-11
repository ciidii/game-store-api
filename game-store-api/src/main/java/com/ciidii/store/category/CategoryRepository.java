package com.ciidii.store.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {
    List<Category> findAllByNameStartingWithIgnoreCaseOrderByNameAsc(String name);


    @Query("""
            SELECT c From Category c
            WHERE c.categoryName like lower(:name)
            ORDER BY c.categoryName ASC
            """)
    List<Category> findAllByName(@Param("name") String categoryName);

    @Query(value = """
            select *from category c
                                where name like :name
                                            order by c.categoryName asc
            """, nativeQuery = true)
    List<Category> findAllByNameUsingNativeQuery(@Param("name") String categoryNme);

    @Query(name = "Category.findByName")
    List<Category> findAllByNamedQuery(@Param("name") String namedQuery);
}
