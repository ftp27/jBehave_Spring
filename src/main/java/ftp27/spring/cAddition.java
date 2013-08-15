package ftp27.spring;

import org.springframework.stereotype.Component;

@Component
public class cAddition implements iAction {
    @Override
    public Integer performAction(Integer a, Integer b) {
        return a+b;
    }

    @Override
    public String actionName() {
        return " + ";
    }
}
