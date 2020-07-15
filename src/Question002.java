import java.util.Scanner;

/*  LeetCode Question 2: Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * */

public class Question002 {

    public static  void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Question002 obj = new Question002();
        int dig1 = sc.nextInt();
        int dig2 = sc.nextInt();
        ListNode l1 = new ListNode(0);
        ListNode head1 = l1;
        while(dig1>0){
            int num = dig1 % 10;
            dig1 = dig1/10;
            l1.next = new ListNode(num);
            l1=l1.next;
        }

        ListNode l2 =  new ListNode(0);
        ListNode head2 = l2;
        while(dig2>0){
            int num = dig2 % 10;
            dig2 = dig2/10;
            l2.next = new ListNode(num);
            l2 = l2.next;
        }

        ListNode result = obj.AddTwoNumbers(head1.next,head2.next);

        while(result!=null)
        {
            System.out.print(result.val+" ");
            result = result.next;
        }
        System.out.println();
/*        while(head1.next!=null)
        {
            System.out.print(head1.next.val+" ");
            head1.next = head1.next.next;
        }
 */
    }

    public ListNode AddTwoNumbers(ListNode l1, ListNode l2){
        int num=0;
        int carry=0;
        int x=0, y=0;
        ListNode head = new ListNode(0);
        ListNode curr = head, ln1 = l1, ln2=l2;
        while(ln1!=null||ln2!=null)
        {
            x = (ln1!=null)? ln1.val:0;
            y = (ln2!=null)? ln2.val:0;
            num = x+y+carry;
            carry=num/10;
            curr.next= new ListNode(num%10);
            curr=curr.next;
            if(ln1!=null) ln1=ln1.next;
            if(ln2!=null) ln2=ln2.next;
        }
        if(carry==1){curr.next = new ListNode(1);}
        return head.next;
    }
}

