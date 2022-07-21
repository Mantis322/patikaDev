import java.util.Arrays;

public class MyList<T> {
    private T[] list;


    public MyList(int capacity) {
        list = (T[]) new Object[capacity];


    }

    public MyList() {
        list = (T[]) new Object[10];
    }


    public int size() {
        int counter = 0;

        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    public int getCapacity() {
        return this.list.length;
    }

    public String toString() {
        T[] tempArray = (T[]) new Object[this.size()];
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i] != null) {
                tempArray[i] = this.list[i];
            }

        }
        return Arrays.toString(tempArray);
    }

    public void add(T member) {

        if (this.size() == this.getCapacity()) {

            T[] tempArray = (T[]) new Object[this.getCapacity() * 2];
            for (int i = 0; i < this.list.length; i++) {
                tempArray[i] = this.list[i];
            }
            this.list = tempArray;
        }
        this.list[this.size()] = member;

    }

    public T get(int i) {
        T e = (T) list[i];
        return e;
    }

    public void set(int index, T member) {
        this.list[index] = member;

    }

    public T remove(int index){
        if(index<0||index>=this.size()){
            return null;
        }
        for (int i = index;i<this.size()-1;i++){
            this.list[i] = this.list[i+1];
        }
        this.list[this.size()-1]= null;
        return this.list[index];
    }
    public void clear(){
        list = (T[]) new Object[10];
    }
    public int indexOf(T member){
        for (int i =0 ;i<this.size();i++){
            if (this.list[i].equals(member)){
                return i;
            }
        }
        return -1;
    }
    public boolean isEmpty(){
        return this.size() == 0;
    }

    public int lastIndexOf(T member){
        for (int i =this.size()-1 ;i>=0;i--){
            if (this.list[i].equals(member)){
                return i;
            }
        }
        return -1;
    }

    public T[] toArray(){
        T[] arr = (T[]) new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            arr[i] = this.get(i);

        }
        return arr;
    }

    public MyList<T> subList(int start,int finish){
        MyList<T> arr =  new MyList<>(finish-start);
        for (int i = start; i < finish; i++) {
            arr.add(this.list[i]);

        }
        return arr;
    }

    public boolean contains(T member){
        for (int i =0;i<this.size();i++){
            if (this.list[i].equals(member)){
                return true;
            }
        }
        return false;
    }

}
