public class Loader {

    private static final double MAX_TEMP = 40.;
    private static final double MIN_TEMP = 32.;
    private static final double MAX_GOOD_TEMP = 36.9;
    private static final double MIN_GOOD_TEMP = 36.2;
    private static final int QUANTITY_TEMPERATURES = 30;

    public static void main(String[] args) {

        double[] temperatures = new double[QUANTITY_TEMPERATURES];
        double summ = 0;
        int countGoodTemp = 0;

        for (int i = 0; i < temperatures.length; i++){
            double d = Math.random() * (MAX_TEMP - MIN_TEMP) + MIN_TEMP;
            temperatures[i] = d;
            summ += d;

            if(d >= MIN_GOOD_TEMP && d <= MAX_GOOD_TEMP) {
                countGoodTemp++;
            }
        }

        System.out.printf("Средняя температура по больнице %.2f\n", summ / QUANTITY_TEMPERATURES);
        System.out.println("Количество здорових пациентов " + countGoodTemp);
    }
}
