package com.lucas.helloworldexample.repositories;

import com.lucas.helloworldexample.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface  UserRepository extends JpaRepository<User, String> { }