package com.mnr.date.convert;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Jiffy {

    private static final String S = "\\d";
    private static final String c = "[1-7]";
    private static final String yy = "\\d{2}";
    private static final String SSS = "\\d{3}";
    private static final String DDD = "\\d{3}";
    private static final String yyyy = "\\d{4}";
    private static final String G = "(?:AD|BC)";
    private static final String A = "(?:AM|PM)";
    private static final String mm = "[0-5][0-9]";
    private static final String ss = "[0-5][0-9]";
    private static final String M = "(?:[1-9]|1[0-2])";
    private static final String h = "(?:[1-9]|1[0-2])";
    private static final String MM = "(?:0[1-9]|1[0-2])";
    private static final String w = "(?:[1-9]|[1-5][0-3])";
    private static final String HH = "(?:[0-1][0-9]|2[0-4])";
    private static final String ALL_LANG_WORD = "[\\p{L}-]+";
    private static final String H = "(?:[0-9]|1[0-9]|2[0-4])";
    private static final String d = "(?:[1-9]|[1-2][0-9]|3[0-1])";
    private static final String dd = "(?:0[1-9]|[1-2][0-9]|3[0-1])";
    private static final String d_2 = "(?:[1-9]|[1-2][0-9]|3[0-1])\\.";
    private static final String VV = "\\[[A-Z]+[a-z]+/[A-Z]+[a-z]+\\]";
    private static final String XXX = "(?:\\+[0-1][0-4]|-[0-1][0-2]):00";
    private static final String Z = "(?:(?:\\+[0-1][0-4]|-[0-1][0-2])00|CET)";

    private static final String hh = HH;
    private static final String EEE = ALL_LANG_WORD;
    private static final String MMM = ALL_LANG_WORD;
    private static final String EEEE = ALL_LANG_WORD;
    private static final String MMMM = ALL_LANG_WORD;

    private static final String H_3_mm = H + ":" + mm;
    private static final String h_3_mm = h + ":" + mm;
    private static final String h_2_mm = h + "\\." + mm;
    private static final String H_2_mm = H + "\\." + mm;
    private static final String HH_3_mm = HH + ":" + mm;
    private static final String yyyyMMdd = yyyy + MM + dd;
    private static final String HH_2_mm = HH + "\\." + mm;
    private static final String hh_2_mm = hh + "\\." + mm;
    private static final String HH_3_mm_3 = HH_3_mm + ":";
    private static final String HH_3_mm_3_ss = HH_3_mm_3 + ss;
    private static final String H_3_mm_3_ss = H_3_mm + ":" + ss;
    private static final String h_2_mm_2_ss = h_2_mm + "\\." + ss;
    private static final String H_2_mm_2_ss = H_2_mm + "\\." + ss;
    private static final String HH_2_mm_2_ss = HH_2_mm + "\\." + ss;
    private static final String hh_2_mm_2_ss = hh_2_mm + "\\." + ss;
    private static final String M_4_d_4_yy = M + "/" + d + "/" + yy;
    private static final String M_1_d_1_yy = M + "-" + d + "-" + yy;
    private static final String d_1_M_1_yy = d + "-" + M + "-" + yy;
    private static final String yy_1_M_1_d = yy + "-" + M + "-" + d;
    private static final String h_3_mm_3_ss = h + ":" + mm + ":" + ss;
    private static final String d_4_MM_4_yy = d + "/" + MM + "/" + yy;
    private static final String dd_1_MM_1_yy = dd + "-" + MM + "-" + yy;
    private static final String dd_4_MM_4_yy = dd + "/" + MM + "/" + yy;
    private static final String d_4_M_4_yyyy = d + "/" + M + "/" + yyyy;
    private static final String d_2_M_2_yy = d + "\\." + M + "\\." + yy;
    private static final String d_2_M_2_yy_2 = d_2_M_2_yy + "\\.";
    private static final String d_MMM_yyyy = d + " " + MMM + " " + yyyy;
    private static final String MM_4_dd_4_yy = MM + "/" + dd + "/" + yy;
    private static final String M_1_d_1_yyyy = M + "-" + d + "-" + yyyy;
    private static final String MM_1_dd_1_yy = MM + "-" + dd + "-" + yy;
    private static final String MMM_d_yyyy = MMM + " " + d + " " + yyyy;
    private static final String yyyy_1_M_1_d = yyyy + "-" + M + "-" + d;
    private static final String yy_1_MM_1_dd = yy + "-" + MM + "-" + dd;
    private static final String M_4_d_4_yyyy = M + "/" + d + "/" + yyyy;
    private static final String yyyy_4_M_4_d = yyyy + "/" + M + "/" + d;
    private static final String yy_4_MM_4_dd = yy + "/" + MM + "/" + dd;
    private static final String yy_2_M_2_d = yy + "\\." + M + "\\." + d;
    private static final String yy_2_d_2_M = yy + "\\." + d + "\\." + M;
    private static final String d_2_MM_2_yy = d + "\\." + MM + "\\." + yy;
    private static final String dd_1_MMM_1_yy = dd + "-" + MMM + "-" + yy;
    private static final String dd_4_MMM_4_yy = dd + "/" + MMM + "/" + yy;
    private static final String d_MMMM_yyyy = d + " " + MMMM + " " + yyyy;
    private static final String CHyyyyMd = yyyy + "年" + M + "月" + d + "日";
    private static final String dd_4_MM_4_yyyy = dd + "/" + MM + "/" + yyyy;
    private static final String yyyy_1_MM_1_dd = yyyy + "-" + MM + "-" + dd;
    private static final String dd_1_MM_1_yyyy = dd + "-" + MM + "-" + yyyy;
    private static final String dd_2_MM_2_YY = dd + "\\." + MM + "\\." + yy;
    private static final String d_2_M_2_yyyy = d + "\\." + M + "\\." + yyyy;
    private static final String d_1_MMM_1_yyyy = d + "-" + MMM + "-" + yyyy;
    private static final String dd_MMMM_yyyy = dd + " " + MMMM + " " + yyyy;
    private static final String MM_1_dd_1_yyyy = MM + "-" + dd + "-" + yyyy;
    private static final String MMM_d_5__yyyy = MMM + " " + d + ", " + yyyy;
    private static final String MM_4_dd_4_yyyy = MM + "/" + dd + "/" + yyyy;
    private static final String yyyy_4_MM_4_dd = yyyy + "/" + MM + "/" + dd;
    private static final String d_4_MMM_4_yyyy = d + "/" + MMM + "/" + yyyy;
    private static final String yyyy_2_d_2_M = yyyy + "\\." + d + "\\." + M;
    private static final String d_2_MM_2_yyyy = d + "\\." + MM + "\\." + yyyy;
    private static final String dd_1_MMM_1_yyyy = dd + "-" + MMM + "-" + yyyy;
    private static final String MMMM_d_5__yyyy = MMMM + " " + d + ", " + yyyy;
    private static final String d_2__MMMM_yyyy = d_2 + " " + MMMM + " " + yyyy;
    private static final String dd_2_MM_2_yyyy = dd + "\\." + MM + "\\." + yyyy;
    private static final String yyyy_2_MM_2_dd = yyyy + "\\." + MM + "\\." + dd;
    private static final String dd_2_MM_2_yyyy_2 = dd_2_MM_2_yyyy + "\\.";
    private static final String yyyy_2_MM_2_dd_2 = yyyy_2_MM_2_dd + "\\.";
    private static final String MM_4_dd_4_yy_H_3_mm = MM_4_dd_4_yy + " " + H_3_mm;
    private static final String MMM_2_dd_2_yyyy = MMM + "\\." + dd + "\\." + yyyy;
    private static final String EEEE_d_MMMM_yyyy = EEEE + " " + d + " " + MMMM + " " + yyyy;
    private static final String EEEE_5__d_MMMM_yyyy = EEEE + ", " + d + " " + MMMM + " " + yyyy;
    private static final String yyyy_1_MM_1_ddTHH_3_mm_3_ss = yyyy_1_MM_1_dd + "T" + HH_3_mm_3_ss;
    private static final String yyyy_1_MM_1_ddTHH_3_mm_3_ssXXX = yyyy_1_MM_1_ddTHH_3_mm_3_ss + XXX;
    private static final String EEEE_5__MMMM_d_5__yyyy = EEEE + ", " + MMMM + " " + d + ", " + yyyy;
    private static final String dd_2_MM_2_yyyy_2__HH_2_mm_2_ss = dd_2_MM_2_yyyy_2 + " " + HH_2_mm_2_ss;
    private static final String yyyy_1_MM_1_ddTHH_3_mm_3_ss_2_SSS = yyyy_1_MM_1_ddTHH_3_mm_3_ss + "\\." + SSS;
    private static final String yyyy_1_MM_1_ddTHH_3_mm_3_ss_2_SSSXXX = yyyy_1_MM_1_ddTHH_3_mm_3_ss_2_SSS + XXX;
    private static final String EEEE_5__MMMM_d_5__yyyy_h_3_mm_3_ss = EEEE_5__MMMM_d_5__yyyy + " " + h_3_mm_3_ss;

    // LinkedHashMap to keep insertion order
    private static Map<Pattern, String> datePatternFormats = new LinkedHashMap<>();

    // Separators in constant name:
    // _ space
    // 1 -
    // 2 .
    // 3 :
    // 4 /
    // 5 ,

    // List of date/time formats: https://help.talend.com/reader/3zI67zZ9kaoTVCjNoXuEyw/YHc8JcQYJ7mWCehcQRTEIw
    static {
        datePatternFormats.put(pattern(d_2_M_2_yy), "d.M.yy");
        datePatternFormats.put(pattern(M_1_d_1_yy), "M-d-yy");
        datePatternFormats.put(pattern(yyyyMMdd), "yyyyMMdd");
        datePatternFormats.put(pattern(M_4_d_4_yy), "M/d/yy");
        datePatternFormats.put(pattern(yy_2_M_2_d), "yy.M.d");
        datePatternFormats.put(pattern(yy_2_d_2_M), "yy.d.M");
        datePatternFormats.put(pattern(d_1_M_1_yy), "d-M-yy");
        datePatternFormats.put(pattern(yy_1_M_1_d), "yy-M-d");
        datePatternFormats.put(pattern(d_2_MM_2_yy), "d.MM.yy");
        datePatternFormats.put(pattern(d_4_MM_4_yy), "d/MM/yy");
        datePatternFormats.put(pattern(d_2_M_2_yy_2), "d.M.yy.");
        datePatternFormats.put(pattern(d_2_M_2_yyyy), "d.M.yyyy");
        datePatternFormats.put(pattern(d_MMM_yyyy), "d MMM yyyy");
        datePatternFormats.put(pattern(dd_1_MM_1_yy), "dd-MM-yy");
        datePatternFormats.put(pattern(dd_2_MM_2_YY), "dd.MM.yy");
        datePatternFormats.put(pattern(M_1_d_1_yyyy), "M-d-yyyy");
        datePatternFormats.put(pattern(MM_1_dd_1_yy), "MM-dd-yy");
        datePatternFormats.put(pattern(MMM_d_yyyy), "MMM d yyyy");
        datePatternFormats.put(pattern(yyyy_1_M_1_d), "yyyy-M-d");
        datePatternFormats.put(pattern(yy_1_MM_1_dd), "yy-MM-dd");
        datePatternFormats.put(pattern(dd_4_MM_4_yy), "dd/MM/yy");
        datePatternFormats.put(pattern(d_4_M_4_yyyy), "d/M/yyyy");
        datePatternFormats.put(pattern(MM_4_dd_4_yy), "MM/dd/yy");
        datePatternFormats.put(pattern(M_4_d_4_yyyy), "M/d/yyyy");
        datePatternFormats.put(pattern(yyyy_4_M_4_d), "yyyy/M/d");
        datePatternFormats.put(pattern(yy_4_MM_4_dd), "yy/MM/dd");
        datePatternFormats.put(pattern(yyyy_2_d_2_M), "yyyy.d.M");
        datePatternFormats.put(pattern(yyyyMMdd + Z), "yyyyMMddz");
        datePatternFormats.put(pattern(d_2_MM_2_yyyy), "d.MM.yyyy");
        datePatternFormats.put(pattern(d_MMMM_yyyy), "d MMMM yyyy");
        datePatternFormats.put(pattern(d_1_MMM_1_yyyy), "d-MMM-yyyy");
        datePatternFormats.put(pattern(dd_1_MM_1_yyyy), "dd-MM-yyyy");
        datePatternFormats.put(pattern(dd_2_MM_2_yyyy), "dd.MM.yyyy");
        datePatternFormats.put(pattern(dd_MMMM_yyyy), "dd MMMM yyyy");
        datePatternFormats.put(pattern(MM_1_dd_1_yyyy), "MM-dd-yyyy");
        datePatternFormats.put(pattern(MMM_d_5__yyyy), "MMM d, yyyy");
        datePatternFormats.put(pattern(dd_4_MM_4_yyyy), "dd/MM/yyyy");
        datePatternFormats.put(pattern(MM_4_dd_4_yyyy), "MM/dd/yyyy");
        datePatternFormats.put(pattern(yyyy_4_MM_4_dd), "yyyy/MM/dd");
        datePatternFormats.put(pattern(yyyy_1_MM_1_dd), "yyyy-MM-dd");
        datePatternFormats.put(pattern(yyyy_2_MM_2_dd), "yyyy.MM.dd");
        datePatternFormats.put(pattern(CHyyyyMd), "yyyy'年'M'月'd'日'");
        datePatternFormats.put(pattern(d_2__MMMM_yyyy), "d. MMMM yyyy");
        datePatternFormats.put(pattern(dd_1_MMM_1_yyyy), "dd-MMM-yyyy");
        datePatternFormats.put(pattern(MMMM_d_5__yyyy), "MMMM d, yyyy");
        datePatternFormats.put(pattern(MMM_2_dd_2_yyyy), "MMM.dd.yyyy");
        datePatternFormats.put(pattern(dd_2_MM_2_yyyy_2), "dd.MM.yyyy.");
        datePatternFormats.put(pattern(yyyy + "W" + w + c), "yyyy'W'wD");
        datePatternFormats.put(pattern(yyyy_2_MM_2_dd_2), "yyyy.MM.dd.");
        datePatternFormats.put(pattern(MM_4_dd_4_yy_H_3_mm), "MM/dd/yy H:mm");
        datePatternFormats.put(pattern(EEEE_d_MMMM_yyyy), "EEEE d MMMM yyyy");
        datePatternFormats.put(pattern(yyyy + "-" + DDD + XXX), "yyyy-DDDXXX");
        datePatternFormats.put(pattern(yyyy_1_MM_1_dd + XXX), "yyyy-MM-ddXXX");
        datePatternFormats.put(pattern(d_2_M_2_yy + " " + H_2_mm), "d.M.yy H.mm");
        datePatternFormats.put(pattern(EEEE_5__d_MMMM_yyyy), "EEEE, d MMMM yyyy");
        datePatternFormats.put(pattern(M_1_d_1_yy + " " + H_3_mm), "M-d-yy H:mm");
        datePatternFormats.put(pattern(M_4_d_4_yy + " " + H_3_mm), "M/d/yy H:mm");
        datePatternFormats.put(pattern(yyyy + "-W" + w + "-" + c), "yyyy-'W'w-D");
        datePatternFormats.put(pattern(yyyy_1_MM_1_dd + " " + G), "yyyy-MM-dd G");
        datePatternFormats.put(pattern(d_2_M_2_yy + " " + H_3_mm), "d.M.yy H:mm");
        datePatternFormats.put(pattern(yy + "\\. " + M + "\\. " + d), "yy. M. d");
        datePatternFormats.put(pattern(d_1_M_1_yy + " " + H_3_mm), "d-M-yy H:mm");
        datePatternFormats.put(pattern(d_2_MM_2_yy + " " + H_3_mm), "d.MM.yy H:mm");
        datePatternFormats.put(pattern(M_1_d_1_yy + " " + HH_3_mm), "M-d-yy HH:mm");
        datePatternFormats.put(pattern(MMMM + " " + d + " " + yyyy), "MMMM d yyyy");
        datePatternFormats.put(pattern(M_4_d_4_yy + " " + HH_3_mm), "M/d/yy HH:mm");
        datePatternFormats.put(pattern(d_4_MM_4_yy + " " + H_3_mm), "d/MM/yy H:mm");
        datePatternFormats.put(pattern(d_2_M_2_yy + " " + HH_3_mm), "d.M.yy HH:mm");
        datePatternFormats.put(pattern(yy_2_M_2_d + " " + HH_2_mm), "yy.M.d HH.mm");
        datePatternFormats.put(pattern(yy_2_d_2_M + " " + HH_3_mm), "yy.d.M HH:mm");
        datePatternFormats.put(pattern(d_2_M_2_yyyy + " " + H_3_mm), "d.M.yyyy H:mm");
        datePatternFormats.put(pattern(dd_2_MM_2_YY + " " + H_3_mm), "dd.MM.yy H:mm");
        datePatternFormats.put(pattern(dd_4_MM_4_yy + " " + H_2_mm), "dd/MM/yy H.mm");
        datePatternFormats.put(pattern(EEEE_5__MMMM_d_5__yyyy), "EEEE, MMMM d, yyyy");
        datePatternFormats.put(pattern(M_1_d_1_yyyy + " " + H_3_mm), "M-d-yyyy H:mm");
        datePatternFormats.put(pattern(MM_1_dd_1_yy + " " + H_3_mm), "MM-dd-yy H:mm");
        datePatternFormats.put(pattern(yyyy_1_M_1_d + " " + H_3_mm), "yyyy-M-d H:mm");
        datePatternFormats.put(pattern(d_4_M_4_yyyy + " " + H_3_mm), "d/M/yyyy H:mm");
        datePatternFormats.put(pattern(M_4_d_4_yyyy + " " + H_3_mm), "M/d/yyyy H:mm");
        datePatternFormats.put(pattern(yy_4_MM_4_dd + " " + H_3_mm), "yy/MM/dd H:mm");
        datePatternFormats.put(pattern(yyyy + "\\. " + M + "\\. " + d), "yyyy. M. d");
        datePatternFormats.put(pattern(d_2_M_2_yy_2 + " " + HH_2_mm), "d.M.yy. HH.mm");
        datePatternFormats.put(pattern(yy_1_M_1_d + " " + A + h_3_mm), "yy-M-d ah:mm");
        datePatternFormats.put(pattern(d_2_M_2_yyyy + " " + HH_3_mm), "d.M.yyyy HH:mm");
        datePatternFormats.put(pattern(dd_1_MM_1_yy + " " + HH_3_mm), "dd-MM-yy HH:mm");
        datePatternFormats.put(pattern(dd_2_MM_2_YY + " " + HH_3_mm), "dd.MM.yy HH:mm");
        datePatternFormats.put(pattern(dd_4_MM_4_yy + " " + HH_3_mm), "dd/MM/yy HH:mm");
        datePatternFormats.put(pattern(M_1_d_1_yyyy + " " + HH_3_mm), "M-d-yyyy HH:mm");
        datePatternFormats.put(pattern(MM_1_dd_1_yy + " " + HH_3_mm), "MM-dd-yy HH:mm");
        datePatternFormats.put(pattern(yyyy_1_M_1_d + " " + HH_3_mm), "yyyy-M-d HH:mm");
        datePatternFormats.put(pattern(yy_1_MM_1_dd + " " + HH_3_mm), "yy-MM-dd HH:mm");
        datePatternFormats.put(pattern(d_4_M_4_yyyy + " " + HH_3_mm), "d/M/yyyy HH:mm");
        datePatternFormats.put(pattern(M_4_d_4_yyyy + " " + HH_3_mm), "M/d/yyyy HH:mm");
        datePatternFormats.put(pattern(yy_4_MM_4_dd + " " + HH_3_mm), "yy/MM/dd HH:mm");
        datePatternFormats.put(pattern(HH_3_mm + " " + dd_4_MM_4_yy), "HH:mm dd/MM/yy");
        datePatternFormats.put(pattern(MM_4_dd_4_yy + " " + HH_3_mm), "MM/dd/yy HH:mm");
        datePatternFormats.put(pattern(CHyyyyMd + " " + EEEE), "yyyy'年'M'月'd'日' EEEE");
        datePatternFormats.put(pattern(dd_1_MM_1_yyyy + " " + H_3_mm), "dd-MM-yyyy H:mm");
        datePatternFormats.put(pattern(M_1_d_1_yy + " " + H_3_mm_3_ss), "M-d-yy H:mm:ss");
        datePatternFormats.put(pattern(MM_1_dd_1_yyyy + " " + H_3_mm), "MM-dd-yyyy H:mm");
        datePatternFormats.put(pattern(MM_4_dd_4_yy_H_3_mm + " " + A), "MM/dd/yy h:mm a");
        datePatternFormats.put(pattern(yyyy_1_MM_1_dd + " " + H_3_mm), "yyyy-MM-dd H:mm");
        datePatternFormats.put(pattern(dd_4_MM_4_yyyy + " " + H_3_mm), "dd/MM/yyyy H:mm");
        datePatternFormats.put(pattern(MM_4_dd_4_yyyy + " " + H_3_mm), "MM/dd/yyyy H:mm");
        datePatternFormats.put(pattern(M_4_d_4_yy + " " + H_3_mm_3_ss), "M/d/yy H:mm:ss");
        datePatternFormats.put(pattern(yyyy_4_MM_4_dd + " " + H_3_mm), "yyyy/MM/dd H:mm");
        datePatternFormats.put(pattern(d_2_M_2_yyyy + " " + HH_3_mm_3), "d.M.yyyy HH:mm:");
        datePatternFormats.put(pattern(dd_1_MM_1_yyyy + " " + HH_3_mm), "dd-MM-yyyy HH:mm");
        datePatternFormats.put(pattern(dd_2_MM_2_yyyy + " " + HH_3_mm), "dd.MM.yyyy HH:mm");
        datePatternFormats.put(pattern(EEEE + ", " + d_2__MMMM_yyyy), "EEEE, d. MMMM yyyy");
        datePatternFormats.put(pattern(M_1_d_1_yy + " " + HH_3_mm_3_ss), "M-d-yy HH:mm:ss");
        datePatternFormats.put(pattern(MM_1_dd_1_yyyy + " " + HH_3_mm), "MM-dd-yyyy HH:mm");
        datePatternFormats.put(pattern(dd_4_MM_4_yyyy + " " + HH_3_mm), "dd/MM/yyyy HH:mm");
        datePatternFormats.put(pattern(MM_4_dd_4_yyyy + " " + HH_3_mm), "MM/dd/yyyy HH:mm");
        datePatternFormats.put(pattern(M_4_d_4_yy + " " + HH_3_mm_3_ss), "M/d/yy HH:mm:ss");
        datePatternFormats.put(pattern(yyyy_2_MM_2_dd + " " + HH_3_mm), "yyyy.MM.dd HH:mm");
        datePatternFormats.put(pattern(HH_3_mm + " " + dd_4_MM_4_yyyy), "HH:mm dd/MM/yyyy");
        datePatternFormats.put(pattern(yyyy_2_MM_2_dd_2 + " " + H_3_mm), "yyyy.MM.dd. H:mm");
        datePatternFormats.put(pattern(d_2_M_2_yyyy + " " + H_2_mm_2_ss), "d.M.yyyy H.mm.ss");
        datePatternFormats.put(pattern(d_2_M_2_yyyy + " " + H_3_mm_3_ss), "d.M.yyyy H:mm:ss");
        datePatternFormats.put(pattern(M_1_d_1_yy + " " + h_3_mm + " " + A), "M-d-yy h:mm a");
        datePatternFormats.put(pattern(M_1_d_1_yyyy + " " + H_3_mm_3_ss), "M-d-yyyy H:mm:ss");
        datePatternFormats.put(pattern(M_4_d_4_yy + " " + h_3_mm + " " + A), "M/d/yy h:mm a");
        datePatternFormats.put(pattern(MM_1_dd_1_yy + " " + H_3_mm_3_ss), "MM-dd-yy H:mm:ss");
        datePatternFormats.put(pattern(yyyy_1_MM_1_ddTHH_3_mm_3_ss), "yyyy-MM-dd'T'HH:mm:ss");
        datePatternFormats.put(pattern(MM_4_dd_4_yy + " " + H_3_mm_3_ss), "MM/dd/yy H:mm:ss");
        datePatternFormats.put(pattern(yy_4_MM_4_dd + " " + H_3_mm_3_ss), "yy/MM/dd H:mm:ss");
        datePatternFormats.put(pattern(yyyy_1_M_1_d + " " + H_3_mm_3_ss), "yyyy-M-d H:mm:ss");
        datePatternFormats.put(pattern(d_2_M_2_yyyy + " " + HH_3_mm_3_ss), "d.M.yyyy HH:mm:ss");
        datePatternFormats.put(pattern(d_2_MM_2_yyyy + " " + H_3_mm_3_ss), "d.MM.yyyy H:mm:ss");
        datePatternFormats.put(pattern(d_MMM_yyyy + " " + HH_3_mm_3_ss), "d MMM yyyy HH:mm:ss");
        datePatternFormats.put(pattern(dd_2_MM_2_YY + " " + HH_3_mm_3_ss), "dd.MM.yy HH:mm:ss");
        datePatternFormats.put(pattern(dd_2_MM_2_yyyy_2__HH_2_mm_2_ss), "dd.MM.yyyy. HH.mm.ss");
        datePatternFormats.put(pattern(dd_4_MM_4_yy + " " + HH_3_mm_3_ss), "dd/MM/yy HH:mm:ss");
        datePatternFormats.put(pattern(M_1_d_1_yyyy + " " + HH_3_mm_3_ss), "M-d-yyyy HH:mm:ss");
        datePatternFormats.put(pattern(MM_1_dd_1_yy + " " + HH_3_mm_3_ss), "MM-dd-yy HH:mm:ss");
        datePatternFormats.put(pattern(d_4_M_4_yyyy + " " + HH_3_mm_3_ss), "d/M/yyyy HH:mm:ss");
        datePatternFormats.put(pattern(MM_4_dd_4_yy + " " + HH_3_mm_3_ss), "MM/dd/yy HH:mm:ss");
        datePatternFormats.put(pattern(M_4_d_4_yyyy + " " + HH_3_mm_3_ss), "M/d/yyyy HH:mm:ss");
        datePatternFormats.put(pattern(yyyy_2_d_2_M + " " + HH_3_mm_3_ss), "yyyy.d.M HH:mm:ss");
        datePatternFormats.put(pattern(yyyy_1_M_1_d + " " + HH_3_mm_3_ss), "yyyy-M-d HH:mm:ss");
        datePatternFormats.put(pattern(dd_4_MM_4_yy + " " + h_3_mm + " " + A), "dd/MM/yy h:mm a");
        datePatternFormats.put(pattern(d_1_MMM_1_yyyy + " " + H_2_mm_2_ss), "d-MMM-yyyy H.mm.ss");
        datePatternFormats.put(pattern(dd_2_MM_2_yyyy + " " + H_3_mm_3_ss), "dd.MM.yyyy H:mm:ss");
        datePatternFormats.put(pattern(M_1_d_1_yyyy + " " + h_3_mm + " " + A), "M-d-yyyy h:mm a");
        datePatternFormats.put(pattern(MM_1_dd_1_yy + " " + h_3_mm + " " + A), "MM-dd-yy h:mm a");
        datePatternFormats.put(pattern(MM_1_dd_1_yyyy + " " + H_3_mm_3_ss), "MM-dd-yyyy H:mm:ss");
        datePatternFormats.put(pattern(yyyy_1_MM_1_dd + " " + H_3_mm_3_ss), "yyyy-MM-dd H:mm:ss");
        datePatternFormats.put(pattern(yyyy_1_M_1_d + " " + h_3_mm + " " + A), "yyyy-M-d h:mm a");
        datePatternFormats.put(pattern(d_4_M_4_yyyy + " " + h_3_mm + " " + A), "d/M/yyyy h:mm a");
        datePatternFormats.put(pattern(M_4_d_4_yyyy + " " + h_3_mm + " " + A), "M/d/yyyy h:mm a");
        datePatternFormats.put(pattern(dd_1_MM_1_yyyy + " " + HH_3_mm_3_ss), "dd-MM-yyyy HH:mm:ss");
        datePatternFormats.put(pattern(dd_2_MM_2_yyyy + " " + HH_3_mm_3_ss), "dd.MM.yyyy HH:mm:ss");
        datePatternFormats.put(pattern(MM_1_dd_1_yyyy + " " + HH_3_mm_3_ss), "MM-dd-yyyy HH:mm:ss");
        datePatternFormats.put(pattern(yyyy_1_MM_1_ddTHH_3_mm_3_ssXXX), "yyyy-MM-dd'T'HH:mm:ssXXX");
        datePatternFormats.put(pattern(yyyy_1_MM_1_dd + " " + HH_3_mm_3_ss), "yyyy-MM-dd HH:mm:ss");
        datePatternFormats.put(pattern(yyyy_1_MM_1_dd + " " + HH_2_mm_2_ss), "yyyy-MM-dd HH.mm.ss");
        datePatternFormats.put(pattern(dd_4_MM_4_yyyy + " " + HH_3_mm_3_ss), "dd/MM/yyyy HH:mm:ss");
        datePatternFormats.put(pattern(MM_4_dd_4_yyyy + " " + HH_3_mm_3_ss), "MM/dd/yyyy HH:mm:ss");
        datePatternFormats.put(pattern(dd_4_MMM_4_yy + " " + h_3_mm + " " + A), "dd/MMM/yy h:mm a");
        datePatternFormats.put(pattern(yyyy_2_MM_2_dd + " " + HH_3_mm_3_ss), "yyyy.MM.dd HH:mm:ss");
        datePatternFormats.put(pattern(HH_3_mm_3_ss + " " + dd_4_MM_4_yyyy), "HH:mm:ss dd/MM/yyyy");
        datePatternFormats.put(pattern(HH_3_mm_3_ss + " " + dd_1_MM_1_yyyy), "HH:mm:ss dd-MM-yyyy");
        datePatternFormats.put(pattern(yyyy_2_MM_2_dd_2 + " " + H_3_mm_3_ss), "yyyy.MM.dd. H:mm:ss");
        datePatternFormats.put(pattern(dd_1_MMM_1_yyyy + " " + HH_3_mm_3_ss), "dd-MMM-yyyy HH:mm:ss");
        datePatternFormats.put(pattern(M_1_d_1_yy + " " + h_3_mm_3_ss + " " + A), "M-d-yy h:mm:ss a");
        datePatternFormats.put(pattern(MM_1_dd_1_yyyy + " " + h_3_mm + " " + A), "MM-dd-yyyy h:mm a");
        datePatternFormats.put(pattern(yyyy_1_MM_1_dd + " " + h_2_mm + "\\." + A), "yy-MM-dd h.mm.a");
        datePatternFormats.put(pattern(yyyy_1_MM_1_dd + " " + h_3_mm + " " + A), "yyyy-MM-dd h:mm a");
        datePatternFormats.put(pattern(dd_4_MM_4_yyyy + " " + h_3_mm + " " + A), "dd/MM/yyyy h:mm a");
        datePatternFormats.put(pattern(MM_4_dd_4_yyyy + " " + h_3_mm + " " + A), "MM/dd/yyyy h:mm a");
        datePatternFormats.put(pattern(M_4_d_4_yy + " " + h_3_mm_3_ss + " " + A), "M/d/yy h:mm:ss a");
        datePatternFormats.put(pattern(yyyy_1_MM_1_ddTHH_3_mm_3_ss_2_SSS), "yyyy-MM-dd'T'HH:mm:ss.SSS");
        datePatternFormats.put(pattern(M_1_d_1_yyyy + " " + h_3_mm_3_ss + " " + A), "M-d-yyyy h:mm:ss a");
        datePatternFormats.put(pattern(MM_1_dd_1_yy + " " + h_3_mm_3_ss + " " + A), "MM-dd-yy h:mm:ss a");
        datePatternFormats.put(pattern(d_4_M_4_yyyy + " " + h_3_mm_3_ss + " " + A), "d/M/yyyy h:mm:ss a");
        datePatternFormats.put(pattern(MM_4_dd_4_yy + " " + h_3_mm_3_ss + " " + A), "MM/dd/yy h:mm:ss a");
        datePatternFormats.put(pattern(M_4_d_4_yyyy + " " + h_3_mm_3_ss + " " + A), "M/d/yyyy h:mm:ss a");
        datePatternFormats.put(pattern(yyyy_1_M_1_d + " " + h_3_mm_3_ss + " " + A), "yyyy-M-d h:mm:ss a");
        datePatternFormats.put(pattern(d_MMM_yyyy + " " + HH_3_mm_3_ss + " " + Z), "d MMM yyyy HH:mm:ss z");
        datePatternFormats.put(pattern(d_MMMM_yyyy + " " + H_2_mm_2_ss + " " + Z), "d MMMM yyyy H.mm.ss z");
        datePatternFormats.put(pattern(dd_2_MM_2_yyyy_2__HH_2_mm_2_ss + " " + Z), "dd.MM.yyyy. HH.mm.ss z");
        datePatternFormats.put(pattern(dd_4_MM_4_yyyy + " " + h_3_mm_3_ss + " " + A), "dd/MM/yyyy h:mm:ss a");
        datePatternFormats.put(pattern(d_1_MMM_1_yyyy + " " + h_3_mm_3_ss + " " + A), "d-MMM-yyyy h:mm:ss a");
        datePatternFormats.put(pattern(d_MMMM_yyyy + " " + HH_3_mm_3_ss + " " + Z), "d MMMM yyyy HH:mm:ss z");
        datePatternFormats.put(pattern(MM_1_dd_1_yyyy + " " + h_3_mm_3_ss + " " + A), "MM-dd-yyyy h:mm:ss a");
        datePatternFormats.put(pattern(MMM_d_5__yyyy + " " + h_3_mm_3_ss + " " + A), "MMM d, yyyy h:mm:ss a");
        datePatternFormats.put(pattern(yyyy_1_MM_1_ddTHH_3_mm_3_ss_2_SSSXXX), "yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        datePatternFormats.put(pattern(yyyy_1_MM_1_dd + " " + h_3_mm_3_ss + " " + A), "yyyy-MM-dd h:mm:ss a");
        datePatternFormats.put(pattern(MM_4_dd_4_yyyy + " " + h_3_mm_3_ss + " " + A), "MM/dd/yyyy h:mm:ss a");
        datePatternFormats.put(pattern(d_4_MMM_4_yyyy + " " + H_3_mm_3_ss + " " + Z), "d/MMM/yyyy H:mm:ss z");
        datePatternFormats.put(pattern(dd_MMMM_yyyy + " " + HH_3_mm_3_ss + " " + Z), "dd MMMM yyyy HH:mm:ss z");
        datePatternFormats.put(pattern(yyyy_1_MM_1_dd + " " + h_3_mm_3_ss + "\\." + A), "yyyy-MM-dd h:mm:ss.a");
        datePatternFormats.put(pattern(yyyy_1_MM_1_ddTHH_3_mm_3_ss_2_SSS + "Z"), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        datePatternFormats.put(pattern(yyyy_1_MM_1_ddTHH_3_mm_3_ssXXX + VV), "yyyy-MM-dd'T'HH:mm:ssXXX'['VV']'");
        datePatternFormats.put(pattern(d_2__MMMM_yyyy + " " + HH_3_mm_3_ss + " " + Z), "d. MMMM yyyy HH:mm:ss z");
        datePatternFormats.put(pattern(yyyy_1_MM_1_dd + " " + HH_3_mm_3_ss + "\\." + S), "yyyy-MM-dd HH:mm:ss.S");
        datePatternFormats.put(pattern(yyyy_1_MM_1_ddTHH_3_mm_3_ss_2_SSS + VV), "yyyy-MM-dd'T'HH:mm:ss.SSS'['VV']'");
        datePatternFormats.put(pattern(EEEE_d_MMMM_yyyy + " " + H_2_mm_2_ss + " " + Z), "EEEE d MMMM yyyy H.mm.ss z");
        datePatternFormats.put(pattern(EEEE_d_MMMM_yyyy + " " + H + " h " + mm + " " + Z), "EEEE d MMMM yyyy H' h 'mm z");
        datePatternFormats.put(pattern(yyyy_1_MM_1_ddTHH_3_mm_3_ss_2_SSSXXX + VV), "yyyy-MM-dd'T'HH:mm:ss.SSSXXX'['VV']'");
        datePatternFormats.put(pattern(MMMM_d_5__yyyy + " " + h_3_mm_3_ss + " " + Z + " " + A), "MMMM d, yyyy h:mm:ss z a");
        datePatternFormats.put(pattern(yyyy_1_MM_1_dd + " " + h_2_mm_2_ss + "\\." + A + " " + Z), "yyyy-MM-dd h.mm.ss.a z");
        datePatternFormats.put(pattern(EEEE_d_MMMM_yyyy + " " + HH + " h " + mm + " " + Z), "EEEE d MMMM yyyy HH' h 'mm z");
        datePatternFormats.put(pattern(EEE + ", " + d_MMM_yyyy + " " + HH_3_mm_3_ss + " " + Z), "EEE, d MMM yyyy HH:mm:ss z");
        datePatternFormats.put(pattern(EEEE_5__MMMM_d_5__yyyy_h_3_mm_3_ss + " " + A + " " + Z), "EEEE, MMMM d, yyyy h:mm:ss a z");
        datePatternFormats.put(pattern(dd_1_MMM_1_yy + " " + hh_2_mm_2_ss + "\\.\\d{9}" + " " + A), "dd-MMM-yy hh.mm.ss.nnnnnnnnn a");
        datePatternFormats.put(pattern(CHyyyyMd + " " + A + hh + "时" + mm + "分" + ss + "秒"), "yyyy'年'M'月'd'日' ahh'时'mm'分'ss'秒'");
        datePatternFormats.put(pattern(CHyyyyMd + " " + H + "時" + mm + "分" + ss + "秒 " + Z), "yyyy'年'M'月'd'日' H'時'mm'分'ss'秒' z");
        datePatternFormats.put(pattern(EEE + " " + MMM + " " + dd + " " + HH_3_mm_3_ss + " " + Z + " " + yyyy), "EEE MMM dd HH:mm:ss z yyyy");
        datePatternFormats.put(pattern(EEEE_5__d_MMMM_yyyy + " " + HH_3_mm_3_ss + " o'clock " + Z), "EEEE, d MMMM yyyy HH:mm:ss 'o''clock' z");
        datePatternFormats.put(pattern(EEEE_5__MMMM_d_5__yyyy_h_3_mm_3_ss + " o'clock " + A + " " + Z), "EEEE, MMMM d, yyyy h:mm:ss 'o''clock' a z");
        datePatternFormats.put(pattern(CHyyyyMd + " " + EEEE + " " + A + hh + "时" + mm + "分" + ss + "秒 " + Z), "yyyy'年'M'月'd'日' EEEE ahh'时'mm'分'ss'秒' z");
    }

    private Jiffy() {
    }

    /**
     * Try to find the correct date format out of the given string, and convert it to a {@link java.util.Date} object.
     *
     * @param s String that represents a date/time
     * @return List of {@link java.util.Date} extracted from given string, empty list if conversion was not successful
     */
    public static List<Date> stringToDate(String s) {
        final ImmutablePair<List<ImmutablePair<String, SimpleDateFormat>>, List<Date>> p = stringToDateFormatAndDate(s);
        return p.getRight();
    }

    /**
     * Try to find the correct date format out of the given string.
     *
     * @param s String that represents a date/time
     * @return List of pair (string and {@link java.text.SimpleDateFormat} extracted from given string), empty list if
     * conversion was not successful
     */
    public static List<ImmutablePair<String, SimpleDateFormat>> stringToDateFormat(String s) {
        final ImmutablePair<List<ImmutablePair<String, SimpleDateFormat>>, List<Date>> p = stringToDateFormatAndDate(s);
        return p.getLeft();
    }

    /**
     * Try to find the correct date format out of the given string, and provide format/date pairs.
     *
     * @param s String that represents a date/time
     * @return Pair of lists of format/date
     */
    public static ImmutablePair<List<ImmutablePair<String, SimpleDateFormat>>, List<Date>> stringToDateFormatAndDate(String s) {
        final List<ImmutablePair<String, SimpleDateFormat>> fs = new ArrayList<>();
        final List<Date> ds = new ArrayList<>();
        for (Map.Entry<Pattern, String> entry : datePatternFormats.entrySet()) {
            if (entry.getKey().matcher(s).matches()) {
                try {
                    final SimpleDateFormat f = new SimpleDateFormat(entry.getValue());
                    fs.add(new ImmutablePair<>(entry.getValue(), f));
                    final Date d = f.parse(s);
                    ds.add(d);
                } catch (Exception ignored) {
                }
            }
        }
        return new ImmutablePair<>(fs, ds);
    }

    private static Pattern pattern(String pattern) {
        return Pattern.compile("^" + pattern + "$");
    }
}
