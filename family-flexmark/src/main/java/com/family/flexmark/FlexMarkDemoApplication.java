package com.family.flexmark;

import java.io.File;
import java.io.FileReader;

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

    public static void main(String[] args) throws Exception {
        MutableDataSet options = new MutableDataSet();
        Parser parser = Parser.builder(options).build();
        String file = "/Users/chuyuancheng/data/projects/blog/app/blog/editor/markdown写微信公众号.md";
        String descFile = "/Users/chuyuancheng/data/projects/freedom/technology/other/markdown写微信公众号.md";
        dirPath = StringUtils.substringBeforeLast(file, "/");
        destFileDir = new File(StringUtils.substringBeforeLast(descFile, "/"));
        //noinspection ResultOfMethodCallIgnored
        destFileDir.mkdirs();
        FileUtils.copyFileToDirectory(new File(file), destFileDir);
        Node document = parser.parseReader(new FileReader(file));
        extractNode(document);
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
