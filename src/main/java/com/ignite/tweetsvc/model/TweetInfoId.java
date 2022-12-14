package com.ignite.tweetsvc.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class TweetInfoId implements Serializable{

	private static final long serialVersionUID = 1L;
	private long tweetId;
	
}
