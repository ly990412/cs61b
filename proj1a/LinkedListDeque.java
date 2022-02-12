
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
  private StuffNode sentinal;
  private int size;

  public LinkedListDeque(){
    sentinal = new StuffNode(null,null,null);
    sentinal.prev = sentinal;
    sentinal.next = sentinal;
    size = 0;
  }
  public void addFirst(T item){
    StuffNode new_node = new StuffNode(item,sentinal.next,sentinal);
    sentinal.next = new_node;
    new_node.next.prev = new_node;
    size += 1;
  }
  public void addLast(T item){
    StuffNode new_node = new StuffNode(item,sentinal,sentinal.prev);
    sentinal.prev = new_node;
    new_node.prev.next = new_node;
    size += 1;
  }
  public boolean isEmpty(){
    if (size == 0){
      return true;
    }
    return false;
  }
  public int size(){
    return size;
  }
  public void printDeque(){
    if (size == 0){
      return ;
    }
    StuffNode tmp = sentinal.next;
    while (tmp != null){
      System.out.println(tmp.item+" ");
      tmp = tmp.next;
    }
  }
  public T removeFirst(){
    if (size == 0){
      return null;
    }
    StuffNode tmp = sentinal.next;
    T out = tmp.item;
    sentinal.next = tmp.next;
    tmp.next.prev = sentinal;
    size -= 1;
    return out;
  }
  public T removeLast(){
    if (size == 0){
      return null;
    }
    StuffNode tmp = sentinal.prev;
    T out = sentinal.item;
    sentinal.prev = tmp.prev;
    tmp.prev.next = sentinal;
    size -= 1;
    return out;
  }
  public T get(int index){
    if (index >= size){
      return null;
    }
    StuffNode tmp = sentinal.next;
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
    return helper(sentinal.next,index);
  }
  private T helper(StuffNode stu,int idx){
    if (idx == 0){
      return stu.item;
    }
    return helper(stu.next,idx -1);
  }
}



