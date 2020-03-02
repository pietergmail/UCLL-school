package domain.db;

import domain.model.Product;

import java.util.*;

public class ProductDbInMemory implements ProductDb {
	private Map<String, Product> records = new HashMap<>();
	
	public ProductDbInMemory () {
		Product rose = new Product("Rose", "Thorny plant", 2.25);
		add(rose);
	}
	
	@Override
    public Product get(int id){
		if(id < 0){
			throw new DbException("No valid id given");
		}
		return records.get(id);
	}
	
	@Override
    public List<Product> getAll(){
		return new ArrayList<Product>(records.values());	
	}

	@Override
    public void add(Product product){
		if(product == null){
			throw new DbException("No product given");
		}
		UUID uuid = UUID.randomUUID();

		String id = uuid+"";
		product.setProductId(id);
		if (records.containsKey(product.getProductId())) {
			throw new DbException("Product already exists");
		}
		records.put(product.getProductId(), product);
	}
	
	@Override
    public void update(Product product){
		if(product == null){
			throw new DbException("No product given");
		}
		if(!records.containsKey(product.getProductId())){
			throw new DbException("No product found");
		}
		records.put(product.getProductId(), product);
	}
	
	@Override
    public void delete(String id){
		records.remove(id);
	}

	@Override
    public int getNumbeOfProducts() {
		return records.size();
	}
}
