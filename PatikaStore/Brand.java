import java.util.*;

public class Brand {

    private String name;
    private int id;
    private int listID = 1;

    private TreeSet<Brand> brandList = new TreeSet<>(Comparator.comparing(Brand::getName));

    public Brand(){
        addTolist();
    }
    public Brand(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void addTolist(){
        String[] list = {"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};

            Arrays.sort(list);
            for (int k =0, l=this.listID;k< list.length;k++,l++){
                brandList.add(new Brand(list[k],l));
                this.listID++;
            }


    }

    public void addBrand(String name){
        brandList.add(new Brand(name,listID));
    }
    public void list(){
        for (Brand e : brandList){
            System.out.println(e.getId() + " " +  e.getName());
        }
    }

  public String getBrand(int id){
        for (Brand b : brandList){
            if (id == b.getId()){
                return b.getName();
            }
        }
        return null;
  }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
