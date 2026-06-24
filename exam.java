import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };   //패턴 저장

        int[] scores = new int[patterns.length]; //정답 개수 저장 

        for (int i = 0; i < answers.length; i++) {
            for (int person = 0; person < patterns.length; person++) {
                if (answers[i] == patterns[person][i % patterns[person].length]) {
                    scores[person]++;
                }
            }
        }                 //반복하며 정답 비교후 맞으면 점수 +1

        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));   //1,2,3 수포자 정답 개수 저장
        List<Integer> result = new ArrayList<>(); //동점 대비 & 최고점수자

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                result.add(i+1);  
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
