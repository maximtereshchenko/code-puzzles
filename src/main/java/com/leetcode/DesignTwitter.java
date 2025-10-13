package com.leetcode;

import java.time.Instant;
import java.util.*;

//https://leetcode.com/problems/design-twitter
final class DesignTwitter {

    private final Map<Integer, List<Tweet>> tweets = new HashMap<>();
    private final Map<Integer, Set<Integer>> followers = new HashMap<>();

    void postTweet(int userId, int tweetId) {
        var userTweets = tweets.computeIfAbsent(userId, key -> new ArrayList<>());
        userTweets.add(new Tweet(tweetId, userId, userTweets.size(), Instant.now()));
    }

    List<Integer> getNewsFeed(int userId) {
        var feed = new ArrayList<Integer>();
        var priorityQueue = new PriorityQueue<>(Comparator.comparing(Tweet::instant).reversed());
        addLast(priorityQueue, userId);
        if (followers.containsKey(userId)) {
            for (var followee : followers.get(userId)) {
                addLast(priorityQueue, followee);
            }
        }
        while (feed.size() < 10 && !priorityQueue.isEmpty()) {
            var tweet = priorityQueue.remove();
            feed.add(tweet.id());
            if (tweet.index() != 0) {
                priorityQueue.add(tweets.get(tweet.userId()).get(tweet.index() - 1));
            }
        }
        return feed;
    }

    void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followerId, key -> new HashSet<>()).add(followeeId);
    }

    void unfollow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId)) {
            return;
        }
        followers.get(followerId).remove(followeeId);
    }

    private void addLast(PriorityQueue<Tweet> priorityQueue, int userId) {
        if (tweets.containsKey(userId)) {
            priorityQueue.add(tweets.get(userId).getLast());
        }
    }

    private record Tweet(int id, int userId, int index, Instant instant) {}
}
