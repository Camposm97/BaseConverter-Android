package com.campos.baseconverter.model;

import java.util.Comparator;

public class BaseComparator implements Comparator<Base> {
    @Override
    public int compare(Base b1, Base b2) {
        int radix1 = b1.getRadix();
        int radix2 = b2.getRadix();
        if (radix1 > radix2) {
            return 1;
        } else if (radix1 < radix2) {
            return -1;
        }
        return 0;
    }
}
