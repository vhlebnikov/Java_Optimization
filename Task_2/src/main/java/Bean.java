import java.util.ArrayList;
import java.util.List;

public class Bean {
    private byte[] byteArray;
    private List<String> arrayList;
    private int primitive;
    private Bean link;

    public Bean() {
        byteArray = new byte[100];
        arrayList = new ArrayList<>();
        primitive = 2;
        link = this;
    }

    public void setLinkOn(Bean bean) {
        link = bean;
    }
}
