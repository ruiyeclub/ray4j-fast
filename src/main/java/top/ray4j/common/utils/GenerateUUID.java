package top.ray4j.common.utils;

import java.util.UUID;

/**
 * @author raychen
 */
public class GenerateUUID {

    public static String get(String flag) {
        return flag + UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(get("In"));
    }

}