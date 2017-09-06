package com.rick.utils;

import java.security.MessageDigest;
/**
 * -------------------------------------------
 * Title : MD5Util 
 * Description : MD5加密算法
 * Create on : 2016年5月3日 上午9:53:42
 * Copyright (C) strongunion
 * @author RICK
 * 修改历史: 
 * 修改人 修改日期 修改描述
 * -------------------------------------------
 */
public class MD5Util {
	
	 // 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public MD5Util() {
    }

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    /**
     * TODO: 生成md5加密串
     * @Auhor: RICK
     * @Date : 2017年5月5日
     * @param strObj
     * @param charsetname 字符集
     * @return
     */
    public static String getMD5Code(String strObj, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            if (charsetname == null || "".equals(charsetname))
                resultString = byteToString(md.digest(resultString.getBytes()));
			else
				resultString = byteToString(md.digest(resultString.getBytes(charsetname)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultString;
    }
    public static String getMD5Code(String strObj) {
        return getMD5Code(strObj,"UTF-8");
    }

    public static void main(String[] args) {
        MD5Util getMD5 = new MD5Util();
        System.out.println(getMD5.getMD5Code("123456", "UTF-8"));
    }
}
