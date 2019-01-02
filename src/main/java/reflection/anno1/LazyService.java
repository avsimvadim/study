package reflection.anno1;

@Service(name = "superLazyService")
public class LazyService {
    @Init
    public void lazyInit() throws Exception{
        System.out.println("lazyInit");
    }
}
