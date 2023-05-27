package com.laba.solvd.tool;

import com.laba.solvd.hospital.staff.Nurse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FileReader {
    private static final Logger logger = LogManager.getLogger(FileReader.class.getName());

    public static void fileReader() {
        String pathIn = "src/main/resources/sample.txt";
        logger.info("Input path has been initialized");
        String pathOut = "src/main/resources/result.txt";
        logger.info("Output path has been initialized");
        File inFile = new File(pathIn);
        logger.info("Input file has been initialized");
        File outFile = new File(pathOut);
        logger.info("Output path has been initialized");

        try (FileInputStream fis = new FileInputStream(inFile)) {
            logger.debug("FileInputStream opened");
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            logger.debug("InputStreamReader opened");
            BufferedReader br = new BufferedReader(isr);
            logger.debug("BufferedReader opened");

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
            logger.debug("BufferedReader closed");
            isr.close();
            logger.debug("InputStreamReader closed");
            logger.debug("FileInputStream closed");
        } catch (IOException e) {
            logger.warn("File not found or is unreadable...");
            System.out.println("File not found or is unreadable...");
        }
    }
}
