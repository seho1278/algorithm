import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        
        int[] student1 = new int[]{1, 2, 3, 4, 5};
        int[] student2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) {
                answer[0]++;
            }
            if (answers[i] == student2[i % student2.length]) {
                answer[1]++;
            }
            if (answers[i] == student3[i % student3.length]) {
                answer[2]++;
            }
        }
        
        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        List<Integer> list = new ArrayList<>();
        if (max == answer[0]) {list.add(1);}
        if (max == answer[1]) {list.add(2);}
        if (max == answer[2]) {list.add(3);}
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
        	result[i] = list.get(i);
        }
        
        return result;
    }
}