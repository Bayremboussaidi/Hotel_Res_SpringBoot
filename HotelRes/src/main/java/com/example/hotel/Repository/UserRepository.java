package com.example.hotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.Entity.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

   public UserInfo findByUsername(String username);

   UserInfo findFirstById(Long id);

}
