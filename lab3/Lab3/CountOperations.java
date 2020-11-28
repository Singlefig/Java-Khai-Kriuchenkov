import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CountOperations {

    private static double m;

    public static int countSignalRange(List<Integer> nums) {
        int minNum = nums.stream().min(Comparator.comparingInt(o -> o)).get();
        int maxNum = nums.stream().max(Comparator.comparingInt(o -> o)).get();
        return maxNum - minNum;
    }

    public static int countSignalEnergy(List<Integer> nums) {
        int e = nums.stream().reduce(0, (a, b) -> a + b * b);
        return e;
    }

    public static double countSignalPower(List<Integer> nums) {
        double p = (double) nums.stream().reduce(0, (a, b) -> a + b * b) / nums.size();
        return p;
    }

    public static double countSignalReadings(List<Integer> nums) {
        double sr = (double) nums.stream().reduce(0, Integer::sum) / nums.size();
        CountOperations.m = sr;
        return sr;
    }

    public static double countSignalReadingsVariance(List<Integer> nums) {
        CountOperations.countSignalReadings(nums);
        double srVars = nums.stream().mapToDouble(v -> v).reduce(0, CountOperations::add) / nums.size();
        return srVars;
    }

    private static double add(double a, double b) {
        return a + (b - m) * (b - m);
    }

    public static List<Double> countSignalAutoCorrFunc(List<Integer> nums) {
        List<Double> autoCorr = new ArrayList<>();
        double tmp;
        for (int t = 0; t <= 5; t++) {
            tmp = 0;
            for (int i = 0; i < nums.size() - t - 1; i++) {
                tmp += (nums.get(i + t) - m) * (nums.get(i) - m);
            }
            autoCorr.add(tmp / nums.size() - t);
        }
        return autoCorr;
    }

    public static double countCorrInterval(List<Integer> nums, List<Double> autoCorr) {
        double tValue;
        double a = 0;
        double b = 0;
        for (Double aDouble : autoCorr) {
            a += aDouble;
        }
        for (int i = 0, t = 0; i < nums.size() - t - 1; i++) {
            b += (nums.get(i + t) - m) * (nums.get(i) - m);
        }
        tValue = a / b;
        return tValue;
    }
}
