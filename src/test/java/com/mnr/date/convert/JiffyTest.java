package com.mnr.date.convert;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class JiffyTest {

    private static final String D_3_FEB_1999 = "Wed Feb 03 00:00:00 CET 1999";
    private static final String D_2_MAR_1999 = "Tue Mar 02 00:00:00 CET 1999";
    private static final String D_22_MAR_1999 = "Mon Mar 22 00:00:00 CET 1999";
    private static final String D_22_MAR_1999_5_6 = "Mon Mar 22 05:06:00 CET 1999";
    private static final String D_22_MAR_1999_5_6_7 = "Mon Mar 22 05:06:07 CET 1999";

    private String string;
    private List<String> dates;
    private List<String> formats;

    public JiffyTest(String string, List<String> dates, List<String> formats) {
        this.string = string;
        this.dates = dates;
        this.formats = formats;
    }

    @Parameters(name = "{index} {0}")
    public static Collection<Object[]> testCases() {
        return Arrays.asList(new Object[][]{
                {"22.3.99", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("d.M.yy")},
                {"3-22-99", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("M-d-yy")},
                {"3/22/99", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("M/d/yy")},
                {"99.3.22", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yy.M.d")},
                {"99.22.3", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yy.d.M")},
                {"22-3-99", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("d-M-yy")},
                {"99-3-22", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yy-M-d")},
                {"22.3.99.", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("d.M.yy.")},
                {"02.03.99", Collections.singletonList(D_2_MAR_1999), Collections.singletonList("dd.MM.yy")},
                {"22-03-99", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("dd-MM-yy")},
                {"19990322", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyyMMdd")},
                {"03-22-99", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("MM-dd-yy")},
                {"99-03-22", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yy-MM-dd")},
                {"03/22/99", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("MM/dd/yy")},
                {"99/03/22", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yy/MM/dd")},
                {"02/03/99", Arrays.asList(D_2_MAR_1999, D_3_FEB_1999), Arrays.asList("dd/MM/yy", "MM/dd/yy")},
//                {"1999W132", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyy'W'wc")},
                {"22.3.1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("d.M.yyyy")},
                {"3-22-1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("M-d-yyyy")},
                {"1999-3-22", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyy-M-d")},
                {"22/3/1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("d/M/yyyy")},
                {"3/22/1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("M/d/yyyy")},
                {"1999/3/22", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyy/M/d")},
                {"1999.22.3", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyy.d.M")},
                {"99. 3. 22", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yy. M. d")},
                {"22.03.99", Arrays.asList(D_22_MAR_1999, D_22_MAR_1999), Arrays.asList("d.MM.yy", "dd.MM.yy")},
                {"22/03/99", Arrays.asList(D_22_MAR_1999, D_22_MAR_1999), Arrays.asList("d/MM/yy", "dd/MM/yy")},
                {"02.03.1999", Collections.singletonList(D_2_MAR_1999), Collections.singletonList("dd.MM.yyyy")},
                {"03-22-1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("MM-dd-yyyy")},
                {"22/03/1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("dd/MM/yyyy")},
                {"03/22/1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("MM/dd/yyyy")},
                {"1999/03/22", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyy/MM/dd")},
                {"1999-03-22", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyy-MM-dd")},
                {"1999.03.22", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyy.MM.dd")},
                {"22-03-1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("dd-MM-yyyy")},
//                {"1999-W13-2", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyy-'W'w-c")},
                {"1999. 3. 22", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyy. M. d")},
                {"19990322+0100", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyyMMddz")},
                {"22.03.1999.", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("dd.MM.yyyy.")},
                {"Mar.22.1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("MMM.dd.yyyy")},
                {"1999.03.22.", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyy.MM.dd.")},
//                {"22 mars 1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("d MMM yyyy")},
//                {"22 mars 1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("d MMMM yyyy")},
                {"22.03.1999", Arrays.asList(D_22_MAR_1999, D_22_MAR_1999), Arrays.asList("d.MM.yyyy", "dd.MM.yyyy")},
                {"1999-03-22 AD", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyy-MM-dd G")},
                {"1999-081+01:00", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyy-DDDXXX")},
//                {"22. März 1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("d. MMMM yyyy")},
                {"22. March 1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("d. MMMM yyyy")},
//                {"99-3-22 上午5:06", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yy-M-d ah:mm")},
                {"22.3.99 5.06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("d.M.yy H.mm")},
                {"3/22/99 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("M/d/yy H:mm")},
                {"22.3.99 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("d.M.yy H:mm")},
                {"22-3-99 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("d-M-yy H:mm")},
                {"22-Mar-1999", Arrays.asList(D_22_MAR_1999, D_22_MAR_1999), Arrays.asList("d-MMM-yyyy", "dd-MMM-yyyy")},
                {"22-mar-1999", Arrays.asList(D_22_MAR_1999, D_22_MAR_1999), Arrays.asList("d-MMM-yyyy", "dd-MMM-yyyy")},
                {"22-Mar-1999", Arrays.asList(D_22_MAR_1999, D_22_MAR_1999), Arrays.asList("d-MMM-yyyy", "dd-MMM-yyyy")},
                {"Mar 22 1999", Arrays.asList(D_22_MAR_1999, D_22_MAR_1999), Arrays.asList("MMM d yyyy", "MMMM d yyyy")},
                {"99.3.22 05.06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("yy.M.d HH.mm")},
                {"3-22-99 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("M-d-yy HH:mm")},
                {"3/22/99 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("M/d/yy HH:mm")},
                {"22/03/99 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("d/MM/yy H:mm")},
                {"22.3.99 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("d.M.yy HH:mm")},
                {"99.22.3 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("yy.d.M HH:mm")},
                {"March 22 1999", Arrays.asList(D_22_MAR_1999, D_22_MAR_1999), Arrays.asList("MMM d yyyy", "MMMM d yyyy")},
                {"1999-03-22+01:00", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyy-MM-ddXXX")},
                {"1999年3月22日", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyy'年'M'月'd'日'")},
                {"03/22/99 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("MM/dd/yy H:mm")},
                {"03-22-99 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("MM-dd-yy H:mm")},
                {"99/03/22 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("yy/MM/dd H:mm")},
                {"Mar 22, 1999", Arrays.asList(D_22_MAR_1999, D_22_MAR_1999), Arrays.asList("MMM d, yyyy", "MMMM d, yyyy")},
                {"22/03/99 5.06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("dd/MM/yy H.mm")},
                {"22.3.99. 05.06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("d.M.yy. HH.mm")},
                {"22.3.1999 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("d.M.yyyy H:mm")},
                {"3-22-1999 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("M-d-yyyy H:mm")},
                {"1999-3-22 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("yyyy-M-d H:mm")},
                {"22/3/1999 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("d/M/yyyy H:mm")},
                {"3/22/1999 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("M/d/yyyy H:mm")},
//                {"99-03-22 5.06.PD", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yy-MM-dd h.mm.a")},
                {"22-03-99 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("dd-MM-yy HH:mm")},
                {"22.03.99 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("dd.MM.yy HH:mm")},
                {"22/03/99 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("dd/MM/yy HH:mm")},
                {"3/22/99 5:06 AM", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("M/d/yy h:mm a")},
                {"03-22-99 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("MM-dd-yy HH:mm")},
                {"3-22-99 5:06 AM", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("M-d-yy h:mm a")},
                {"99-03-22 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("yy-MM-dd HH:mm")},
                {"03/22/99 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("MM/dd/yy HH:mm")},
                {"99/03/22 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("yy/MM/dd HH:mm")},
                {"05:06 22/03/99", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("HH:mm dd/MM/yy")},
                {"March 22, 1999", Arrays.asList(D_22_MAR_1999, D_22_MAR_1999), Arrays.asList("MMM d, yyyy", "MMMM d, yyyy")},
                {"3-22-99 5:06 AM", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("M-d-yy h:mm a")},
                {"22.3.1999 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("d.M.yyyy HH:mm")},
                {"3-22-1999 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("M-d-yyyy HH:mm")},
                {"1999-3-22 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("yyyy-M-d HH:mm")},
                {"22/3/1999 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("d/M/yyyy HH:mm")},
                {"3/22/1999 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("M/d/yyyy HH:mm")},
                {"22-03-1999 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("dd-MM-yyyy H:mm")},
                {"03-22-1999 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("MM-dd-yyyy H:mm")},
                {"1999-03-22 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("yyyy-MM-dd H:mm")},
                {"22/03/1999 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("dd/MM/yyyy H:mm")},
                {"03/22/1999 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("MM/dd/yyyy H:mm")},
                {"1999/03/22 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("yyyy/MM/dd H:mm")},
//                {"lundi 22 mars 1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("EEEE d MMMM yyyy")},
                {"3-22-99 5:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("M-d-yy H:mm:ss")},
                {"3/22/99 5:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("M/d/yy H:mm:ss")},
                {"22.3.1999 05:06:", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("d.M.yyyy HH:mm:")},
                {"22/03/99 5:06 AM", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("dd/MM/yy h:mm a")},
                {"03/22/99 5:06 AM", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("MM/dd/yy h:mm a")},
                {"03-22-99 5:06 AM", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("MM-dd-yy h:mm a")},
                {"22-03-1999 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("dd-MM-yyyy HH:mm")},
                {"22.03.1999 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("dd.MM.yyyy HH:mm")},
                {"03-22-1999 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("MM-dd-yyyy HH:mm")},
                {"3-22-1999 5:06 AM", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("M-d-yyyy h:mm a")},
                {"1999-3-22 5:06 AM", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("yyyy-M-d h:mm a")},
                {"22/03/1999 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("dd/MM/yyyy HH:mm")},
                {"22/3/1999 5:06 AM", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("d/M/yyyy h:mm a")},
                {"03/22/1999 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("MM/dd/yyyy HH:mm")},
                {"3/22/1999 5:06 AM", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("M/d/yyyy h:mm a")},
                {"1999.03.22. 5:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("yyyy.MM.dd. H:mm")},
                {"1999.03.22 05:06", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("yyyy.MM.dd HH:mm")},
                {"05:06 22/03/1999", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("HH:mm dd/MM/yyyy")},
                {"3-22-99 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("M-d-yy HH:mm:ss")},
                {"3/22/99 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("M/d/yy HH:mm:ss")},
                {"22/Mar/99 5:06 AM", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("dd/MMM/yy h:mm a")},
                {"03-22-99 5:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("MM-dd-yy H:mm:ss")},
                {"03/22/99 5:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("MM/dd/yy H:mm:ss")},
                {"99/03/22 5:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yy/MM/dd H:mm:ss")},
                {"Monday, 22. Mar 1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("EEEE, d. MMMM yyyy")},
                {"Monday, 22 March 1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("EEEE, d MMMM yyyy")},
                {"22.3.1999 5.06.07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("d.M.yyyy H.mm.ss")},
                {"22.3.1999 5:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("d.M.yyyy H:mm:ss")},
                {"3-22-1999 5:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("M-d-yyyy H:mm:ss")},
                {"1999-3-22 5:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-M-d H:mm:ss")},
                {"03-22-1999 5:06 AM", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("MM-dd-yyyy h:mm a")},
                {"1999-03-22 5:06 AM", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("yyyy-MM-dd h:mm a")},
                {"22/03/1999 5:06 AM", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("dd/MM/yyyy h:mm a")},
                {"03/22/1999 5:06 AM", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("MM/dd/yyyy h:mm a")},
//                {"Montag, 22. März 1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("EEEE, d. MMMM yyyy")},
                {"22.03.99 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("dd.MM.yy HH:mm:ss")},
                {"22/03/99 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("dd/MM/yy HH:mm:ss")},
                {"03-22-99 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("MM-dd-yy HH:mm:ss")},
                {"3-22-99 5:06:07 AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("M-d-yy h:mm:ss a")},
                {"03/22/99 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("MM/dd/yy HH:mm:ss")},
                {"3/22/99 5:06:07 AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("M/d/yy h:mm:ss a")},
                {"Monday, March 22, 1999", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("EEEE, MMMM d, yyyy")},
                {"22.03.99 5:06", Arrays.asList(D_22_MAR_1999_5_6, D_22_MAR_1999_5_6), Arrays.asList("d.MM.yy H:mm", "dd.MM.yy H:mm")},
                {"22.03.99 5:06", Arrays.asList(D_22_MAR_1999_5_6, D_22_MAR_1999_5_6), Arrays.asList("d.MM.yy H:mm", "dd.MM.yy H:mm")},
                {"22.3.1999 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("d.M.yyyy HH:mm:ss")},
                {"3-22-1999 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("M-d-yyyy HH:mm:ss")},
                {"1999-3-22 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-M-d HH:mm:ss")},
                {"22/3/1999 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("d/M/yyyy HH:mm:ss")},
                {"3/22/1999 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("M/d/yyyy HH:mm:ss")},
                {"1999.22.3 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy.d.M HH:mm:ss")},
//                {"1999年3月22日 星期一", Collections.singletonList(D_22_MAR_1999), Collections.singletonList("yyyy'年'M'月'd'日' EEEE")},
                {"03-22-1999 5:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("MM-dd-yyyy H:mm:ss")},
                {"1999-03-22 5:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-MM-dd H:mm:ss")},
                {"22-mar-1999 5.06.07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("d-MMM-yyyy H.mm.ss")},
                {"03-22-99 5:06:07 AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("MM-dd-yy h:mm:ss a")},
                {"03/22/99 5:06:07 AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("MM/dd/yy h:mm:ss a")},
                {"22-03-1999 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("dd-MM-yyyy HH:mm:ss")},
                {"22.03.1999 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("dd.MM.yyyy HH:mm:ss")},
                {"03-22-1999 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("MM-dd-yyyy HH:mm:ss")},
                {"3-22-1999 5:06:07 AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("M-d-yyyy h:mm:ss a")},
                {"1999-3-22 5:06:07 AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-M-d h:mm:ss a")},
                {"1999-03-22 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-MM-dd HH:mm:ss")},
                {"1999-03-22 05.06.07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-MM-dd HH.mm.ss")},
                {"22/03/1999 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("dd/MM/yyyy HH:mm:ss")},
                {"22/3/1999 5:06:07 AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("d/M/yyyy h:mm:ss a")},
                {"03/22/1999 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("MM/dd/yyyy HH:mm:ss")},
                {"3/22/1999 5:06:07 AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("M/d/yyyy h:mm:ss a")},
                {"1999.03.22. 5:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy.MM.dd. H:mm:ss")},
                {"1999.03.22 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy.MM.dd HH:mm:ss")},
                {"05:06:07 22/03/1999", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("HH:mm:ss dd/MM/yyyy")},
                {"05:06:07 22-03-1999", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("HH:mm:ss dd-MM-yyyy")},
                {"1999-03-22T05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-MM-dd'T'HH:mm:ss")},
                {"22.03.1999. 05.06.07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("dd.MM.yyyy. HH.mm.ss")},
                {"22-Mar-1999 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("dd-MMM-yyyy HH:mm:ss")},
//                {"22 mars 1999 05:06:07", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("d MMM yyyy HH:mm:ss")},
                {"03-22-1999 5:06:07 AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("MM-dd-yyyy h:mm:ss a")},
                {"1999-03-22 5:06:07 AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-MM-dd h:mm:ss a")},
                {"22/03/1999 5:06:07 AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("dd/MM/yyyy h:mm:ss a")},
                {"03/22/1999 5:06:07 AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("MM/dd/yyyy h:mm:ss a")},
//                {"1999-03-22 5:06:07.PD", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-MM-dd h:mm:ss.a")},
                {"22-Mar-1999 5:06:07 AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("d-MMM-yyyy h:mm:ss a")},
                {"1999-03-22 05:06:07.0", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-MM-dd HH:mm:ss.S")},
                {"Mar 22, 1999 5:06:07 AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("MMM d, yyyy h:mm:ss a")},
                {"22/Mar/1999 5:06:07 +0100", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("d/MMM/yyyy H:mm:ss z")},
                {"22.03.1999. 05.06.07 CET", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("dd.MM.yyyy. HH.mm.ss z")},
//                {"22 marzo 1999 5.06.07 CET", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("d MMMM yyyy H.mm.ss z")},
//                {"22 mars 1999 05:06:07 CET", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("d MMMM yyyy HH:mm:ss z")},
//                {"1999-03-22 5.06.07.PD CET", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-MM-dd h.mm.ss.a z")},
                {"1999-03-22T05:06:07.000", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-MM-dd'T'HH:mm:ss.SSS")},
                {"22. Mar 1999 05:06:07 CET", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("d. MMMM yyyy HH:mm:ss z")},
                {"1999-03-22T05:06:07+01:00", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-MM-dd'T'HH:mm:ssXXX")},
//                {"22. März 1999 05:06:07 MEZ", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("d. MMMM yyyy HH:mm:ss z")},
                {"1999-03-22T05:06:07.000Z", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")},
                {"March 22, 1999 5:06:07 CET AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("MMMM d, yyyy h:mm:ss z a")},
                {"22 March 1999", Arrays.asList(D_22_MAR_1999, D_22_MAR_1999, D_22_MAR_1999), Arrays.asList("d MMM yyyy", "d MMMM yyyy", "dd MMMM yyyy")},
                {"22.03.1999 5:06:07", Arrays.asList(D_22_MAR_1999_5_6_7, D_22_MAR_1999_5_6_7), Arrays.asList("d.MM.yyyy H:mm:ss", "dd.MM.yyyy H:mm:ss")},
                {"Mon Mar 22 05:06:07 CET 1999", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("EEE MMM dd HH:mm:ss z yyyy")},
//                {"lundi 22 mars 1999 5 h 06 CET", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("EEEE d MMMM yyyy H' h 'mm z")},
//                {"lundi 22 mars 1999 05 h 06 CET", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("EEEE d MMMM yyyy HH' h 'mm z")},
                {"1999-03-22T05:06:07.000+01:00", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")},
                {"Mon, 22 Mar 1999 05:06:07 +0100", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("EEE, d MMM yyyy HH:mm:ss z")},
//                {"lunedì 22 marzo 1999 5.06.07 CET", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("EEEE d MMMM yyyy H.mm.ss z")},
//                {"22-Mar-99 05.06.07.000000888 AM", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("dd-MMM-yy hh.mm.ss.nnnnnnnnn a")},
//                {"Montag, 22. März 1999 05:06 Uhr MEZ", Collections.singletonList(D_22_MAR_1999_5_6), Collections.singletonList("EEEE, d. MMMM yyyy HH:mm' Uhr 'z")},
                {"1999年3月22日 5時06分07秒 CET", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy'年'M'月'd'日' H'時'mm'分'ss'秒' z")},
//                {"1999年3月22日 上午05时06分07秒", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy'年'M'月'd'日' ahh'时'mm'分'ss'秒'")},
                {"Monday, March 22, 1999 5:06:07 AM CET", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("EEEE, MMMM d, yyyy h:mm:ss a z")},
//                {"1999-03-22T05:06:07.000[Europe/Paris]", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-MM-dd'T'HH:mm:ss.SSS'['VV']'")},
//                {"1999-03-22T05:06:07+01:00[Europe/Paris]", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-MM-dd'T'HH:mm:ssXXX'['VV']'")},
//                {"1999-03-22T05:06:07.000+01:00[Europe/Paris]", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy-MM-dd'T'HH:mm:ss.SSSXXX'['VV']'")},
                {"Monday, 22 March 1999 05:06:07 o'clock CET", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("EEEE, d MMMM yyyy HH:mm:ss 'o''clock' z")},
//                {"1999年3月22日 星期一 上午05时06分07秒 CET", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("yyyy'年'M'月'd'日' EEEE ahh'时'mm'分'ss'秒' z")},
                {"Monday, March 22, 1999 5:06:07 o'clock AM CET", Collections.singletonList(D_22_MAR_1999_5_6_7), Collections.singletonList("EEEE, MMMM d, yyyy h:mm:ss 'o''clock' a z")},
                {"22 Mar 1999 05:06:07 +0100", Arrays.asList(D_22_MAR_1999_5_6_7, D_22_MAR_1999_5_6_7, D_22_MAR_1999_5_6_7), Arrays.asList("d MMM yyyy HH:mm:ss z", "d MMMM yyyy HH:mm:ss z", "dd MMMM yyyy HH:mm:ss z")},
                {"22 March 1999 05:06:07 CET", Arrays.asList(D_22_MAR_1999_5_6_7, D_22_MAR_1999_5_6_7, D_22_MAR_1999_5_6_7), Arrays.asList("d MMM yyyy HH:mm:ss z", "d MMMM yyyy HH:mm:ss z", "dd MMMM yyyy HH:mm:ss z")},
        });
    }

    @Test
    public void test() {
        final List<Date> ds = Jiffy.stringToDate(string);
        assertFalse("stringToDate() failed; string: " + string, ds.isEmpty());
        assertEquals("Number of generated dates is not correct, ", dates.size(), ds.size());
        for (int i = 0; i < dates.size(); i-=-1) {
            assertEquals("Generated date is not correct, ", dates.get(i), ds.get(i).toString());
        }

        final List<ImmutablePair<String, SimpleDateFormat>> fs = Jiffy.stringToDateFormat(string);
        assertFalse("stringToDateFormat() failed; string: " + string, fs.isEmpty());
        assertEquals("Number of generated formats is not correct, ", formats.size(), fs.size());
        for (int i = 0; i < formats.size(); i-=-1) {
            assertEquals("Generated format is not correct, ", formats.get(i), fs.get(i).getLeft());
        }
    }
}
