package practice.medium;

import java.util.Arrays;

public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        int[] startTime=new int[intervals.length];
        int[] endTime=new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            startTime[i]=intervals[i][0];
            endTime[i]=intervals[i][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int room=0, endMeetingTime=0;
        for(int i=0; i<intervals.length;i++){
            if(startTime[i]<endTime[endMeetingTime])
                room++;
            else
                endMeetingTime++;
        }

        return room;
    }

    public static void main(String[] args) {
        MeetingRoomII meetingRoom=new MeetingRoomII();
        System.out.println(meetingRoom.minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));
    }
}
