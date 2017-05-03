package ModelLayer;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Vlad Mataoanu on 03.05.2017.
 */
public class RawMaterialOrder extends Order{
    private ArrayList<RAW_Material> raw_materials;

    public RawMaterialOrder(String id, Date deliveryDate, String orderStatus, double totalPrice, String companyId, String type) {
        super(id, deliveryDate, orderStatus, totalPrice, companyId, type);
        raw_materials=new ArrayList<>();
    }

    public void addRawMaterialsOrdered(RAW_Material raw){
        raw_materials.add(raw);
    }

    public ArrayList<RAW_Material> getRaw_materials(){return raw_materials;}

    public void deleteRAWMaterial(RAW_Material raw){
        raw_materials.remove(raw);
    }
}
