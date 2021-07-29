public class Stack<T> {
    private final Object[] dataArray;
    private int maxSize;
    private int currentArraySize = 0;


    public Stack(int max_size){
        dataArray = new Object[max_size];
        maxSize = max_size;
    }

    public T pop(){
        T data = (T) dataArray[currentArraySize];
        currentArraySize--;
        return data;
    }

    public void push(T data){
        //Check if it is full
        if(currentArraySize <= maxSize){
            dataArray[currentArraySize] = data;
            currentArraySize++;
        }
    }

    public T peak(){
        return (T) dataArray[currentArraySize];
    }

    public boolean IsEmpty(){
        return currentArraySize == 0;
    }


}
