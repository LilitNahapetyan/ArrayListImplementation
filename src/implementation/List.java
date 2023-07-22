package implementation;
public interface List<E> {
    int size();

    boolean isEmpty();

    boolean add(E element);

    void add(int index, E element);

    E get(int index);

    E set(int index, E element);

    boolean remove(E element);

    E remove(int index);

    boolean contains(E element);

    int indexOf(E element);

    int lastIndexOf(E element);

    void clear();

    E[] toArray();

    <T> T[] toArray(T[] array);

    List<E> subList(int fromIndex, int toIndex);

    boolean removeAll(List<?> otherList);

    boolean retainAll(List<?> otherList);

    boolean containsAll(List<?> otherList);

    boolean addAll(List<? extends E> otherList);

    boolean addAll(int index, List<? extends E> otherList);

    boolean equals(Object obj);

    int hashCode();

    String toString();
}