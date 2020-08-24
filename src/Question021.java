/* LeetCode Question 21: Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * */

import java.util.Scanner;

public class Question021 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Length of 1st list:");
        int len = sc.nextInt();
        System.out.print("Num array of 1st list:");
        ListNode l1 = new ListNode();
        ListNode prelist = new ListNode();
        for(int i=0;i<len;i++){
            int num = sc.nextInt();
            if(i==0){
                l1.val=num;
                prelist = l1;
            }else{
                prelist.next = new ListNode(num);
                prelist = prelist.next;
            }
        }
        System.out.print("Length of 2nd list:");
        len = sc.nextInt();
        System.out.print("Num array of 2nd list:");
        ListNode l2 = new ListNode();
        for(int i=0;i<len;i++){
            int num = sc.nextInt();
            if(i==0){
                l2.val=num;
                prelist = l2;
            }else{
                ListNode l = new ListNode(num);
                prelist.next = l ;
                prelist = l;
            }
        }
        Question021 obj = new Question021();
        ListNode ans = obj.mergeTwoLists2(l1,l2);
        System.out.print("Two lists after merge: ");
        while(ans!=null){
            System.out.print(ans.val+"->");
            ans = ans.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1==null){return l2;}
        if(l2==null){return l1;}
        ListNode tmp = new ListNode();
        ListNode ans = tmp;
        while(l1!=null || l2!=null){
            if(l1==null){
                tmp.next = l2;
                tmp = tmp.next;
                l2 = l2.next;
            }else if(l2==null){
                tmp.next = l1;
                tmp = tmp.next;
                l1 = l1.next;
            }else{
                if(l1.val<=l2.val){
                    tmp.next = l1;
                    tmp = tmp.next;
                    l1 = l1.next;
                }else{
                    tmp.next = l2;
                    tmp = tmp.next;
                    l2 = l2.next;
                }
            }
        }
        return ans.next;
    }

    //Approach 2: Iteration
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode preList = head;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                preList.next = l1;
                l1 = l1.next;
            }else{
                preList.next = l2;
                l2 = l2.next;
            }
            preList = preList.next;
        }
        preList.next = l1!=null?l1:l2;
        return head.next;
    }

    //Approach 3: Recursion
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if(l1==null){return l2;}
        if(l2==null){return l1;}
        if(l1.val<=l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }
}
