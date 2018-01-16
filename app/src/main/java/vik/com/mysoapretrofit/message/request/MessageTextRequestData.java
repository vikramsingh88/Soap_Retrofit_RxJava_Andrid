package vik.com.mysoapretrofit.message.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by Ganesha on 12/12/2016.
 */

@Root(name = "Add", strict = false)
@Namespace(reference = "http://tempuri.org/")
public class MessageTextRequestData {

    @Element(name = "intA", required = false)
    private int intA;

    @Element(name = "intB", required = false)
    private int intB;

    public int getIntA() {
        return intA;
    }

    public void setIntA(int intA) {
        this.intA = intA;
    }

    public int getIntB() {
        return intB;
    }

    public void setIntB(int intB) {
        this.intB = intB;
    }
}
