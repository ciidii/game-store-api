package com.ciidii.store.user;

import com.ciidii.store.common.BaseEntity;
import com.ciidii.store.gamerequest.GameRequest;
import com.ciidii.store.notification.Notification;
import com.ciidii.store.wishlist.WishList;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_")
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String profilePictureUrl;
    @OneToOne(mappedBy = "user")
    private WishList wishList;

    @OneToMany(mappedBy = "user")
    private List<Notification> notification;

    @OneToMany(mappedBy = "user")
    List<GameRequest> gameRequests;
}
