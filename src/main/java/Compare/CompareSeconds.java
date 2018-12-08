package Compare;

public class CompareSeconds implements CompareTimeStamps {

    /**
     *
     * @param a
     * @param b
     * @param dif
     * @return
     */
    public boolean compareTimestamps(long a,long b,long dif) {
        boolean boolea  = false;
        if ((b-a) <= dif) {
            boolea = true;
        }
        return boolea;
    }
}
