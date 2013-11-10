package devkook.study.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserVO {
    
    private String name = "devkook";
    private int age = 0;

    public UserVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
}
