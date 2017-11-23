/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.saiku.service.util;

/**
 *
 * @author dinhnn
 */
public class VietnameseUnicodeUtils {
    
    private static final int VN_CODE[] = {97, 226, 259, 101, 234, 105, 111, 244, 417, 117, 432, 121,
        65, 194, 258, 69, 202, 73, 79, 212, 416, 85, 431, 89,
        225, 7845, 7855, 233, 7871, 237, 243, 7889, 7899, 250, 7913, 253,
        193, 7844, 7854, 201, 7870, 205, 211, 7888, 7898, 218, 7912, 221,
        224, 7847, 7857, 232, 7873, 236, 242, 7891, 7901, 249, 7915, 7923,
        192, 7846, 7856, 200, 7872, 204, 210, 7890, 7900, 217, 7914, 7922,
        7841, 7853, 7863, 7865, 7879, 7883, 7885, 7897, 7907, 7909, 7921, 7925,
        7840, 7852, 7862, 7864, 7878, 7882, 7884, 7896, 7906, 7908, 7920, 7924,
        7843, 7849, 7859, 7867, 7875, 7881, 7887, 7893, 7903, 7911, 7917, 7927,
        7842, 7848, 7858, 7866, 7874, 7880, 7886, 7892, 7902, 7910, 7916, 7926,
        227, 7851, 7861, 7869, 7877, 297, 245, 7895, 7905, 361, 7919, 7929,
        195, 7850, 7860, 7868, 7876, 296, 213, 7894, 7904, 360, 7918, 7928,
        100, 273, 68, 272, 208, 393};

    private static final char ASCII_CHAR[] = {'a', 'a', 'a', 'e', 'e', 'i', 'o', 'o', 'o', 'u', 'u', 'y',
        'A', 'A', 'A', 'E', 'E', 'I', 'O', 'O', 'O', 'U', 'U', 'Y',
        'a', 'a', 'a', 'e', 'e', 'i', 'o', 'o', 'o', 'u', 'u', 'y',
        'A', 'A', 'A', 'E', 'E', 'I', 'O', 'O', 'O', 'U', 'U', 'Y',
        'a', 'a', 'a', 'e', 'e', 'i', 'o', 'o', 'o', 'u', 'u', 'y',
        'A', 'A', 'A', 'E', 'E', 'I', 'O', 'O', 'O', 'U', 'U', 'Y',
        'a', 'a', 'a', 'e', 'e', 'i', 'o', 'o', 'o', 'u', 'u', 'y',
        'A', 'A', 'A', 'E', 'E', 'I', 'O', 'O', 'O', 'U', 'U', 'Y',
        'a', 'a', 'a', 'e', 'e', 'i', 'o', 'o', 'o', 'u', 'u', 'y',
        'A', 'A', 'A', 'E', 'E', 'I', 'O', 'O', 'O', 'U', 'U', 'Y',
        'a', 'a', 'a', 'e', 'e', 'i', 'o', 'o', 'o', 'u', 'u', 'y',
        'A', 'A', 'A', 'E', 'E', 'I', 'O', 'O', 'O', 'U', 'U', 'Y',
        'd', 'd', 'D', 'D', 'D', 'D'};

    /*
     * Convert a unicode vietnamese string to ascii string.
     * This function resolves the problem of unicode character
     * mismatch of province names provided by delivery partners
     */
    public static String convertToAscii(String str) {
        if (str == null) {
            return null;
        }
        int vn_codeLength = VN_CODE.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int found = -1;
            int code = (int) str.charAt(i);
            for (int j = 0; found == -1 && j < vn_codeLength; j++) {
                if (VN_CODE[j] == code) {
                    found = j;
                }
            }
            if (found >= 0) {
                sb.append(ASCII_CHAR[found]);
            } else {
                char ch = str.charAt(i);
                if ((ch >= 'A' && ch <= 'Z')
                        || (ch >= 'a' && ch <= 'z')
                        || (ch >= '0' && ch <= '9')
                        || (ch == ' ')
                        || (ch == '-')
                        || (ch == '#')
                        || (ch == '_')
                        || (ch == '/')
                        || (ch == '\\')
                        || (ch == '\n')
                        || (ch == ':')
                        || (ch == ',')) {

                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

    /**
     *
     * @param str
     * @return
     */
    public static String convertAndLowerCase(String str) {
        if (str == null) {
            return str;
        }
        str = convertToAscii(str);
        while (str.contains("  ")) {
            str = str.replaceAll("  ", " ");
        }
        return str.toLowerCase().trim();
    }
}
