package com.evive.training.guava;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
/**
 * @author evivehealth on 30/10/15
 */
public class GuavaStringTest {

    private GuavaString guavaString;

    @Before
    public void init(){
        guavaString = new GuavaString();
    }

    @Test
    public void testJavaStringClass(){
        assertThat(guavaString.usingJavaStringClass("")).isNullOrEmpty();
        assertThat(guavaString.usingJavaStringClass("Hello!!"))
                .isEqualToIgnoringCase("heLLo!!");
        assertThat(guavaString.usingJavaStringClass("Hello!!"))
                .isEqualTo("Hello!!");
        assertThat(guavaString.usingJavaStringClass("EviveTraining").contains("Evive"));
        assertThat(guavaString.usingJavaStringClass("EviveTraining").equalsIgnoreCase("eviveTrAiNing"));
        assertThat(guavaString.usingJavaStringClass("EviveTraining").equals("EviveTraining"));
    }

    @Test
    public void testGuavaStringClass(){
        assertThat(guavaString.usingGuavaStringsClass("")).isNullOrEmpty();
        assertThat(guavaString.usingGuavaStringsClass("Hello!!"))
                .isEqualToIgnoringCase("heLLo!!");
        assertThat(guavaString.usingGuavaStringsClass("Hello!!"))
                .isEqualTo("Hello!!");
        assertThat(guavaString.usingGuavaStringsClass("EviveTraining").contains("Evive"));
        assertThat(guavaString.usingGuavaStringsClass("EviveTraining").equalsIgnoreCase("eviveTrAiNing"));
        assertThat(guavaString.usingGuavaStringsClass("EviveTraining").equals("EviveTraining"));
    }

    @Test
    public void testNullToEmpty(){
        assertThat(guavaString.nullToEmpty("")).isEmpty();
        assertThat(guavaString.nullToEmpty(null)).isEmpty();
        assertThat(guavaString.nullToEmpty("Training")).isEqualToIgnoringCase("training");
    }

    @Test
    public void testEmptyToNull(){
        assertThat(guavaString.emptyToNull("")).isNull();
        assertThat(guavaString.emptyToNull(null)).isNull();
        assertThat(guavaString.emptyToNull("Training")).isEqualToIgnoringCase("training");
    }
}