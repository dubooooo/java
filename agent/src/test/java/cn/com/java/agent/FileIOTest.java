package cn.com.java.agent;

/**
 * @author dubooooo@126.com 2018-02-02
 */
class FileIOTest {

    public static void main(String[] args) {
        FileIO fileIO = new FileIO("F:/fxml.txt");
        fileIO.append("123");
        fileIO.append("456");
    }

}