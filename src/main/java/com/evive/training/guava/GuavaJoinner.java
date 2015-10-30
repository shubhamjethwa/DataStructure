package com.evive.training.guava;

import com.google.common.base.Joiner;

import java.util.List;

/**
 * @author evivehealth on 30/10/15
 *  Joinner joins the text with the given seperator.
 *  @see http://guava-libraries.googlecode.com/svn-history/r14/trunk/javadoc/com/google/common/base/Joiner.html
 */
public class GuavaJoinner {

    /**
     * In this method seperator is ':'. skipnull() skips the null values while joining.
     * @param stringList
     * @return
     */
    public String useOfJoiner(List<String> stringList){
        Joiner joiner = Joiner.on(":").skipNulls();
        return joiner.join(stringList);
    }


    /**
     * Here seperator is '|'.useForNull(string) this replaces the null to specified string.
     * @param stringList
     * @return
     */
    public String joinerUseForNull(List<String> stringList) {
        Joiner joiner = Joiner.on("|").useForNull("Replace");
        return joiner.join(stringList);
    }
}
