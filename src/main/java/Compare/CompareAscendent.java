package Compare;

//De petit a gran
public class CompareAscendent implements Comparator {
    public boolean comparar(int num1, int num2) {
        boolean b = false;
        if (num1 > num2) {
            b = true;
        }
        return b;
    }
}
