package ftp27.spring;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.jbehave.core.io.CodeLocations.codeLocationFromPath;

@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations={"/calculator.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UseSpring {
    @Autowired
    iCalculator Calculator;

    @Test
    public void testAddition() {
        Calculator.setAction(new cAddition());
        assertEquals("Addition equal", (Integer) 7, Calculator.run());
    }

    @Test
    public void testSubstract() {
        Calculator.setAction(new cSubtraction());
        assertEquals("Substract equal", (Integer) 1, Calculator.run());
    }
}
