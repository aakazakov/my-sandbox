package dev.fun.examples.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fun.examples.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{

}
