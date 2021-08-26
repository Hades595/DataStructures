public class SampleKey<T> {
    private final String keyString;

    //Constructor
    public SampleKey(T keyString){
        this.keyString = keyString.toString();
    }

    public String getKeyString(){
        return this.keyString;
    }

    //Calculate the hashcode
    @Override
    public int hashCode() {
        //http://www.cse.yorku.ca/~oz/hash.html
        int hashCode = 0;

        //Direct hash + Getting a number we can manipulate
        //for (int i = 0; i < keyString.length(); i++){
        //    hashCode += Character.getNumericValue((keyString.charAt(i)));
        //}

        //Polynomial Rolling Hash
        //keyString[0]*31^(keyString.length-1) + keyString[1]*31^(keyString.length-2) + keyString[2]*31^(keyString.length-2)
        /*
        for (int j = 0; j < keyString.length(); j++){
          hashCode += Character.getNumericValue(keyString.charAt(j)) * Math.pow(31, (keyString.length() - j+1));
        }
         */

        //DjB2 hash
        /*
        long hash = 5381;
        for (int j = 0; j < keyString.length(); j++){
            hash = hash * 33;
            hash += Character.getNumericValue(keyString.charAt(j));
        }
        if ((int)hash < 0)
            return (int)Math.abs(hash);
        else
            return (int)hash;
         */



        //SBDM
        int hash = 0;
        int i = 0;

        for (i = 0; i < keyString.length(); i++)
        {
            hash = ((byte)Character.getNumericValue(keyString.charAt(i))) + (hash << 6) + (hash << 16) - hash;
        }

        if (hash < 0)
            return Math.abs(hash);
        else
            return hash;

        //return hashCode;
    }

    @Override
    public boolean equals(Object o){
        //If the object is null
        if(o == null)
            return false;

        //If the object is an instance of this
        if (o == this)
            return true;

        //If they are not the same class
        if (this.getClass() != o.getClass()){
            return false;
        }

        //If the object is this keyString
        SampleKey testKey = (SampleKey) o;
        return this.keyString.equals(testKey.keyString);
    }

}
