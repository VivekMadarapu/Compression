import java.util.Objects;

public class Entry implements Comparable
{
    public Character data;
    public int frequency;

    public Entry(Character data, int frequency)
    {
        this.data = data;
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return frequency == entry.frequency &&
                Objects.equals(data, entry.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, frequency);
    }

    @Override
    public int compareTo(Object o) {
        if(o == null){
            throw new NullPointerException();
        }
        else if(!o.getClass().equals(Entry.class)){
            throw new ClassCastException();
        }
        else if(((Entry) o).frequency < frequency){
            return 1;
        }
        else if(((Entry) o).frequency > frequency){
            return -1;
        }
        return 0;
    }
}