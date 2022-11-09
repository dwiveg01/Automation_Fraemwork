package com.automationqa.utilities;

import java.util.Arrays;

import static com.automationqa.utilities.PropertyUtil.getProperty;

public class LocatorUtil {
    public static String getLocator(String locatorName, String... args) {
        Object[] argsObjects = Arrays.stream(args).toArray();
        return String.format(getProperty(locatorName), argsObjects);

    }
}
