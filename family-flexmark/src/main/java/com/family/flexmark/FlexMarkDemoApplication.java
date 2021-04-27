package com.family.flexmark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.vladsch.flexmark.ast.Image;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
import com.vladsch.flexmark.util.data.MutableDataSet;

public class FlexMarkDemoApplication {
    private static String dirPath = "";
    public static File destFileDir;
    private static final String DEST_FILE_PARENT_PATH = "/Users/chuyuancheng/data/projects/freedom";

    public static void main(String[] args) throws Exception {
        //要发表的文章路径
        String file = "/Users/chuyuancheng/data/projects/blog/app/blog/concurrency/探秘synchronized.md";
        MutableDataSet options = new MutableDataSet();
        Parser parser = Parser.builder(options).build();
        String descFile = DEST_FILE_PARENT_PATH + StringUtils.substringAfterLast(file, "blog");
        dirPath = StringUtils.substringBeforeLast(file, "/");
        destFileDir = new File(StringUtils.substringBeforeLast(descFile, "/"));
        //noinspection ResultOfMethodCallIgnored
        destFileDir.mkdirs();
        FileUtils.copyFileToDirectory(new File(file), destFileDir);
        Node document = parser.parseReader(new FileReader(file));
        extractNode(document);
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(new String[]{"/bin/bash", "-c", "pwd;git status;git add -A;git commit -m 's';git push;"});
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;
        while ((line = buf.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("push finished");
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
