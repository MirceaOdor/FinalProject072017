package ModelLayer;
import java.util.*;

    /**
     * Created by Alexander on 3/29/2017.
     */
    public class SupplyOrder {
        private String id;
        private String prodType;
        private double qty;
        private Date date;
        private Date dlvDate;
        private String sID;

        public SupplyOrder(){

        }

        public SupplyOrder(String id, String prodType, double qty, Date date, Date dlvDate, String sID) {
            this.id = id;
            this.prodType = prodType;
            this.qty = qty;
            date = new Date();
            dlvDate =new Date();
            this.sID = sID;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProdType() {
            return prodType;
        }

        public void setProdType(String prodType) {
            this.prodType = prodType;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Date getDlvDate() {
            return dlvDate;
        }

        public void setDlvDate(Date dlvDate) {
            this.dlvDate = dlvDate;
        }

        public String getsID() {
            return sID;
        }

        public void setsID(String sID) {
            this.sID = sID;
        }
    }

