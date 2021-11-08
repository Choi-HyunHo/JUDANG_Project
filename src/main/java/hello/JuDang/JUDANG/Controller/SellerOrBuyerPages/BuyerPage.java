package hello.JuDang.JUDANG.Controller.SellerOrBuyerPages;

import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Service.Seller.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.hql.internal.classic.Parser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/BuyerPage")
public class BuyerPage {
    private final ShopService shopService;

    @GetMapping
    public String goBuyerPage(Model model,
                              @RequestParam String lat,@RequestParam String lon) {
        //현재 위치기반 지도 띄우기
        Long latitude = Long.parseLong(lat);// long 변환
        Long longitude = Long.parseLong(lon);// long 변환

        List<Shop> nearShops = shopService.findNearShop(latitude, longitude);
        model.addAttribute("nearShops",nearShops);
        return "/buyer/buyer_main";
    }

    @PostMapping("/search/name")
    public String searchByName(@RequestParam String searchWord,Model model){
        List<Shop> shops = shopService.findByName(searchWord);
        model.addAttribute("searchByNameList",shops);
        return "/buyer/buyer_main";
    }

    @PostMapping("/search/category")
    public String searchByCategory(@RequestParam String searchWord,Model model){
        List<Shop> shops = shopService.findByCategory(searchWord);
        model.addAttribute("searchByCategoryList",shops);
        return "/buyer/buyer_main";
    }
}