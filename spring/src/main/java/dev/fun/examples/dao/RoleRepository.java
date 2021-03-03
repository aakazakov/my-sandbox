package dev.fun.examples.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fun.examples.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
