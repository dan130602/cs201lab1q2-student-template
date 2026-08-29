public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            walk = walk.getNext();
        }
        return sb.toString();
    }

    public E removeLast() {
        if (isEmpty()) return null;                  // nothing to remove
        E answer = tail.getElement();
        if (head == tail) {                         // if there is only one node
            head = null;
            tail = null;
        }
        else {                                      // if there is more than one node, find second last node
            Node<E> walk = head;
            while(walk.getNext() != tail)
                walk = walk.getNext();
            walk.setNext(null);
            tail = walk;
        }
        size--;
        return answer;
    }

    public void reverse(){
        Node<E> curr = head;
        Node<E> prev = null;
        tail = head;
        while (curr != null) {
            Node<E> nextNode = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = nextNode;
        }
        head = prev;
    }
}