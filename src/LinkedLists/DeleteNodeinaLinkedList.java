package LinkedLists;

/**
 * Created by RajeshAatrayan|InterviewPreparation|LinkedLists|DeleteNodeinaLinkedList| on Jun,2020
 *  
 * Happy Coding :)
 **/
public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {

        node.val=node.next.val;
        node.next=node.next.next;

    }
}
