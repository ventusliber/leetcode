package Questions;

import Leet.ListNode;

public class Q02 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int res = 0;
        while(l1!=null || l2!=null || res!=0)
        {
        	int sum = ((l1==null)? 0 :l1.val) + ((l2==null)? 0 :l2.val) + res;
        	ListNode node = new ListNode(sum%10);
        	res = sum/10;
        	temp.next = node;
        	temp = temp.next;
        	
        	l1 = (l1==null)? l1: l1.next;
        	l2 = (l2==null)? l2: l2.next;
        }
        
        return result.next;
    }
    
    public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode temp1 = l1;
		temp1.next = new ListNode(4);
		temp1 = temp1.next;
		temp1.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		ListNode temp2 = l2;
		temp2.next = new ListNode(6);
		temp2 = temp2.next;
		temp2.next = new ListNode(4);
		
		
		ListNode result = addTwoNumbers(l1,l2);
		while(result !=null)
		{
			System.out.println(result.val);
			result = result.next;
		}

	}
}
