package com.greedy.thunderbolts.model.service.oauth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<TblUser, Long> {

    Optional<TblUser> findByEmail(String email);
}