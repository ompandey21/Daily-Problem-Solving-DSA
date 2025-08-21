import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
// Unsolved
public class DesignTwitter {
    class Twitter {

        public Twitter() {

        }

        private HashMap<Integer, PriorityQueue<Integer>> posts = new HashMap<>();
        private HashMap<Integer, HashMap<Integer, List<Integer>>> following = new HashMap<>();
        private HashMap<Integer, HashMap<Integer, List<Integer>>> followers = new HashMap<>();

    }

    public void postTweet(int userId, int tweetId) {
        postTweet(userId, tweetId, posts);
    }

    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> li = new ArrayList<>();

        for (int c : posts) {
            li.add(c);
        }
        return li;
    }

    public void follow(int followerId, int followeeId) {
        following.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        following.remove(Integer.valueOf(followeeId));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

