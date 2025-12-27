class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? (int) (a[1] - b[1]) : (int) (a[0] - b[0]));

        int[] roomCount = new int[n]; 
        int result = 0;

        for (int i = 0; i < n; i++)
            pq.add(new long[] { 0, i });

        for (int[] item : meetings) {
            int time = item[0]; 

            while (pq.peek()[0] < time) 
                pq.add(new long[] { time, pq.poll()[1] });

            long[] current = pq.poll();
            int curRoom = (int) current[1];
            long meetingEndTime = current[0] + (item[1] - item[0]); 
            roomCount[curRoom]++;

            if (roomCount[curRoom] > roomCount[result]) 
                result = curRoom;
            else if (roomCount[curRoom] == roomCount[result])
                result = Math.min(result, curRoom);

            pq.add(new long[] { meetingEndTime, curRoom });
        }

        return result;
    }
}