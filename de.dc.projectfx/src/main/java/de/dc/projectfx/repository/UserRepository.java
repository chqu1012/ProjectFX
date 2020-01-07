package de.dc.projectfx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dc.projectfx.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
