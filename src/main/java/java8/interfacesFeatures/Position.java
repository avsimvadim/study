package java8.interfacesFeatures;

public interface Position {
    void setX(int x);

    void setY(int y);

    int getX();

    int getY();

    default int changeX(int x){
        setX(x);
        return getX();
    }

    default int changeY(int y){
        setY(y);
        return getY();
    }

}
