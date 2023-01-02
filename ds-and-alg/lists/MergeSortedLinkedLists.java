package lists;

public class MergeSortedLinkedLists {

    
    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        
        SinglyLinkedListNode result = null;
        SinglyLinkedListNode resultPointer = null;
        SinglyLinkedListNode curr1 = head1;
        SinglyLinkedListNode curr2 = head2;
        if (head1.data > head2.data){ 
            result = new SinglyLinkedListNode(head2.data);
            curr2 = head2.next;            
        }else {
            result = new SinglyLinkedListNode(head1.data);
            curr1 = head1.next;
        }
        MergeSortedLinkedLists.printListNode(result);
        
        resultPointer = result;
        while (curr1 != null && curr2 != null) {
            if (curr1.data <= curr2.data){
                resultPointer.next = new SinglyLinkedListNode(curr1.data);
                curr1 = curr1.next;
            } else {
                resultPointer.next = new SinglyLinkedListNode(curr2.data);
                curr2 = curr2.next;
            }
            resultPointer = resultPointer.next;
            
            MergeSortedLinkedLists.printListNode(result);
            System.out.println("loop");
        }

        while (curr1 != null) {
            resultPointer.next = new SinglyLinkedListNode(curr1.data);
            curr1 = curr1.next;
            resultPointer = resultPointer.next;
        }
        while (curr2 != null) {
            resultPointer.next = new SinglyLinkedListNode(curr2.data);
            curr2 = curr2.next;
            resultPointer = resultPointer.next;
        }
        
        return result;
    }

    public static void printListNode(SinglyLinkedListNode list){
        SinglyLinkedListNode node = list;
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String args[]) {
        SinglyLinkedListNode n1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode n2 = new SinglyLinkedListNode(3);
        SinglyLinkedListNode n3 = new SinglyLinkedListNode(7);

        n1.next = n2;
        n2.next = n3;

        SinglyLinkedListNode m1 = new SinglyLinkedListNode(3);
        SinglyLinkedListNode m2 = new SinglyLinkedListNode(4);

        m1.next = m2;

        SinglyLinkedListNode result = MergeSortedLinkedLists.mergeLists(n1, m1);

        MergeSortedLinkedLists.printListNode(result);
    }
    
}
