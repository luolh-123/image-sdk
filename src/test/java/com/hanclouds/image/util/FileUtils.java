package com.hanclouds.image.util;

import java.io.*;


/**
 * 文件操作工具类
 *
 * @author luolh
 * @version 1.0
 * @date 2019/3/7 10:10
 */
public class FileUtils {

    /**
     * 多次创建多级目录
     *
     * @param dirPath
     * @return
     */
    public static boolean mkdir(String dirPath) {
        String dir = "";
        String[] strs = dirPath.split("/");
        for (String str : strs) {
            if ("".equals(str)) {
                continue;
            }
            dir += "/" + str;
            File file = new File(dir);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        return true;
    }

    /**
     * 一次性创建多级目录
     *
     * @param dirPath
     * @return
     */
    public static boolean mkdirs(String dirPath) {
        if (StringUtils.isEmpty(dirPath)) {
            return false;
        }

        File file = new File(dirPath);
        if (!file.exists()) {
            return file.mkdirs();
        }

        return true;
    }

    /**
     * 将字节数据写入指定文件
     *
     * @param data
     * @param outPath
     * @throws IOException
     */
    public static void write(byte[] data, String outPath, String name)
            throws IOException {
        File file = new File(outPath);
        //没有目录创建目录
        if (!file.exists()) {
            if (!outPath.substring(outPath.length() - 1).contains(File.separator)) {
                outPath = outPath + File.separator;
            }
            mkdirs(outPath);
        }
        FileOutputStream fos = new FileOutputStream(outPath + File.separator + name);
        fos.write(data);
        fos.flush();
        fos.close();
    }

    /**
     * 将输入流写入指定文件中
     *
     * @param is
     * @param outPath
     * @throws IOException
     */
    public static void write(InputStream is, String outPath, String name) throws IOException {
        File file = new File(outPath);
        //没有目录创建目录
        if (!file.exists()) {
            if (outPath.lastIndexOf(File.separator) == -1) {
                outPath = outPath + File.separator;
            }
            mkdirs(outPath);
        }

        FileOutputStream fos = new FileOutputStream(outPath + File.separator + name);
        byte[] buff = new byte[1024];
        int length = 0;
        while ((length = is.read(buff)) != -1) {
            fos.write(buff, 0, length);
        }
        fos.flush();
        fos.close();
        is.close();
    }


    /**
     * 将字条串写入指定文件中
     *
     * @param content
     * @param filePath
     * @return
     */
    public static boolean write(String content, String filePath) {
        File file = new File(filePath);
        try {
            //没有目录创建目录
            if (!file.exists()) {
                String dir = filePath.substring(0, filePath.lastIndexOf(File.separator));
                mkdirs(dir);
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write(content);
            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String read(File file) {
        if (file == null) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                if (res.length() != 0) {
                    res.append("\n");
                }

                res.append(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res.toString();
    }

    /**
     * 检查文件后缀
     *
     * @param file
     * @param suffix
     * @return
     */
    public static boolean checkFileSuffix(File file, String suffix) {
        if (null == file) {
            return false;
        }

        String fileName = file.getName();
        if (fileName.contains(suffix)) {
            return true;
        }

        return false;
    }

    /**
     * 输入流转byte
     *
     * @param in
     * @return
     * @throws IOException
     */
    public static byte[] toBytes(InputStream in) throws IOException {
        byte[] buf = new byte[1024];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int len;
        while ((len = in.read(buf)) > -1) {
            out.write(buf, 0, len);
        }

        byte[] bytes = out.toByteArray();
        out.close();
        return bytes;
    }
}
