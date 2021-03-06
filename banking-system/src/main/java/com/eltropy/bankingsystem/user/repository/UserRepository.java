package com.eltropy.bankingsystem.user.repository;

import com.eltropy.bankingsystem.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{

}
