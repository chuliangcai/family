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

    public static final String OUTPUT_PATH = "/Users/chuyuancheng/Desktop/markdown写微信公众号.md";
    public static final Pattern PATTERN = Pattern.compile("!\\[image-\\d{17}]\\(image-\\d{17}\\.png\\)");
    public static final String IMAGE_PATH_PREFIX = "https://cdn.jsdelivr.net/gh/chuliangcai/freedom/technology/other/";

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("/Users/chuyuancheng/data/projects/freedom/technology/other/markdown写微信公众号.md");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUTPUT_PATH)));
        String str;
        while ((str = br.readLine()) != null) {
            Matcher matcher = PATTERN.matcher(str);
            if (matcher.find()) {
                String image = matcher.group();
                String fileName = StringUtils.substringBetween(image, "(", ")");
                String replaced = str.replace(image, "![" + fileName + "](" + IMAGE_PATH_PREFIX + fileName + ")");
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
