package com.ignite.tweetsvc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.ignite.tweetsvc.model.FeedResponse;
import com.ignite.tweetsvc.model.TweetInfo;
import com.ignite.tweetsvc.model.UserInfo;
import com.ignite.tweetsvc.repository.TweetRepository;
import com.ignite.tweetsvc.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserTweetService implements IUserTweetService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TweetRepository tweetRepository;

	@Override
	public FeedResponse getUserFeed(String userId) {
		UserInfo userInfo = userRepository.getUserInfo(userId);
		FeedResponse feedResponse = new FeedResponse();
		if(userInfo != null && userInfo.getGenre() != null && userInfo.getGenre().isEmpty()) {
			Pageable pageable = PageRequest.of(0, 5, Sort.by(Order.desc("posted_date")));
			TweetInfo feed = tweetRepository.getLatestTweetsInfo(userInfo.getGenre(), pageable);
			
			feedResponse.setMessage("Success");
			feedResponse.setStatusCode(200);
			feedResponse.setTweetList(feed);
			
		} else {
			log.error("Invalid user");
			feedResponse.setMessage("Failure");
			feedResponse.setStatusCode(401);
		}	
		return feedResponse;
	}
}
