package com.family.algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import lombok.Getter;
import lombok.Setter;

/**
 * 阿里在线面试：时长一个小时
 */
public class Areas {

    private AreaNode root;

    public static void main(String[] args) throws Exception {
        Areas node = new Areas();
        System.out.println(node.isValid("浙江省", "杭州市", "滨江区2"));
    }

    @Getter
    @Setter
    private class AreaNode implements Comparable<AreaNode> {
        private int seq;
        private String name;
        private Set<AreaNode> children;

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            AreaNode areaNode = (AreaNode) o;
            return seq == areaNode.seq;
        }

        @Override
        public int hashCode() {
            return Objects.hash(seq);
        }

        @Override
        public int compareTo(AreaNode o) {
            return Integer.compare(seq, o.getSeq());
        }

        public AreaNode(String str) {
            String[] pair = str.split(":");
            try {
                this.seq = Integer.parseInt(pair[0]);
            } catch (Exception e) {
                System.out.println(str);
                throw e;
            }

            this.name = pair[1];
        }

        public AreaNode(int seq, String name) {
            this.seq = seq;
            this.name = name;
        }

        public void addChild(AreaNode o) {
            if (children == null) {
                children = new TreeSet<>();
            }
            children.add(o);
        }

        public boolean containsChild(AreaNode o) {
            return this.children.contains(o);
        }

        public AreaNode getChild(String name) {
            for (AreaNode node : children) {
                if (Objects.equals(name, node.name)) {
                    return node;
                }
            }
            return null;
        }

    }

    public Areas() throws Exception {
        FileInputStream inputStream = new FileInputStream("/Users/chuyuancheng/Desktop/area.txt");
        InputStreamReader isReader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader reader = new BufferedReader(isReader);
        String str;
        AreaNode root = new AreaNode(1, "中国");
        Map<AreaNode, Set<AreaNode>> provinceMap = new HashMap<>();  //省;
        Map<AreaNode, Set<AreaNode>> cityMap = new HashMap<>();  //市;
        while ((str = reader.readLine()) != null) {
            String[] pair = str.split("-");
            AreaNode parent = new AreaNode(pair[0]);
            AreaNode child = new AreaNode(pair[1]);
            if (parent.name.endsWith("省")) {
                Set<AreaNode> children = provinceMap.computeIfAbsent(parent, t -> new TreeSet<>());
                children.add(child);
            } else {
                Set<AreaNode> children = cityMap.computeIfAbsent(parent, t -> new TreeSet<>());
                children.add(child);
            }
        }
        provinceMap.forEach((k, v) -> {
            k.setChildren(v);
            root.addChild(k);
        });
        cityMap.forEach((k, v) -> {
            boolean zhixia = true;
            k.setChildren(v);
            for (AreaNode province : root.getChildren()) {
                if (province.containsChild(k)) {
                    province.children.remove(k);
                    province.addChild(k);
                    zhixia = false;
                    break;
                }
            }
            if (zhixia) {
                root.addChild(k);
            }
        });
        this.root = root;
    }

    boolean isValid(String lv1, String lv2, String lv3) {
        AreaNode province = root.getChild(lv1);
        if (province != null) {
            AreaNode city = province.getChild(lv2);
            if (city != null) {
                if (city.children == null && lv3 == null) {
                    return true;
                }
                return city.getChild(lv3) != null;
            }
        }
        return false;
    }
}
