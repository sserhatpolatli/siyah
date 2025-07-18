package greedy;
public class Tools {
    String toolname;
    int cost;
    int energysavingrate;
    double benefit;

    public Tools(String toolname, int cost, int energysavingrate) {
        this.toolname = toolname;
        this.cost = cost;
        this.energysavingrate = energysavingrate;
        this.benefit = (double) energysavingrate / cost;
    }

}
