public class SampleData <T>{
    //Data needed to store in the table
    private T data;
    private SampleKey<T> key;

    //Constructor
    public SampleData(T data){
        this.data = data;
        this.key = new SampleKey<>(data);
    }

    public SampleKey<T> getKey() {
        //Return the key
        return this.key;
    }


    @Override
    public String toString() {
        //So it doesn't display memory address
        return (String) this.data;
    }
}
