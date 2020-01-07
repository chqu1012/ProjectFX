package de.dc.projectfx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dc.projectfx.model.ProjectCategory;

public interface ProjectCategoryRepository extends JpaRepository<ProjectCategory, Long>{

}
