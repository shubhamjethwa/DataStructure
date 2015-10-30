package com.evive.training.guava;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author evivehealth on 30/10/15
 */
public class GuavaString {
    private static final Logger logger = LoggerFactory.getLogger(GuavaString.class);

    public String usingJavaStringClass(String str1){

        if( !str1.equals(null) || !str1.isEmpty()){
            return str1;
        }
        else {
            return null;
        }
    }

    /**
     *   isNullOrEmpty(String str) method checks if the given string isEmpty or null.
     * @param str1
     * @return
     */
    public String usingGuavaStringsClass(String str1){

        if(Strings.isNullOrEmpty(str1)){
            return null;
        }
        else {
            return str1;
        }
    }

    /**
     * nullToEmpty(String str) this method returns String if it is not null.else returns Empty String.
     * @param str1
     * @return
     */
    public String nullToEmpty(String str1){
        return Strings.nullToEmpty(str1);
    }

    /**
     * emptyToNull(String str) this method returns String if it is non empty.else returns null.
     * @param str1
     * @return
     */
    public String emptyToNull(String str1){
        return Strings.emptyToNull(str1);
    }

}
