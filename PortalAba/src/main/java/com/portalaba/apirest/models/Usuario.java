package com.portalaba.apirest.models;

import javax.validation.constraints.NotBlank;
import org.dom4j.tree.AbstractEntity;
import org.hibernate.validator.constraints.UniqueElements;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name="tb_user")
public class Usuario extends AbstractEntity{

	private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
	
    @NotBlank
    @UniqueElements
    @Column(length=30)
    private String userName;
     
    @NotBlank
    @Column(length=60)
    @JsonIgnore
    private String password;    

    @NotBlank
    private String name;
    
    @NotBlank
    private boolean nivel;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getNivel() {
		return nivel;
	}

	public void setNivel(boolean nivel) {
		this.nivel = nivel;
	}
    
}
