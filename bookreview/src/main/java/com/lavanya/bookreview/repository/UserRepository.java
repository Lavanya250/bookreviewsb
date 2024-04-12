package com.lavanya.bookreview.repository;

import com.lavanya.bookreview.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    
}
