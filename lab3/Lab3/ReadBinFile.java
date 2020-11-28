import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ReadBinFile {

    public static List<Integer> readFile(String pathToFile) throws IOException {
        List<Integer> list = new ArrayList<>();
        FileInputStream fin = new FileInputStream(pathToFile);
        int num = fin.read();
        for (;;) {
            if (num != -1) {
                num = fin.read();
                list.add(num);
            } else {
                break;
            }
        }
        fin.close();
        return list;
    }
}
