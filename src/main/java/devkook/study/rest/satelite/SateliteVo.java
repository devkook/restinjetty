package devkook.study.rest.satelite;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Satelite")
public class SateliteVo {
    
    String launchKey;//간직하고 싶은 나만의 발사키 - 발사대 + 시간 : NARO50411131DEVKOOK - 하루에 12 대 ... 친구들과 함께 발사의 가슴 벅참을 ... 기념일에 쏘고 ... 의미를 담아 쏘자 가끔 우리 머리위 상공을 넘나들때 ~
    String controlStation;//관제소 - 가끔은 사라지고 다시 나타나고 검은별검은별 ... 날주아리나리
    String name;
    
    public String getLaunchKey() {
        return launchKey;
    }
    public void setLaunchKey(String launchKey) {
        this.launchKey = launchKey;
    }
    public String getControlStation() {
        return controlStation;
    }
    public void setControlStation(String controlStation) {
        this.controlStation = controlStation;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
}
