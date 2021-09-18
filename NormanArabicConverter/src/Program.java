import java.util.Scanner;

public class Program {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String arabicNumber = sc.nextLine();
        NotationConverter notationConverter = new NotationConverter();
        try {
            System.out.println(notationConverter.toArabic(arabicNumber));
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
