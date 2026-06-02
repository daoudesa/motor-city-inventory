package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (partRepository.count() == 0 && productRepository.count() == 0) {

            // ===== PARTS (E) =====
            OutsourcedPart p1 = new OutsourcedPart();
            p1.setName("Brake Pads");
            p1.setInv(25);
            p1.setMinInv(5);
            p1.setMaxInv(50);
            p1.setPrice(49.99);
            p1.setCompanyName("Motor City Performance Garage");

            OutsourcedPart p2 = new OutsourcedPart();
            p2.setName("Engine Oil");
            p2.setInv(40);
            p2.setMinInv(5);
            p2.setMaxInv(80);
            p2.setPrice(29.99);
            p2.setCompanyName("Motor City Performance Garage");

            OutsourcedPart p3 = new OutsourcedPart();
            p3.setName("Air Filter");
            p3.setInv(30);
            p3.setMinInv(5);
            p3.setMaxInv(60);
            p3.setPrice(19.99);
            p3.setCompanyName("Motor City Performance Garage");

            OutsourcedPart p4 = new OutsourcedPart();
            p4.setName("Spark Plugs");
            p4.setInv(60);
            p4.setMinInv(10);
            p4.setMaxInv(100);
            p4.setPrice(14.99);
            p4.setCompanyName("Motor City Performance Garage");

            OutsourcedPart p5 = new OutsourcedPart();
            p5.setName("Tires Set");
            p5.setInv(12);
            p5.setMinInv(2);
            p5.setMaxInv(25);
            p5.setPrice(199.99);
            p5.setCompanyName("Motor City Performance Garage");

            // save parts
            partRepository.save(p1);
            partRepository.save(p2);
            partRepository.save(p3);
            partRepository.save(p4);
            partRepository.save(p5);

            // ===== PRODUCTS (5) =====
            Product pr1 = new Product();
            pr1.setName("Basic Maintenance Kit");
            pr1.setInv(10);
            pr1.setPrice(119.99);

            Product pr2 = new Product();
            pr2.setName("Performance Upgrade Kit");
            pr2.setInv(5);
            pr2.setPrice(499.99);

            Product pr3 = new Product();
            pr3.setName("Oil Change Package");
            pr3.setInv(15);
            pr3.setPrice(79.99);

            Product pr4 = new Product();
            pr4.setName("Brake Replacement Package");
            pr4.setInv(8);
            pr4.setPrice(299.99);

            Product pr5 = new Product();
            pr5.setName("Full Tune-Up Bundle");
            pr5.setInv(3);
            pr5.setPrice(699.99);

            // save products
            productRepository.save(pr1);
            productRepository.save(pr2);
            productRepository.save(pr3);
            productRepository.save(pr4);
            productRepository.save(pr5);
        }


       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
