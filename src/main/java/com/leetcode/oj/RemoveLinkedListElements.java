/**
 * Source : https://leetcode.com/problems/remove-linked-list-elements/
 * Author : Hexiaoqiao
 * Date   : 2015-05-03
 *
 * 0.Problem:
 * Remove all elements from a linked list of integers that 
 * have value val.
 * 
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * 1.Refer.:
 * 
 */
package com.leetcode.oj;

public class RemoveLinkedListElements {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static ListNode removeElements(ListNode head, int val) {
    ListNode p = head;
    ListNode q = null;
    while (null != p && val == p.val) {
      p = p.next;
      head = head.next;
    }
    if (null == head) return null; 
    p = head.next;
    q = head;
    while (null != p) {
      if (val == p.val) {
        q.next = p.next;
        p = p.next;
      } else {
        q = q.next;
        p = p.next;
      }
    }
    return head;
  }

  public static void printlinkedlist(ListNode head) {
    ListNode p = head;
    while (null != p) {
      System.out.print(p.val);
      System.out.print(" ");
      p = p.next;
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(1);
    ListNode c = new ListNode(2);
    ListNode d = new ListNode(2);
    ListNode e = new ListNode(3);
    ListNode f = new ListNode(4);
    ListNode g = new ListNode(5);
    
    a.next = b;
    /*
    b.next = c;
    c.next = d;
    d.next = e;
    e.next = f;
    f.next = g;
    */
    printlinkedlist(a);
    a = removeElements(a, 1);
    printlinkedlist(a);
  }
}
