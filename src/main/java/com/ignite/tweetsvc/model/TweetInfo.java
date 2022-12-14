package com.ignite.tweetsvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Data
@Entity
@IdClass(TweetInfoId.class)
public class TweetInfo {

	@Id
	@Column(name = "tweet_id")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long tweetId;
	
	@Column(name = "text")
	private String tweetText;
	
	@Column(name = "posted_date")
	private Date posted_date;
	
	@Column(name = "genre")
	private String genre;

}
