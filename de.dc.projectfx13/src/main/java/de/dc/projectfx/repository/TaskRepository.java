package de.dc.projectfx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dc.projectfx.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
