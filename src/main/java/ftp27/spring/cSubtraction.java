package ftp27.spring;


public class cSubtraction implements iAction {
    @Override
    public Integer performAction(Integer a, Integer b) {
        return a-b;
    }

    @Override
    public String actionName() {
        return " - ";
    }
}
