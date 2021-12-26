package hello.JuDang.JUDANG.Repository.Menu;

import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Domain.Shop;

import java.util.List;
import java.util.Optional;

public interface MenuRepository {
    int save(Menu menu,int shopNum);
    List<Menu> findAllMenu(int shopNum);
    int update(Shop shop,Menu menu);
    int delete(Shop shop);
}
