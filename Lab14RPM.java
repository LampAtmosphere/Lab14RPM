import java.io.*;

public class Lab14RPM {

    public static void main(String[] args) {
        try {
            File inputFile = new File("C:\\Users\\datch\\OneDrive\\Рабочий стол\\input.txt");
            File outputFile = new File("C:\\Users\\datch\\OneDrive\\Рабочий стол\\output.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            boolean inComment = false;

            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("/*")) {
                    inComment = true;
                }

                if (!inComment) {
                    int index = line.indexOf("//");
                    if (index != -1) {
                        line = line.substring(0, index);
                    }
                    writer.write(line + "\n");
                }

                if (line.trim().endsWith("*/")) {
                    inComment = false;
                }
            }

            reader.close();
            writer.close();

            System.out.println("Comments removed successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
