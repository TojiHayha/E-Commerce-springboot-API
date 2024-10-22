package com.ecommercek.ecommercek.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ecommercek.ecommercek.models.Category;
import com.ecommercek.ecommercek.models.Product;
import com.ecommercek.ecommercek.repositories.CategoryRepository;
import com.ecommercek.ecommercek.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics", "Latest gadgets and electronic devices", "https://d1ih8jugeo2m5m.cloudfront.net/2022/09/revenda-eletronicos-1200x685.jpg");
		Category cat2 = new Category(null, "Books", "Wide range of books from all genres", "https://assets.aboutamazon.com/dims4/default/7204561/2147483647/strip/true/crop/6570x3698+2+0/resize/1320x743!/quality/90/?url=https%3A%2F%2Famazon-blogs-brightspot.s3.amazonaws.com%2F36%2F86%2Fda47669747fabf0a8a389edb212b%2Fdisposicao-de-livros-de-vista-superior.jpg");
		Category cat3 = new Category(null, "Computers", "High-performance computers and accessories", "https://m.media-amazon.com/images/I/51LnfULhGYL._AC_UF894,1000_QL80_.jpg");
		Category cat4 = new Category(null, "Home Appliances", "Essential appliances for your home", "https://t3.ftcdn.net/jpg/03/29/32/18/360_F_329321873_tWphXnKQHwtZzj4xHUvFRsnaL6cEoLtX.jpg");
		Category cat5 = new Category(null, "Toys", "Fun and educational toys for all ages", "https://ae01.alicdn.com/kf/S309058bf47b643b88acafb78d16f91e1z/ACTOYS-DARK-SOULS-Q-Version-Action-Figure-brinquedos-modelo-original-de-anime-presente-11cm-em-estoque.jpg");
		Category cat6 = new Category(null, "Clothing", "Fashionable and comfortable clothing", "https://blog.melhorenvio.com.br/wp-content/uploads/2021/02/Venda-de-roupas-online-1024x683-1.jpg");
		Category cat7 = new Category(null, "Sports", "Gear and equipment for sports enthusiasts", "https://img.freepik.com/fotos-gratis/ferramentas-esportivas_53876-138077.jpg");
		
		Product p1 = new Product(null, "Apple iPhone 14", "https://http2.mlstatic.com/D_NQ_NP_902062-MLM51559388098_092022-O.webp", 999.99, "Latest model of the iPhone with advanced features.", cat1);
		Product p2 = new Product(null, "Harry Potter and the Philosopher's Stone", "https://m.media-amazon.com/images/I/81q77Q39nEL._AC_UF1000,1000_QL80_.jpg", 29.99, "The first book in the Harry Potter series.", cat2);
		Product p3 = new Product(null, "Dell XPS 13", "https://images.tcdn.com.br/img/img_prod/1314128/dell_xps_13_plus_9320_notebook_pc_core_i7_1360p_13_4_fhd_16gb_ram_1tb_ssd_win_11_pro_3425_2_57263a4dabc42a9add404b08ae002fe2.jpeg", 1399.99, "Powerful and sleek laptop with a stunning display.", cat3);
		Product p4 = new Product(null, "Dyson Vacuum Cleaner", "https://cdn.mos.cms.futurecdn.net/tomE6gL6ZFyGasaL46kCEa.jpg", 499.99, "High-efficiency vacuum cleaner with advanced technology.", cat4);
		Product p5 = new Product(null, "Lego Star Wars Set", "https://m.media-amazon.com/images/I/81xCK66iBnL._AC_UF894,1000_QL80_.jpg", 59.99, "Buildable Lego set from the Star Wars series.", cat5);
		Product p6 = new Product(null, "Adidas Running Shoes", "https://brand.assets.adidas.com/image/upload/f_auto,q_auto,fl_lossy/SUPERNOVA_d_60e123ca7d.jpg", 120.0, "Comfortable running shoes with superior grip.", cat6);
		Product p7 = new Product(null, "Yoga Mat", "https://m.media-amazon.com/images/I/91cJwPOdbmL._AC_UF1000,1000_QL80_.jpg", 25.0, "Durable yoga mat with excellent cushioning.", cat7);

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));
		
		
	}


	
}
