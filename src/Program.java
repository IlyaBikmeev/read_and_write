import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


/*
В файле input.txt будут лежать имя и фамилия какого-то человека. Записать в файл output.txt,
который должен лежать в папке result строку "Имя: <имя>; Фамилия: <фамилия>"
 */

public class Program {
    public static void main(String[] args) {
        //Чтение из файла

        //Старая Java
//        BufferedReader bufferedReader = null;
//        try {
//            bufferedReader = new BufferedReader(new FileReader("firhrhle.txt"));
//            String line = null;
//            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
//        catch(IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        finally {
//            try {
//                if(bufferedReader != null)
//                    bufferedReader.close();
//            }
//            catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }

        //После Java 8 (или 9)
        //try with resources

        String firstName = null;
        String lastName = null;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            String fullName = bufferedReader.readLine();
            String[] data = fullName.split(" ");
            firstName = data[0];
            lastName = data[1];
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        //Запись в файл
        try(PrintWriter writer = new PrintWriter("result/output.txt")) {
            writer.printf("Имя: %s\nФамилия: %s", firstName, lastName);
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
