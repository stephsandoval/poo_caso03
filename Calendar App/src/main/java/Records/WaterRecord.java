package Records;

public class WaterRecord {
    
    private double waterAmount, waterpH;
    private String waterSource, waterNote;
    private boolean hasInformation;

    public WaterRecord (){
        this.waterSource = "-";
        this.waterAmount = 0.0;
        this.waterpH = 1.0;
        this.waterNote = "-";
        this.hasInformation = false;
    }

    public WaterRecord (String waterSource, double waterAmount, double waterpH, String waterNote){
        this.hasInformation = false;
        setWaterAmount(waterAmount);
        setWaterpH(waterpH);
        setWaterSource(waterSource);
        setWaterNote(waterNote);
    }

    public String getWaterSource (){
        return this.waterSource;
    }

    public double getWaterAmount (){
        return this.waterAmount;
    }

    public double getWaterpH (){
        return this.waterpH;
    }

    public String getWaterNote (){
        return this.waterNote;
    }

    public void setWaterSource (String waterSource){
        if (waterSource != null){
            this.waterSource = waterSource;
            this.hasInformation = true;
        } else {
            this.waterSource = "-";
        }
    }

    public void setWaterAmount (double waterAmount){
        if (waterAmount > 0){
            this.waterAmount = waterAmount;
            this.hasInformation = true;
        } else {
            this.waterAmount = 0;
        }
    }

    public void setWaterpH (double waterpH){
        if (waterpH > 1){
            this.waterpH = waterpH;
            this.hasInformation = true;
        } else {
            this.waterpH = 1;
        }
    }

    public void setWaterNote (String waterNote){
        if (waterNote != null){
            this.waterNote = waterNote;
            this.hasInformation = true;
        } else {
            this.waterNote = "-";
        }
    }

    public boolean hasInformation (){
        return this.hasInformation;
    }

    public String toString (){
        return "water record >> source > " + waterSource + " | amount > " + waterAmount + " | pH > " + waterpH + " | note > " + waterNote;
    }
}