package ftp27.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static junit.framework.Assert.assertEquals;

@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations={"/calculator.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringStories {
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
