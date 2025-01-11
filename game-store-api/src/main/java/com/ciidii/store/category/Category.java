package com.ciidii.store.category;

import com.ciidii.store.common.BaseEntity;
import com.ciidii.store.game.Game;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Category.findByName",query = """
    SELECT c From Category c
    WHERE c.categoryName like lower(:name)
    ORDER BY c.categoryName ASC
""")
public class Category  extends BaseEntity {
    private String categoryName;
    private String categoryDescription;

    @OneToMany(mappedBy = "category")
    private List<Game> games;
}
