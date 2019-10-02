package SpringCore.SpringConfigurationAnnotation;

public class DemoManagerImpl implements DemoManager{
    private String ret;
    DemoManagerImpl(){
        ret="default str.";
    }
    DemoManagerImpl(String str){
        ret=str;
    }
    public String getServiceName() {
        return ret;
    }
}
