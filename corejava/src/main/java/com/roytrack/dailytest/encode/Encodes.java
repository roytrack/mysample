package com.roytrack.dailytest.encode;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;


/**
 * 封装各种格式的编码解码工具类.<br />
 *
 * 1.Commons-Codec的 hex/base64 编码<br />
 * 2.自行编写的，将long进行base62编码以缩短其长度 <br />
 * 3.Commons-Lang的xml/html escape<br />
 * 4.JDK提供的URLEncoder
 *
 */
public class Encodes {

    /** Logger for this class. */
    private static Log logger = LogFactory.getLog(Encodes.class);

    /** The Constant ALPHABET. */
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /** The Constant DEFAULT_URL_ENCODING. */
    private static final String DEFAULT_URL_ENCODING = "UTF-8";

    /**
     * Instantiates a new encodes.
     */
  public   Encodes() {
    }

    /**
     * Hex编码, byte[]->String.
     *
     * @param input
     *            the input
     * @return the string
     */
    public static String encodeHex(byte[] input) {
        return Hex.encodeHexString(input);
    }

    /**
     * Hex解码, String->byte[].
     *
     * @param input
     *            the input
     * @return the byte[]
     */
    public static byte[] decodeHex(String input) {
        try {
            return Hex.decodeHex(input.toCharArray());
        } catch (DecoderException e) {
            logger.error("decodeHex(String)", e);
            throw new IllegalStateException("Hex Decoder exception", e);
        }
    }

    /**
     * Base64编码, byte[]->String.
     *
     * @param input
     *            the input
     * @return the string
     */
    public static String encodeBase64(byte[] input) {
        return Base64.encodeBase64String(input);
    }

    /**
     * Base64编码, URL安全(将Base64中的URL非法字符'+'和'/'转为'-'和'_', 见RFC3548).
     *
     * @param input
     *            the input
     * @return the string
     */
    public static String encodeUrlSafeBase64(byte[] input) {
        return Base64.encodeBase64URLSafeString(input);
    }

    /**
     * Base64解码, String->byte[].
     *
     * @param input
     *            the input
     * @return the byte[]
     */
    public static byte[] decodeBase64(String input) {
        return Base64.decodeBase64(input);
    }

    /**
     * Base62(0_9A_Za_z)编码数字, long->String.
     *
     * @param num
     *            the num
     * @return the string
     */
    public static String encodeBase62(long num) {
        return alphabetEncode(num, 62);
    }

    /**
     * Base62(0_9A_Za_z)解码数字, String->long.
     *
     * @param str
     *            the str
     * @return the long
     */
    public static long decodeBase62(String str) {
        return alphabetDecode(str, 62);
    }

    /**
     * Alphabet encode.
     *
     * @param num
     *            the num
     * @param base
     *            the base
     * @return the string
     */
    private static String alphabetEncode(long num, int base) {
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        for (; num > 0; num /= base) {
            sb.append(ALPHABET.charAt((int) (num % base)));
        }

        return sb.toString();
    }

    /**
     * Alphabet decode.
     *
     * @param str
     *            the str
     * @param base
     *            the base
     * @return the long
     */
    private static long alphabetDecode(String str, int base) {
        Validate.notBlank(str);

        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            result += ALPHABET.indexOf(str.charAt(i)) * Math.pow(base, i);
        }

