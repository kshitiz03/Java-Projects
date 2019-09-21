package com.nagarro.Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author kshitizrawat
 *  * POJO mapping to Login_details table to extract and set values

 *
 */
@Entity
@Table(name = "Login_Details")

public class LoginBean {

	@Id
	private String username;
	private String password;

	@OneToMany(mappedBy = "user_info")
	private List<ImageBean> images = new ArrayList<ImageBean>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ImageBean> getImages() {
		return images;
	}

	public void setImages(List<ImageBean> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "LoginBean [username=" + username + ", password=" + password + "]";
	}
}
