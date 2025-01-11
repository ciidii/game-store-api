package com.ciidii.store.game;

import com.ciidii.store.category.Category;
import com.ciidii.store.comment.Comment;
import com.ciidii.store.common.BaseEntity;
import com.ciidii.store.wishlist.WishList;
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
public class Game extends BaseEntity {
    private String title;
    @Enumerated(EnumType.STRING)
    private SupportedPlatforms supportedPlatforms;
    private String coverPicture;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "game")
   // @OrderBy(value = "content")
    private List<Comment> comments;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "game_wishlists",
            joinColumns = {
                    @JoinColumn(name = "game_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "wishList_id")
            }
    )
    List<WishList> wishLists;

    public void addWishList(WishList wishList) {
        this.wishLists.add(wishList);
        wishList.getGames().add(this);
    }

    public void removeWishList(WishList wishList) {
        this.wishLists.remove(wishList);
        wishList.getGames().remove(this);
    }
}
