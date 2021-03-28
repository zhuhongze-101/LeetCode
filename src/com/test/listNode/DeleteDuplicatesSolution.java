package com.test.listNode;

import java.util.HashMap;
import java.util.HashSet;

public class DeleteDuplicatesSolution {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode();
        ListNode result2 = result;
        HashSet<Integer> valSet = new HashSet<Integer>();
        for (;head!=null;head=head.next){
            if(!valSet.contains(head.val)) {
                result.next = new ListNode(head.val);
                result = result.next;
                valSet.add(head.val);
            }
        }

        return  result2.next;
    }

    public static void main(String[] args) {
        deleteDuplicates(new ListNode(1,new ListNode(1,new ListNode(2))));
    }
}
