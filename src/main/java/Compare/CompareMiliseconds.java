package Compare;

public class CompareMiliseconds implements CompareTimeStamps {
    public boolean compareTimestamps(long a,long b, long dif) {
        boolean boolea  = false;
        if ((b-a)<= (dif*1000)) {
            boolea = true;
        }
        return boolea;
    }
}
