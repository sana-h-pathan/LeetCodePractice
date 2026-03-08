class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for(int[] booking: bookings){
            int s = booking[0]-1;
            int e = booking[1]-1;
            int seats = booking[2];
            for(int i=s;i<=e;i++){
                result[i]+=seats;
            }
        }
        return result;
    }
}