        return result;
    }

    /**
     * Html 转码.
     *
     * @param html
     *            the html
     * @return the string
     */
    public static String escapeHtml(String html) {
        return StringEscapeUtils.escapeHtml4(html);
    }

    /**
     * Html 解码.
     *
     * @param htmlEscaped
     *            the html escaped
     * @return the string
     */
    public static String unescapeHtml(String htmlEscaped) {
        return StringEscapeUtils.unescapeHtml4(htmlEscaped);
    }

    /**
     * Xml 转码.
     *
     * @param xml
     *            the xml
     * @return the string
     */
    public static String escapeXml(String xml) {
        return StringEscapeUtils.escapeXml(xml);
    }

    /**
     * Xml 解码.
     *
     * @param xmlEscaped
     *            the xml escaped
     * @return the string
     */
    public static String unescapeXml(String xmlEscaped) {
        return StringEscapeUtils.unescapeXml(xmlEscaped);
    }

    /**
     * Csv 转码.
     *
     * @param csv
     *            the csv
     * @return the string
     */
    public static String escapeCsv(String csv) {
        return StringEscapeUtils.escapeCsv(csv);
    }

    /**
     * Csv 解码.
     *
     * @param csvEscaped
     *            the csv escaped
     * @return the string
     */
    public static String unescapeCsv(String csvEscaped) {
        return StringEscapeUtils.unescapeCsv(csvEscaped);
    }

    /**
     * URL 编码, Encode默认为UTF-8.
     *
     * @param part
     *            the part
     * @return the string
     */
    public static String urlEncode(String part) {
        try {
            return URLEncoder.encode(part, DEFAULT_URL_ENCODING);
        } catch (UnsupportedEncodingException e) {
            logger.error("urlEncode(String)", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * URL 解码, Encode默认为UTF-8.
     *
     * @param part
     *            the part
     * @return the string
     */
    public static String urlDecode(String part) {
        try {
            return URLDecoder.decode(part, DEFAULT_URL_ENCODING);
        } catch (UnsupportedEncodingException e) {
            logger.error("urlDecode(String)", e);
            throw new RuntimeException(e);
        }
    }


    @Test
    public void base64Op(){
        String encodeStr="eyJ1c2VySWQiOjkwMzUxLCJ1c2VyTmFtZSI6InJ1YW5jaGFuZ21pbmdAbGV0di5jb20iLCJjbk5hbWUiOiLpmK7luLjpk60ifQ==";
        encodeStr=           "eyJ1c2VySWQiOjkwMzUxLCJ1c2VyTmFtZSI6InJ1YW5jaGFuZ21pbmdAbGV0di5jb20iLCJjbk5hbWUiOiLpmK7luLjpk60ifQ==";
        String decodeStr=new String (Encodes.decodeBase64(encodeStr));
        System.out.println(decodeStr);

    }

    @Test
    public void base64Encode(){
        String origin="v6i6xaO6vMW+stPXsrXU9C0tLS1xd2VyMjAxNi0tLS1saWh1aWFubnk1MjBAMTYzLmNvbS0tLS0xOTg2MDMwOQm/qLrFo7qy1MHCy767qMjvLS0tLXF3ZXIyMDE2LS0tLWxpbGVpaHVhaUAxNjMuY29tLS0tLTM3MDg5NTQ0NAm/qLrFo7q9wLexv8nG0NS9LS0tLXF3ZXIyMDE2LS0tLWxpanExMEAxNjMuY29tLS0tLUxpNzYxMDE2Cb+ousWjusqlMTQ1MTAwMTI0M7awLS0tLXF3ZXIyMDE2LS0tLWptdGFueWpAMTYzLmNvbS0tLS0xOTk4MTAwMgm/qLrFo7rKpTE0NTEwMDA2OTLNtS0tLS1xd2VyMjAxNi0tLS1qb3JkYW5kdW5nMTk4QDE2My5jb20tLS0tMTIzNDU2Cb+ousWjurjLz/PF8rza1fAtLS0tcXdlcjIwMTYtLS0tanJzeTEyMEAxNjMuY29tLS0tLTEzNTUyOTg0NjYwcQm/qLrFo7q4ycT9sKbC88u8u7MtLS0tcXdlcjIwMTYtLS0tanNsMzQxMkAxNjMuY29tLS0tLTMxMjQxMjIwNgm/qLrFo7qzo7LpyagtLS0tcXdlcjIwMTYtLS0tanRqd3d3d3d3d3d3QDE2My5jb20tLS0temhvdTEyMzQ1Ngm/qLrFo7rF7bbQyde1xsXtLS0tLXF3ZXIyMDE2LS0tLWp4eGZnZmxAMTYzLmNvbS0tLS1nZmwxOTg4MDQwMgm/qLrFo7rUxrP0ut0tLS0tcXdlcjIwMTYtLS0tankwMjEzMjUzMEAxNjMuY29tLS0tLXN0b25lYWdl";
        String encodes=new String (Encodes.encodeBase64(origin.getBytes()));
        encodes="v6i6xaO6vMW+stPXsrXU9C0tLS1xd2VyMjAxNi0tLS1saWh1aWFubnk1MjBAMTYzLmNvbS0tLS0xOTg2MDMwOQm/qLrFo7qy1MHCy767qMjvLS0tLXF3ZXIyMDE2LS0tLWxpbGVpaHVhaUAxNjMuY29tLS0tLTM3MDg5NTQ0NAm/qLrFo7q9wLexv8nG0NS9LS0tLXF3ZXIyMDE2LS0tLWxpanExMEAxNjMuY29tLS0tLUxpNzYxMDE2Cb+ousWjusqlMTQ1MTAwMTI0M7awLS0tLXF3ZXIyMDE2LS0tLWptdGFueWpAMTYzLmNvbS0tLS0xOTk4MTAwMgm/qLrFo7rKpTE0NTEwMDA2OTLNtS0tLS1xd2VyMjAxNi0tLS1qb3JkYW5kdW5nMTk4QDE2My5jb20tLS0tMTIzNDU2Cb+ousWjurjLz/PF8rza1fAtLS0tcXdlcjIwMTYtLS0tanJzeTEyMEAxNjMuY29tLS0tLTEzNTUyOTg0NjYwcQm/qLrFo7q4ycT9sKbC88u8u7MtLS0tcXdlcjIwMTYtLS0tanNsMzQxMkAxNjMuY29tLS0tLTMxMjQxMjIwNgm/qLrFo7qzo7LpyagtLS0tcXdlcjIwMTYtLS0tanRqd3d3d3d3d3d3QDE2My5jb20tLS0temhvdTEyMzQ1Ngm/qLrFo7rF7bbQyde1xsXtLS0tLXF3ZXIyMDE2LS0tLWp4eGZnZmxAMTYzLmNvbS0tLS1nZmwxOTg4MDQwMgm/qLrFo7rUxrP0ut0tLS0tcXdlcjIwMTYtLS0tankwMjEzMjUzMEAxNjMuY29tLS0tLXN0b25lYWdl";
        System.out.println(encodes);
        System.out.println("--------------------------");
        String result=new String(Encodes.decodeBase64(encodes));
        System.out.println(result);
        System.out.println("--------------------------");
    }


    @Test
    public void changeJDK(){
        System.out.println("Default Charset=" + Charset.defaultCharset());
        System.out.println("file.encoding=" + System.getProperty("file.encoding"));
        System.out.println("Default Charset=" + Charset.defaultCharset());
        System.out.println("Default Charset in Use=" + getDefaultCharSet());
    }

    private static String getDefaultCharSet() {
        OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
        String enc = writer.getEncoding();
        return enc;
    }
}
