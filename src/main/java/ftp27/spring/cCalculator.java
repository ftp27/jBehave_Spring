package ftp27.spring;

public class cCalculator implements iCalculator{
    private final String ADDITION = "additional", SUBSTRUCT = "subctruction";

    private iAction action;
    private Integer a,b;

    public void setAction(String action) {
        if (action.equals(ADDITION)) {
            setAction(new cAddition());
        } else if (action.equals(SUBSTRUCT)) {
                setAction(new cSubtraction());
        }
    }

    @Override
    public void setAction(iAction action) {
        this.action = action;
    }

    @Override
    public void setA(Integer a) {
        this.a = a;
    }

    @Override
    public void setB(Integer b) {
        this.b = b;
    }

    @Override
    public Integer run() {
        return action.performAction(a, b);
    }
}

