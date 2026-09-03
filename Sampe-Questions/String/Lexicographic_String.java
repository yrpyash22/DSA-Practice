package String;

public class Lexicographic_String {
    
    public static String compair_str(String fruits[])
    {
        String larger = fruits[0];
        for(int i = 1; i<fruits.length; i++)
        {
            if(larger.compareTo(fruits[i]) < 0)
            {
                larger = fruits[i];
            }
        }
        return larger;
    }

    public static void main(String[] args) {
        
        String fruits[] = {"apple", "banana", "mango"};
        System.out.print("Largest String: " + compair_str(fruits));
    }
}
