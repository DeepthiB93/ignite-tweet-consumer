package com.ignite.tweetsvc.service;

import com.ignite.tweetsvc.model.FeedResponse;

public interface IUserTweetService {

	public FeedResponse getUserFeed(String userId);
}
