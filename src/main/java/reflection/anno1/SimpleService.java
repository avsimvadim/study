package reflection.anno1;

@Service(name = "superSimpleService")
public class SimpleService {
    @Init
    public void initService(){
        System.out.println("initService");
    }

    public void initServiceNoAnno(){
        System.out.println("initServiceNoAnno");
    }
}
