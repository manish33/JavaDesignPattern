package Behavioral.Iterator;

public class NameRepository implements IteratorContainer {
    String[] name  = {"Manish","Rohit","Divyesh"};
    @Override
    public Iterator getIterator() {
        return new NamedIterator();
    }

    private class NamedIterator implements Iterator{
            int index;
        @Override
        public boolean hasNext() {
            if(index<name.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return name[index++];
            }
            return null;
        }
    }
}
