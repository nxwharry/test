import javax.swing.*;

public class List {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        ListNode head,last;
        head = null;
        last = null;
        for(int num : a){
            ListNode temp = new ListNode(num);
            if(head == null) {
                last = head = temp;
            }else{
               last.next = temp;
               last = temp;
            }
        }
        last.next = null;
        reverseList2(head,2,4);
    }
    public static ListNode reverseList(ListNode head) {
        //迭代法
        if(head != null) {
            ListNode tmp, last, work;
            work = head.next;
            last = head;
            while (work != null) {
                tmp = work.next;
                work.next = head;
                head = work;
                work = tmp;
            }
            last.next = null;
            while (head != null) {
                System.out.println(head.val);
                head = head.next;
            }
        }
        return head;
//        //递归法
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode p = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return p;
    }
    public static ListNode reverseList2(ListNode head, int m, int n) {
        int length = 0;
        ListNode l;
        ListNode r = new ListNode(-1);
        r.next = head;
        l = head;
        while(l != null){
            l = l.next;
            length = length + 1;
        }
        if(m >= length){
            return head;
        }
        ListNode pre = r;
        for(int i = 0; i < m-1; i++){
            pre = pre.next;
        }
        ListNode last,work;
        work = pre.next;
        last = pre.next;
        n = n - m + 1;
        while(work != null && n > 0){
            ListNode tmp = work.next;
            work.next = pre.next;
            pre.next = work;
            work = tmp;
            n = n - 1;
        }
        last.next = work;
        r= r.next;
        while (r!=null){
            System.out.println(r.val);
            r=r.next;
        }
        return r;
    }

}
