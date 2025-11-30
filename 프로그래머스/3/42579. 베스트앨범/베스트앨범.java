import java.util.*;

class Solution {
    static class Song implements Comparable<Song> {
        int id;
        String genre;
        int playCount;
        int genreTotalPlayCount;
        
        public Song (int id, String genre, int playCount, int genreTotalPlayCount) {
            this.id = id;
            this.genre = genre;
            this.playCount = playCount;
            this.genreTotalPlayCount = genreTotalPlayCount;
        }
        
        @Override
        public int compareTo(Song o) {
            if (o.genreTotalPlayCount == this.genreTotalPlayCount) {
                if (o.playCount == this.playCount) {
                    return this.id - o.id;
                }    
                
                return o.playCount - this.playCount;
            }
            
            return o.genreTotalPlayCount - this.genreTotalPlayCount;
        }
        
    }
    
    static Map<String, Integer> map;
    static Map<String, Integer> totalCount;
    
    public int[] solution(String[] genres, int[] plays) {
        map = new HashMap<>();
        totalCount = new HashMap<>();
        
        // total count 집계
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            totalCount.put(genre, totalCount.getOrDefault(genre, 0) + play);
        }
        
        
        // 우선순위 큐에 song을 입력
        PriorityQueue<Song> pq = new PriorityQueue<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            pq.offer(new Song(i, genre, play, totalCount.get(genre)));
        }
        
        List<Integer> arr = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            Song song = pq.poll();
            String genre = song.genre;
            map.put(genre, map.getOrDefault(genre, 0) + 1);
            
            if (map.get(genre) <= 2) {
                arr.add(song.id);        
            }
            
        }
        
        int[] answer = arr.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

// 1. genre의 play total count
// 2. genre`s song count 
// 3. song mId

// 각 genre별 상위 count 두곡씩
// 만약 한개밖에 없으면 한개만

// genres, plays, mID

//  song <= 10000 O(n)