package com.infoshareacademy.zajavka.service;


import com.infoshareacademy.zajavka.data.ListDirectoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class GetFileNames {

    public static final String UPLOAD_PATH = System.getProperty("java.io.tmpdir") + "/zajavka-data";
    private static final Logger LOG = LoggerFactory.getLogger(GetFileNames.class);

    public List GetFileNames() throws ListDirectoryException {
        List<String> fileList = new ArrayList<>();

        LOG.info("Scanning directory");
        try (Stream<Path> filePathStream = Files.walk(Paths.get(UPLOAD_PATH))) {
            filePathStream.forEach(filePath -> {
                if (Files.isRegularFile(filePath) && filePath.toString().endsWith(".csv")) {
                    LOG.info("Found csv file: " + filePath.getFileName().toString());
                    fileList.add(filePath.getFileName().toString());
                } else {
                    LOG.info("Skipping file: " + filePath.getFileName().toString());
                }
            });
        } catch (IOException e) {
            LOG.error(e.getMessage());
            throw new ListDirectoryException(e.getMessage());
        }

        return fileList;
    }
}
