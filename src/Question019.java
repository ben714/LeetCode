/* LeetCode Question 19: Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note: Given n will always be valid.
 * */

import java.util.*;

public class Question019 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Length of list:");
        int n = sc.nextInt();
        ListNode head = new ListNode();
        ListNode preList = new ListNode();
        System.out.println("Linked list:");
        for(int i=0;i<n;i++){
            int num=sc.nextInt();
            if(i==0){
                head = new ListNode(num);
                preList = head;
            }
            else{
                ListNode li = new ListNode(num);
                preList.next = li;
                preList = li;
            }
        }
        System.out.println("Target n:");
        int target = sc.nextInt();
        Question019 obj = new Question019();
        ListNode ans = obj.removeNthFromEnd(head,target);
        System.out.println("Result:");
        while(ans!=null){
            System.out.print(ans.val +"->");
            ans=ans.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode ans = head;
        List<ListNode> li = new ArrayList<>();
        int count = 0;
        while(ans!=null){
            li.add(ans);
            count++;
            ans=ans.next;
        }
        count = count -n;

        ListNode second = li.get(count);
        if(count==0) {
            if(second.next==null) {
                return null;
            }else{
                return second.next;
            }
        } else{
            ListNode first = li.get(count-1);
            if(second.next!=null)
            {
                first.next=second.next;
            }else{
                first.next=null;
            }
        }
        return head;
    }
}
