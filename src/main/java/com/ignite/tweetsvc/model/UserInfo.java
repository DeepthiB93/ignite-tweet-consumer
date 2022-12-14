package com.ignite.tweetsvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Data
@Entity
@IdClass(UserInfoId.class)
public class UserInfo {

	@Id
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "genre")
	private String genre;
		
	@Column(name = "user_account_creation_date")
	private Date creationDate;
	
	@Column(name = "user_password")
	private String userPass;
	
}
