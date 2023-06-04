package WhiteBoarding_w15;

import java.util.Arrays;

/*
 * Given an array of meeting time intervals consisting of start and end times
 *  [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:
Input: [[0,30],[5,10],[15,20]]
Output: false

Example 2:
Input: [[7,10],[2,4]]
Output: true
 */
public class MeetingTime {
    public static void main(String[] args) {
        int[][] meetings1 = {{0,30}, {5,10},{15,20}};
        int[][] meetings2 = {{7,10},{2,4}};

        System.out.println(makeMeeting(meetings1));
        System.out.println(makeMeeting(meetings2));
    }

    public static boolean makeMeeting(int[][] meetings) {
        // loop thru from first to end and see if time slot clashes
        for(int i = 0 ; i < meetings.length - 1; i++) {
            for(int j = i+1; j < meetings.length; j++ ) {
                // start greater than start or less than end 
                // or end greater than start or less than end
                // System.out.println("meeting 1 : " + Arrays.toString(meetings[i]));
                // System.out.println("meeting 2 : " + Arrays.toString(meetings[j]));

                if(meetings[i][0] > meetings[j][0] && meetings[i][0] < meetings[j][1] ||
                    meetings[i][1] > meetings[j][0] && meetings[i][1] < meetings[j][1] ||
                    meetings[j][0] > meetings[i][0] && meetings[j][1] < meetings[i][1] ||
                    meetings[j][1] > meetings[i][0] && meetings[j][1] < meetings[i][1]) {
                        return false;
                    }
            }
        }
        return true;
    }

        
    }
    
    

