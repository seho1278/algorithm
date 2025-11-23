import java.util.*;

class Solution {           
    
    static class Car {
        int inTime;
        int accumulate;
        
        public Car(int inTime, int accumulate) {
            this.inTime = inTime;
            this.accumulate = accumulate;
        }
                
    }
    
    Car[] cars = new Car[10000];
    
    public static int convertTime(String time) {
        String[] timeArr = time.split(":");        
        
        int hour = Integer.parseInt(timeArr[0]);
        int minute = Integer.parseInt(timeArr[1]);
        
        return hour * 60 + minute;
    }
    
    public static int calculator(int[] fees, int accumulate) {
        if (accumulate <= fees[0]) {
            return fees[1];
        } else {
            int overTime = accumulate - fees[0];
            int unit = (int) Math.ceil((double) overTime / fees[2]);
            return fees[1] + unit * fees[3];
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        cars = new Car[10000];
        
        for (String record: records) {
            String[] tmp = record.split(" ");
            int time = convertTime(tmp[0]);
            int carNo = Integer.parseInt(tmp[1]);
            
            if (cars[carNo] == null) {
                cars[carNo] = new Car(-1, 0);
            }
            
            if (tmp[2].equals("IN")) {
                cars[carNo].inTime = time;
            } else {
                cars[carNo].accumulate += time - cars[carNo].inTime;
                cars[carNo].inTime = -1;
                
            }
        }
               
        int carCnt = 0;
        for (int i = 0; i < 10000; i++) {
            if (cars[i] != null) {
                carCnt++;
                if (cars[i].inTime != -1) {
                    cars[i].accumulate += (24 * 60 - 1) - cars[i].inTime;
                }
            }
        }
        
        int[] answer = new int[carCnt];
        int idx = 0;
        
        for (int i = 0; i < 10000; i++) {
            if (cars[i] == null) {
                continue;
            }
            
            answer[idx++] = calculator(fees, cars[i].accumulate);
        }
            
        return answer;
    }
}