package com.groupSpring.garbageAppSpring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_recyclings")
public class UserRecycling implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "materialname", nullable = false)
	private String materialname;
	
	
	@OneToOne
	@JoinColumn(name = "name", referencedColumnName = "name", insertable = false, updatable = false)
    private User user;
	
	@OneToOne
	@JoinColumn(name = "materialname", referencedColumnName = "name", insertable = false, updatable = false)
    private Material material;
	
	
	@Column(name = "date", nullable = true)
    private java.util.Date date;
	
	@Column(name = "quantity", nullable = true)
    private float quantity;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaterialname() {
		return materialname;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public void setMaterialname(String materialname) {
		this.materialname = materialname;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
