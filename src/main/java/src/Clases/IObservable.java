package src.Clases;

import java.util.ArrayList;
import java.util.List;
public interface IObservable {
     void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();

}
