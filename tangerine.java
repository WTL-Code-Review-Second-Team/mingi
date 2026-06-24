import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
         Map<Integer, Integer> countMap = new HashMap<>();
         for (int t : tangerine) {
             
            countMap.put(t, countMap.getOrDefault(t, 0) + 1);
        }   //t=귤 크기, getOrDefault(t, 0) 그 크기의 귤 개수를 Map에 저장
        
         List<Integer> counts = new ArrayList<>(countMap.values());
         counts.sort(Collections.reverseOrder()); //내림차순 정렬

        int answer = 0;
        int total = 0;
        
        for (int count : counts) {
            // 현재 종류의 귤 개수를 total에 더함
            total += count;
            answer++;

            // k개 이상 모였으면 종료
            if (total >= k) {
                break;
            }
        }
        return answer;
    }
}
