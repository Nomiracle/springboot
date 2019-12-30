package IOExample;

public class GetResource {
    public static void main(String[] args) {
        String filename = "IAmConfigFileName.txt";
        GetResource getResource = new GetResource();
        System.out.println(
                "find path:"+
                getResource.getClass().getResource("/"+filename)
        );
    }
}
