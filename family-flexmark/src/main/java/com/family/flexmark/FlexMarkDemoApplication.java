package com.family.flexmark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.vladsch.flexmark.ast.Image;
import com.vladsch.flexmark.formatter.Formatter;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.flexmark.util.sequence.BasedSequence;

/**
 * 需求：使用flexMark操作markdown，实现一键生产可以粘贴到博客的文章
 * flexMark地址：
 */
public class FlexMarkDemoApplication {
    private static String dirPath = "";
    private static File destFileDir;
    private static String IMAGE_FILE_URL_PREFIX = "https://cdn.jsdelivr.net/gh/chuliangcai/freedom";
    private static final String DEST_FILE_PARENT_PATH = "/Users/chuyuancheng/data/projects/freedom/";

    public static void main(String[] args) throws Exception {
        //要发表的文章路径
        String file = "/Users/chuyuancheng/data/projects/blog/app/blog/jvm/编译jdk和使用clion调试jdk博客版.md";
        MutableDataSet options = new MutableDataSet();
        Parser parser = Parser.builder(options).build();
        String descFile = DEST_FILE_PARENT_PATH + StringUtils.substringAfterLast(file, "blog");
        IMAGE_FILE_URL_PREFIX = StringUtils.substringBeforeLast(IMAGE_FILE_URL_PREFIX + StringUtils.substringAfterLast(file, "blog"), "/");
        dirPath = StringUtils.substringBeforeLast(file, "/");
        destFileDir = new File(StringUtils.substringBeforeLast(descFile, "/"));
        //noinspection ResultOfMethodCallIgnored
        destFileDir.mkdirs();
        FileUtils.copyFileToDirectory(new File(file), destFileDir);
        Node document = parser.parseReader(new FileReader(file));
        extractNode(document);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(LocalDateTime.now().format(formatter) + " copy finished");
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(new String[]{"/bin/bash", "-c", "cd " + DEST_FILE_PARENT_PATH + ";pwd;git status;git add -A;git commit -m 's';git push;"});
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;
        while ((line = buf.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println(LocalDateTime.now().format(formatter) + " push finished");
        Node replace = parser.parseReader(new FileReader(file));
        replaceUrl(replace);
        File outputFile = new File("/Users/chuyuancheng/Desktop/blog_source/" + StringUtils.substringAfterLast(file, "/"));
        Formatter mFormatter = new Formatter.Builder().build();
        FileUtils.write(outputFile, mFormatter.render(replace), Charset.defaultCharset());
        System.out.println(LocalDateTime.now().format(formatter) + " replace url finished");
    }

    public static void replaceUrl(Node node) throws Exception {
        if (!node.hasChildren()) {
            return;
        }
        ReversiblePeekingIterator<Node> iterator = node.getChildIterator();
        while (iterator.hasNext()) {
            Node node1 = iterator.next();
            if (node1 instanceof Image) {
                Image image = (Image) node1;
                String fileName = image.getUrl().toString();
                image.setPageRef(BasedSequence.of(IMAGE_FILE_URL_PREFIX + "/" + fileName));
            } else {
                replaceUrl(node1);
            }
        }
    }

    public static void extractNode(Node node) throws Exception {
        if (!node.hasChildren()) {
            return;
        }
        ReversiblePeekingIterator<Node> iterator = node.getChildIterator();
        while (iterator.hasNext()) {
            Node node1 = iterator.next();
            if (node1 instanceof Image) {
                Image image = (Image) node1;
                File imgFile = new File(dirPath + "/" + image.getUrl().toString());
                FileUtils.copyFileToDirectory(imgFile, destFileDir);
            } else {
                extractNode(node1);
            }
        }
    }
}
