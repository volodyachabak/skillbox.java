public class Loader {

    public static void main(String[] args) {

        String[] colors = {"Red", "Orange", "Yellow", "Green", "Cyan", "Blue", "Violet"};
        print(colors);

        for (int i = 0; i < colors.length / 2; i++) {
            String temp = colors[i];
            int lastIndex = colors.length - 1 - i;
            colors[i] = colors[lastIndex];
            colors[lastIndex] = temp;
        }

        System.out.println();
        print(colors);
    }

    private static void print(String[] colors){
        for (String color : colors) {
            System.out.print(color + " ");
        }
    }
}
