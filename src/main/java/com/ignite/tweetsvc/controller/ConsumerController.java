package com.ignite.tweetsvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ignite.tweetsvc.model.FeedResponse;
import com.ignite.tweetsvc.service.IUserTweetService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "ignite", produces = "application/json")
@CrossOrigin
@Slf4j
public class ConsumerController {
	
	IUserTweetService userService;

	@GetMapping("/api/getUserFeeds/users/{userId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public FeedResponse getUserSpecificTweets(@PathVariable String userId) {
		log.info("Getting tweets for the user : " + userId);
		FeedResponse feed = userService.getUserFeed(userId);
		return feed;
	}
}
