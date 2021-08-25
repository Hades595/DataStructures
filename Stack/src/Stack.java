public class Stack<T>{
    //Create a array to store data into
    private final Object[] dataArray;
    //What is the current capacity
    private int currentArraySize = 0;

    public Stack(int max_size){
        dataArray = new Object[max_size]; //Assign max size
    }

    //Pop the first value of the stack
    public T pop(){
        //Get the data value
        T data = (T) dataArray[currentArraySize-1];
        //Remove the data value
        currentArraySize--;
        //Return the data
        return data;
    }

    //Add data to the stack
    public boolean push(T data){
        //Check if it is full
        if(currentArraySize < dataArray.length){
            //If there is space in the array
            dataArray[currentArraySize] = data;
            //Increase the capacity
            currentArraySize++;
            //return true if successful
            return true;
        }
        //return false if unsuccessful
        return false;
    }

    //Look at the first value of the stack
    public T peak(){
        return (T) dataArray[currentArraySize-1];
    }

    //Is the stack empty
    public boolean IsEmpty(){
        return currentArraySize == 0;
    }


}
