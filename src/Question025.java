/* LeetCode Question 25: Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 * */

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Question025 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Length of the list:");
        int len = sc.nextInt();
        System.out.print("Num array of the list:");
        ListNode head = new ListNode();
        ListNode prelist = new ListNode();
        for(int i=0;i<len;i++){
            int num = sc.nextInt();
            if(i==0){
                head.val=num;
                prelist = head;
            }else{
                prelist.next = new ListNode(num);
                prelist = prelist.next;
            }
        }
        System.out.print("Value K:");
        int k = sc.nextInt();
        Question025 obj = new Question025();
        ListNode ans = obj.reverseKGroup(head,k);
        System.out.println("Result:");
        while(ans!=null){
            System.out.print(ans.val +"->");
            ans=ans.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k){
        if(k<=1){return head;}

        ListNode ans = head;
        ListNode first = head;

        for (int i = 1; i < k && head != null; i++) {
            head = head.next;
        }
        if (head == null) {return ans;}

        ListNode next = head.next;
        head.next = null;

        ans = reverse(ans);
        first.next = reverseKGroup(next,k);
        return ans;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
