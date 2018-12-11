package com.infoshareacademy.zajavka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Stateless
public class UnzipService {

    public static final String EXTRACTED_DATA_PATH = System.getProperty("java.io.tmpdir") + "/zajavka-data/extracted";
    private static final Logger LOG = LoggerFactory.getLogger(UnzipService.class);

    public void unzip(String file, String outputDir) {

        LOG.info("Trying to unzip {} to {}", file, outputDir);

        byte[] buffer = new byte[1024];

        try {
            File folder = new File(outputDir);

            if (folder.exists()) {
                deleteDir(folder);
            }
            if (!folder.exists()) {
                folder.mkdir();
            }
            ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
            ZipEntry ze = zis.getNextEntry();

            while (ze != null) {
                String fileName = ze.getName();
                File newFile = new File(outputDir + File.separator + fileName);
                LOG.info("Extracting {} to {}", fileName, newFile.getAbsolutePath());

                new File(newFile.getParent()).mkdirs();

                FileOutputStream fos = new FileOutputStream(newFile);

                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();

                LOG.info("Successfully extracted {} to {}", fileName, newFile.getAbsolutePath());

                ze = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();

            LOG.info("Successfully unzipped {} to {}", file, outputDir);

        } catch (IOException ex) {
            LOG.error("Error while unzipping {} to {}: {}", file, outputDir, ex.getMessage());
        }
    }
    private boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
