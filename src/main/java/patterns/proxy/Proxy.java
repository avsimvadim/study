package patterns.proxy;

//a proxy is a wrapper or agent object that is being called by the client
//to access the real serving object behind the scenes.
//Use of the proxy can simply be forwarding to the real object,
// or can provide additional logic. In the proxy, extra functionality can be provided,
// for example caching when operations on the real object are resource intensive,
// or checking preconditions before operations on the real object are invoked.
// For the client, usage of a proxy object is similar to using the real object,
// because both implement the same interface.

public class Proxy {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //image will be loaded from disk
        image.display();
        System.out.println("");

        //image will not be loaded from disk
        image.display();
    }
}

interface Image{
    void display();
}

class RealImage implements Image{
    String file;

    public RealImage(String file){
        this.file = file;
        load();
    }

    public void load(){
        System.out.println("loading " + file);
    }

    @Override
    public void display() {
        System.out.println("Watching " + file);
    }
}

class ProxyImage implements Image{
    private String file;
    private RealImage image;

    public ProxyImage(String file){
        this.file = file;
    }

    @Override
    public void display() {
        if(image == null) {
            image = new RealImage(file);
        }
        image.display();
    }
}