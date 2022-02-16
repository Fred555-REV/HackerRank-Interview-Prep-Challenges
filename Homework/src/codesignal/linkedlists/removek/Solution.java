package codesignal.linkedlists.removek;

public class Solution {
    // Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
    ListNode<Integer> solution(ListNode<Integer> l, int k) {
        ListNode<Integer> current = l;
        if(current == null){
            return null;
        }
        if(current.value == k ){
            return solution(current.next,k);
        }
        if(current.next != null && current.next.value == k) {
            //2.n = 3
            current.next = solution(current.next, k);
            //2.n = 4
        }
        if(current.next != null) {
            solution(current.next,k);
        }
        return current;
    }

}
