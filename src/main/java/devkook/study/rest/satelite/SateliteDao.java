package devkook.study.rest.satelite;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class SateliteDao {
    Hashtable<String, SateliteVo> satelites = new Hashtable<String, SateliteVo>();

    public SateliteDao() {
        
        String launchKey = "NARO50411131BIGBANG";
        
        SateliteVo satelite = new SateliteVo();
        satelite.setLaunchKey(launchKey);
        satelite.setControlStation("만휴정"); //여기 아시면 여행좀 다닌다는 .. 인정! 검색하고 알기 있기?없기?
        satelite.setName("bigBANg"); //태초의 시작 그곳에 아무것도 없엇다
        
        insert(launchKey, satelite);
    }

    public void insert(String launchKey, SateliteVo satelite) {
        satelites.put(launchKey, satelite);
    }

    public void update(String launchKey, SateliteVo satelite) {
        satelites.put(launchKey, satelite);
    }

    public void delete(String launchKey) {
        satelites.remove(launchKey);
    }

    public SateliteVo select(String launchKey) {
        return satelites.get(launchKey);
    }

    public List<SateliteVo> getList() {
        return new ArrayList<SateliteVo>(satelites.values());
    }
}
