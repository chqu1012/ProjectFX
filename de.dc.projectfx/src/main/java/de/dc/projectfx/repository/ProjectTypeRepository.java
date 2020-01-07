package de.dc.projectfx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dc.projectfx.model.ProjectType;

public interface ProjectTypeRepository extends JpaRepository<ProjectType, Long>{

}
