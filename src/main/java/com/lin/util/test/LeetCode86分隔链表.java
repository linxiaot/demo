package com.lin.util.test;

/**
 * @author liuxiaojia
 * @date 2023/2/24 09:40
 * @Description:
 */
public class LeetCode86分隔链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        ListNode partition = partition(head, 3);
        System.out.println(partition);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2;
        ListNode p = head;
        while(p != null){
            if(p.val < x){
                p1.next = p;
                p1 = p1.next;
            }else {
                p2.next = p;
                p2 = p2.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
