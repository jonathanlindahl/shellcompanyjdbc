package com.domain.shellcompanyjdbc.models;

public class Shell
{
    private final Long id;
    private final String manufacturer;
    private final String model;
    private final String name;
    private final int price;
    
    public Shell(Long id, String manufacturer, String model, String name, int price)
    {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.name = name;
        this.price = price;
    }
    
    public Long getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getManufacturer() { return manufacturer; }
    public String getModel() { return model; }
    
    @Override
    public String toString()
    {
        return "Shell{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
