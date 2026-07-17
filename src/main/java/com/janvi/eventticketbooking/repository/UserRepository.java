package com.janvi.eventticketbooking.repository;

import com.janvi.eventticketbooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
