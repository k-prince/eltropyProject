package com.eltropy.bankingsystem.user.repository;

import com.eltropy.bankingsystem.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long>
{
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);
}
