package com.laba.solvd.tool;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FileReader {
    public static void fileReader() {
        String pathIn = "src/main/resources/sample.txt";
        String pathOut = "src/main/resources/result.txt";
        File inFile = new File(pathIn);
        File outFile = new File(pathOut);

        try (FileInputStream fis = new FileInputStream(inFile)) {
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            String text = "";
            String line = br.readLine();
            while (line != null) {
                text = text.concat(line + " ");
                line = br.readLine();
            }

            text = StringUtils.lowerCase(text.replaceAll("\n", " ").replaceAll("\r", "").replaceAll("[^a-zA-Z']+", " "));
            List<String> words = Arrays.asList(text.split(" "));

            HashMap<String, Integer> uniqueWords = new HashMap<>();
            words.stream().forEach(word -> {
                uniqueWords.putIfAbsent(word, 0);
                uniqueWords.put(word, uniqueWords.get(word) + 1);
            });

            final String[] results = {"✦✦✦ UNIQUE WORD COUNT ✦✦✦\nNumber of unique words :: " + uniqueWords.size() + "\n\n"};
            uniqueWords.keySet().stream().forEach(key -> {
                results[0] = results[0].concat(key + " -> " + uniqueWords.get(key).toString() + "\n");
            });
            FileUtils.writeStringToFile(outFile, results[0], StandardCharsets.UTF_8, false);

            br.close();
            isr.close();
        } catch (IOException e) {
            System.out.println("File not found or is unreadable...");
        }
    }
}
