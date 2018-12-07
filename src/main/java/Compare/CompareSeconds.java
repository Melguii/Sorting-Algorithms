package Compare;

public class CompareSeconds implements CompareTimeStamps {
    public boolean compareTimestamps(long a,long b,long dif) {
        boolean boolea  = false;
        if ((b-a) <= dif) {
            boolea = true;
        }
        return boolea;
    }
}
