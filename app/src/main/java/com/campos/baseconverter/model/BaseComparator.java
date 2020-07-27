package com.campos.baseconverter.model;

import java.util.Comparator;

public class BaseComparator implements Comparator<Base> {
    @Override
    public int compare(Base b1, Base b2) {
        int radix1 = b1.getRadix();
        int radix2 = b2.getRadix();

        if (radix1 < radix2) {
            return 1; // 1 = We're converting to a higher base
        } else if (radix1 > radix2) {
            return -1; // -1 = We're converting to a lower base
        }
        return 0;
    }
}
