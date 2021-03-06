package de.dc.projectfx.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String key;
	
	@OneToOne(fetch = FetchType.LAZY, cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private ProjectType type;
	
	@OneToOne(fetch = FetchType.LAZY, cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private User projectLead;

	@OneToOne(fetch = FetchType.LAZY, cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private ProjectCategory category;
	private LocalDateTime createdOn;
	
	public Project() {
	}
	
	public ProjectType getType() {
		return type;
	}

	public void setType(ProjectType type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public User getProjectLead() {
		return projectLead;
	}

	public void setProjectLead(User projectLead) {
		this.projectLead = projectLead;
	}

	public ProjectCategory getCategory() {
		return category;
	}

	public void setCategory(ProjectCategory category) {
		this.category = category;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
}
