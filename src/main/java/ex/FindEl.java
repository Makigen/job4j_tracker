package ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        int index = 0;
        for (String element: value) {
            if(element.equals(key)) {
                rsl = index;
            } index++;
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = {"Alpha", "Beta", "Gamma"};
        String key = "Omega";
        try {
            indexOf(value, key);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
