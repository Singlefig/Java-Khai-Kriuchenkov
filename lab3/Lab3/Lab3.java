import java.io.IOException;
import java.util.List;

public class Lab3 {
    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            List<Integer> nums = ReadBinFile.readFile(args[0]);

            double signalReadings = CountOperations.countSignalReadings(nums);
            double signalReadingsVariance = CountOperations.countSignalReadingsVariance(nums);
            List<Double> autoCorr = CountOperations.countSignalAutoCorrFunc(nums);
            double corrInterval = CountOperations.countCorrInterval(nums, autoCorr);
            double signalPower = CountOperations.countSignalPower(nums);
            int signalRange = CountOperations.countSignalRange(nums);
            int signalEnergy = CountOperations.countSignalEnergy(nums);

            System.out.println("Result of dynamic signal range: " + signalRange);
            System.out.println("Result of signal energy: " + signalEnergy);
            System.out.println("Result of average signal power: " + signalPower);
            System.out.println("Result of value of signal readings: " + signalReadings);
            System.out.println("Result of variance of signal readings: " + signalReadingsVariance);
            for (int i = 0; i < autoCorr.size(); i++) {
                System.out.println("Result of t = " + i + " : autocorrelation = " + autoCorr.get(i));
            }
            System.out.println("Result of correlation interval: " + corrInterval);
        } else {
            System.err.println("Wrong data");
        }
    }
}
