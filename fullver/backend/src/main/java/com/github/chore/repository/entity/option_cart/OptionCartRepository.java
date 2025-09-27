package com.github.chore.repository.entity.option_cart;

import com.github.chore.repository.entity.cart.Cart;
import com.github.chore.repository.entity.option.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.chore.repository.entity.user.User;

@Repository
public interface OptionCartRepository extends JpaRepository<OptionCart,Integer> {
    OptionCart findByOptionAndCart(Option option, Cart existingCart);
    OptionCart findByOptionAndCart_User(Option option, User user);
}
