import java.io.*;
import java.util.ArrayList;
import java.util.List;

    public class WorkWithFile implements Dictionary {

        public static File file = new File("E:\\Examples\\Library.txt");

        public List<String> read() {
            String line = null;
            List<String> result = new ArrayList<>();
            try (
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr)
            ) {
                while (br.ready()) {
                    line = br.readLine();
                    if (line != null) {
                        System.out.println(line);
                        result.add(line);
                    }
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        public void write(String wd) {
            BufferedWriter bf = null;
            try {
                bf = new BufferedWriter(new FileWriter(file, true));
                bf.write(wd);
                bf.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bf.close();
                } catch (Exception e){
                }
            }
        }
    }
