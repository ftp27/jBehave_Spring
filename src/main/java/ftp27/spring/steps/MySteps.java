package ftp27.spring.steps;

import ftp27.spring.cCalculator;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertEquals;

@Component
public class MySteps {
    public cCalculator Calculator;

    @Given("calculator object")
    public void setCalculator() {
        Calculator = new cCalculator();
    }

    @Given("set '$act' action for calculator")
    public void setAction(String act) {
        Calculator.setAction(act);
    }

    @When("a equal $a and b equal $b")
    public void SetAandB(Integer a, Integer b) {
      Calculator.setA(a);
      Calculator.setB(b);
    }

    @Then("result is $result")
    public void compareResult(Integer result) {
        assertEquals(result, Calculator.run());
    }

}
