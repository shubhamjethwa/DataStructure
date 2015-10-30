
package com.evive.training.guava;

import com.google.common.base.Splitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Splitter splits the given string at seperator.
 * @author evivehealth on 30/10/15
 * @see  http://docs.guava-libraries.googlecode.com/git/javadoc/com/google/common/base/Splitter.html
 */
public class GuavaSplitter {
    private static final Logger logger = LoggerFactory.getLogger(GuavaSplitter.class);
    private Splitter splitter = Splitter.on(",").trimResults();

    /**
     * Split String to Iterator.
     * @param str1
     * @return Iterable<String>
     */
    public Iterable<String> useOfSplitter(String str1){
        return splitter.split(str1);
    }

    /**
     * Splits string to List.
     * @param str1
     * @return List<String>
     */
    public List<String> useOfSplitToList(String str1){
        return splitter.splitToList(str1);
    }
}
