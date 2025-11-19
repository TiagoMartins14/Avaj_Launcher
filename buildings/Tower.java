package buildings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import flyables.Flyable;
import singletons.OutputFileWriter;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        
        OutputFileWriter fileWriter = OutputFileWriter.getInstance();

        fileWriter.writeOutput("Tower says: " + p_flyable.tag() + " registered to weather tower.");
    }

    public void unregister(Flyable p_flyable) {
        OutputFileWriter fileWriter = OutputFileWriter.getInstance();
        
        fileWriter.writeOutput(p_flyable.tag() + ": landing.");
        fileWriter.writeOutput("Tower says: " + p_flyable.tag() + " unregistered from weather tower.");
    }

    protected void conditionChanged() {
        Iterator<Flyable> it = observers.iterator();

        while (it.hasNext()) {
            Flyable flyable = it.next();

            flyable.updateConditions();
            
            if (!flyable.isFlying()) {
                unregister(flyable);
                it.remove();
            }
        }
    }
}