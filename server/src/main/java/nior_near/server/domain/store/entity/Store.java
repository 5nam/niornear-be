package nior_near.server.domain.store.entity;

import jakarta.persistence.*;
import nior_near.server.domain.order.entity.Order;
import nior_near.server.domain.user.entity.Member;
import nior_near.server.global.util.Time;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Store extends Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @ColumnDefault("기본 이미지 링크")
    private String profileImage;

    @ColumnDefault("기본 음식 이미지 링크")
    private String thumbnail;

    @Column(nullable = false, length = 50)
    private String title;

    private String introduction;

    @Column(nullable = false, precision = 10, scale = 2)
    @ColumnDefault("36.5")
    private BigDecimal temperature;

    @Column(nullable = false)
    private String message;

    private Long lowestPrice;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoreAuth> storeAuthList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoreImage> storeImageList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menu> menuList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoreRegion> storeRegionList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orderList = new ArrayList<>(); // 요리사 입장에서 주문 리스트를 조회할 수 있으므로
}
