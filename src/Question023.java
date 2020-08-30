import java.util.*;

public class Question023 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Length of lists:");
        int n = sc.nextInt();
        ListNode[] lists = new ListNode[n];
        for(int i=0;i<n;i++){
            System.out.print("The length of "+i+"th linked list:");
            int len=sc.nextInt();
            System.out.print("Num array of "+i+"th list:");
            ListNode head = new ListNode();
            ListNode preList = new ListNode();
            for(int j=0;j<len;j++) {
                int num = sc.nextInt();
                if (j == 0) {
                    head = new ListNode(num);
                    preList = head;
                } else {
                    preList.next = new ListNode(num);
                    preList = preList.next;
                }
            }
            lists[i] = head;
        }
        Question023 obj = new Question023();
        ListNode ans = obj.mergeKLists(lists);
        while(ans!=null){
            System.out.print(ans.val+"->");
            ans=ans.next;
        }
    }

    //Approach 1: Brute Force
    public ListNode mergeKLists(ListNode[] lists){
        List<Integer> nums = new ArrayList<>();
        for(ListNode l:lists){
            while(l!=null){
                nums.add(l.val);
                l=l.next;
            }
        }
        Collections.sort(nums);
        ListNode ans = new ListNode();
        ListNode res = ans;
        for(Integer n:nums){
            ans.next = new ListNode(n);
            ans=ans.next;
        }
        return res.next;
    }

    //Approach 2: Compare one by one
    public ListNode mergeKLists1(ListNode[] lists){
        ListNode li = new ListNode();
        ListNode ans = li;
        int len = lists.length;
        while(true){
            int tmp = Integer.MAX_VALUE;
            int index = -1;
            for(int i=0;i<len;i++){
                if(lists[i]!=null && lists[i].val<tmp){
                    tmp = lists[i].val;
                    index = i;
                }
            }
            if(index!=-1){
                li.next = lists[index];
                li=li.next;
                lists[index]=lists[index].next;
            }else{
                break;
            }
        }
        return ans.next;
    }

    //Approach 3: Optimize Approach 2 by Priority Queue
    public ListNode mergeKLists2(ListNode[] lists){
        Comparator<ListNode> cmp =  new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        };
        Queue<ListNode> q = new PriorityQueue<ListNode>(cmp);
        for(ListNode l:lists){
            if(l!=null){
                q.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!q.isEmpty()){
            point.next=q.poll();
            point = point.next;
            ListNode next = point.next;
            if(next!=null){
                q.add(next);
            }
        }
        return head.next;
    }

    //Approach 4: Merge with Divide and Conquer (Bottom-up)
    private ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tail.next=l1;
                l1=l1.next;
            }else{
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }
        tail.next=l1==null?l2:l1;
        return dummyHead;
    }

    public ListNode mergeKLists3(ListNode[] lists){
        if(lists.length==0){
            return null;
        }
        int k= lists.length;
        while(k>1){
            int idx=0;
            for(int i=0;i<k;i=i+2){
                if(i==k-1){
                    lists[idx++]=lists[i];
                }else{
                    lists[idx++]=merge2Lists(lists[i],lists[i+1]);
                }
            }
            k=idx;
        }
        return lists[0];
    }

    //Approach 4: Merge with Divide and Conquer (Recursion)
    public ListNode mergeKLists4(ListNode[] lists){
        if(lists.length==0){return null;}
        return merge(lists,0,lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int lo, int hi){
        if(lo==hi){
            return lists[lo];
        }
        int mid=lo+(hi-lo)/2;
        ListNode l1 = merge(lists,lo,mid);
        ListNode l2 = merge(lists,mid+1,hi);
        return merge2Lists(l1,l2);
    }
}
