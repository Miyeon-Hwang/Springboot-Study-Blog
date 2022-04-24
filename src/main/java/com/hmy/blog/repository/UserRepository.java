package com.hmy.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmy.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
