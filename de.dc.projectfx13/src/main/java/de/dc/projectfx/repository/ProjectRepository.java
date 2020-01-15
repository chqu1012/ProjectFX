package de.dc.projectfx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dc.projectfx.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
