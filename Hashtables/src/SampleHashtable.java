public class SampleHashtable {
    //Create a table to store the data into
    private final SampleData[] table;
    //The capacity for the table
    private final int capacity;

    //Constructor
    public SampleHashtable(int size){
        //Initialise the table with the size
        this.capacity = size;
        table = new SampleData[this.capacity];
    }

    public void put(SampleData d) {
        SampleKey k = d.getKey();
        //Check if k and d are null
        if (k == null || d == null)
            return;

        //If the index at the table is empty
        if (table[k.hashCode() % capacity] == null) {
            //Put the data into the table
            table[k.hashCode() % capacity] = d;
        }
        else{
            //Else go through the table to find an open spot
            int index = k.hashCode() % capacity + 1;
            while(table[index] != null){
                //If we reached the end of the table
                if (index == table.length-1)
                    //Go to the start
                    index = 0;

                //if we loop and go back to the original index
                //Meaning we do not have space in the table
                if (index == k.hashCode() % capacity)
                    return;

                index++;
            }
            //Either we found a empty space or there is no space in the table

            if (table[index] == null){
                table[index] = d;
            }

        }
    }

    public SampleData get(SampleKey k) {
        //If the key is null
        if(k == null)
            return null;

        //Start of the index
        int index = k.hashCode() % capacity;
        //Get the data from the table
        if (table[index].getKey().equals(k))
            //Return the data
            return table[k.hashCode() % capacity];
        else{
            index++;
            //While we don't find it or we reach the end of the table
            while (!(table[index].getKey().equals(k))){

                //If we reached the end of the table
                if (index == table.length-1)
                    //Go to the start
                    index = 0;

                //if we loop and go back to the original index
                //Meaning we do not have it in the table
                if (index == k.hashCode() % capacity)
                    return null;

                //Increase the index
                index++;
            }
            if (table[index].getKey().equals(k))
                return table[index];
            else
                return null;
        }
    }

    public SampleData[] getTable(){
        return this.table;
    }
}
