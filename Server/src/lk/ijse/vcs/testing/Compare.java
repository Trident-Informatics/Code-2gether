/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vcs.testing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dilini Peiris
 */
public class Compare {

    public static void main(String[] args) {
        try {

            File changes = new File("src/lk/ijse/vcs/testing/changes.txt");
            changes.createNewFile();

            BufferedReader earlierFileBufRdr = new BufferedReader(new FileReader(new File("src/lk/ijse/vcs/testing/Demo1.java")));
            BufferedReader newFileBufRdr = new BufferedReader(new FileReader(new File("src/lk/ijse/vcs/testing/Demo2.java")));
            BufferedWriter resultFileBufWrtr = new BufferedWriter(new FileWriter(changes));

            LineNumberReader earlierLine = new LineNumberReader(earlierFileBufRdr);
            LineNumberReader newLine = new LineNumberReader(newFileBufRdr);

            loop1:
            while (true) {
                String lineLast = earlierFileBufRdr.readLine();  //line from the last commited file
                String lineNew = newFileBufRdr.readLine();      //line from the new file to be commited
                int lastLineNum = newLine.getLineNumber();
                if (lineLast != null || lineNew != null) {
                    if (lineLast.equals(lineNew)) {
                        resultFileBufWrtr.append("" + earlierLine.getLineNumber() + "\t\t" + lineLast);
                        resultFileBufWrtr.newLine();
                        continue loop1;
                    } else {
                        String lineNewCopy = lineNew;
                        int newLineNum = newLine.getLineNumber();
                        boolean isFound = false;
                        ArrayList<Integer> lineNumbers = new ArrayList<>();
                        loop2:
                        while (lineNewCopy != null) {
                            int newLineNumCopy = newLine.getLineNumber();
                            if (lineLast.equals(lineNewCopy)) {
                                System.out.println("newly added lines : " + lineNumbers.toString());
                                isFound = true;
                                break loop2;
                            } else {
                                lineNumbers.add(newLineNumCopy);
                                resultFileBufWrtr.append("" + newLineNumCopy + "\t+\t" + lineNewCopy);
                                resultFileBufWrtr.newLine();
                                lineNewCopy = newFileBufRdr.readLine();
                            }
                        }
                        if (!isFound) {
                            resultFileBufWrtr.append("" + lastLineNum + "\t-\t" + lineLast);
                            resultFileBufWrtr.newLine();
                            System.out.println("deleted line : " + lastLineNum);
                        }
                        newLine.setLineNumber(newLineNum);
                    }
                } else {
                    break loop1;
                }

            }
            earlierFileBufRdr.close();
            newFileBufRdr.close();
            resultFileBufWrtr.close();

        } catch (IOException ex) {
            Logger.getLogger(Compare.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
