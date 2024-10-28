package com.company;

import java.util.Arrays;

/**
 * 将IP装为数字
 */
public class IPConvertInteger {

    public static void main(String[] args) {
        String ip_address = "120.1.1.45";
        Integer value = converIpToInteger(ip_address);
        System.out.println("ip数值为：" + value);


        String ip_String = converIntegerToIp(value);
        System.out.println("ip地址为：" + ip_String);

    }

    public static Integer converIpToInteger(String ip_address){
        String[] ip_arr = ip_address.split("\\.");
        System.out.println(Arrays.toString(ip_arr));
        Integer part_0 = Integer.parseInt(ip_arr[0]) << 3*8;
        Integer part_1 = Integer.parseInt(ip_arr[1]) << 2*8;
        Integer part_2 = Integer.parseInt(ip_arr[2]) << 8;
        Integer part_3 = Integer.parseInt(ip_arr[3]);

        Integer ip_value = part_0 + part_1 + part_2 + part_3;
        return ip_value;
    }

    public static String converIntegerToIp(Integer ip_value){
        String ip_binary = Integer.toBinaryString(ip_value);
        System.out.println(ip_binary);

        Integer part3 = Integer.parseInt(ip_binary.substring(ip_binary.length() - 8, ip_binary.length()), 2);
        Integer part2 = Integer.parseInt(ip_binary.substring(ip_binary.length() - 2*8, ip_binary.length() - 8), 2);
        Integer part1 = Integer.parseInt(ip_binary.substring(ip_binary.length() - 3*8, ip_binary.length() - 2*8), 2);
        Integer part0 =  Integer.parseInt(ip_binary.substring(0, ip_binary.length() - 3*8), 2);

        return part0 + "." + part1 + "." + part2 + "." + part3;
    }

}
