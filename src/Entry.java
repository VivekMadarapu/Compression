import java.util.Objects;

public class Entry
{
    public Object data;
    public int frequency;

    public Entry(Object data, int frequency)
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
}