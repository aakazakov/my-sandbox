package dev.fun.examples.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fun.examples.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
