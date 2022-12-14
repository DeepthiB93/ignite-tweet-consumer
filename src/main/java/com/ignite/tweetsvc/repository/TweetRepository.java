package com.ignite.tweetsvc.repository;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ignite.tweetsvc.model.TweetInfo;
import com.ignite.tweetsvc.model.TweetInfoId;
import com.ignite.tweetsvc.model.UserInfo;

@Repository
public interface TweetRepository extends CrudRepository<TweetInfo, TweetInfoId> {
	
	
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO tweet_info (tweet_id, text, posted_date, genre) VALUES "
					+ "?1, ?2, ?3, ?4 ", nativeQuery = true)
	void insertTweets(long id, String text, Date postedDate, String genre);
	
	
	/**
	 * Get the latest records for the user based on the genre
	 * 
	 * @param genre user specific genre
	 * @return Tweet
	 */
	@Query("SELECT t FROM tweet_info t where genre = ?1")
	TweetInfo getLatestTweetsInfo(String genre, Pageable pageable);
}
