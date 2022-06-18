package com.family.lombok.construct;

import lombok.NonNull;

public class Demo2 {
    public void testLombok(@NonNull Object args){
        args.toString();
    }

    public static void main(String[] args) {
        new Demo2().testLombok(null);
    }
}
