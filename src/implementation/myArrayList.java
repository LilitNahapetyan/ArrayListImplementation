package implementation;

import java.util.Objects;

public class myArrayList<E> implements List<E> {
    private  Object[] data;
    private int capacity;
    private static final int FACTOR = 5;
    private  int cursor;

    {
        capacity = 10;
        data = new Object[capacity];
        cursor = 0;
    }

    public myArrayList(){}

    public myArrayList(E... arr){
        for(E el: arr){
            add(el);
        }
    }

    public int capacity(){
        return capacity;
    }
    @Override
    public int size() {
        return cursor;
    }

    @Override
    public boolean isEmpty() {
        return cursor == 0;
    }

    @Override
    public boolean add(E element) {
        if(cursor == capacity - 1){
            increaseArray();
        }
        data[cursor++] = element;
        return true;
    }

    private void increaseArray(){
        capacity += FACTOR;
        Object[] newArray = new Object[capacity];
        System.arraycopy(data,0,newArray,0,cursor);
        data = newArray;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        if(cursor == capacity - 1){
            if(index == cursor){
                add(element);
            }else{
                capacity += FACTOR;
            }
        }
        Object[] newArray = new Object[capacity];
        System.arraycopy(data,0,newArray,0,index);
        newArray[index] = element;
        System.arraycopy(data,index,newArray,index,cursor);
        data = newArray;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E)data[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        data[index] = element;
        return element;
    }

    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        if(index != -1){
           remove(index);
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        checkIndex(index);
        E removedElement = (E) data[index];
        for(int i = index; i < cursor - 1; i++){
            data[i] = data[i+1];
        }
        cursor--;
        return removedElement;
    }


    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public int indexOf(E element) {
        for(int i = 0; i < cursor; i++){
            if(data[i] == null){
                if(element == null){
                    return i;
                }
            }else {
                if(data[i].equals(element)){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        for (int i = cursor - 1; i >= 0; i--) {
            if (data[i] == null) {
                if (element == null) {
                    return i;
                }
            } else {
                if (data[i].equals(element)) {
                    return i;
                }
            }
        }
        return -1;
    }


    @Override
    public void clear() {
        cursor = 0;
        capacity = 10;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] resultArray = (E[]) new Object[cursor];
        System.arraycopy(data, 0, resultArray, 0, cursor);

        return resultArray;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] array) {
        if (array.length < cursor) {
            T[] newArray = (T[]) new Object[cursor];
            System.arraycopy(data, 0, newArray, 0, cursor);
            return newArray;
        } else {
            System.arraycopy(data, 0, array, 0, cursor);
            if (array.length > cursor) {
                array[cursor] = null; // Set the element after the last one to null.
            }
            return array;
        }
    }


    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > cursor || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Invalid index range");
        }
        myArrayList<E> sub = new myArrayList<>();
        System.arraycopy(data, fromIndex, sub.data, 0, toIndex - fromIndex);
        sub.cursor = toIndex - fromIndex;
        sub.capacity = toIndex - fromIndex;
        return sub;
    }


    @Override
    @SuppressWarnings("unchecked")
    public boolean removeAll(List<?> otherList) {
        for(int i = 0; i < otherList.size(); i++){
            E current = (E)otherList.get(i);
            if(contains(current)){
                remove(current);
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(List<?> otherList) {
        int s= size();
        for(int i = 0 ; i < cursor; i++){
            E current = (E)data[i];
            if(contains(current)){
                remove(current);
            }
        }
        return s == size();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean containsAll(List<?> otherList) {
        for(int i = 0; i < otherList.size(); i++){
            if(!contains((E)otherList.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean addAll(List<? extends E> otherList) {
        Object[] o = otherList.toArray();
        for (Object element : o) {
            add((E) element);
        }
        return true;
    }
    @Override
    public boolean addAll(int index, List<? extends E> otherList) {
        if (index < 0 || index > cursor) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }

        int otherListSize = otherList.size();
        if (otherListSize == 0) {
            return false;
        }

        int requiredCapacity = cursor + otherListSize;
        if (requiredCapacity > capacity) {
            while (capacity < requiredCapacity) {
                capacity += FACTOR;
            }
            Object[] newArray = new Object[capacity];
            System.arraycopy(data, 0, newArray, 0, index);
            System.arraycopy(otherList.toArray(), 0, newArray, index, otherListSize);
            System.arraycopy(data, index, newArray, index + otherListSize, cursor - index);
            data = newArray;
        } else {
            System.arraycopy(data, index, data, index + otherListSize, cursor - index);
            System.arraycopy(otherList.toArray(), 0, data, index, otherListSize);
        }

        cursor += otherListSize;
        return true;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }

        List<?> otherList = (List<?>) obj;

        if (this.size() != otherList.size()) {
            return false;
        }

        for (int i = 0; i < this.size(); i++) {
            E element1 = this.get(i);
            Object element2 = otherList.get(i);

            if (!element1.equals(element2)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public int hashCode() {
        int hashCode = 1;

        for (Object element : data) {
            hashCode = 31 * hashCode + Objects.hashCode(element);
        }

        return hashCode;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder("[");
        for (int i = 0; i < size() - 1; i++) {
            st.append(data[i]).append(", ");
        }
        if (size() > 0) {
            st.append(data[size() - 1]);
        }
        st.append("]");
        return st.toString();
    }

    private  void checkIndex(int index){
        if(index < 0){
            throw new RuntimeException("Index must be greather than 0:");
        }
        if(index >= cursor){
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
    }
}
