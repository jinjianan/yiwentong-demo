package com.yiwentong.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * 签名工具类
 */
public class SignatureUtil {


    private static final String SEPARATOR = "&";

    private static final String CONNECTOR = "=";

    private static final String SIGN_NAME = "signature";

    /**
     * 根据对象签名
     * @param secretKey
     * @param object
     * @return
     */
    public static String signByObj(String secretKey, Object object) {
        return signByObj(secretKey, object,null);
    }

    public static String signByObj(String secretKey, Object object ,String[] excludes){
        TreeMap<String, Object> map = new TreeMap<>();
        try {
            map = new TreeMap<>(DataParseUtil.beanToMap(object));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (map != null){
            return  signByMap(secretKey,map,excludes);
        }
        else return null;
    }

    /**
     * 根据MAP签名
     *
     * @param map
     * @return
     */
    public static String signByMap(String secretKey, TreeMap<String, Object> map) {
        return signByMap(secretKey, map,null);
    }

    public static String signByMap(String secretKey, TreeMap<String, Object> map , String[] excludes) {
        try {
            HashSet<String> excludesSet;
            if (excludes == null || excludes.length<=0){
                excludesSet = new HashSet<>();
            }
            else excludesSet = new HashSet<>(Arrays.asList(excludes));
            excludesSet.add(SIGN_NAME);
            StringBuffer sb = new StringBuffer();
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if (!excludesSet.contains(key)){
                    Object valueObj = map.get(key);
                    if (valueObj != null) {
                        sb.append(key+CONNECTOR+valueObj.toString()+SEPARATOR);
                    }
                }
            }
            String originSignText = sb.deleteCharAt(sb.length()-1).toString();
            System.out.println("签名元串"+originSignText);
            return AESUtil.encryptToBase64String(originSignText,secretKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据MAP验签
     * @param secretKey
     * @param originMap
     * @param originSignature
     * @return
     */
    public static boolean verifySignatureByMap(String secretKey, TreeMap<String, Object> originMap, String originSignature) {
        return verifySignatureByMap(secretKey, originMap, originSignature,null);
    }
    public static boolean verifySignatureByMap(String secretKey, TreeMap<String, Object> originMap, String originSignature,String[] excludes) {
        String signByOrgin = signByMap(secretKey,originMap,excludes);
        if (signByOrgin.equals(originSignature))
            return true;
        else return false;
    }

    /**
     * 根据对象验签
     * @param secretKey
     * @param originObj
     * @param originSignature
     * @return
     */
    public static boolean verifySignatureByObj(String secretKey,Object originObj,String originSignature) {
        return verifySignatureByObj(secretKey, originObj, originSignature,null);
    }

    public static boolean verifySignatureByObj(String secretKey,Object originObj,String originSignature,String[] excludes) {
        String signByOrgin = signByObj(secretKey,originObj,excludes);
        if (signByOrgin.equals(originSignature))
            return true;
        else return false;
    }

}
