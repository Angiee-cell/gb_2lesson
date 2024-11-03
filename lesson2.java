import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class lesson2 {

    public static void main(String[] args) {
        
        writeFileNamesToNewFile(".", "lesson2.txt");

    }



    public static void writeFileNamesToNewFile(String out, String in) {

        String[] names = completeFileNames(out);

        FileWriter fw = null;
        try {
            fw = new FileWriter(in);

            for (String name : names) {
                fw.write(name + "\n");
            }
            fw.flush();

        } catch (IOException exception) {
            throw new RuntimeException("Запись не удалась " + exception.getMessage());
        }
        finally {
            try {
                fw.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            
        } 

    } 


    public static String[] completeFileNames(String path) {

            File file = new File(path);
            
            if (file.isFile()) {
                return new String[0];
            }

            File[] files = file.listFiles();

            String[] names = new String[files.length];

            for (int i = 0; i < files.length; i++) {
                names [i] = files[i].getName();
            }
            return names;
    }


}