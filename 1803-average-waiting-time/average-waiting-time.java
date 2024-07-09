class Solution {
    public double averageWaitingTime(int[][] customers) {
        int totCust=customers.length;
        double totWaitTime = 0;
        int currTime = 0;

        for (int[] customer : customers) {
            int arrival = customer[0];
            int service = customer[1];
            if (currTime < arrival) {
                currTime = arrival;
            }
            int waitTime = currTime - arrival + service;
            totWaitTime += waitTime;
            currTime += service;
        }

        return totWaitTime / totCust;
    }
}