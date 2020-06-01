package java8.interfacesFeatures;

public interface Resizable {

    int getDiameter();

    void setDiameter(int d);

    default int resize(int percent){
        int newDiameter = getDiameter() * percent / 100;
        setDiameter(newDiameter);
        return getDiameter();
    }
}
