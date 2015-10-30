package com.evive.training.guava.guava;

import com.evive.training.guava.GuavaJoinner;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author evivehealth on 30/10/15
 */
public class GuavaJoinerTest {

    private static final Logger logger = LoggerFactory.getLogger(GuavaJoinerTest.class);
    private GuavaJoinner guavaJoiner;
    private List<String> stringList1;

    @Before
    public void init(){
        guavaJoiner = new GuavaJoinner();
        stringList1 = ImmutableList.of("Orange,yellow", "Green", "Purple");
    }

    @Test
    public void testJoinerJoin(){
        assertThat(guavaJoiner.useOfJoiner(stringList1)).isNotEmpty();
        assertThat(guavaJoiner.useOfJoiner(stringList1)).isEqualTo("Orange,yellow:Green:Purple");
        assertThat(guavaJoiner.useOfJoiner(Arrays.asList("One", null, "two", "three"))).isEqualToIgnoringCase("one:two:three");
    }

    @Test
    public void testJoinerUseForNull(){
        assertThat(guavaJoiner.joinerUseForNull(stringList1)).isNotEmpty();
        assertThat(guavaJoiner.joinerUseForNull(Arrays.asList("One", null, "two", "three"))).isEqualToIgnoringCase("one|replace|two|three");
    }
}
