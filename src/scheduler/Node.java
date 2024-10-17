package scheduler;


public class Node<T> {
    //you left ur token in the clipboard don't do that or you will be hacked again
    private T value;
    private Node<T> prev;
    private Node<T> next;
   
    
    public Node(T value) {
        this.value = value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
    
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
    
    public void setNext(Node<T> next) {
        this.next = next;
    }   
    
    public T getValue() {
        return this.value;
    }
    
    public Node<T> getPrev() {
        return this.prev;
    }
    
    public Node<T> getNext() {
        return this.next;
    }
}
