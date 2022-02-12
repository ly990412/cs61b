
public class LinkedListDeque<T> {

  private class StuffNode {
    public T item;
    public StuffNode next;
    public StuffNode prev;

    public StuffNode(T item, StuffNode next, StuffNode prev) {
      this.item = item;
      this.next = next;
      this.prev = prev;
    }
  }
  private StuffNode first;
  private StuffNode last;
  private int size;

  public LinkedListDeque(){
    first = null;
    last = null;
    size = 0;
  }
  public void addFirst(T item){
    if (last== null && first == null){
      last = new StuffNode(item,null,null);
    }
    first = new StuffNode(item,first,null);
    size += 1;
  }
  public void addLast(T item){
    if (first == null && last == null){
      first = new StuffNode(item,null,null);
    }
    last = new StuffNode(item,null,last);
    size += 1;
  }
  public boolean isEmpty(){
    if (first == null && last == null){
      return true;
    }
    return false;
  }
  public int size(){
    return size;
  }
  public void printDeque(){
    StuffNode tmp = first;
    while (tmp != null){
      System.out.println(tmp.item+" ");
      tmp = tmp.next;
    }
  }
  public T removeFirst(){
    if (first == null){
      return null;
    }
    T out = first.item;
    first = first.next;
    size -= 1;
    return out;
  }
  public T removeLast(){
    if (last == null){
      return null;
    }
    T out = last.item;
    last = last.prev;
    size -= 1;
    return out;
  }
  public T get(int index){
    if (index >= size){
      return null;
    }
    StuffNode tmp = first;
    while (index >0) {
      tmp = tmp.next;
      index -= 1;
    }
    return tmp.item;
  }
  public T getRecursive(int index){
    if (index > size){
      return null;
    }
    return helper(first,index);
  }
  private T helper(StuffNode stu,int idx){
    if (idx == 0){
      return stu.item;
    }
    return helper(stu.next,idx -1);
  }
}



