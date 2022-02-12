public class ArrayDeque<T> {

  private T[] array;
  private int size;
  private int next_first;
  private int next_last;

  public ArrayDeque(){
    array = (T[]) new Object[8];
    size = 0;
    next_first = 3;
    next_last = 4;
  }
  private void resize(int capacity){
    T[] a = (T[]) new Object[capacity+size+capacity];
    System.arraycopy(array,0,a,capacity,size);
    array = a;
    next_first = capacity - 1 ;
    next_last = capacity + size;
  }
  public void addFirst(T item){
    if (size == array.length){
      resize(100);
    }
    array[next_first] = item;
    size += 1;
    next_first -= 1;
    if (next_first < 0){
      next_first = array.length - 1;
    }
  }
  public void addLast(T item){
    if (size == array.length){
      resize(100);
    }
    array[next_last] = item;
    size += 1;
    next_last += 1;
    if (next_last == array.length){
      next_last = 0;
    }
  }
  public boolean isEmpty(){
    if (size == 0){
      return true;
    }
    return false;
  }
  public void printDeque(){
    if (next_first < next_last) {
      for (int i = next_first + 1; i < next_last; i++) {
        System.out.println(array[i]);
      }
    }
    else{
      for (int k = next_first+1;k<array.length;k++ ){
        System.out.println(array[k]);
      }
      for (int j = 0;j<next_last;j++){
        System.out.println(array[j]);
      }
    }
  }
  public int size(){
    return size;
  }
  public T removeFirst(){
    T out = array[next_first +1];
    next_first += 1;
    size -= 1;
    if (next_first == array.length){
      next_first = 0;
    }
    return out;
  }
  public T removeLast(){
    T out = array[next_last-1];
    next_last -= 1;
    size -= 1;
    if (next_last <0){
      next_last = array.length - 1;
    }
    return out;
  }
  public T get(int index){
    if(next_last <= index && index <= next_first){
      return null;
    }
    if (index <= next_first || index >= next_last){
      return null;
    }
    return array[index];
  }

}
