/* LeetCode Question 24: Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * */

import java.util.Scanner;

public class Question024 {
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
        Question024 obj = new Question024();
        ListNode ans = obj.swapPairs(head);
        System.out.println("Result:");
        while(ans!=null){
            System.out.print(ans.val +"->");
            ans=ans.next;
        }
    }

    //Approach 1: Iteration
    public ListNode swapPairs(ListNode head) {
        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;
        while ((head != null) && (head.next != null)) {
            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }
        // Return the new head node.
        return dummy.next;
    }

    //Approach 2: Recursion
    public ListNode swapPairs2(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs2(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }
}
