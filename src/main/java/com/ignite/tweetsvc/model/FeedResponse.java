package com.ignite.tweetsvc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedResponse {

	private String message;
	private Integer statusCode;
	private TweetInfo tweetList;
	
}
