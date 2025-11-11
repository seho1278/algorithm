import java.util.*;

class Solution {
    static int[] parent;
    static String[] arr;
    
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA == rootB) {
            return;
        }
        
        String val1 = arr[rootA];
        String val2 = arr[rootB];
        
        
        parent[rootB] = rootA;
        
        if (val1 != null) {
            arr[rootA] = val1;
        } else {
            arr[rootA] = val2;
        }
        
        arr[rootB] = null;
    }
    
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public String[] solution(String[] commands) {
        arr = new String[2501];
        
        List<String> aList = new ArrayList<>();
        parent = new int[2501];
        
        for (int i = 1; i <= 2500; i++) {
            parent[i] = i;
        }
        
        for (String command: commands) {
            String[] tmp = command.split(" ");
            
            if (tmp[0].equals("UPDATE")) {
                if (tmp.length == 4) {
                    int root = find((Integer.parseInt(tmp[1]) - 1) * 50 + Integer.parseInt(tmp[2]));
                    arr[root] = tmp[3];
                } else if (tmp.length == 3) {
                    String val1 = tmp[1];
                    String val2 = tmp[2];
                    for (int i = 1; i <= 2500; i++) {
                        if (parent[i] == i && val1.equals(arr[i])) {
                            arr[i] = val2;
                        }
                    }
                }
            } else if (tmp[0].equals("MERGE")) {
                int idx1 = (Integer.parseInt(tmp[1]) - 1) * 50 + Integer.parseInt(tmp[2]);
                int idx2 = (Integer.parseInt(tmp[3]) - 1) * 50 + Integer.parseInt(tmp[4]);
                
                union(idx1, idx2);
                
            } else if (tmp[0].equals("UNMERGE")) {
                int target = (Integer.parseInt(tmp[1]) - 1) * 50 + Integer.parseInt(tmp[2]);
                int root = find(target);
                String val1 = arr[root];
                
                arr[root] = null;
                
                List<Integer> unMerge = new ArrayList<>();
                for (int i = 1; i <= 2500; i++) {
                    if (find(i) == root) {
                        unMerge.add(i);
                    }
                }
                
                for (int idx: unMerge) {
                    parent[idx] = idx;
                }
                
                arr[target] = val1;
                
            } else if (tmp[0].equals("PRINT")) {
                int root = find((Integer.parseInt(tmp[1]) - 1) * 50 + Integer.parseInt(tmp[2]));
                String s = arr[root];
                if (s == null) {
                    aList.add("EMPTY");
                } else {
                    aList.add(s);    
                }
            }
        }
        
        String[] answer = new String[aList.size()];
        int idx = 0;
        for (String s: aList) {
            answer[idx] = s;
            idx++;
        }
        return answer;
    }
}