package com.ignite.tweetsvc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;

import com.ignite.tweetsvc.repository.TweetRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ConsumerComponent {

	@Autowired
	TweetRepository tweetRepository;

	@KafkaListener(topics = "TEST_TOPIC", groupId = "group_id")
	public void consume(Tweet message) {
		log.info("message = " + message);
		tweetRepository.insertTweets(message.getId(), message.getText(), message.getCreatedAt(), message.getSource());
	}
}
