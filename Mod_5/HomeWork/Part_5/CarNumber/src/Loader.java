import java.util.*;

public class Loader {

    private static List<String> numbersArrayList;
    private static Set<String> numbersHashSet;
    private static Set<String> numbersTreeSet;
    private static List<String> numbersSortedArrayList;

    static {
        numbersArrayList = generateNumbers();
        numbersHashSet = new HashSet<>(numbersArrayList);
        numbersTreeSet = new TreeSet<>(numbersArrayList);
        numbersSortedArrayList = new ArrayList<>(numbersArrayList);
        Collections.sort(numbersSortedArrayList);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Please input number [X000XX00]:");
            String number = scanner.nextLine();
            searchNumber(number);
        }
    }
    
    private static List<String> generateNumbers(){
        char[] allowedSymbols = {'A', 'B', 'C', 'E', 'H', 'K', 'M', 'O', 'P', 'T', 'Y', 'X'};
        int digitPartMin = 0;
        int digitPartMax = 9;
        int digitRegionMin = 1;
        int digitRegionMax = 199;
        List<String> numbers = new ArrayList<>();

        System.out.println("Compile start! Please wait.");
        long start = System.currentTimeMillis();

        for (char firstSymbol : allowedSymbols) {
            for (int numberPart = digitPartMin; numberPart <= digitPartMax; numberPart++) {
                for (char secondSymbol : allowedSymbols){
                    for (char thirdSymbol : allowedSymbols){
                        for (int regionPart = digitRegionMin; regionPart <= digitRegionMax; regionPart++) {
                            numbers.add(String.format("%1$c%2$d%2$d%2$d%3$c%4$c%5$02d", firstSymbol, numberPart, secondSymbol,thirdSymbol,regionPart));
                        }
                    }
                }
            }
        }
        System.out.println(String.format("List generated. Total items is: %1$d. (%2$fs)", numbers.size(), (System.currentTimeMillis() - start)/1_000.f));
        return numbers;
    }

    private static void searchNumber(String number){
        long start = System.nanoTime();
        System.out.println(String.format(Locale.US, "Поиск перебором в ArrayList: номер %sнайден, поиск занял(%fns)", (!numbersArrayList.contains(number))? "не ": "", (System.nanoTime() - start)/1_000f));
        start = System.nanoTime();
        System.out.println(String.format(Locale.US, "Бинарный поиск в ArrayList: номер %sнайден, поиск занял(%fns)", (!(Collections.binarySearch(numbersSortedArrayList, number) >= 0))? "не " : "", (System.nanoTime() - start)/1_000f));
        start = System.nanoTime();
        System.out.println(String.format(Locale.US, "Поиск в HashSet: номер %sнайден, поиск занял(%fns)", (!numbersHashSet.contains(number))? "не " : "", (System.nanoTime() - start)/1_000f));
        start = System.nanoTime();
        System.out.println(String.format(Locale.US, "Поиск в TreeSet: номер %sнайден, поиск занял(%fns)\n", (!numbersTreeSet.contains(number))? "не " : "", (System.nanoTime() - start)/1_000f));
    }
}


/*
* [X000XX00]
* */