
package com.evive.training.guava.guava;


import com.evive.training.guava.GuavaSplitter;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author evivehealth on 30/10/15
 */
public class GuavaSplitterTest {
    private GuavaSplitter guavaSplitter;

    @Before
    public void init(){
        guavaSplitter = new GuavaSplitter();
    }

    @Test
    public void testUseOfSplitter(){
        assertThat(guavaSplitter.useOfSplitter("orange, apple, mango")).isNotEmpty();
        assertThat(guavaSplitter.useOfSplitter("orange, apple, mango")).contains("mango");
    }

    @Test
    public void testSplittetToList(){
        assertThat(guavaSplitter.useOfSplitToList("orange, apple, mango")).contains("apple");
        assertThat(guavaSplitter.useOfSplitToList("orange, apple, mango")).isEqualTo(Arrays.asList("orange", "apple", "mango"));
    }

}