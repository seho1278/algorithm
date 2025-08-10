class Solution {
    public int solution(String s) {
        int minLength = s.length();
        
        for (int i = 1; i <= s.length()/2; i++) {
        	StringBuilder sb = new StringBuilder(); 
            int pos = 0;
            
            while(pos + i <= s.length()) {
            	String pattern = s.substring(pos, pos + i);
            	pos += i;
            	int count = 1;
            	
            	while (pos + i <= s.length()) {
            		String next = s.substring(pos, pos + i);
            		if (pattern.equals(next)) {
            			count++;
            			pos += i;
            		} else {
            			break;
            		}
            	}
            	
            	if (count > 1) {
            		sb.append(count);
            	}
            	sb.append(pattern);
            }
            
            if (pos < s.length()) {
            	sb.append(s.substring(pos));
            }
            
            minLength = Math.min(minLength, sb.length());
        }
        
        
        return minLength;
    }
}