/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(matrix[i], -1);
        }
        int top=0;
        int left=0;
        int bottom=m-1;
        int right=n-1;
        while(head!=null){
            for(int j=left;j<=right && head!=null;j++){
                matrix[top][j]=head.val;
                head=head.next;
            }
            top++;
            for(int i=top;i<=bottom && head!=null;i++){
                matrix[i][right]=head.val;
                head=head.next;
            }
            right--;
            for(int j=right;j>=left && head!=null;j--){
                matrix[bottom][j]=head.val;
                head=head.next;
            }
            bottom--;
            for(int i=bottom;i>=top && head!=null;i--){
                matrix[i][left]=head.val;
                head=head.next;
            }
            left++;
        }
        return matrix;
    }
}