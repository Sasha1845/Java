package Classes;

public class Engine {
    private boolean engineWorks;

    public void startEngine() {
        engineWorks = true;
        System.out.println("Engine started.");
    }

    public void stopEngine() {
        engineWorks = false;
        System.out.println("Engine stopped.");
    }

    public boolean isEngineWorks() {
        return engineWorks;
    }
}
