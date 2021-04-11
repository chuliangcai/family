package com.family.jdk.regex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 需求：
 * 将markdown文章中![image-20210206113635544](image-20210206113635544.png)
 * 这种相对路径替换为
 * ![image-20210206113635544](https://cdn.jsdelivr.net/gh/chuliangcai/freedom/technology/other/image-20210206113635544.png)
 * 这样的完整路径
 * 技术点：java io, java regex
 */
public class RegexDemo {

    public static final String OUTPUT_PATH = "/Users/chuyuancheng/Desktop/AVL树实战.md";
    public static final Pattern PATTERN = Pattern.compile("!\\[[0-9a-zA-Z_.-]+]\\([0-9a-zA-Z_.-]+\\)");

    public static final Pattern PATTERN2 = Pattern.compile("src=\"[0-9a-zA-Z_.-]+\"");

    public static final String IMAGE_PATH_PREFIX = "https://cdn.jsdelivr.net/gh/chuliangcai/freedom/technology/algorithm/";

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("/Users/chuyuancheng/data/projects/freedom/technology/algorithm/AVL树实战.md");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUTPUT_PATH)));
        String str;
        while ((str = br.readLine()) != null) {
            Matcher matcher = PATTERN.matcher(str);
            Matcher matcher2 = PATTERN2.matcher(str);
            if (matcher.find()) {
                String image = matcher.group();
                String fileName = StringUtils.substringBetween(image, "(", ")");
                String replaced = str.replace(image, "![" + fileName + "](" + IMAGE_PATH_PREFIX + fileName + ")");
                bw.write(replaced + "\n");
            } else if (matcher2.find()) {
                String image = matcher2.group();
                String fileName = StringUtils.substringBetween(image, "\"", "\"");
                String replaced = str.replace(image, "scr=\"" + IMAGE_PATH_PREFIX + fileName + "\"");
                bw.write(replaced + "\n");
            } else {
                bw.write(str + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

}
