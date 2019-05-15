import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

import java.util.List;

public class EshopMain {
    public static void main(String ar[]) {
        Products pApple1 = createProductApple1();
        Sku sku1 = createSkuApple1();
        Sku sku2 = createSkuApple2();
        sku1.setProductId(pApple1);

        sku2.setProductId(pApple1);
        List<Sku> applSkuList = new ArrayList<Sku>();

        applSkuList.add(sku1);

        applSkuList.add(sku2);
        pApple1.setSkuList(applSkuList);
        Products pSam1 = createProductSam2();

        Sku sku3 = createSkuSam1();
        Sku sku4 = createSkuSam2();
        sku3.setProductId(pSam1);
        sku4.setProductId(pSam1);
        List<Sku> SamSkuList = new ArrayList<Sku>();

        SamSkuList.add(sku3);

        SamSkuList.add(sku4);
        pSam1.setSkuList(SamSkuList);
        Session s1 = Main.getSF().openSession();

//        Session s1 = FactoryService.getSessionFactory().openSession();

        Transaction t1 = s1.beginTransaction();
        s1.persist(pApple1);
        s1.persist(pSam1);
        t1.commit();
        s1.close();
    }

    public static Products createProductApple1() {
        Products product = new Products();
        product.setBrandName("apple");
        product.setType("iPhone");
        return product;
    }

    public static Products createProductSam2() {
        Products product = new Products();
        product.setBrandName("Samsung");
        product.setType("Tablet");
        return product;
    }

    public static Sku createSkuSam1() {
        Sku sku = new Sku();
        sku.setColor("black");
        sku.setDescription("smart phone, Android OS, 64GB memory, two sim");
        sku.setModel("2018");
        sku.setName("galaxy S9");
        return sku;
    }

    public static Sku createSkuSam2() {
        Sku sku = new Sku();
        sku.setColor("white");
        sku.setDescription("smart phone, Android OS, 128 GB memory, two sim");
        sku.setModel("2018");
        sku.setName("galaxy S9+ plus");
        return sku;
    }

    public static Sku createSkuApple1() {
        Sku sku = new Sku();
        sku.setColor("White");
        sku.setDescription("smart phone, iPhone OS, 64GB memory, one sim");
        sku.setModel("2018");
        sku.setName("iPhone 8");
        return sku;
    }

    public static Sku createSkuApple2() {
        Sku sku = new Sku();
        sku.setColor("White");
        sku.setDescription("smart phone, iPhone OS, 64GB memory, one sim");
        sku.setModel("2019");
        sku.setName("iPhone X");
        return sku;
    }
}