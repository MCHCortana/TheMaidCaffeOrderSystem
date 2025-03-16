package k2w.thePub.dto;
public class OrderDTO {
    private Long id;

    private String productName;
    private int amount;
    private double price;
    private Long userId;
    private Long drinkId;

    public OrderDTO() {
    }

    public OrderDTO(Long id, String productName, int amount, double price, Long userId, Long drinkId) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
        this.price = price;
        this.userId = userId;
        this.drinkId = drinkId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(Long drinkId) {
        this.drinkId = drinkId;
    }

}
