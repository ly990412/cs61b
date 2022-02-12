public class ArrayDeque<T> {

  private T[] array;
  private int size;
  private int next_first;
  private int next_last;
  private static int max_size = 8;

  public ArrayDeque(){
    array = (T[]) new Object[max_size];
    size = 0;
    next_first = 0;
    next_last = 1;
  }

  private int getNext(int index){
    if (index < 0){
      return index + max_size;
    }
    return index % max_size;
  }
  private int getNext_first(int index){
    return getNext(index - 1);
  }
  private int getNext_last(int index){
    return getNext(index + 1);
  }
  private void resize(int capacity){
    T[] a = (T[]) new Object[size + capacity];
    System.arraycopy(array,0,a,0,size);
    max_size *= 2;
    array = a;
    next_first = getNext_first(0);
    next_last = size;
  }
  public void addFirst(T item){
    if (size == array.length){
      resize(max_size);
    }
    array[next_first] = item;
    size += 1;
    next_first = getNext_first(next_first);
  }
  public void addLast(T item){
    if (size == array.length){
      resize(max_size);
    }
    array[next_last] = item;
    size += 1;
    next_last = getNext_last(next_last);
  }
  public boolean isEmpty(){
    if (size == 0){
      return true;
    }
    return false;
  }
  public void printDeque(){
    for (int i = 0;i<size;i++){
      System.out.println(get(i)+" ");
    }
  }
  public int size(){
    return size;
  }
  public T removeFirst(){
    if (size == 0){
      return null;
    }
    next_first = getNext(next_first + 1);
    T out = array[next_first];
    array[next_first] = null;
    size -= 1;
    return out;
  }
  public T removeLast(){
    if (size == 0){
      return null;
    }
    next_last = getNext(next_last - 1);
    T out = array[next_last];
    array[next_last] = null;
    size -= 1;
    return out;
  }
  public T get(int index){
    index = (index + next_first + 1)%max_size;
    return array[index];
  }

}
